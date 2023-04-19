package Model;

public class Referee extends  User{

    private String password;

    public Referee(String fullName, String password, int ID) {
        super(fullName, ID);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Referee\n" +
                " password = " + password +
                "\n fullName = " + fullName +
                "\n ID = " + ID;
    }
}
