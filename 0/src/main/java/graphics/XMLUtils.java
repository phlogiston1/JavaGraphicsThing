package graphics;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.Scanner;

public class XMLUtils {
    public Document parsed;
    public XMLUtils(String xmlURL) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        StringBuilder xmlStringBuilder = new StringBuilder();

        String xml = "";
        try {
            File myObj = new File("C:/Users/Benham/Sean/programming/idkwutdiswillbecalled/0/src/main/java/graphics/test.xml");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                xml += data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        xmlStringBuilder.append(xml);

        ByteArrayInputStream input = new ByteArrayInputStream(xmlStringBuilder.toString().getBytes("UTF-8"));
        parsed = builder.parse(input);
    }
    public NodeList getElementsByTag(String tagName){
        return parsed.getElementsByTagName(tagName);
    }
    public NodeList getChildren(Element root) {
        return root.getChildNodes();
    }
    public static void main(String args[]) throws ParserConfigurationException, SAXException, IOException {
        XMLUtils xmlReader = new XMLUtils("C:/Users/Benham/Sean/programming/idkwutdiswillbecalled/0/src/main/java/graphics/test.xml");
        Element root = xmlReader.parsed.getDocumentElement();
        NodeList children = root.getChildNodes();
        System.out.println(children.item(0).getChildNodes().item(0).getChildNodes().getLength());
    }
}
