package com.ihasan.play.play.model;

/**
 * @author Imrul Hasan
 * @date 02/03/19
 */
public class Post {

    private int id;
    private String author;
    private String text;

    public Post(int id, String author, String text) {
        this.id = id;
        this.author = author;
        this.text = text;
    }

    public Post() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

