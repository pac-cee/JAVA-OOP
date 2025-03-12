package com.oopmastery.abstraction;

/**
 * Demonstration class showing how abstraction works with the notification system.
 * This class shows how the same interface can be used to handle different types
 * of notifications while hiding their implementation details.
 */
public class AbstractionDemo {
    public static void main(String[] args) {
        System.out.println("=== Abstraction Demonstration ===\n");

        // Create different types of notifications
        Notification emailNotif = new EmailNotification(
            "Welcome to OOP Mastery",
            "Thank you for joining our course!",
            Notification.Priority.HIGH,
            "student@example.com",
            "course@oopmastery.com"
        );

        Notification pushNotif = new PushNotification(
            "New Message",
            "You have a new assignment available",
            Notification.Priority.MEDIUM,
            "device-token-123",
            "com.oopmastery.app"
        );

        // Demonstrate email notification
        System.out.println("--- Email Notification ---");
        // Add some attachments
        ((EmailNotification) emailNotif).setAttachments(
            "welcome.pdf", "schedule.pdf"
        );
        // Send the notification
        emailNotif.send();

        System.out.println("\n--- Push Notification ---");
        // Configure push notification
        ((PushNotification) pushNotif).setSilent(true);
        ((PushNotification) pushNotif).setTimeToLive(1800); // 30 minutes
        // Send the notification
        pushNotif.send();

        // Demonstrate error handling
        System.out.println("\n--- Error Handling ---");
        Notification invalidEmail = new EmailNotification(
            "",  // Invalid empty title
            "This should fail validation",
            Notification.Priority.LOW,
            "invalid-email",  // Invalid email
            "sender@example.com"
        );
        invalidEmail.send();  // This should fail validation

        // Demonstrate handling different notification types uniformly
        System.out.println("\n--- Processing Multiple Notifications ---");
        Notification[] notifications = {emailNotif, pushNotif, invalidEmail};
        processNotifications(notifications);
    }

    private static void processNotifications(Notification[] notifications) {
        for (Notification notification : notifications) {
            System.out.printf("\nProcessing %s notification:%n", notification.getType());
            System.out.println("Status: " + (notification.isDelivered() ? "Delivered" : "Not Delivered"));
            System.out.println("Details: " + notification);
        }
    }
} 