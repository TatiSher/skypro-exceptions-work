package pro.sky.skyproexceptionswork.service;

import org.springframework.stereotype.Service;
import pro.sky.skyproexceptionswork.Employee;
import pro.sky.skyproexceptionswork.EmployeeServise;
import pro.sky.skyproexceptionswork.exception.EmployeeCannotBeAddedException;
import pro.sky.skyproexceptionswork.exception.EmployeeExistsException;
import pro.sky.skyproexceptionswork.exception.NoEmployeeFoundException;

@Service
public class EmployeeServiseImpl implements EmployeeServise {

    Employee[] employees = new Employee[10];

    private int indexOf(Employee newEmployee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].equals(newEmployee)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                return newEmployee;
            }
        }
        if (indexOf(newEmployee) != -1) {
            throw new EmployeeExistsException();
        }
        throw new EmployeeCannotBeAddedException();
    }


    @Override
    public Employee remove(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].equals(newEmployee)) {
                employees[i] = null;
                return employees[i];
            }
        }
        throw new NoEmployeeFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        if (indexOf(newEmployee) != -1) {
            return newEmployee;
        }
        throw new NoEmployeeFoundException();
    }

}
