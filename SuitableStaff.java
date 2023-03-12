import java.util.List;
public class SuitableStaff extends Candidate {
    // private int staffId;
    private boolean ifTrained;

    public SuitableStaff( Boolean ifTrained, String name, Boolean workExperience,int educationLevel, double gpa) {
        super(name, workExperience, educationLevel, gpa);
        // this.staffId = staffId;
        this.ifTrained=ifTrained;
    }

    public SuitableStaff( Boolean ifTrained,Candidate c) {
        super(c.getName(), c.getWorkExperience(), c.getEducationLevel(), c.getGpa());
        this.setId(c.getId());
        // this.staffId = staffId;
        this.ifTrained=ifTrained;
        this.setSkills(c.getSkills());
    }

    // public int getStaffId() {
    //     return staffId;
    // }


    // public void setSID(int sid)
    // {
    //     staffId=sid;
    // }
    public void setIftrained(boolean change)
    {
        ifTrained=change;
    }


    public boolean getIfTrained()
    {
        return ifTrained;
    }

    @Override
    public String toString() {
        // String result = "";
        return  "**************************\nStaff\n"+super.toString()+"\ntrained? \t" + ifTrained + '\n' +
        "**************************";

    }
}

