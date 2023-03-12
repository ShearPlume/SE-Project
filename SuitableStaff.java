import java.util.List;
public class SuitableStaff extends Candidate {
    private int staffId;
    private boolean ifTrained;

    public SuitableStaff(int staffId, Boolean ifTrained; String name, Boolean workExperience,int educationLevel, double gpa) {
        super(name, workExperience, educationLevel, gpa);
        this.staffId = staffId;
        this.ifTrained=ifTrained;
    }

    public int getStaffId() {
        return staffId;
    }

}

