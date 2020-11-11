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

public class Page {
    JPanel page;
    public Page(String jsonURL) throws ParserConfigurationException, SAXException, IOException {
        page = new JPanel();
        XMLUtils xmlReader = new XMLUtils(jsonURL);
        getElements(xmlReader, xmlReader.parsed.getDocumentElement(), page);
    } 
   public static void getElements(XMLUtils xmlReader, Element root, JPanel panel){
        ArrayList<JComponent> components = new ArrayList<>();
        NodeList children = xmlReader.getChildren(root);
        for(int i = 0; i < children.getLength(); i++){
            if(children.item(i).getNodeName() == "button"){
                components.add(new JButton(children.item(i).getTextContent()));
            }
            if(children.item(i).getNodeName() == "label"){
                components.add(new JLabel(children.item(i).getTextContent()));
            }
            if(children.item(i).getNodeName() == "panel"){
                JPanel newPanel = new JPanel();
                getElements(xmlReader, (Element)children.item(i), newPanel);
                components.add(newPanel);
            }
            
        }
        for(int i = 0; i < components.size(); i++){
            System.out.println(i);
            panel.add(components.get(i));
        }
    }
}
