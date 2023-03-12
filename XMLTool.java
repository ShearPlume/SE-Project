

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class XMLTool {
    static final String outputEncoding = "UTF-8";

    public static Document getDocument(String Path) throws ParserConfigurationException, IOException, SAXException {
        //Instantiate the Factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //Instantiate the Builders
        DocumentBuilder db = dbf.newDocumentBuilder();
        //Handling Validation Errors
        OutputStreamWriter errorWriter = new OutputStreamWriter(System.err, outputEncoding);
        db.setErrorHandler(new MyErrorHandler(new PrintWriter(errorWriter, true)));
        //Get a Parser and Parse the File
        Document doc = db.parse(new File(Path));
        return doc;
    }

    //region search xml


    public static Node getNode(Document document, String TagName, String str) {
        NodeList nlist = document.getElementsByTagName(TagName);
        for (int i = 0; i < nlist.getLength(); i++) {
            Node node = nlist.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                System.err.println("Error: Search node not of element type");
                System.exit(22);
            }

            if (!node.hasChildNodes()) return null;

            NodeList sublist = node.getChildNodes();
            for (int j = 0; j < sublist.getLength(); j++) {
                Node subnode = sublist.item(j);
                if (subnode.getNodeType() == Node.ELEMENT_NODE) {
                    if (subnode.getTextContent().equals(str))
                        return subnode.getParentNode();
                }
            }
        }
        return null;
    }

    //endregion
    //region add

    //endregion
    //region delete
    public static void deleteNode(Document document, String TagName, String str, String path) throws TransformerException {
        NodeList nlist = document.getElementsByTagName(TagName);
        for (int i = 0; i < nlist.getLength(); i++) {
            Node node = nlist.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                System.err.println("Error: Search node not of element type");
                System.exit(22);
            }
            NodeList sublist = node.getChildNodes();
            for (int j = 0; j < sublist.getLength(); j++) {
                Node subnode = sublist.item(j);
                if (subnode.getNodeType() == Node.ELEMENT_NODE) {
                    if (subnode.getTextContent().equals(str)) {
                        Node pNode = subnode.getParentNode();
                        pNode.getParentNode().removeChild(pNode);
                        System.out.println("delete " + subnode.getTextContent());
                        saveXml(document, path);
                        return;
                    }

                }
            }
        }

    }

    //endregion
    //region update
    public static void updateNode(Document document, String TagName, String str, String updateStr, String path) throws TransformerException {
        NodeList nlist = document.getElementsByTagName(TagName);
        for (int i = 0; i < nlist.getLength(); i++) {
            Node node = nlist.item(i);
            if (node.getNodeType() != Node.ELEMENT_NODE) {
                System.err.println("Error: Search node not of element type");
                System.exit(22);
            }
            NodeList sublist = node.getChildNodes();
            for (int j = 0; j < sublist.getLength(); j++) {
                Node subnode = sublist.item(j);
                if (subnode.getNodeType() == Node.ELEMENT_NODE) {
                    if (subnode.getTextContent().equals(str)) {
                        subnode.setTextContent(updateStr);
                        System.out.println("update " + str + " to " + updateStr);
                        saveXml(document, path);
                        return;
                    }

                }
            }
        }

    }

    //endregion
    //save xml method
    public static void saveXml(Document document, String path) throws TransformerException {
        // Instantiate a factory class
        TransformerFactory tff = TransformerFactory.newInstance();
        // Instantiate a write-back class
        Transformer tf = tff.newTransformer();
        // Write back method transform()
        tf.transform(new DOMSource(document), new StreamResult(path));
        System.out.println("Save to " + path);
    }

}
