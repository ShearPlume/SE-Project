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
            try {
                System.out.println("Please enter your requirement course:");
                Scanner s1 = new Scanner(System.in);
                String course = s1.nextLine();
                System.out.println("Please enter your required staff number:");
                Scanner s2 = new Scanner(System.in);
                int num = s2.nextInt();
                System.out.println("Please enter your required work experience:（true or false)");
                Scanner s3 = new Scanner(System.in);
                boolean workExperience = Boolean.parseBoolean(s3.nextLine());
                System.out.println("Please enter your required education level:(number between 1-3)");
                Scanner s4 = new Scanner(System.in);
                int educationLevel = s4.nextInt();
                System.out.println("Please enter your required Gpa:");
                Scanner s5 = new Scanner(System.in);
                double Gpa = s5.nextDouble();
                System.out.println("Please enter your required skill:（Please separate with commas if there are more than one）");
                Scanner s6 = new Scanner(System.in);
                String allSkills = s6.nextLine();
                List<String> skills = new ArrayList<>();
                if (allSkills.contains(",")) { //if more than one skill
                    String[] arr = allSkills.split(",");
                    for (int i = 0; i < arr.length; i++) {
                        skills.add(arr[i]);
                    }
                } else { //if only one skill
                    skills.add(allSkills);
                }
                //set all requirements in Database
                Requirement requirement = new Requirement();
                //TODO：need DBwriter send ID

                requirement.setCourse(course);
                requirement.setNum(num);
                requirement.setWorkExperience(workExperience);
                requirement.setEducationLevel(educationLevel);
                requirement.setGpa(Gpa);
                requirement.setSkills(skills);
                DBWriter.addRequirement(requirement);
            }catch (Exception e){
                System.out.println("invalid input");
            }
        }
    }
