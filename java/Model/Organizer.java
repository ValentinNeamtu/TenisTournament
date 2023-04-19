package Model;

public class Organizer extends User{
    private String password;

    public Organizer(String fullName, String password, int ID) {
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
        return "Organizer\n" +
                " password = " + password +
                "\n fullName = " + fullName +
                "\n ID=" + ID;
    }
}
