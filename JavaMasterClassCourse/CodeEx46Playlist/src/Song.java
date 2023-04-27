public class Song {
    private String title;
    private double duration;

    public Song(String title, double songDuration) {
        this.title = title;
        this.duration = songDuration;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    public String toString() {
        return this.title + ": " + this.duration;
    }
}
