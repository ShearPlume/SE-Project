import java.util.List;

public class Administrator extends User{
    // Ye Zhang added on 11/Mar
    public Administrator(int userID){
        this.userID = userID;
        // admin can read requirements but cannot write requirements
        this.readFileAcess = true;
        this.writeFileAcess = false;
    }

    /*
    public List<Teacher> search(){
        List<Teacher> resultList;

        return resultList;
    }
    */
    public void writeToDatabase(){

    }

    public void getRequirements(){
        
    }

}
