package com.oopmastery.polymorphism.runtime;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * VideoPlayer class demonstrating runtime polymorphism through inheritance.
 * Shows:
 * 1. Implementation of abstract methods with video-specific behavior
 * 2. Additional video-specific functionality
 * 3. Format and resolution handling
 * 4. Specialized video controls
 */
public class VideoPlayer extends MediaPlayer {
    private static final Set<String> SUPPORTED_FORMATS = 
        new HashSet<>(Arrays.asList("mp4", "mkv", "avi", "mov"));
    
    private int width;
    private int height;
    private boolean subtitlesEnabled;
    private String currentSubtitleTrack;
    private boolean fullscreen;

    public VideoPlayer() {
        super();
        this.width = 1920;
        this.height = 1080;
        this.subtitlesEnabled = false;
        this.fullscreen = false;
    }

    @Override
    protected boolean loadMedia(String mediaPath) {
        String extension = getFileExtension(mediaPath);
        if (!SUPPORTED_FORMATS.contains(extension)) {
            System.out.printf("Unsupported video format: %s%n", extension);
            return false;
        }

        // Simulate video metadata loading
        detectResolution(mediaPath);
        System.out.printf("Loading video file: %s (%dx%d)%n", 
            mediaPath, width, height);
        return true;
    }

    @Override
    protected void onPlay() {
        System.out.printf("Playing video at %dx%d resolution%n", width, height);
        if (subtitlesEnabled && currentSubtitleTrack != null) {
            System.out.printf("Subtitles enabled: %s%n", currentSubtitleTrack);
        }
    }

    @Override
    protected void onStop() {
        System.out.println("Stopping video playback");
        if (fullscreen) {
            toggleFullscreen(); // Exit fullscreen on stop
        }
    }

    @Override
    protected void onVolumeChange() {
        System.out.println("Adjusting video audio levels...");
    }

    @Override
    protected void onSpeedChange() {
        System.out.println("Adjusting video frame rate...");
    }

    @Override
    protected String getMediaInfo() {
        return String.format("Video[%s, %dx%d]", 
            Path.of(getCurrentMedia()).getFileName(), width, height);
    }

    /**
     * Toggles fullscreen mode
     * @return Current fullscreen state
     */
    public boolean toggleFullscreen() {
        fullscreen = !fullscreen;
        System.out.printf("Video display: %s%n", 
            fullscreen ? "Fullscreen" : "Windowed");
        return fullscreen;
    }

    /**
     * Gets the current fullscreen state
     * @return true if in fullscreen mode, false otherwise
     */
    public boolean isFullscreen() {
        return fullscreen;
    }

    /**
     * Sets the subtitle track and enables subtitles
     * @param track Subtitle track name/language
     */
    public void setSubtitles(String track) {
        if (track == null || track.trim().isEmpty()) {
            throw new IllegalArgumentException("Subtitle track cannot be empty");
        }
        this.currentSubtitleTrack = track;
        this.subtitlesEnabled = true;
        System.out.printf("Enabled subtitles: %s%n", track);
    }

    /**
     * Gets the current subtitle track
     * @return Current subtitle track or null if none
     */
    public String getSubtitles() {
        return currentSubtitleTrack;
    }

    /**
     * Toggles subtitles on/off
     * @return Current subtitle state
     */
    public boolean toggleSubtitles() {
        if (currentSubtitleTrack == null) {
            System.out.println("No subtitle track available");
            return false;
        }
        subtitlesEnabled = !subtitlesEnabled;
        System.out.printf("Subtitles %s%n", 
            subtitlesEnabled ? "enabled" : "disabled");
        return subtitlesEnabled;
    }

    /**
     * Checks if subtitles are currently enabled
     * @return true if subtitles are enabled, false otherwise
     */
    public boolean hasSubtitles() {
        return subtitlesEnabled;
    }

    /**
     * Changes video quality/resolution
     * @param width New width in pixels
     * @param height New height in pixels
     */
    public void setResolution(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Invalid resolution dimensions");
        }
        this.width = width;
        this.height = height;
        System.out.printf("Changed resolution to %dx%d%n", width, height);
    }

    /**
     * Gets the current video width
     * @return Width in pixels
     */
    public int getWidth() {
        return width;
    }

    /**
     * Gets the current video height
     * @return Height in pixels
     */
    public int getHeight() {
        return height;
    }

    private String getFileExtension(String path) {
        int lastDot = path.lastIndexOf('.');
        if (lastDot == -1 || lastDot == path.length() - 1) {
            return "";
        }
        return path.substring(lastDot + 1).toLowerCase();
    }

    private void detectResolution(String mediaPath) {
        // Simulate reading video resolution from file
        // In a real implementation, this would analyze the video file
        this.width = 1920;  // Default to 1080p
        this.height = 1080;
    }
} 