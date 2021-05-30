package dto;

public class EmployeeDTO {
    private int id;
    private String name;
    private String department;
    private int age;

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                '}';
    }

    public EmployeeDTO() {
    }

    public EmployeeDTO(int id) {
        this(id, "Mister");
    }

    public EmployeeDTO(int id, String name) {
        this(id, name, "Unknown");
    }

    public EmployeeDTO(int id, String name, String department) {
        this(id, name, department, 0);
    }

    public EmployeeDTO(int id, String name, String department, int age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.age = age;
    }
}

