import java.util.List;

public class Teacher extends SuitableStaff {
    private String course;
    private double salary;

    public Teacher(String name,int age,Boolean workExperience, String educationLevel, double gpa, int staffID, String trainingAppointmentTime, String course, double salary) {
        super(name,age,workExperience, educationLevel, gpa,staffID,trainingAppointmentTime);
        this.course = course;
        this.salary = salary;
    }

    public String getCourse() {
        return course;
    }

    public double getSalary() {
        return salary;
    }
}