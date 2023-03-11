public class ClassDirector extends User{
    private String className;

    public ClassDirector(String className){
        this.className = className;
        this.readFileAcess = false;
        this.writeFileAcess = true;
    }

    public void writeToDatabase(){

    }
}
