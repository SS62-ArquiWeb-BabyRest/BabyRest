package backend.project.services;

import backend.project.entities.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> listAll();
    public List<Employee> listByName(String name);



    public Employee findById(Long id);

    public Employee save(Employee employee);
    public void delete(Long id);



}
