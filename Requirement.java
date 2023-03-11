import java.util.Arrays;
import java.util.List;

public class Requirement {
    private int Id;
    private String Course;
    private int Num;
    private boolean workExperience;
    private int educationLevel;
    private double Gpa;
    private List<String> skills;

    public Requirement() {

    }

    public int getId() {return this.Id;}

    public void setId(int Id) {this.Id = Id;}

    public String getCourse() {
        return Course;
    }

    public void setCourse(String Course){this.Course=Course;}

    public List<String> getSkills(){return this.skills;}
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }


    public int getNum() {
        return Num;
    }
    public void setNum(int Num) {this.Num = Num;}

    public boolean getWorkExperience() {
        return workExperience;
    }
    public void setWorkExperience(boolean workExperience){this.workExperience=workExperience;}

    public int getEducationLevel() {
        return educationLevel;
    }
    public void setEducationLevel(int educationLevel){this.educationLevel=educationLevel;}
    public double getGpa() {return this.Gpa;}

    public void setGpa(double Id) {this.Gpa = Gpa;}

}



