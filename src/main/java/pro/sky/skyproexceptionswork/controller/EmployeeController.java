package pro.sky.skyproexceptionswork.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproexceptionswork.service.EmployeeServiseImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiseImpl employeeService;

    public EmployeeController(EmployeeServiseImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public String add(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        employeeService.add(firstName, lastName);
        return "Сотрудник " + firstName + " " + lastName + " успешно создан.";
    }

    @GetMapping(path = "/remove")
    public String remove(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        employeeService.remove(firstName, lastName);
        return "Сотрудник " + firstName + " " + lastName + " успешно удалён.";
    }

    @GetMapping(path = "/find")
    public String find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        employeeService.remove(firstName, lastName);
        return "Сотрудник: " + firstName + " " + lastName;
    }
}
