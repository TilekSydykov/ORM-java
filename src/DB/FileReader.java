package DB;

import DB.helpers.Column;
import DB.helpers.Database;
import DB.helpers.Table;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class FileReader {
    public Database getSchema() throws Exception{
        File file = new File(System.getProperty("user.dir")+"\\schema.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        doc.getDocumentElement().normalize();
        Database database = new Database();
        NodeList nodeList = doc.getElementsByTagName("table");
        for (int itr = 0; itr < nodeList.getLength(); itr++) {
            Element tableElement = (Element) nodeList.item(itr);;
            Table t = new Table();
            t.setName(tableElement.getAttribute("name"));
            NodeList columnsList = tableElement.getElementsByTagName("column");
            for (int i = 0; i < columnsList.getLength(); i++) {
                Element columnNode = (Element) columnsList.item(i);
                Column c = new Column();
                c.setAutoIncrement(columnNode.hasAttribute("autoincrement"));
                c.setName(columnNode.getAttribute("name"));
                c.setPrimary(columnNode.getAttribute("primary").equals("true"));
                c.setNull((columnNode.getAttribute("null").equals("true")));
                c.setDefaultValue(columnNode.getAttribute("default"));
                c.setType(columnNode.getAttribute("type"));
                t.addColumn(c);
            }
            database.addTable(t);
        }
        return database;
    }
}