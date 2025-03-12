package com.oopmastery.abstraction;

/**
 * Concrete implementation of Notification for sending push notifications.
 * Demonstrates how abstraction is used to hide the complexity
 * of push notification delivery while maintaining a clean interface.
 */
public class PushNotification extends Notification {
    private final String deviceToken;
    private final String appId;
    private boolean silent;
    private int timeToLive;

    /**
     * Constructor for creating a push notification.
     * @param title The notification title
     * @param message The notification message
     * @param priority The notification priority
     * @param deviceToken The target device token
     * @param appId The application ID
     */
    public PushNotification(String title, String message, Priority priority,
                          String deviceToken, String appId) {
        super(title, message, priority);
        this.deviceToken = deviceToken;
        this.appId = appId;
        this.timeToLive = 3600; // Default 1 hour
        this.silent = false;
    }

    /**
     * Sets whether this is a silent notification.
     * @param silent true for silent notification, false for normal
     */
    public void setSilent(boolean silent) {
        this.silent = silent;
    }

    /**
     * Sets the time-to-live in seconds.
     * @param seconds Number of seconds before the notification expires
     */
    public void setTimeToLive(int seconds) {
        if (seconds < 0) {
            throw new IllegalArgumentException("Time-to-live cannot be negative");
        }
        this.timeToLive = seconds;
    }

    @Override
    protected boolean validate() {
        return super.validate() &&
               deviceToken != null && !deviceToken.trim().isEmpty() &&
               appId != null && !appId.trim().isEmpty();
    }

    @Override
    protected void preProcess() {
        System.out.println("Preparing push notification...");
        System.out.printf("Target app: %s%n", appId);
        System.out.printf("Mode: %s%n", silent ? "Silent" : "Alert");
    }

    @Override
    protected boolean doSend() {
        // Simulate push notification sending
        System.out.printf("Sending push notification to device: %s%n", deviceToken);
        System.out.printf("Title: %s%n", getTitle());
        System.out.printf("Priority: %s%n", getPriority());
        System.out.printf("TTL: %d seconds%n", timeToLive);
        // Simulate successful sending
        return true;
    }

    @Override
    protected void postProcess() {
        System.out.println("Push notification delivered!");
        if (getPriority() == Priority.HIGH || getPriority() == Priority.URGENT) {
            System.out.println("Logging high-priority notification delivery...");
        }
    }

    @Override
    protected void handleError(Exception e) {
        super.handleError(e);
        if (getPriority() == Priority.URGENT) {
            System.err.println("Attempting fallback delivery method...");
        }
    }

    @Override
    public String getType() {
        return "Push";
    }
} 