package Model;

public class Request {
    private String tenismenName;
    private String tenismenEmail;
    private int id;
    private int tenismenAge;
    private  int trialID;

    public Request(String tenismenName, String tenismenEmail, int id, int tenismenAge, int trialID) {
        this.tenismenName = tenismenName;
        this.tenismenEmail = tenismenEmail;
        this.id = id;
        this.tenismenAge = tenismenAge;
        this.trialID = trialID;
    }

    public Request(String tenismenName, String tenismenEmail, int id, int trialID) {
        this.tenismenName = tenismenName;
        this.tenismenEmail = tenismenEmail;
        this.id = id;
        this.trialID = trialID;
    }

    public String getTenismenName() {
        return tenismenName;
    }

    public void setTenismenName(String tenismenName) {
        this.tenismenName = tenismenName;
    }

    public String getTenismenEmail() {
        return tenismenEmail;
    }

    public void setTenismenEmail(String tenismenEmail) {
        this.tenismenEmail = tenismenEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrialID() {
        return trialID;
    }

    public void setTrialID(int trialID) {
        this.trialID = trialID;
    }

    public int getTenismenAge() {
        return tenismenAge;
    }

    public void setTenismenAge(int tenismenAge) {
        this.tenismenAge = tenismenAge;
    }

    @Override
    public String toString() {
        return "Request" +
                "\n tenismenName = " + tenismenName +
                "\n tenismenEmail = " + tenismenEmail +
                "\n id = " + id +
                "\n tenismenAge = " + tenismenAge +
                "\n trialID = " + trialID;
    }
}
