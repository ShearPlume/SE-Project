import java.util.List;

public class Teacher implements Person {
    private Person person;
    private String course;
    private int salary;

    public Teacher(Person person,String course, int salary) {
        this.person = person;
        this.course = course;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return person.getName();
    }

    @Override
    public int getAge() {
        return person.getAge();
    }
    
    @Override
    public int getYearsOfExperience() {
        return person.getYearsOfExperience();
    }

    @Override
    public String getEducationLevel() {
        return person.getEducationLevel();
    }

    @Override
    public float getGPA() {
        return person.getGPA();
    }

    @Override
    public List<String> getSkills() {
        return person.getSkills();
    }

    public String getCourse() {
        return course;
    }

    public int getSalary() {
        return salary;
    }


}