package com.oopmastery.polymorphism.runtime;

/**
 * Demonstrates runtime polymorphism using the MediaPlayer hierarchy.
 * Shows how the same interface can be used to handle different types of media players,
 * with the specific behavior determined at runtime.
 */
public class MediaPlayerDemo {
    public static void main(String[] args) {
        // Create instances of different media players
        MediaPlayer audioPlayer = new AudioPlayer();
        MediaPlayer videoPlayer = new VideoPlayer();

        System.out.println("=== Demonstrating Runtime Polymorphism ===\n");

        // Demonstrate polymorphic behavior with audio
        System.out.println("--- Audio Player Demonstration ---");
        audioPlayer.play("music/favorite-song.mp3");
        audioPlayer.setVolume(75.0);
        audioPlayer.setPlaybackSpeed(1.5);
        // Cast to access audio-specific features
        AudioPlayer audio = (AudioPlayer) audioPlayer;
        audio.toggleEqualizer();
        audio.setBassBoost(80);
        audioPlayer.stop();
        System.out.println();

        // Demonstrate polymorphic behavior with video
        System.out.println("--- Video Player Demonstration ---");
        videoPlayer.play("videos/movie.mp4");
        videoPlayer.setVolume(90.0);
        // Cast to access video-specific features
        VideoPlayer video = (VideoPlayer) videoPlayer;
        video.setSubtitles("English");
        video.toggleFullscreen();
        video.setResolution(3840, 2160); // 4K resolution
        videoPlayer.stop();
        System.out.println();

        // Demonstrate error handling
        System.out.println("--- Error Handling Demonstration ---");
        audioPlayer.play("video/unsupported.avi"); // Audio player can't play video
        videoPlayer.play("music/unsupported.mp3"); // Video player can't play audio
        System.out.println();

        // Demonstrate array of media players
        System.out.println("--- Media Player Array Demonstration ---");
        MediaPlayer[] players = {audioPlayer, videoPlayer};
        String[] mediaFiles = {"music/song.mp3", "videos/clip.mp4"};
        
        for (int i = 0; i < players.length; i++) {
            System.out.printf("\nPlaying media file %d:%n", i + 1);
            players[i].play(mediaFiles[i]);
            players[i].setVolume(60.0);
            players[i].stop();
        }
    }
} 