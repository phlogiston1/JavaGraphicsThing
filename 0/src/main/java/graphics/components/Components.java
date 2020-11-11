package graphics.components;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import graphics.XMLUtils;
import graphics.layout.Styles;

public class Components {   
    public static ArrayList<Styles> styles = new ArrayList<>();
   public static void getComponent(XMLUtils xmlReader, Element root, JPanel panel){
        ArrayList<JComponent> components = new ArrayList<>();
        NodeList children = xmlReader.getChildren(root);
        for(int i = 0; i < children.getLength(); i++){
            if(children.item(i).getNodeName() == "button"){
                components.add(new JButton(children.item(i).getTextContent()));
            }
            if(children.item(i).getNodeName() == "label"){
                components.add(new JLabel(children.item(i).getTextContent()));
            }
            if(children.item(i).getNodeName() == "check"){
                components.add(new JCheckBox(children.item(i).getTextContent()));
            }
            if(children.item(i).getNodeName() == "panel"){
                JPanel newPanel = new JPanel();
                String layoutAttr = ((Element)children.item(i)).getAttribute("layout");
                System.out.println(layoutAttr);
                if(layoutAttr.equals("grid")){
                    int rowsAttr = Integer.parseInt(((Element)children.item(i)).getAttribute("rows"));
                    int colsAttr = Integer.parseInt(((Element)children.item(i)).getAttribute("cols"));
                    System.out.println(colsAttr + ' ' + layoutAttr);
                    newPanel.setLayout(new GridLayout(rowsAttr, colsAttr));
                }
                getComponent(xmlReader, (Element)children.item(i), newPanel);
                components.add(newPanel);
            }
            styles.add(new Styles());
        }
        for(int i = 0; i < components.size(); i++){
            panel.add(components.get(i));
        }
    }
}
