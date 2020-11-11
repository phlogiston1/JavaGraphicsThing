package graphics;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class concepty {
    static ArrayList<JComponent> components = new ArrayList<>();
    public static void getElements(XMLUtils xmlReader, Element root, ArrayList<JComponent> components, JPanel panel){

        NodeList children = xmlReader.getChildren(root);
        for(int i = 0; i < children.getLength(); i++){
            if(children.item(i).getNodeName() == "button"){
                components.add(new JButton(children.item(i).getTextContent()));
            }
            if(children.item(i).getNodeName() == "label"){
                components.add(new JLabel(children.item(i).getTextContent()));
            }
        }
        for(int i = 0; i < components.size(); i++){
            System.out.println(i);
            panel.add(components.get(i));
        }
    }
    public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException {


        XMLUtils xmlReader = new XMLUtils("C:/Users/Benham/Sean/programming/idkwutdiswillbecalled/0/src/main/java/graphics/test.xml");
        JFrame frame = new JFrame("waw");
        getElements(xmlReader, xmlReader.parsed.getDocumentElement(), components, (JPanel)frame.getContentPane());
        frame.setVisible(true);
        frame.setLayout(new GridLayout(3,3));
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }    
}
