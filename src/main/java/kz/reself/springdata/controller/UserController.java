package kz.reself.springdata.controller;

import kz.reself.springdata.entity.Employee;
import kz.reself.springdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    public List<Employee> getByName(String name){
        return userService.getByName(name);
    }
    public void createEmployee(Employee employee) {
        userService.createEmployee(employee);
    }

    public void employeeList() {
        userService.employeeList();
    }

    public void deleteEmployee(Long id) {
        userService.deleteEmployee(id);
    }

    public List<Employee> findByName(String name) {
        return userService.getByName(name);
    }

    public void updateEmployee(Long id) {
        userService.updateEmployee(id);
    }

    public void rewardSalariedCommissionEmployees(int persent) {
        userService.rewardSalariedCommissionEmployees(persent);
    }

    public void salaryHourlyEmployees(){
        userService.salaryHourlyEmployees();
    }
    public void salaryCommisionAndSalariedCommision(){
        userService.salaryCommisionAndSalariedCommision();
    }
}
