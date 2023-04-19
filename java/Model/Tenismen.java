package Model;

public class Tenismen extends User{
    private String email;
    private int age;

    public Tenismen() {
        super();
    }

    public Tenismen(String fullName, int ID) {
        super(fullName, ID);
    }

    public Tenismen(String fullName, int ID, String email, int age){
        super(fullName, ID);
        this.email = email;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Tenismen\n" +
                " email = " + email +
                "\n fullName = " + fullName +
                "\n ID = " + ID;
    }
}
