
package guest.book;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class PostManager {
    private final List<Post> posts = new ArrayList<>();
    
    public PostManager() {}
    
    public Post post(User author, String title, String content) {
        if (content.isEmpty() || content.length() > 500)
            return null;
        Post post = new Post(author, title, content, LocalDateTime.now());
        posts.add(post);
        return post;
    }
    
    public List<Post> getAllPosts(int offset, int length) {
        Collections.sort(posts,
            (a,b) -> b.getPosted().compareTo(a.getPosted()));
        return posts
                .stream()
                .skip(offset)
                .limit(length)
                .collect(Collectors.toList());
    }
}
