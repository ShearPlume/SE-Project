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
        
        system.start();
        // Administrator. seeAllRequirements();
        // ClassDirector cd=new ClassDirector(1);
        // cd.writeReqToDatabase();

  // course=s.nextLine();
                // workExperience = Boolean.parseBoolean(s.nextLine());
                // educationLevel=Integer.parseInt(s.nextLine());
                // Gpa=Double.parseDouble(s.nextLine());
                // String allSkills = s.nextLine();
                // System.out.println(course+workExperience+educationLevel+Gpa);
                // if (allSkills.contains(",")) { //if more than one skill
                //     String[] arr = allSkills.split(",");
                //     for (int i = 0; i < arr.length; i++) {
                //         skills.add(arr[i]);
                //     }
                // } else { //if only one skill
                //     skills.add(allSkills);
                // }
                // System.out.println(skills);


        // Candidate c=new Candidate("John Wick", true, 2, 99.99);
        // c.setId(100);
        // c.setSkills(Arrays.asList("eat", "sleep", "play"));
        // DBWriter.addCandidate(c);
        // DBWriter.deleteXML(100, "candidate");
        // DBReader.getSpecificObject(100,"staff");
        // System.out.println(c.toString());
        // SuitableStaff Lambo=new SuitableStaff( false, c);
        // DBWriter.addSuitableStaff(Lambo);
        // SuitableStaff asd1= (SuitableStaff)DBReader.getSpecificObject(10001,"Staff");
        // // System.out.println(asd1.toString());
        // System.out.println(DBReader.getSpecificObject(1,"requirement").toString());
        // System.out.println(DBReader.getSpecificObject(24349,"candidate").toString());
        // System.out.println(DBReader.getSpecificObject(100,"Staff").toString());
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

    // public void ()

}