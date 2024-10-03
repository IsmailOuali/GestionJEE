package models;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String department;
    private String poste;

    // Constructors
    public Employee() {}

    public Employee(String name, String email, String phone, String department, String poste) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.poste = poste;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }
}
