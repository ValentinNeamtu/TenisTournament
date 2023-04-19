package Model;

public class User {
    protected String fullName;
    protected int ID;

    public User(String fullName, int ID) {
        this.fullName = fullName;
        this.ID = ID;
    }

    public User() {

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return
                " fullName = " + fullName +
                "\n ID=" + ID;
    }
}
