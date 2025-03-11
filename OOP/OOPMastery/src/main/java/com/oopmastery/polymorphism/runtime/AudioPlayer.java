package com.oopmastery.polymorphism.runtime;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * AudioPlayer class demonstrating runtime polymorphism through inheritance.
 * Shows:
 * 1. Implementation of abstract methods
 * 2. Additional audio-specific functionality
 * 3. Format validation
 * 4. Specialized behavior
 */
public class AudioPlayer extends MediaPlayer {
    private static final Set<String> SUPPORTED_FORMATS = 
        new HashSet<>(Arrays.asList("mp3", "wav", "aac", "flac"));
    
    private String currentArtist;
    private String currentAlbum;
    private boolean equalizerEnabled;
    private int bassBoostLevel;

    public AudioPlayer() {
        super();
        this.equalizerEnabled = false;
        this.bassBoostLevel = 0;
    }

    @Override
    protected boolean loadMedia(String mediaPath) {
        String extension = getFileExtension(mediaPath);
        if (!SUPPORTED_FORMATS.contains(extension)) {
            System.out.printf("Unsupported audio format: %s%n", extension);
            return false;
        }

        // Simulate loading metadata
        parseMetadata(mediaPath);
        System.out.println("Loading audio file: " + mediaPath);
        return true;
    }

    @Override
    protected void onPlay() {
        if (equalizerEnabled) {
            System.out.println("Applying equalizer settings...");
        }
        System.out.printf("Now playing: %s - %s (%s)%n", 
            currentArtist, getCurrentMedia(), currentAlbum);
    }

    @Override
    protected void onStop() {
        System.out.println("Stopping audio playback");
    }

    @Override
    protected void onVolumeChange() {
        System.out.println("Adjusting audio amplification...");
    }

    @Override
    protected void onSpeedChange() {
        System.out.println("Adjusting audio sampling rate...");
    }

    @Override
    protected String getMediaInfo() {
        return String.format("Audio[%s - %s]", currentArtist, 
            Path.of(getCurrentMedia()).getFileName());
    }

    /**
     * Toggles the equalizer on/off
     * @return Current equalizer state
     */
    public boolean toggleEqualizer() {
        equalizerEnabled = !equalizerEnabled;
        System.out.printf("Equalizer %s%n", equalizerEnabled ? "enabled" : "disabled");
        return equalizerEnabled;
    }

    /**
     * Sets bass boost level
     * @param level Bass boost level (0-100)
     */
    public void setBassBoost(int level) {
        if (level < 0 || level > 100) {
            throw new IllegalArgumentException("Bass boost must be between 0 and 100");
        }
        this.bassBoostLevel = level;
        System.out.printf("Setting bass boost to %d%%%n", level);
    }

    /**
     * Gets the current bass boost level
     * @return Current bass boost level (0-100)
     */
    public int getBassBoost() {
        return bassBoostLevel;
    }

    private String getFileExtension(String path) {
        int lastDot = path.lastIndexOf('.');
        if (lastDot == -1 || lastDot == path.length() - 1) {
            return "";
        }
        return path.substring(lastDot + 1).toLowerCase();
    }

    private void parseMetadata(String mediaPath) {
        // Simulate reading metadata from audio file
        String fileName = Path.of(mediaPath).getFileName().toString();
        // Assume format: Artist - Song.ext
        String[] parts = fileName.split(" - ");
        this.currentArtist = parts.length > 1 ? parts[0] : "Unknown Artist";
        this.currentAlbum = "Unknown Album"; // In real implementation, would read from file
    }
} 