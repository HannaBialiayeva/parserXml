package com.itacademy.parsersXml;

import com.itacademy.parsersXml.object.Article;
import com.itacademy.parsersXml.object.Contacts;
import com.itacademy.parsersXml.object.HotKey;
import com.itacademy.parsersXml.object.Journal;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DomParser{

    public static Journal parseXml(String fileName) throws ParserConfigurationException, IOException, SAXException {
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println("The document has been parsed with DOM parser\n");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(fileName));
        Journal journal = new Journal();

        //Title
        String title = doc.getElementsByTagName("title").item(0).getTextContent();
        journal.setTitle(title);

        //Contracts
        journal.setContacts(
                new Contacts(
                        doc.getElementsByTagName("address").item(0).getTextContent(),
                        doc.getElementsByTagName("tel").item(0).getTextContent(),
                        doc.getElementsByTagName("email").item(0).getTextContent(),
                        doc.getElementsByTagName("url").item(0).getTextContent()
                )
        );

        //Articles
        NodeList articlesList = doc.getElementsByTagName("article");
        ArrayList<Article> articles = new ArrayList<>();

        for (int i = 0; i < articlesList.getLength(); i++) {
            Element element = (Element) articlesList.item(i);

            //Adding hotkeys
            ArrayList<HotKey> hotKeysList = new ArrayList<>();
            NodeList hotKeys = element.getElementsByTagName("hotkey");

            for (int z = 0; z < hotKeys.getLength(); z++) {
                Element hotKeyElement = (Element) hotKeys.item(z);
                hotKeysList.add(
                        new HotKey(
                                hotKeyElement.getTextContent()
                        )
                );
            }

            //Adding article
            articles.add(
                    new Article(
                            element.getElementsByTagName("title").item(0).getTextContent(),
                            element.getElementsByTagName("author").item(0).getTextContent(),
                            element.getElementsByTagName("url").item(0).getTextContent(),
                            hotKeysList
                    )
            );

            journal.setArticles(articles);

        }
        System.out.println("+++++++++++++++++++++++++++");
        return journal;
    }
}
