package kz.reself.springdata.service;

import kz.reself.springdata.entity.Employee;

import java.util.Collection;
import java.util.List;

public interface UserService {
    void rewardSalariedCommissionEmployees(double persent);
    List<Employee> getByName(String name);
    Collection<Employee> employeeList();
    void createEmployee(Employee employee);
    void updateEmployee(Long id);
    void deleteEmployee(Long id);
    void salaryHourlyEmployees();
    void salaryCommisionAndSalariedCommision();
}
