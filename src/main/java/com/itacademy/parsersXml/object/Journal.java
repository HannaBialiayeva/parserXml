package com.itacademy.parsersXml.object;

import java.util.ArrayList;

public class Journal {

    private String title;
    private Contacts contacts;
    private ArrayList<Article> articles;

    public String getTitle() {
        return title;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Journal {" +
                "\n\ttitle = '" + title + '\'' +
                "\n\tcontacts = " + contacts +
                "\n\tarticles = " + articles +
                '}';
    }
}