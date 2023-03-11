import java.util.Arrays;
import java.util.List;

public interface Person {
    String getName();

    int getAge();

    int getYearsOfExperience();

    String getEducationLevel();

    float getGPA();

    List<String> getSkills();
    // int ID;
    // String name;
    // boolean hasWorkExp;
    // String eduLev;
    // double GPA;
    // List<String> skills;

    // public Person(List skills)
    // {
    // ID=1;
    // name="Abgile";
    // hasWorkExp=true;
    // eduLev="PGT";
    // GPA=83.5;

    // this.skills=skills;

    // }

    // public void setID(int id) {
    // this.ID = id;
    // }
    // public void setName(String name) {
    // this.name = name;
    // }
    // public void setworkExp(Boolean hasWorkExp) {
    // this.hasWorkExp = hasWorkExp;
    // }
    // public void setEdu(String edu) {
    // this.eduLev = edu;
    // }
    // public void setGPA(double GPA) {
    // this.GPA = GPA;
    // }
    // public void setSkills(List<String> skills) {
    // this.skills = skills;
    // }

    // @Override
    // public String toString() {
    // String result="";
    // return "_________________________\n" +
    // "ID: \t\t" + ID + '\n' +
    // "name: \t\t" + name + '\n' +
    // "hasworkexp? \t" + hasWorkExp +'\n'+
    // "edu level: \t" + eduLev + '\n' +
    // "GPA: \t\t" + GPA + '\n' +
    // "skills: \t" + Arrays.toString(skills.toArray()) + '\n' +
    // "_________________________";
    // }

    // public static void main(String[] args) {
    // Person p=new Person((Arrays.asList("kill", "steal", "rob")));
    // System.out.println(p);
    // }

}
