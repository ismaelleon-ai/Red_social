public class Image extends Post {
    private String title;
    private int width;
    private int height;

    public Image(String title, int width, int height) {
        super();
        this.title = title;
        this.width = width;
        this.height = height;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Imagen: " + title + " (" + width + "x" + height + ")";
    }
}
