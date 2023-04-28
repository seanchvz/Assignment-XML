/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.xmlparser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import java.io.File;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;



/**
 *
 * @author sevchavez
 */
public class MyXMLParser {
    public void parseXML(String fileName) throws Exception {
        File inputFile = new File("plant_catalog.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory. newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();
        
        // Create a two-dimensional array to store the data
        Object[][] data = new Object[doc.getElementsByTagName("PLANT").getLength()][6];
        
        NodeList nList = doc.getElementsByTagName("PLANT");
        
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
        
        // Create a JTable with the data and column names
        JTable table = new JTable(data, columnNames);
        
        // Create a JFrame to display the JTable
        JFrame frame = new JFrame();
        frame.add(new JScrollPane(table));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    //CD CATALOG
    
        
        
    

    
}