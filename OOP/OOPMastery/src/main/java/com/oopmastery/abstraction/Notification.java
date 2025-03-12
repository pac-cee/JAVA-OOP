package com.oopmastery.abstraction;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Abstract class demonstrating abstraction principles.
 * This class provides a template for different types of notifications,
 * hiding implementation details while exposing a clean interface.
 */
public abstract class Notification {
    private final String id;
    private final String title;
    private final String message;
    private final Priority priority;
    private final LocalDateTime timestamp;
    private boolean delivered;

    /**
     * Constructor for creating a notification.
     * @param title The notification title
     * @param message The notification message
     * @param priority The notification priority
     */
    protected Notification(String title, String message, Priority priority) {
        this.id = generateId();
        this.title = title;
        this.message = message;
        this.priority = priority;
        this.timestamp = LocalDateTime.now();
        this.delivered = false;
    }

    /**
     * Sends the notification. This is a template method that defines
     * the algorithm structure while letting subclasses provide specific implementations.
     * @return true if the notification was sent successfully
     */
    public final boolean send() {
        if (validate()) {
            boolean success = false;
            try {
                preProcess();
                success = doSend();
                if (success) {
                    this.delivered = true;
                    postProcess();
                }
            } catch (Exception e) {
                handleError(e);
            }
            return success;
        }
        return false;
    }

    /**
     * Validates the notification before sending.
     * @return true if the notification is valid
     */
    protected boolean validate() {
        return title != null && !title.trim().isEmpty() &&
               message != null && !message.trim().isEmpty();
    }

    /**
     * Pre-processes the notification before sending.
     * Can be overridden by subclasses if needed.
     */
    protected void preProcess() {
        // Default implementation does nothing
    }

    /**
     * Post-processes the notification after successful sending.
     * Can be overridden by subclasses if needed.
     */
    protected void postProcess() {
        // Default implementation does nothing
    }

    /**
     * Handles errors that occur during sending.
     * Can be overridden by subclasses to provide specific error handling.
     * @param e The exception that occurred
     */
    protected void handleError(Exception e) {
        System.err.println("Error sending notification: " + e.getMessage());
    }

    /**
     * Abstract method that must be implemented by concrete notification types
     * to provide specific sending behavior.
     * @return true if the notification was sent successfully
     */
    protected abstract boolean doSend();

    /**
     * Abstract method that must be implemented by concrete notification types
     * to provide a string representation of the notification type.
     * @return The type of notification
     */
    public abstract String getType();

    // Getters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public Priority getPriority() {
        return priority;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public boolean isDelivered() {
        return delivered;
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return String.format("%s[id=%s, title=%s, priority=%s, delivered=%s]",
            getType(), id, title, priority, delivered);
    }

    /**
     * Enumeration for notification priority levels.
     */
    public enum Priority {
        LOW, MEDIUM, HIGH, URGENT
    }
} 