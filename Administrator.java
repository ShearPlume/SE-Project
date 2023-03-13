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
        this.writeFileAcess = true;
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

        // make candidate tamplate
        Candidate tempCandidate = new Candidate(); // work-exp, edu-level, gpa, skills
        tempCandidate.setEducationLevel(thisReq.getEducationLevel());
        tempCandidate.setWorkExperience(thisReq.getWorkExperience());
        tempCandidate.setGpa(thisReq.getGpa());
        tempCandidate.setSkills(thisReq.getSkills());

        for(Candidate candidate: cList){
            if(candidate.compareTo(tempCandidate) > 0){
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
        List<Candidate> cList = null;
        Candidate chosenCandidate = null;
        try {
            cList = DBReader.getCandidateList();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            // e.printStackTrace();
        }

        for(Candidate c: cList){
            if(c.getId() == Integer.parseInt(cId)){
                chosenCandidate = c;
                // int sID=c.getId()+1000;
                SuitableStaff suitableStaff = new SuitableStaff(false,c.getName(), c.getWorkExperience(), c.getEducationLevel(), c.getGpa());
                // write suitableStaff to DBWriter
                try {
                    DBWriter.addSuitableStaff(suitableStaff);
                } catch (ParserConfigurationException | IOException | SAXException |TransformerException e) {
                    // e.printStackTrace();
                }
                break ;
            }
        }
        // delete this chosenCandidate from xml candidates
        try {
            DBWriter.deleteXML(Integer.parseInt(cId),"candidate");
        } catch (TransformerException e) {
            // e.printStackTrace();
        }
    }

    public static void trainStaff(String staffId, String time) {
    }
}
