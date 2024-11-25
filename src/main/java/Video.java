public class Video extends Post {
    private String title;
    private int quality;
    private int duration;

    public Video(String title, int quality, int duration) {
        super();
        this.title = title;
        this.quality = quality;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Video: " + title + " (" + quality + "p, " + duration + "mins)";
    }
}

