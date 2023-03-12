import java.util.List;
public class SuitableStaff extends Candidate {
    private int staffId;
    private String trainingAppointmentTime;

    public SuitableStaff(int staffId, String name, Boolean workExperience, int educationLevel, double gpa) {
        super(name, workExperience, educationLevel, gpa);
        this.staffId = staffId;
        this.trainingAppointmentTime = null;
    }

    public int getStaffId() {
        return staffId;
    }

    public String getTrainingAppointmentTime() {
        return trainingAppointmentTime;
    }
}

