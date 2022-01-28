package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BlogController {

    private PostRepository postRepository = new PostRepository();

    public BlogController(PostRepository postRepositroy){
        this.postRepository = postRepositroy;
    }

    @RequestMapping("/")
    public String listPosts(ModelMap mm){
        List<Post> allPosts = postRepository.getAllPosts();
        mm.put("posts",allPosts);
        return "home";
    }

    @RequestMapping("/post/{id}")
    public String postDetails(@PathVariable Long id, ModelMap modelMap){

        modelMap.put("post", postRepository.findById(id));
        return "post-details";
    }


}
