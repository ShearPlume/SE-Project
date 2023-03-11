import java.util.List;
public class SuitableStaff extends Candidate {
    private int staffID;
    private String trainingAppointmentTime;

    public SuitableStaff(String name,int age,Boolean workExperience, String educationLevel, double gpa, int staffID, String trainingAppointmentTime) {
        super(name,age,workExperience, educationLevel, gpa);
        this.staffID = staffID;
        this.trainingAppointmentTime = trainingAppointmentTime;
    }

    public int getStaffID() {
        return staffID;
    }

    public String getTrainingAppointmentTime() {
        return trainingAppointmentTime;
    }
}

