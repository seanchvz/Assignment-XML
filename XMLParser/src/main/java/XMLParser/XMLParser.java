/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package XMLParser;

/**
 *
 * @author Admin
 */
public class XMLParser {

    public static void main(String[] args) throws Exception {
        MyXMLParser parse = new MyXMLParser();
        parse.parseXML("plant_catalog.xml");
        
        MyXMLParser parsefm = new MyXMLParser();
        parsefm.parseXMLfm("food_menu.xml");
        
        MyXMLParser parsecd = new MyXMLParser();
        parsecd.parseXMLcd("cd_catalog.xml");
    
    
    
    }
}

