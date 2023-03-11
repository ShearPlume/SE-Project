import java.util.Arrays;
import java.util.List;

public class Candidate implements Comparable<Candidate> {
    private int Id;
    private String name;
    private int age;
    private boolean workExperience;
    private int educationLevel; // change to int by Z.Nie
    private double gpa;
    private List<String> skills;

    public Candidate(String name, int age, Boolean workExperience, int educationLevel, double gpa) {
        this.name = name;
        this.age = age;
        this.workExperience = workExperience;
        this.educationLevel = educationLevel;
        this.gpa = gpa;
    }

    public int getId() {return this.Id;}

    public void setId(int Id) {this.Id = Id;}

    public String getName() {
        return name;
    }

    public void setName(String name){this.name=name;}

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }


    public int getAge() {
        return age;
    }
    public void setAge(int age) {this.age = age;}

    public boolean getWorkExperience() {
        return workExperience;
    }
    public void setWorkExperience(boolean workExperience){this.workExperience=workExperience;}

    public int getEducationLevel() {
        return educationLevel;
    }
    public void setEducationLevel(int educationLevel){this.educationLevel=educationLevel;}
    public double getGpa() {
        return gpa;
    }
    public void setGpa(int gpa){this.gpa=gpa;}

    @Override
    public int compareTo(Candidate other) {
        int thisWorkExp = workExperience ? 1 : 0;
        int otherWorkExp = other.workExperience ? 1 : 0;
        if (thisWorkExp == otherWorkExp && gpa == other.gpa && educationLevel == other.educationLevel) {
            return 0;
        }
        if (gpa > other.gpa && educationLevel > other.educationLevel && thisWorkExp > otherWorkExp) {
            return 1;
        }
        return -1;
    }


    @Override
    public String toString() {
        String result = "";
        return "_________________________\n" +
                "name: \t\t" + name + '\n' +
                "hasworkexp? \t" + workExperience + '\n' +
                "edu level: \t" + educationLevel + '\n' +
                "GPA: \t\t" + gpa + '\n' +
                "skills: \t" + Arrays.toString(skills.toArray()) + '\n' +
                "_________________________";
    }

}



