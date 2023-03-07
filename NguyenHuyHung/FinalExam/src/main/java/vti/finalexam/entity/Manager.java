package vti.finalexam.entity;

public class Manager extends User{
    private int expInYear;
    private int projectId;

    public Manager(int id, String fullName, String email,String password,   int expInYear, int projectId) {
        super(id, fullName, email,password);
        this.expInYear = expInYear;
        this.projectId = projectId;
    }

    public Manager(int id, String fullName, String email,String password) {
        super(id, fullName, email,password);
    }

    public Manager(int id, String fullName, String email) {
        super(id,fullName,email);
    }

    public int getExpInYear() {
        return expInYear;
    }

    public int getProjectId() {
        return projectId;
    }
}
