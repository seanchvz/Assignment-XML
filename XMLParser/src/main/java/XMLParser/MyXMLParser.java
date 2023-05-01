package XMLParser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import java.io.File;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Admin
 */
public class MyXMLParser {

    public void parseXML(String fileName) throws Exception {
        File inputFile = new File("plant_catalog.xml");
        // Create a DocumentBuilderFactory object
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        // Parse the XML file and store the result in a Document object
        doc.getDocumentElement().normalize();

        // Create a two-dimensional array to store the data
        Object[][] data = new Object[doc.getElementsByTagName("PLANT").getLength()][6];

        NodeList nList = doc.getElementsByTagName("PLANT");
        
        // Loop through
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;

                // Extract the data for each column and store it in the array
                data[temp][0] = eElement.getElementsByTagName("COMMON").item(0).getTextContent();
                data[temp][1] = eElement.getElementsByTagName("BOTANICAL").item(0).getTextContent();
                data[temp][2] = eElement.getElementsByTagName("ZONE").item(0).getTextContent();
                data[temp][3] = eElement.getElementsByTagName("LIGHT").item(0).getTextContent();
                data[temp][4] = eElement.getElementsByTagName("PRICE").item(0).getTextContent();
                data[temp][5] = eElement.getElementsByTagName("AVAILABILITY").item(0).getTextContent();
            }
        }

        // Create an array of column names
        String[] columnNames = {"COMMON", "BOTANICAL", "ZONE", "LIGHT", "PRICE", "AVAILABILITY"};

        // Calculate the maximum width for each column
        System.out.println("PLANT CATALOG"); // TITLE
        int[] columnWidths = new int[columnNames.length];
        for (int i = 0; i < columnNames.length; i++) {
            columnWidths[i] = columnNames[i].length();
        }
        for (Object[] data1 : data) {
            for (int j = 0; j < data1.length; j++) {
                if (data1[j].toString().length() > columnWidths[j]) {
                    columnWidths[j] = data1[j].toString().length();
                }
            }
        }

        // Print the table to the console with aligned columns
        System.out.print("| ");
        for (int i = 0; i < columnNames.length; i++) {
            System.out.printf("%-" + columnWidths[i] + "s | ", columnNames[i]);
        }
        System.out.println();
        for (Object[] data1 : data) {
            System.out.print("| ");
            for (int j = 0; j < data1.length; j++) {
                System.out.printf("%-" + columnWidths[j] + "s | ", data1[j]);
            }
            System.out.println();
        }
    }

    //FOOD MENU
    public void parseXMLfm(String fileName) throws Exception {
        File inputFile = new File("food_menu.xml");
        // Create a DocumentBuilderFactory object
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc1 = dBuilder.parse(inputFile);
        // Parse the XML file and store the result in a Document object
        doc1.getDocumentElement().normalize();

        // Create a two-dimensional array to store the data
        Object[][] data = new Object[doc1.getElementsByTagName("food").getLength()][4];

        NodeList nList1 = doc1.getElementsByTagName("food");
           
        // Loop through
        for (int temp = 0; temp < nList1.getLength(); temp++) {
            Node nNode1 = nList1.item(temp);

            if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode1;

                // Extract the data for each column and store it in the array
                data[temp][0] = eElement.getElementsByTagName("name").item(0).getTextContent();
                data[temp][1] = eElement.getElementsByTagName("price").item(0).getTextContent();
                data[temp][2] = eElement.getElementsByTagName("description").item(0).getTextContent();
                data[temp][3] = eElement.getElementsByTagName("calories").item(0).getTextContent();

            }
        }

        // Create an array of column names
        String[] columnNames = {"name", "price", "description", "calories"};

        // Calculate the maximum width for each column
        System.out.println("FOOD MENU");
        int[] columnWidths = new int[columnNames.length];
        for (int i = 0; i < columnNames.length; i++) {
            columnWidths[i] = columnNames[i].length();
        }
        for (Object[] data1 : data) {
            for (int j = 0; j < data1.length; j++) {
                if (data1[j].toString().length() > columnWidths[j]) {
                    columnWidths[j] = data1[j].toString().length();
                }
            }
        }

        // Print the table to the console with aligned columns
        System.out.print("| ");
        for (int i = 0; i < columnNames.length; i++) {
            System.out.printf("%-" + columnWidths[i] + "s | ", columnNames[i]);
        }
        System.out.println();
        for (Object[] data1 : data) {
            System.out.print("| ");
            for (int j = 0; j < data1.length; j++) {
                System.out.printf("%-" + columnWidths[j] + "s | ", data1[j]);
            }
            System.out.println();
        }
    }

    // CD CATALOG
    public void parseXMLcd(String fileName) throws Exception {
        File inputFile = new File("cd_catalog.xml");
        // Create a DocumentBuilderFactory object
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc2 = dBuilder.parse(inputFile);
        // Parse the XML file and store the result in a Document object
        doc2.getDocumentElement().normalize();

        // Create a two-dimensional array to store the data
        Object[][] data = new Object[doc2.getElementsByTagName("CD").getLength()][6];

        NodeList nList2 = doc2.getElementsByTagName("CD");
           
        // Loop through
        for (int temp = 0; temp < nList2.getLength(); temp++) {
            Node nNode2 = nList2.item(temp);

            if (nNode2.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode2;

                // Extract the data for each column and store it in the array
                data[temp][0] = eElement.getElementsByTagName("TITLE").item(0).getTextContent();
                data[temp][1] = eElement.getElementsByTagName("ARTIST").item(0).getTextContent();
                data[temp][2] = eElement.getElementsByTagName("COUNTRY").item(0).getTextContent();
                data[temp][3] = eElement.getElementsByTagName("COMPANY").item(0).getTextContent();
                data[temp][4] = eElement.getElementsByTagName("PRICE").item(0).getTextContent();
                data[temp][5] = eElement.getElementsByTagName("YEAR").item(0).getTextContent();

            }
        }

        // Create an array of column names
        String[] columnNames = {"TITLE", "ARTIST", "COUNTRY", "COMPANY", "PRICE", "YEAR"};

        // Calculate the maximum width for each column
        System.out.println("CD CATALOG");
        int[] columnWidths = new int[columnNames.length];
        for (int i = 0; i < columnNames.length; i++) {
            columnWidths[i] = columnNames[i].length();
        }
        for (Object[] data1 : data) {
            for (int j = 0; j < data1.length; j++) {
                if (data1[j].toString().length() > columnWidths[j]) {
                    columnWidths[j] = data1[j].toString().length();
                }
            }
        }

        // Print the table to the console with aligned columns
        System.out.print("| ");
        for (int i = 0; i < columnNames.length; i++) {
            System.out.printf("%-" + columnWidths[i] + "s | ", columnNames[i]);
        }
        System.out.println();
        for (Object[] data1 : data) {
            System.out.print("| ");
            for (int j = 0; j < data1.length; j++) {
                System.out.printf("%-" + columnWidths[j] + "s | ", data1[j]);
            }
            System.out.println();
        }
    }

}
