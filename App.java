import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        // Get the singleton instance of the CandidateManagementSystem
        CandidateManagementSystem system = CandidateManagementSystem.getInstance();     
        Candidate c=new Candidate("John Wick", 46, true, 2, 99.99);
        c.setSkills(Arrays.asList("eat", "sleep", "play"));
        System.out.println(c.toString());
        //other tasks with the CandidateManagementSystem as needed

    }
}