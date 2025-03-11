package com.oopmastery.polymorphism.runtime;

/**
 * Abstract MediaPlayer class demonstrating runtime polymorphism.
 * Shows:
 * 1. Abstract methods for required functionality
 * 2. Concrete methods with default behavior
 * 3. Template method pattern
 * 4. Protected fields for subclass access
 */
public abstract class MediaPlayer {
    protected String currentMedia;
    protected boolean isPlaying;
    protected double volume;
    protected double playbackSpeed;

    public MediaPlayer() {
        this.volume = 50.0; // Default volume 50%
        this.playbackSpeed = 1.0; // Normal speed
        this.isPlaying = false;
    }

    /**
     * Template method defining the sequence of playing media
     * @param mediaPath Path to the media file
     * @return true if media was loaded and started playing, false otherwise
     */
    public final boolean play(String mediaPath) {
        if (isPlaying) {
            stop();
        }
        
        if (loadMedia(mediaPath)) {
            this.currentMedia = mediaPath;
            this.isPlaying = true;
            onPlay();
            System.out.printf("Playing %s at volume %.1f%% and speed %.1fx%n",
                getMediaInfo(), volume, playbackSpeed);
            return true;
        }
        return false;
    }

    /**
     * Stops the current playback
     */
    public void stop() {
        if (isPlaying) {
            onStop();
            isPlaying = false;
            System.out.println("Stopped playback");
        }
    }

    /**
     * Sets the playback volume
     * @param volume Volume level (0-100)
     */
    public void setVolume(double volume) {
        if (volume < 0 || volume > 100) {
            throw new IllegalArgumentException("Volume must be between 0 and 100");
        }
        this.volume = volume;
        onVolumeChange();
        System.out.printf("Volume set to %.1f%%%n", volume);
    }

    /**
     * Gets the current volume level
     * @return Current volume (0-100)
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Sets the playback speed
     * @param speed Playback speed multiplier
     */
    public void setPlaybackSpeed(double speed) {
        if (speed <= 0) {
            throw new IllegalArgumentException("Speed must be positive");
        }
        this.playbackSpeed = speed;
        onSpeedChange();
        System.out.printf("Playback speed set to %.1fx%n", speed);
    }

    /**
     * Gets the current playback speed
     * @return Current playback speed multiplier
     */
    public double getPlaybackSpeed() {
        return playbackSpeed;
    }

    /**
     * Checks if media is currently playing
     * @return true if playing, false otherwise
     */
    public boolean isPlaying() {
        return isPlaying;
    }

    /**
     * Gets the current media file path
     * @return Current media path or null if none
     */
    public String getCurrentMedia() {
        return currentMedia;
    }

    // Abstract methods to be implemented by specific players
    protected abstract boolean loadMedia(String mediaPath);
    protected abstract void onPlay();
    protected abstract void onStop();
    protected abstract void onVolumeChange();
    protected abstract void onSpeedChange();
    protected abstract String getMediaInfo();
} 