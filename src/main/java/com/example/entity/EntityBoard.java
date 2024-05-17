package com.example.entity;

import jakarta.persistence.*;

@Entity
public class EntityBoard {

    public EntityBoard() {
        this.boardid = -1;
        this.title = "";
        this.contents = "";
        this.author = "";
        this.date = "";
    }

    public int getBoardid() {
        return boardid;
    }

    public void setBoardid(int boardid) {
        this.boardid = boardid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public EntityBoard(int boardid, String title, String contents, String author, String date) {
        super();
        this.boardid = boardid;
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int boardid;

    @Column
    String title;
    @Column
    String contents;
    @Column
    String author;
    @Column
    String date;

    @Override
    public String toString() {
        return "EntityBoard{" +
                "boardid=" + boardid +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                '}';
    }


}
