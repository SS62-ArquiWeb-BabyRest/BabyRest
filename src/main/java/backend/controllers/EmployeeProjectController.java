package backend.controllers;

import backend.entities.Employee;
import backend.entities.EmployeeProject;
import backend.services.EmployeeProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeeProjectController {

    @Autowired
    EmployeeProjectService employeeProjectService;



    @GetMapping("/employees_projects/{id}")
    public ResponseEntity<EmployeeProject> getAEmployeeProjectById(@PathVariable("id") Long id) {
        EmployeeProject employeeProject = employeeProjectService.findById(id);
        return new ResponseEntity<EmployeeProject>(employeeProject, HttpStatus.OK);
    }

    @PostMapping("/employees_projects")
    public ResponseEntity<EmployeeProject> createEmployeeProject(@RequestBody EmployeeProject employeeProject) {
        EmployeeProject newEmployeeProject = employeeProjectService.save(employeeProject);
        return new ResponseEntity<EmployeeProject>(newEmployeeProject, HttpStatus.CREATED);
    }

    @PutMapping("/employees_projects/{id}")
    public ResponseEntity<EmployeeProject> updateEmployeeProject(@RequestBody EmployeeProject employeeProject, @PathVariable("id") Long id) {
        EmployeeProject newEmployeeProject = employeeProjectService.save(employeeProject);
        return new ResponseEntity<EmployeeProject>(newEmployeeProject, HttpStatus.OK);
    }
    @DeleteMapping("/employees_projects/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") Long id) {
        employeeProjectService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }






    @GetMapping("/employees_projects")
    public ResponseEntity<List<EmployeeProject>> getAllEmployeesProjects() {
        List<EmployeeProject> employeeProjectList = employeeProjectService.listAll();
        return new ResponseEntity<List<EmployeeProject>>(employeeProjectList, HttpStatus.OK);
    }



    @GetMapping("/employees_projects/project/{id_project}")
    public ResponseEntity<List<EmployeeProject>> getEmployeesProjectsByProject_Id(@PathVariable("id_project") Long id) {
        List<EmployeeProject> employeeProjectList = employeeProjectService.findByProject_Id(id);
        return new ResponseEntity<List<EmployeeProject>>(employeeProjectList, HttpStatus.OK);
    }

    @GetMapping("/employees_projects/employees/project/{id_project}")
    public ResponseEntity<List<Employee>> getEmployeesByProject_Id(@PathVariable("id_project") Long id) {
        List<Employee> employeeProjectList = employeeProjectService.findEmployees_ByProject_Id(id);
        return new ResponseEntity<List<Employee>>(employeeProjectList, HttpStatus.OK);
    }





}
