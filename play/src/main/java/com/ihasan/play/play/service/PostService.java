package com.ihasan.play.play.service;

import com.ihasan.play.play.model.Post;
import com.ihasan.play.play.model.entity.PostEntity;
import com.ihasan.play.play.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Imrul Hasan
 * @date 02/03/19
 */

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    private List<Post> posts = new ArrayList<>();

    public PostService() {
        Post p1 = new Post();
        p1.setId(221);
        p1.setAuthor("imrul hasan");
        p1.setText("hello world post from imrul");

        Post p2 = new Post();
        p2.setId(222);
        p2.setAuthor("Mahmuda Tumpa");
        p2.setText("hello world post from tumpa22222222222");

        Post p3 = new Post();
        p3.setId(223);
        p3.setAuthor("imrul tareq");
        p3.setText("hello world post from tareq1111111111111");

        Post p4 = new Post();
        p4.setId(224);
        p4.setAuthor("harunur rashid");
        p4.setText("hello world post from rashid 33333");

        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
        posts.add(p4);

    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Post getPost(int id) {
        return posts.stream().filter(p -> p.getId() == id).findAny().get();
    }


    public Post getPost(String author){
        return posts.stream().filter(p -> p.getAuthor().contains(author)).findAny().get();
    }

    public void createPost(PostEntity post){
        postRepository.createPost(post);
    }


    public List<Post> getAllPost(){
        List<PostEntity>  postEntities = postRepository.getAllPosts();
        List<Post> posts = new ArrayList<>();
        postEntities.forEach(postEntity -> {
            posts.add(new Post(postEntity.getId(), postEntity.getAuthor(), postEntity.getText()));
        });
        return posts;
    }
}
