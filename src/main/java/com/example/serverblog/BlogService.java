package com.example.serverblog;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BlogService {
    ArrayList<BlogPost> allBlogPosts;
    int latestBlogPostID;

    public BlogService() {
        allBlogPosts = new ArrayList<>();
        latestBlogPostID = 0;
    }

    public ArrayList<BlogPost> getBlogPosts() {
        return allBlogPosts;
    }

    public BlogPost getBlogPost(int id) {
        return getBlogPostByID(id);
    }

    public boolean deleteBlogPost(int id) {
        BlogPost fetchedPost = getBlogPostByID(id);
        if (fetchedPost != null) {
            allBlogPosts.remove(fetchedPost);
            return true;
        } else {
            return false;
        }
    }

    public BlogPost updateBlogPost(int id, String title, String body) {
        BlogPost postToUpdate = getBlogPostByID(id);

        if (postToUpdate == null) {
            // Returnerar null för att vi inte hittat något blog inlägg med angivet ID
            return null;
        }
        postToUpdate.setTitle(title);
        postToUpdate.setBody(body);

        return updateBlogPostByID(id, postToUpdate);
    }

    public BlogPost createBlogPost(BlogPost newBlogPost) {
        latestBlogPostID++;
        newBlogPost.setId(latestBlogPostID);
        allBlogPosts.add(newBlogPost);
        return newBlogPost;
    }

    private BlogPost getBlogPostByID(int id) {
        for (int i = 0; i < allBlogPosts.size(); i++) {
            BlogPost currentBlogPost = allBlogPosts.get(i);
            if (currentBlogPost.getId() == id) {
                return allBlogPosts.get(i);
            }
        }
        return null;
    }

    private BlogPost updateBlogPostByID(int id, BlogPost updatedBlogPost) {
        for (int i = 0; i < allBlogPosts.size(); i++) {
            BlogPost currentBlogPost = allBlogPosts.get(i);
            if (currentBlogPost.getId() == id) {
                allBlogPosts.set(i, updatedBlogPost);
                return allBlogPosts.get(i);
            }
        }
        return null;
    }
}
