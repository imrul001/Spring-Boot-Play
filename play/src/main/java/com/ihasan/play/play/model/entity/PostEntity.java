package com.ihasan.play.play.model.entity;

import javax.persistence.*;

/**
 * @author Imrul Hasan
 * @date 03/03/19
 */

@Entity(name = "Post")
@Table(name = "Post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private int id;

    @Column(name = "author_name")
    private String author;

    @Column(name = "post_text")
    private String text;

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
