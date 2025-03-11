package com.oopmastery.polymorphism.runtime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the MediaPlayer hierarchy demonstrating runtime polymorphism.
 */
public class MediaPlayerTest {
    private MediaPlayer audioPlayer;
    private MediaPlayer videoPlayer;
    private AudioPlayer audio;
    private VideoPlayer video;

    @BeforeEach
    void setUp() {
        audioPlayer = new AudioPlayer();
        videoPlayer = new VideoPlayer();
        audio = (AudioPlayer) audioPlayer;
        video = (VideoPlayer) videoPlayer;
    }

    @Test
    void testAudioPlayerBasicOperations() {
        assertTrue(audioPlayer.play("test.mp3"));
        assertFalse(audioPlayer.play("test.avi")); // Should fail for video format
        
        // Test volume and playback speed
        audioPlayer.setVolume(75.0);
        assertEquals(75.0, audioPlayer.getVolume());
        
        audioPlayer.setPlaybackSpeed(1.5);
        assertEquals(1.5, audioPlayer.getPlaybackSpeed());
    }

    @Test
    void testVideoPlayerBasicOperations() {
        assertTrue(videoPlayer.play("test.mp4"));
        assertFalse(videoPlayer.play("test.mp3")); // Should fail for audio format
        
        // Test volume and playback speed
        videoPlayer.setVolume(80.0);
        assertEquals(80.0, videoPlayer.getVolume());
        
        videoPlayer.setPlaybackSpeed(2.0);
        assertEquals(2.0, videoPlayer.getPlaybackSpeed());
    }

    @Test
    void testAudioPlayerSpecificFeatures() {
        assertTrue(audio.toggleEqualizer());
        
        // Test bass boost with valid and invalid values
        audio.setBassBoost(50);
        assertEquals(50, audio.getBassBoost());
        
        assertThrows(IllegalArgumentException.class, () -> audio.setBassBoost(-1));
        assertThrows(IllegalArgumentException.class, () -> audio.setBassBoost(101));
    }

    @Test
    void testVideoPlayerSpecificFeatures() {
        assertTrue(video.toggleFullscreen());
        assertTrue(video.isFullscreen());
        
        // Test subtitle functionality
        video.setSubtitles("English");
        assertEquals("English", video.getSubtitles());
        assertTrue(video.toggleSubtitles());
        assertTrue(video.hasSubtitles());
        
        // Test resolution changes
        video.setResolution(1920, 1080);
        assertEquals(1920, video.getWidth());
        assertEquals(1080, video.getHeight());
        
        assertThrows(IllegalArgumentException.class, 
            () -> video.setResolution(-1, 1080));
        assertThrows(IllegalArgumentException.class, 
            () -> video.setResolution(1920, 0));
    }

    @Test
    void testPolymorphicBehavior() {
        MediaPlayer[] players = {audioPlayer, videoPlayer};
        String[] validFiles = {"test.mp3", "test.mp4"};
        String[] invalidFiles = {"test.avi", "test.wav"};

        for (int i = 0; i < players.length; i++) {
            assertTrue(players[i].play(validFiles[i]));
            assertFalse(players[i].play(invalidFiles[i]));
            
            players[i].setVolume(50.0);
            assertEquals(50.0, players[i].getVolume());
            
            players[i].setPlaybackSpeed(1.0);
            assertEquals(1.0, players[i].getPlaybackSpeed());
            
            players[i].stop();
            assertFalse(players[i].isPlaying());
        }
    }

    @Test
    void testInvalidOperations() {
        // Test invalid volume values
        assertThrows(IllegalArgumentException.class, 
            () -> audioPlayer.setVolume(-1.0));
        assertThrows(IllegalArgumentException.class, 
            () -> videoPlayer.setVolume(101.0));

        // Test invalid playback speed
        assertThrows(IllegalArgumentException.class, 
            () -> audioPlayer.setPlaybackSpeed(0.0));
        assertThrows(IllegalArgumentException.class, 
            () -> videoPlayer.setPlaybackSpeed(-1.0));
    }

    @Test
    void testTypeChecking() {
        assertTrue(audioPlayer instanceof MediaPlayer);
        assertTrue(videoPlayer instanceof MediaPlayer);
        assertTrue(audioPlayer instanceof AudioPlayer);
        assertTrue(videoPlayer instanceof VideoPlayer);
        assertFalse(audioPlayer instanceof VideoPlayer);
        assertFalse(videoPlayer instanceof AudioPlayer);
    }
} 