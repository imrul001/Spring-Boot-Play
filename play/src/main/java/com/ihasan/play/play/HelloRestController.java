package com.ihasan.play.play;

import com.ihasan.play.play.model.Post;
import com.ihasan.play.play.model.entity.PostEntity;
import com.ihasan.play.play.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Imrul Hasan
 * @date 02/03/19
 */

@RestController
public class HelloRestController {


    @Autowired
    private PostService postService;

    @RequestMapping(value = "/bin/ihasan/posts")
    public List<Post> getPost() {

        PostEntity post = new PostEntity();
        post.setAuthor("John Abrahum");
        post.setText("I am loving spring service development");

        postService.createPost(post);

        return postService.getAllPost();
    }

    @RequestMapping(value = "/bin/ihasan/posts/{id}", method = RequestMethod.GET)
    public Post getPostById(@PathVariable(name = "id") int id) {
        return postService.getPost(id);
    }

    @RequestMapping(value = "/bin/ihasan/postbyauthor", method = RequestMethod.GET)
    public Post getPostByAuthor(@RequestParam(name = "author") String author) {
        return postService.getPost(author);
    }
}
