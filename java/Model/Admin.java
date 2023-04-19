package Model;

public class Admin extends User{
    private String password;

    public Admin(String fullName, String password, int ID) {
        super(fullName,ID);
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
        return "Admin\n" +
                " password = " + password +
                "\n fullName = " + fullName;
    }
}
