import javax.xml.transform.TransformerException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ClassDirector extends User{
    // private String className;

    public ClassDirector(int userID){
        // this.className = className;
        this.userID=userID;
        this.readFileAcess = false;
        this.writeFileAcess = true;
    }


        public static void writeToDatabase(){
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

            requirement.setCourse(course);
            requirement.setWorkExperience(workExperience);
            requirement.setEducationLevel(educationLevel);
            requirement.setGpa(Gpa);
            requirement.setSkills(skills);
            try {
                DBWriter.addRequirement(requirement);
            } catch (TransformerException e) {
                // e.printStackTrace();
            }
        }
    }
