package com.example.serverblog;

//Paket som används av spring ramverket

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Används för att logga händelser och information
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "api/v1/blog")
public class BlogController {
    private BlogService blogService;
    private Logger logger;

    @Autowired
    public BlogController(BlogService blogService) {

        this.blogService = blogService;
        logger = LoggerFactory.getLogger(BlogController.class);
    }

    //Metod för att returnera en responsecode för att berätta om det gick bra eller dåligt att skapa ett inlägg
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Void> addBlogPost(@RequestBody BlogPost blogPost) {

        if (blogPost.getTitle().equals("") || blogPost.getBody().equals("")) {
            logger.warn("Couldn't create blog post.");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            blogService.createBlogPost(blogPost);
            logger.info("Blog post with ID: [" + blogPost.getId() + "] has successfully been created.");
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    //Metod för att returnera en arraylist av Blog inlägg
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<BlogPost>> listBlogPosts() {

        logger.info("Blog posts are being loaded.");
        return new ResponseEntity<>(blogService.getBlogPosts(), HttpStatus.OK);
    }

    //Metod för att returnera ett specifikt Blog inlägg om det finns
    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public ResponseEntity<BlogPost> listBlogPost(@PathVariable("id") int id) {

        BlogPost fetchedPost = blogService.getBlogPost(id);

        if (fetchedPost == null) {
            logger.warn("Couldn't find blog post with ID: [" + id + "].");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } else {
            logger.info("Loading blog post with ID: [" + id + "].");
            return new ResponseEntity<>(fetchedPost, HttpStatus.OK);
        }
    }

    //Metod för att returnera en responsecode för att berätta för klienten om det gick bra eller dåligt att updater inlägg
    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public ResponseEntity<BlogPost> updateBlogPost(@PathVariable("id") int id, @RequestBody BlogPost blogPostChanges) {

        String title = blogPostChanges.getTitle();
        String body = blogPostChanges.getBody();

        if (title.equals("") || body.equals("")) {
            logger.warn("Missing body or title updating post with ID: [" + id + "];" + blogPostChanges);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        BlogPost updatedBlogPost = blogService.updateBlogPost(id, title, body);

        if (updatedBlogPost != null) {
            logger.info("Blog post with ID: [" + id + "] has been updated.");
            return new ResponseEntity<>(updatedBlogPost, HttpStatus.OK);
        } else {
            logger.warn("Blog post with ID: [" + id + "] doesn't exist.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Metod för att returnera en responsecode för att berätta för klienten om det gick bra eller dåligt att radera inlägg
    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBlogPost(@PathVariable("id") int id) {
        boolean success = blogService.deleteBlogPost(id);

        if (success) {
            logger.info("Blog post with ID: [" + id + "] has been deleted.");
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            logger.warn("Blog post with ID: [" + id + "] was not found.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
