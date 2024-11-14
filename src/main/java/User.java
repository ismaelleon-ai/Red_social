import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class User {
    private String name;
    private List<User> following;
    private List<Post> posts;

    public User(String name) {
        this.name = name    ;
        this.following = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public void addPost(Post post){
        posts.add(post);
    }

    public void deletePost(Post post){
        posts.remove(post);
    }

    public void followUser(User user){
        if(!following.contains(user)&& user!=this) {
            following.add(user);
        }
    }

    public void unfollowUser(User user){
        following.remove(user);
    }

    public List<Post> listPosts(){
        return posts;
    }

    public List<Comments> listComments(){
        List<Comments> comments = new ArrayList<>();
        for (Post post : posts){
            comments.addAll(post.getUserComments(this));
        }
        return comments;
    }

    public List<Post> showFeed(){
        List<Post> feed = new ArrayList<>();
        for (User u: following) {
            feed.addAll(u.listPosts());
        }
        return feed;
    }

    public void setFollowing(List<User> following) {
        this.following = following;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getFollowing(){
        return following;
    }
}
