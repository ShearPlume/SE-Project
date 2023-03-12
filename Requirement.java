import java.util.Arrays;
import java.util.List;

public class Requirement {
    private int Id;
    private String course;
    private int num;
    private boolean workExperience;
    private int educationLevel;
    private double gpa;
    private List<String> skills;

    public Requirement() {

    }

    public int getId() {return this.Id;}

    public void setId(int Id) {this.Id = Id;}

    public String getCourse() {
        return course;
    }

    public void setCourse(String course){this.course = course;}

    public List<String> getSkills(){return this.skills;}
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String toString(){
        return  "--------------------------" + "\n" +
                "Req Id: \t\t" + Id + "\n" +
                "Course: \t\t" + course + '\n' +
                "Num Required: \t" + num + '\n' +
                "Work_Exp Required: \t" + workExperience + '\n' +
                "Edu_Level Required: \t" + educationLevel + '\n' +
                "GPA Required: \t\t" + gpa + '\n' +
                "Skills Required: \t" + Arrays.toString(skills.toArray()) + '\n' +
                "--------------------------";
    }

    public int getNum() {
        return num;
    }
    public void setNum(int num) {this.num = num;}

    public boolean getWorkExperience() {
        return workExperience;
    }
    public void setWorkExperience(boolean workExperience){this.workExperience=workExperience;}

    public int getEducationLevel() {
        return educationLevel;
    }
    public void setEducationLevel(int educationLevel){this.educationLevel=educationLevel;}
    public double getGpa() {return this.gpa;}

    public void setGpa(double Id) {this.gpa = gpa;}

}



