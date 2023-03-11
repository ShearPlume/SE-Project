import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import java.io.File;

public class DBReader{
   String filePath;
   public DBReader(String path)
   {
      filePath=path;
   }
   public DataBase readDB()
   {
      try {
         File inputFile = new File(filePath);
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);         
         doc.getDocumentElement().normalize();
         System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

         return new DataBase (doc);
      } catch (Exception e) {
         e.printStackTrace();
         System.out.println("read error");
      }
      return null;
   }
}