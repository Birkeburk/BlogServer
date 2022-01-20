package com.example.serverblog;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "api/v1/blog")
public class BlogController {

    ArrayList<BlogPost> allBlogPosts;
    int latestBlogPostID;

    public BlogController(){

        allBlogPosts = new ArrayList<>();
        latestBlogPostID = 0;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public BlogPost addBlogPost(@RequestBody BlogPost blogPost){
        latestBlogPostID++;
        blogPost.setId(latestBlogPostID);
        allBlogPosts.add(blogPost);
        System.out.println("BlogPost has successfully been created");
        return blogPost;
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ArrayList<BlogPost> listBlogPosts(){
        System.out.println("BlogPosts are being loaded");
        return allBlogPosts;
    }

    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public BlogPost listBlogPost(@PathVariable("id") int id){
        System.out.println("BlogPost is being loading");
        return getBlogPostByID(id);
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PATCH)
    public BlogPost updateBlogPost(@PathVariable("id") int id, @RequestBody BlogPost blogPostChanges){
        System.out.println("Getting blog post with id " + id);
        BlogPost blogPostToUpdate = getBlogPostByID(id);

        if(blogPostChanges.getTitle() != null){
            blogPostToUpdate.setTitle(blogPostChanges.getTitle());
        }
        if(blogPostChanges.getBody() != null){
            blogPostToUpdate.setBody(blogPostChanges.getBody());
        }

        updateBlogPostByID(id, blogPostToUpdate);

        System.out.println("Blog post with id " + id + " has successfully been updated");

        return blogPostToUpdate;
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteBlogPost(@PathVariable("id") int id){
        System.out.println("Getting blog post with id " + id);
        for(int i = 0; i < allBlogPosts.size(); i++){
            if(getBlogPostByID(id) == allBlogPosts.get(i)){
                allBlogPosts.remove(i);
                System.out.println("Blog post with id " + id + " has successfully been deleted");
            }
        }
    }

    private BlogPost getBlogPostByID(int id){
        for(int i = 0; i < allBlogPosts.size(); i++){
            BlogPost currentBlogPost = allBlogPosts.get(i);
            if(currentBlogPost.getId() == id){
                return allBlogPosts.get(i);
            }
        }
        return new BlogPost();
    }
    private BlogPost updateBlogPostByID(int id, BlogPost updatedBlogPost){
        for(int i = 0; i < allBlogPosts.size(); i++){
            BlogPost currentBlogPost = allBlogPosts.get(i);
            if(currentBlogPost.getId() == id){
                allBlogPosts.set(i, updatedBlogPost);
                return allBlogPosts.get(i);
            }
        }
        return new BlogPost();
    }
}
