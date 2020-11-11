package graphics;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import graphics.components.Components;

public class Page {
    JPanel page;
    public Page(String jsonURL) throws ParserConfigurationException, SAXException, IOException {
        page = new JPanel();
        XMLUtils xmlReader = new XMLUtils(jsonURL);
        Components.getComponent(xmlReader, xmlReader.parsed.getDocumentElement(), page);
    } 
}
