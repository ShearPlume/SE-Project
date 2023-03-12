import java.util.Arrays;
import java.util.List;

public class Candidate implements Comparable<Candidate> {
    private int Id;
    private String name;
    // private int age;
    private boolean workExperience;
    private int educationLevel; // change to int by Z.Nie
    private double gpa;
    private List<String> skills;

    public Candidate(){

    }

    public Candidate(String name, Boolean workExperience, int educationLevel, double gpa) {
        this.name = name;
        // this.age = age;
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

    public List<String> getSkills(){return this.skills;}
    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    /*
    public int getAge() {
        return age;
    }
    public void setAge(int age) {this.age = age;}
    */
    
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
    public void setGpa(double gpa){this.gpa=gpa;}

    @Override
    public int compareTo(Candidate other) {
        int thisWorkExp = workExperience ? 1 : 0;
        int otherWorkExp = other.workExperience ? 1 : 0;
    //    if (thisWorkExp == otherWorkExp && gpa == other.gpa && educationLevel == other.educationLevel) {
    //        return 0;
    //    }
        if (gpa >= other.gpa && educationLevel >= other.educationLevel && thisWorkExp >= otherWorkExp) {
            for(String skill: other.skills){
                if(!skills.contains(skill)){
                    // this candidate does not have ordered skill
                    return 0;
                }
            }
            return 1;
        }else{
            return 0;
        }
    }


    @Override
    public String toString() {
        String result = "";
        return  "--------------------------" + "\n" +
                "Id: \t\t" + Id + "\n" +
                "Name: \t\t" + name + '\n' +
                "HasWorkExp? \t" + workExperience + '\n' +
                "Edu Level: \t" + educationLevel + '\n' +
                "GPA: \t\t" + gpa + '\n' +
                "Skills: \t" + Arrays.toString(skills.toArray()) + '\n' +
                "--------------------------";
    }

}



