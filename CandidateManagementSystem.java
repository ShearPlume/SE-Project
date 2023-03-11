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
        CandidateManagementSystem system=new CandidateManagementSystem();
        DBReader reader=new DBReader();
        DBWriter writer=new DBWriter();
        system.DB=

    }

    public List<Teacher> train(List<SuitableStaff> suitableStaffs)
    {
        return null;
    }

}