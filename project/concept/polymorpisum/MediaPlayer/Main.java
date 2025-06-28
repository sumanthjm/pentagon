import java.util.ArrayList;

// Superclass
class MediaFile {
    String fileName;
    double fileSize; // in MB

    // Constructor
    MediaFile(String fileName, double fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    // Method to be overridden
    void play() {
        System.out.println("Playing media: " + fileName);
    }
}

// Subclass: Audio File
class AudioFile extends MediaFile {
    double duration; // in minutes

    AudioFile(String fileName, double fileSize, double duration) {
        super(fileName, fileSize);
        this.duration = duration;
    }

    @Override
    void play() {
        System.out.println("Now playing audio file: " + fileName);
        System.out.println("Size: " + fileSize + " MB");
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("----------------------------");
    }
}

// Subclass: Video File
class VideoFile extends MediaFile {
    String resolution;
    double frameRate;

    VideoFile(String fileName, double fileSize, String resolution, double frameRate) {
        super(fileName, fileSize);
        this.resolution = resolution;
        this.frameRate = frameRate;
    }

    @Override
    void play() {
        System.out.println("Now playing video file: " + fileName);
        System.out.println("Size: " + fileSize + " MB");
        System.out.println("Resolution: " + resolution);
        System.out.println("Frame Rate: " + frameRate + " fps");
        System.out.println("----------------------------");
    }
}

// Main class
public class Main{
    public static void main(String[] args) {
        ArrayList<MediaFile> playlist = new ArrayList<>();

        // Add different media files
        playlist.add(new AudioFile("song1.mp3", 5.2, 3.5));
        playlist.add(new VideoFile("movie.mp4", 750.0, "1920x1080", 30.0));
        playlist.add(new AudioFile("podcast.mp3", 25.0, 45.0));
        playlist.add(new VideoFile("trailer.mkv", 300.0, "1280x720", 24.0));

        // Polymorphic call to play()
        System.out.println("🎵📺 Welcome to Java Media Player\n");
        for (MediaFile media : playlist) {
            media.play(); // Polymorphism in action
        }
    }
}
