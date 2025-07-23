package com.baker_online.utilities;

import com.mailslurp.clients.ApiClient;
import com.mailslurp.clients.ApiException;
import com.mailslurp.apis.InboxControllerApi;
import com.mailslurp.apis.WaitForControllerApi;
import com.mailslurp.models.Email;
import com.mailslurp.models.EmailPreview;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for email operations to test forgot password functionality
 * using the MailSlurp API
 */
public class MailSlurpUtils {

    private static final String API_KEY = ConfigurationReader.getProperty("mailslurp.api.key");
    private static final String EMAIL_ADDRESS = ConfigurationReader.getProperty("mailslurp.email");
    private static UUID INBOX_ID;
    
    private static ApiClient apiClient;
    private static InboxControllerApi inboxControllerApi;
    private static WaitForControllerApi waitForControllerApi;
    
    /**
     * Initialize the MailSlurp API client and controllers
     */
    public static void setup() {
        System.out.println("Setting up MailSlurp for email testing");
        
        try {
            // Initialize the API client with the API key
            apiClient = new ApiClient();
            apiClient.setApiKey(API_KEY);
            
            // Initialize the API controllers
            inboxControllerApi = new InboxControllerApi(apiClient);
            waitForControllerApi = new WaitForControllerApi(apiClient);
            
            // Extract the inbox ID from the email address
            INBOX_ID = UUID.fromString(EMAIL_ADDRESS.split("@")[0]);
            System.out.println("Setting up email testing with address: " + EMAIL_ADDRESS);
        } catch (Exception e) {
            System.err.println("Error setting up MailSlurp: " + e.getMessage());
            throw new RuntimeException("Failed to set up MailSlurp", e);
        }
    }
    
    /**
     * Wait for a password reset email to arrive in the inbox
     *
     * @return The received email
     */
    public static Email waitForPasswordResetEmail() {
        long timeoutMillis = 60000;
        System.out.println("Waiting for password reset email to " + EMAIL_ADDRESS);
        
        try {
            cleanupInbox();
            
            // Set a timeout for waiting
            long startTime = System.currentTimeMillis();
            long endTime = startTime + timeoutMillis;
            
            Email email = null;
            
            // Keep checking for new emails until we find one or timeout
            while (System.currentTimeMillis() < endTime) {
                try {
                    // Check for new emails
                    List<EmailPreview> emails = inboxControllerApi.getEmails(INBOX_ID, null, null, null, null, null, null, null, null, null);
                    
                    if (emails != null && !emails.isEmpty()) {
                        // Get the latest email
                        EmailPreview latestEmail = emails.get(0);
                        email = waitForControllerApi.waitForLatestEmail(INBOX_ID, timeoutMillis, null, null, null, null, null);
                        
                        if (email != null) {
                            return email;
                        }
                    }
                    
                    // Wait a bit before checking again
                    Thread.sleep(2000);
                } catch (ApiException | InterruptedException e) {
                    // Continue waiting
                }
            }
            
            // If we couldn't get a real email after waiting, throw an exception
            throw new RuntimeException("No email received after waiting " + timeoutMillis + "ms");
        } catch (Exception e) {
            throw new RuntimeException("Failed to receive password reset email", e);
        }
    }
    
    /**
     * Extract a password reset link from an email body
     * 
     * @param email The email containing the reset link
     * @return The extracted reset link
     */
    public static String extractResetLink(Email email) {
        String body = email.getBody();
        
        // Look for a link with "new-password" or "reset-password" in it
        Pattern pattern = Pattern.compile("href=\"(https?://[^\"]+(?:new-password|reset-password)[^\"]+)\"");
        Matcher matcher = pattern.matcher(body);
        
        if (matcher.find()) {
            String resetLink = matcher.group(1);
            return resetLink;
        } else {
            // If we can't find a reset link with the specific pattern, try a more general approach
            // Look for any link that might be related to password reset
            pattern = Pattern.compile("href=\"(https?://bakeronline[^\"]+(?:token|password)[^\"]+)\"");
            matcher = pattern.matcher(body);
            
            if (matcher.find()) {
                String resetLink = matcher.group(1);
                return resetLink;
            } else {
                throw new RuntimeException("No password reset link found in email body");
            }
        }
    }
    
    /**
     * Clean up the inbox by deleting all emails
     */
    public static void cleanupInbox() {
        System.out.println("Cleaning up inbox for " + EMAIL_ADDRESS);
        
        try {
            // Delete all emails in the inbox
            inboxControllerApi.deleteAllInboxEmails(INBOX_ID);
            System.out.println("Successfully deleted all emails from inbox");
        } catch (ApiException e) {
            System.err.println("Error cleaning up inbox: " + e.getMessage());
            // Don't throw an exception here, as this is just cleanup
        }
    }
}
