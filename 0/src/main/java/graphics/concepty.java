package graphics;

import java.io.IOException;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class concepty {
    public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException {


        Page xmlReader = new Page("C:/Users/Benham/Sean/programming/idkwutdiswillbecalled/0/src/main/java/graphics/test.xml");
        JFrame frame = new JFrame("waw");
        frame.setContentPane(xmlReader.page);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }    
}
