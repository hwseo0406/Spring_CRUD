package com.example.dto;

import com.example.entity.EntityBoard;
import com.example.entity.EntityUser;

public class DTOBoard {
    public String boardid;
    public String title;
    public String contents;
    public String author;

    public String getBoardid() {
        return boardid;
    }

    public void setBoardid(String boardid) {
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

    public String date;

    public DTOBoard() {
        boardid = title = contents = author = date = "";
    }

    public EntityBoard ToEntity(){
        return new EntityBoard(-1, this.title, this.contents, this.author, this.date);
    }

    @Override
    public String toString() {
        return "DTOBoard{" +
                "boardid='" + boardid + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", author='" + author + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
