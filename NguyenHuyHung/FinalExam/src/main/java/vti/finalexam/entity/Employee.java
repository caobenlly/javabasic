package vti.finalexam.entity;

public class Employee extends User{
    private int projectId;
    private String proSkill;

    public Employee(int id, String fullName, String email,String password, String proSkill) {
        super(id, fullName, email,password);
        this.proSkill = proSkill;
    }

    public int getProjectId() {
        return projectId;
    }

    public String getProSkill() {
        return proSkill;
    }
}
