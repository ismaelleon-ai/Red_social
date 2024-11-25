import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<User> follow;
    private List<Post> posts;

    public User(String name) {
        this.name = name;
        this.follow = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<User> getFollow() {
        return follow;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void seguir(User user) {
        if (!follow.contains(user)) {
            follow.add(user);
        }
    }

    public void unfollow(User user) {
        follow.remove(user);
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public void deletePost(Post post) {
        posts.remove(post);
    }

    public void showFollowUsers() {
        if (follow.isEmpty()) {
            System.out.println("No sigue a ningún usuario.");
        } else {
            System.out.println("Sigue a los siguientes usuarios:");
            for (User user : follow) {
                System.out.println("- " + user.getName());
            }
        }
    }
}
