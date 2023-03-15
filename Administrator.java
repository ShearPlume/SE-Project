import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class Administrator extends User{
    // Ye Zhang added on 11/Mar
    public Administrator(int userID){
        setID(userID);
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

    public static void seeAllCandidates(){
        List<Candidate> canList = null;
        try {
            canList = DBReader.getCandidateList();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            // e.printStackTrace();
        }
        for(Candidate can: canList){
            System.out.println(can.toString());
        }
    }
    
    public static void seeAllStaffs(){
        List<SuitableStaff> sList = null;
        try {
            sList = DBReader.getStaffList();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            // e.printStackTrace();
        }
        for(Candidate s: sList){
            System.out.println(s.toString());
        }
    }

    public void trainStaff(int sID)
    {
        List<SuitableStaff> sList = null;
        // SuitableStaff staffToBeTrained = null;
        try {
            sList = DBReader.getStaffList();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            // e.printStackTrace();
        }
        for(SuitableStaff s: sList){
            if(s.getId() == (sID)){
                            // staffToBeTrained = new SuitableStaff(true,s.getName(), s.getWorkExperience(), s.getEducationLevel(), s.getGpa());
                            // staffToBeTrained.setId(sID);
                            // staffToBeTrained.setSkills(s.getSkills());
                            // write suitableStaff to DBWriter

                            s.setIftrained(true);
                            try {
                                DBWriter.updateStaff(s);
                            } catch (TransformerException e) {
                                // e.printStackTrace();
                            }
                            break ;
                        }
        }
    }
    // public static void feedbackAndSaveStaff(int rID,int cID)
    // {

    //     try {//delete xml
    //         DBWriter.deleteXML(rID, "requirement");
    //     } catch (TransformerException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }//
    //     saveSuitableStaff(cID);//save staff, delete corresponding  candidate code within this method
    //     //feedback starts

        
    //     //feedback ends

    // }

    public static void saveSuitableStaff(int rID,int cId) {
        List<Candidate> cList = null;
        Candidate chosenCandidate = null;
        // try {//delete xml
        //     DBWriter.deleteXML(rID, "requirement");
        // } catch (TransformerException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }//
        try {
            cList = DBReader.getCandidateList();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            // e.printStackTrace();
        }

        for(Candidate c: cList){
            if(c.getId() == (cId)){
                chosenCandidate = c;
                // int sID=c.getId()+1000;
                SuitableStaff suitableStaff = new SuitableStaff(false,c.getName(), c.getWorkExperience(), c.getEducationLevel(), c.getGpa());
                suitableStaff.setSkills(c.getSkills());
                suitableStaff.setId(c.getId());
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
        // try {
        //     DBWriter.deleteXML((cId),"candidate");
        // } catch (TransformerException e) {
        //     // e.printStackTrace();
        // }
    }

}
