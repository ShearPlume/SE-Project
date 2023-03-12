import java.util.List;
public class SuitableStaff extends Candidate {
    private int staffId;
    private boolean ifTrained;

    public SuitableStaff(int staffId, Boolean ifTrained, String name, Boolean workExperience,int educationLevel, double gpa) {
        super(name, workExperience, educationLevel, gpa);
        this.staffId = staffId;
        this.ifTrained=ifTrained;
    }

    public SuitableStaff(int staffId, Boolean ifTrained,Candidate c) {
        super(c.getName(), c.getWorkExperience(), c.getEducationLevel(), c.getGpa());
        this.staffId = staffId;
        this.ifTrained=ifTrained;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setIftrained(boolean change)
    {
        ifTrained=change;
    }


    public boolean getIfTrained()
    {
        return ifTrained;
    }

}

