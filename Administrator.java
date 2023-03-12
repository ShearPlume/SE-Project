import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Administrator extends User{
    // Ye Zhang added on 11/Mar
    public Administrator(int userID){
        this.userID = userID;
        // admin can read requirements but cannot write requirements
        this.readFileAcess = true;
        this.writeFileAcess = false;
    }
    /*
    <requirement>
            <rId>1</rId><!--requirement ID-->
            <rCourse>Math</rCourse><!--requirement course-->
            <rNum>1</rNum><!--required staff number-->
            <rWorkExp>true</rWorkExp><!--required work experience-->
            <rEduLevel>3</rEduLevel><!--education level: doctor > postgraduate > undergraduate-->
            <rGpa>3.0</rGpa>
            <skills><!--required skills-->
                <a>matlab</a>
                <a>excel</a>
            </skills>
        </requirement>
     */

    public static void search(String rId){
        List<Requirement> reqList = null;
        List<Candidate> cList = null;
        List<Candidate> resulList = new ArrayList<Candidate>();
        Requirement thisReq = null;

        try {
            reqList = DBReader.getRequirementList();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            // e.printStackTrace();
        }
        try {
            cList = DBReader.getCandidateList();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            // e.printStackTrace();
        }
        
        // get target requirement
        for(Requirement r: reqList){
            if(Integer.parseInt(rId) == r.getId()){
                thisReq = r;
            }
        }

        // make candidate tamplate: work-exp, edu-level, gpa, skills
        Candidate tempCandidate = new Candidate(thisReq.getWorkExperience(),thisReq.getEducationLevel(),thisReq.getGpa(),thisReq.getSkills());

        for(Candidate candidate: cList){
            if(candidate.compareTo(tempCandidate) == 1){
                resulList.add(candidate);
                if(resulList.size() == thisReq.getNum()){
                    break;
                }
            }
        }
        
        if(resulList.size() == 0){
            System.out.println("No suitable candidate found.");
        }else{
            System.out.println(resulList.toString());
        }
        
    }

    public static void seeAllRequirements(){
        List<Requirement> reqList = null;
        try {
            reqList = DBReader.getRequirementList();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            // e.printStackTrace();
        }
        for(Requirement req: reqList){
            System.out.println(req.toString());
        }
    }

    public static void saveSuitableStaff(String cId) {
        List<Candidate> allCandidats = null;
        Candidate chosenCandidate = null;
        try {
            allCandidats = DBReader.getCandidateList();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            // e.printStackTrace();
        }
        outer:
        for(Candidate c: allCandidats){
            if(c.getId() == Integer.parseInt(cId)){
                chosenCandidate = c;
                int sID=c.getId()+1000;
                SuitableStaff suitableStaff = new SuitableStaff(sID, false,c.getName(), c.getWorkExperience(), c.getEducationLevel(), c.getGpa());
                // write suitableStaff to DBWriter
                try {
                    DBWriter.addSuitableStaff(suitableStaff);
                } catch (ParserConfigurationException | IOException | SAXException | TransformerException e) {
                    // e.printStackTrace();
                }
                // 这部分要把上面suitableStaff相关信息写入XML ↑↑↑
                break outer;
            }
        }

        // 这部分要把上面chosenCandidate相关信息从XML删除 ↓↓↓

        // 这部分要把上面chosenCandidate相关信息从XML删除 ↑↑↑

    }

    public static void trainStaff(String staffId, String time) {
    }
}
