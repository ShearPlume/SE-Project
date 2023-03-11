import java.util.List;

public class CandidateManagementSystem{
    List<ClassDirector> directors;
    Administrator admin;
    DataBase DB;

    public CandidateManagementSystem()
    {
        admin=new Administrator();
    }
    public static void main(String[] args) {
        String filePath="Database.xml";
        CandidateManagementSystem system=new CandidateManagementSystem();
        DBReader reader=new DBReader(filePath);
        DBWriter writer=new DBWriter(filePath);
        DataBase DB=reader.readDB();

    }

    public List<Teacher> train(List<SuitableStaff> suitableStaffs)
    {
        return null;
    }

}