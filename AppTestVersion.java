import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class AppTestVersion {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        // Get the singleton instance of the CandidateManagementSystem
        CandidateManagementSystem system = CandidateManagementSystem.getInstance();     
        Candidate c=new Candidate("John Wick", true, 2, 99.99);
        c.setSkills(Arrays.asList("eat", "sleep", "play"));
        System.out.println(c.toString());
        SuitableStaff Lambo=new SuitableStaff(10001, false, "Lambo", true, 2, 0.0);
        DBWriter.addSuitableStaff(Lambo);
        // system
        //other tasks with the CandidateManagementSystem as needed

    }
}