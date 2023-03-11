import java.util.List;

public class SuitableStaff implements Person {
    private Person person;
    private int staffNum;
    private int trainingSlot;

    public SuitableStaff(Person person, int staffNum, int trainingSlot) {
        this.person = person;
        this.staffNum = staffNum;
        this.trainingSlot = trainingSlot;
    }

    @Override
    public String getName() {
        return person.getName();
    }

    @Override
    public int getAge() {
        return person.getAge();
    }

    public int getStaffNum() {
        return staffNum;
    }

    public int getTrainingSlot() {
        return trainingSlot;
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
        return person.getSkills()
    }
}