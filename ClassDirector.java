import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;
public class ClassDirector extends User{
    // private String className;
    ArrayList<Integer>reqList;
    public ClassDirector(int userID){
        // this.className = className;
        this.userID=userID;
        this.readFileAcess = false;
        this.writeFileAcess = true;
        reqList=new ArrayList<>();
    }

    public void trainStaff(ArrayList<SuitableStaff> suitableStaffs)
    {
        return;
    }

    public void trainStaff(int sID)
    {
        List<SuitableStaff> sList = null;
        SuitableStaff staffToBeTrained = null;
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
    // public void trainStaff(int sID)
    // {



    //     for(SuitableStaff s: sList){
    //         if(s.getId() == (sID)){
    //             staffToBeTrained = new SuitableStaff(true,s.getName(), s.getWorkExperience(), s.getEducationLevel(), s.getGpa());
    //             // write suitableStaff to DBWriter
    //             try {
    //                 DBWriter.updateStaff(staffToBeTrained);
    //             } catch (ParserConfigurationException | IOException | SAXException |TransformerException e) {
    //                 // e.printStackTrace();
    //             }
    //             break ;
    //         }
    //     }
    // }
    // }



        public void writeReqToDatabase(){
        //input requirements
            Scanner s=new Scanner(System.in);
            String course="";
            boolean workExperience=false;
            int educationLevel=0;
            double Gpa=0.0;
            List<String> skills = new ArrayList<>();

            try {
                course=s.nextLine();
                workExperience = Boolean.parseBoolean(s.nextLine());
                educationLevel=Integer.parseInt(s.nextLine());
                Gpa=Double.parseDouble(s.nextLine());
                String allSkills = s.nextLine();
                System.out.println(course+workExperience+educationLevel+Gpa);
                if (allSkills.contains(",")) { //if more than one skill
                    String[] arr = allSkills.split(",");
                    for (int i = 0; i < arr.length; i++) {
                        skills.add(arr[i]);
                    }
                } else { //if only one skill
                    skills.add(allSkills);
                }
                System.out.println(skills);
            }catch (NullPointerException | NumberFormatException e){
                System.out.println("invalid input");
            }

            //set all requirements in Database
            Requirement requirement = new Requirement();
            //TODO：need DBwriter send ID
            requirement.setId(this.userID*100+reqList.size()+1);
            requirement.setCourse(course);
            requirement.setWorkExperience(workExperience);
            requirement.setEducationLevel(educationLevel);
            requirement.setGpa(Gpa);
            requirement.setSkills(skills);
            reqList.add(requirement.getId());
            try {
                DBWriter.addRequirement(requirement);
            } catch (TransformerException e) {
                // e.printStackTrace();
            }
        }
    }
