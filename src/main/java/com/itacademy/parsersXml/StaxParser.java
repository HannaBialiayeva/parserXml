package com.itacademy.parsersXml;

import com.itacademy.parsersXml.object.Article;
import com.itacademy.parsersXml.object.Contacts;
import com.itacademy.parsersXml.object.HotKey;
import com.itacademy.parsersXml.object.Journal;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class StaxParser {

    public static Journal parseXml(String fileName) throws FileNotFoundException, XMLStreamException {
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println("The document has been parsed with STAX parser\n");

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));

        Journal journal = new Journal();
        Contacts contacts = new Contacts();
        ArrayList<Article> articles = new ArrayList<>();

        //Adding general information
        while (reader.hasNext()) {
            XMLEvent nextEvent = reader.nextEvent();

            if (nextEvent.isStartElement()) {
                StartElement startElement = nextEvent.asStartElement();

                switch (startElement.getName().getLocalPart()) {
                    case "title":
                        nextEvent = reader.nextEvent();
                        if (journal.getTitle() == null) {
                            journal.setTitle(nextEvent.asCharacters().getData());
                        }
                        break;
                    case "address":
                        nextEvent = reader.nextEvent();
                        contacts.setAddress(nextEvent.asCharacters().getData());
                        break;
                    case "tel":
                        nextEvent = reader.nextEvent();
                        contacts.setTel(nextEvent.asCharacters().getData());
                        break;
                    case "email":
                        nextEvent = reader.nextEvent();
                        contacts.setEmail(nextEvent.asCharacters().getData());
                        break;
                    case "url":
                        nextEvent = reader.nextEvent();
                        contacts.setUrl(nextEvent.asCharacters().getData());
                        break;
                }
            }
        }

        //Adding articles
        xmlInputFactory = XMLInputFactory.newInstance();
        reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));

        Article article = new Article();
        ArrayList<HotKey> hotkeys = new ArrayList<>();

        while (reader.hasNext()) {
            XMLEvent nextEvent = reader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElement = nextEvent.asStartElement();

                switch (startElement.getName().getLocalPart()) {
                    case "title":
                        nextEvent = reader.nextEvent();
                        article.setTitle(nextEvent.asCharacters().getData());
                        break;
                    case "author":
                        nextEvent = reader.nextEvent();
                        article.setAuthor(nextEvent.asCharacters().getData());
                        break;
                    case "url":
                        nextEvent = reader.nextEvent();
                        article.setUrl(nextEvent.asCharacters().getData());
                        break;
                    case "hotkey":
                        nextEvent = reader.nextEvent();
                        hotkeys.add(
                                new HotKey(nextEvent.asCharacters().getData())
                        );
                }

            }

            if (nextEvent.isEndElement()) {
                EndElement endElement = nextEvent.asEndElement();
                if (endElement.getName().getLocalPart().equals("article")) {
                    article.setHotkeys(hotkeys);
                    articles.add(article);
                    article = new Article();
                    hotkeys = new ArrayList<>();
                }
            }
        }

        journal.setContacts(contacts);
        journal.setArticles(articles);
        System.out.println("+++++++++++++++++++++++++++");
        return journal;

    }

}