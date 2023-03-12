import java.util.ArrayList;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import java.io.File;

public class CandidateManagementSystem{//using Singleton Pattern
    private static CandidateManagementSystem instance = null;
    private DataBase DB;
    private DBReader reader;
    private DBWriter writer;
    private User currentUser;
    ArrayList<ClassDirector> directors;
    Administrator admin;

    // Private constructor to prevent other classes from creating instances
    private CandidateManagementSystem() {
        // Connect to the database using an XML file
        admin=new Administrator(0);
        currentUser=admin;//default user is admin
        directors=new ArrayList<>();
        DB=getDatabaseConnection("Database.xml");
        reader=new DBReader(DB);
        writer=new DBWriter(DB);
    }

    // Public static method to return the singleton instance of the class
    public static synchronized CandidateManagementSystem getInstance() {
        if (instance == null) {
            instance = new CandidateManagementSystem();
        }
        System.out.println("Admin logged in");
        return instance;
    }

    // Public method to interact with the database connection

    public DataBase getDatabaseConnection(String path)
    {
       try {
          File inputFile = new File(path);
          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
          Document doc = dBuilder.parse(inputFile);         
          doc.getDocumentElement().normalize();
          System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
 
          return new DataBase (doc);
       } catch (Exception e) {
          e.printStackTrace();
          System.out.println("read error");
       }
       return null;
    }


    public ArrayList<Teacher> train(ArrayList<SuitableStaff> suitableStaffs)
    {
        return null;
    }

    public void commandProcessor(String command) {
        String[] split = command.split(" ");
        String cmd1 = split[0];
        if(currentUser.getClass()== ClassDirector.class)
        {
            switch (cmd1) {
                case "NEW_DIRECTOR": {
                    directors.add(new ClassDirector(directors.size()+1));
                    currentUser=directors.get(directors.size());
                    System.out.println("new director logged in");
                    break;
                }
                case "LOGIN_DIRECTOR": {
                    currentUser=directors.get(Integer.parseInt(split[1]));
                    System.out.println("existed director logged in");
                    break;
                }               
                case "ENTER_REQ": {
                    if(currentUser.getClass()== ClassDirector.class)
                    {
    
                    }
                    break;
                }
                case "ARRANGE_TRAINING": {
                    break;
                }
                default:
                break;
            }
        }
        else if(currentUser.getClass()== Administrator.class)
        {
            switch (cmd1) {
                case "LOGIN_ADMIN": {
                    currentUser=admin;
                    break;
                }       
                case "SEARCH": {
                    // YE ZHANG
                    // command: SEARCH REQ 1/2/3/(requirement Id)...                 
                    if(split[1]=="REQ"){
                        Administrator.search(split[2]);
                    }
                    break;
                }          
                case "SAVE_SUITABLE": {
                    // YE ZHANG
                    // command: SAVE_SUITABLE 24336(candidate Id)
                    // 该命令将根据candidate Id，删除XML中对应的candidate，写入XML中的SuitableStaff
                    Administrator.saveSuitableStaff(split[1]);
                    break;
                }
                case "Train": {
                    // YE ZHANG
                    // command: Train 24336(staff Id) 24(trainingAppointmentTime)
                    // 该命令将根据staff Id，更新XML中对应staff的训练时间属性
                    Administrator.trainStaff(split[1], split[2]);
                }
                default:{
                    System.out.println("invalid command");
                    break;
                }

            }

        }
       
    }



    // List<ClassDirector> directors;
    // Administrator admin;
    // DataBase DB;

    // public CandidateManagementSystem()
    // {
    //     admin=new Administrator();
    // }
    // public static void main(String[] args) {
    //     String filePath="Database.xml";
    //     CandidateManagementSystem system=new CandidateManagementSystem();
    //     DBReader reader=new DBReader(filePath);
    //     DBWriter writer=new DBWriter(filePath);
    //     DataBase DB=reader.readDB();

    // }


}