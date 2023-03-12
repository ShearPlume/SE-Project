import java.util.List;

public class Teacher extends Candidate {
    private String course;
    private double salary;
    private int staffID;

    public Teacher(String name,int age,Boolean workExperience, int educationLevel, double gpa, int staffID,  String course, double salary) {
        super(name, workExperience, educationLevel, gpa);
        this.course = course;
        this.staffID=staffID;
        this.salary = salary;
    }

    public String getCourse() {
        return course;
    }

    public int getStaffID(){
        return staffID;
    }

    public double getSalary() {
        return salary;
    }
}