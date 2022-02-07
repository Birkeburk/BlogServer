package com.example.serverblog;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BlogService {
    ArrayList<BlogPost> allBlogPosts;
    int latestBlogPostID;

    //Vår konstruktor
    public BlogService() {
        allBlogPosts = new ArrayList<>();
        latestBlogPostID = 0;
    }

    //Plockar fram array list av inlägg och returnerar dem
    public ArrayList<BlogPost> getBlogPosts() {
        return allBlogPosts;
    }

    //Plockar fram ett blog inlägg och returnerar det med hjälp av angivet id
    public BlogPost getBlogPost(int id) {
        return getBlogPostByID(id);
    }

    //Tar bort ett blog inlägg från en arraylist med hjälp av angivet id
    public boolean deleteBlogPost(int id) {
        BlogPost fetchedPost = getBlogPostByID(id);
        if (fetchedPost != null) {
            allBlogPosts.remove(fetchedPost);
            return true;
        } else {
            return false;
        }
    }

    //Skriver över ett befintligt inlägg för att uppdatera det med hjälp av angivet id och innehåll
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

    //Lägger till id på inlägg och lägger till det till en arraylist
    public void createBlogPost(BlogPost newBlogPost) {
        latestBlogPostID++;
        newBlogPost.setId(latestBlogPostID);
        allBlogPosts.add(newBlogPost);
    }

    //Returnerar ett inlägg efter id
    private BlogPost getBlogPostByID(int id) {
        for (int i = 0; i < allBlogPosts.size(); i++) {
            BlogPost currentBlogPost = allBlogPosts.get(i);
            if (currentBlogPost.getId() == id) {
                return allBlogPosts.get(i);
            }
        }
        return null;
    }

    //Byter ut gammalt inlägg mot nytt
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
