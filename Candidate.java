import java.util.Arrays;
import java.util.List;

public class Candidate {
    private String name;
    private int age;
    private boolean workExperience;
    private String educationLevel;
    private double gpa;
    private List <String> skills;

    public Candidate(String name,int age,Boolean workExperience, String educationLevel, double gpa) {
        this.name=name;
        this.age=age;
        this.workExperience = workExperience;
        this.educationLevel = educationLevel;
        this.gpa = gpa;
    }
    public String getName() {
        return name;
    }

    public void setSkills(List <String> skills) {
        this.skills=skills;
    }


    public int getAge() {
        return age;
    }

    public boolean getWorkExperience() {
        return workExperience;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
    String result="";
    return "_________________________\n" +
    "name: \t\t" + name + '\n' +
    "hasworkexp? \t" + workExperience +'\n'+
    "edu level: \t" + educationLevel + '\n' +
    "GPA: \t\t" + gpa + '\n' +
    "skills: \t" + Arrays.toString(skills.toArray()) + '\n' +
    "_________________________";
    }
}



