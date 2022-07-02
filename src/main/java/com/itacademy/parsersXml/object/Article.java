package com.itacademy.parsersXml.object;

import java.util.ArrayList;

public class Article {

    private String title;
    private String author;
    private String url;
    private ArrayList<HotKey> hotkeys;

    public Article(String title, String author, String url, ArrayList<HotKey> hotkeys) {
        this.title = title;
        this.author = author;
        this.url = url;
        this.hotkeys = hotkeys;
    }

    public Article() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setHotkeys(ArrayList<HotKey> hotkeys) {
        this.hotkeys = hotkeys;
    }

    @Override
    public String toString() {
        return "\n\t\tArticle{" +
                "\n\t\t\ttitle = '" + title + '\'' +
                "\n\t\t\tauthor = '" + author + '\'' +
                "\n\t\t\turl = '" + url + '\'' +
                "\n\t\t\thotkeys = " + hotkeys +
                '}';
    }
}
