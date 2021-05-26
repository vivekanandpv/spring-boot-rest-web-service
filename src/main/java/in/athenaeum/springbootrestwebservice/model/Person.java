package in.athenaeum.springbootrestwebservice.model;

public class Person {
    private String firstName;
    private String lastName;
    private String employeeCode;

    public Person(String ln, String ec, String fn) {
        this.firstName = fn;
        this.lastName = ln;
        this.employeeCode = ec;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }
}
