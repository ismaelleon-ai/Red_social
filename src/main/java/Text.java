public class Text extends Post {
    private String content;

    public Text(String content) {
        super();
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Texto: " + content;
    }
}

