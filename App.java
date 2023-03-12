import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws ParserConfigurationException, IOException, TransformerException, SAXException {
        // Get the singleton instance of the CandidateManagementSystem
        CandidateManagementSystem system = CandidateManagementSystem.getInstance();     
        Candidate c=new Candidate("John Wick", true, 2, 99.99);
        c.setSkills(Arrays.asList("eat", "sleep", "play"));
        List<Candidate> cList=DBReader.getCandidateList();
        List<Requirement> rList=DBReader.getRequirementList();
        DBWriter.deleteXML(24349,"candidate");
        DBWriter.addCandidate(c);
        System.out.println(c.toString());
        //other tasks with the CandidateManagementSystem as needed

    }
}