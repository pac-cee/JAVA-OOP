package com.oopmastery.abstraction;

/**
 * Concrete implementation of Notification for sending emails.
 * Demonstrates how abstraction is used to hide the complexity
 * of email sending while maintaining a clean interface.
 */
public class EmailNotification extends Notification {
    private final String recipientEmail;
    private final String senderEmail;
    private String[] attachments;

    /**
     * Constructor for creating an email notification.
     * @param title The email subject
     * @param message The email body
     * @param priority The notification priority
     * @param recipientEmail The recipient's email address
     * @param senderEmail The sender's email address
     */
    public EmailNotification(String title, String message, Priority priority,
                           String recipientEmail, String senderEmail) {
        super(title, message, priority);
        this.recipientEmail = recipientEmail;
        this.senderEmail = senderEmail;
    }

    /**
     * Sets file attachments for the email.
     * @param attachments Array of file paths to attach
     */
    public void setAttachments(String... attachments) {
        this.attachments = attachments;
    }

    @Override
    protected boolean validate() {
        return super.validate() &&
               isValidEmail(recipientEmail) &&
               isValidEmail(senderEmail);
    }

    @Override
    protected void preProcess() {
        System.out.println("Preparing email notification...");
        if (attachments != null && attachments.length > 0) {
            System.out.println("Processing attachments...");
        }
    }

    @Override
    protected boolean doSend() {
        // Simulate email sending
        System.out.printf("Sending email from %s to %s%n", senderEmail, recipientEmail);
        System.out.printf("Subject: %s%n", getTitle());
        System.out.printf("Priority: %s%n", getPriority());
        if (attachments != null) {
            System.out.printf("Attachments: %d%n", attachments.length);
        }
        // Simulate successful sending
        return true;
    }

    @Override
    protected void postProcess() {
        System.out.println("Email sent successfully!");
        if (attachments != null) {
            System.out.println("Cleaning up temporary attachment files...");
        }
    }

    @Override
    public String getType() {
        return "Email";
    }

    private boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        // Simple email validation (for demonstration)
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
} 