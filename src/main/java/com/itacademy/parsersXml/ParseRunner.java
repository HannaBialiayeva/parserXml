package com.itacademy.parsersXml;

import com.itacademy.parsersXml.DomParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class ParseRunner {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XMLStreamException {
        String FILE_NAME = "src/main/resources/text.xml";
        System.out.println(DomParser.parseXml(FILE_NAME));
        System.out.println(StaxParser.parseXml(FILE_NAME));
    }
}
