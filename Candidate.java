import java.util.List;

public class Candidate implements Person {
    private Person person;
    private String name;
    private int age;
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


    public ConcretePerson(String name,int age) {
        this.name = name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
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