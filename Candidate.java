import java.util.List;

public class Candidate {
    private String name;
    private int age;
    private String workExperience;
    private String educationLevel;
    private double gpa;

    public Candidate(String workExperience, String educationLevel, double gpa) {
        this.workExperience = workExperience;
        this.educationLevel = educationLevel;
        this.gpa = gpa;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public double getGpa() {
        return gpa;
    }
}


public class Candidate implements Person {
    private Person person;

    private int yearsOfExperience;
    private String educationLevel;
    private float GPA;
    private List<String> skills;

    public Candidate(Person person,String name,int age,int yearsOfExperience, String educationLevel, float GPA, List<String> skills) {
        this.name = name;
        this.age=age;
        this.person = person;
        this.yearsOfExperience = yearsOfExperience;
        this.educationLevel = educationLevel;
        this.GPA = GPA;
        this.skills = skills;
    }

    

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public float getGPA() {
        return GPA;
    }

    public List<String> getSkills() {
        return skills;
    }
}