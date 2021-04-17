package postgrad.oop2.code2;

// This class is given
public class Employee {
    private String name, gender;
    private Double salary;

    public Employee(String name, String gender, Double salary) {
        this.name = name;
        this.gender = gender;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", gender=" + gender + ", salary=" + salary + '}';
    }
    
}
