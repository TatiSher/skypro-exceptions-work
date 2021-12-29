package pro.sky.skyproexceptionswork;

public interface EmployeeServise {

    Employee add(String firstName, String lastName);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);
}
