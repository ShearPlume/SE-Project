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
        c.setId(100);
        c.setSkills(Arrays.asList("eat", "sleep", "play"));
        // DBWriter.addCandidate(c);
        // DBWriter.deleteXML(100, "candidate");
        DBReader.getSpecificStaff(100);
        System.out.println(c.toString());
        SuitableStaff Lambo=new SuitableStaff(10001, false, c);
        // DBWriter.addSuitableStaff(Lambo);
        SuitableStaff asd1= DBReader.getSpecificStaff(10001);
        System.out.println(asd1.toString());
        // List<SuitableStaff> ss=DBReader.getCandidateList();
        // List<Candidate> cs=DBReader.getCandidateList();
        // System.out.println(c.getSkills());
        // c=cs.get(0);
        // System.out.println(c.getSkills().get(0));
        // System.out.println(c.toString());
        // System.out.println(cs.get(cs.size()-1).toString());

        // system
        //other tasks with the CandidateManagementSystem as needed

    }
}