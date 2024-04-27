package backend.controllers;
import backend.entities.Employee;
import backend.entities.Ninero_Universitario;
import backend.exporters.EmployeeExcelExporter;
import backend.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedInheritableThreadLocal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //http://localhost:8080/api/employees
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.listAll();
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getAEmployeeById(@PathVariable("id") Long id) {
        Employee employee = employeeService.findById(id);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.save(employee);
        return new ResponseEntity<Employee>(newEmployee, HttpStatus.CREATED);
    }


    @DeleteMapping("/employees/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    //Alternativa 1 -> Pasar el Id por la ruta
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id) {
        Employee foundEmployee = employeeService.findById(id);
        if (employee.getName()!=null) {
            foundEmployee.setName(employee.getName());
        }
        if (employee.getCity()!=null) {
            foundEmployee.setCity(employee.getCity());
        }
        if (employee.getSalary()!=null) {
            foundEmployee.setSalary(employee.getSalary());
        }
        Employee newEmployee = employeeService.save(foundEmployee);
        return new ResponseEntity<Employee>(newEmployee, HttpStatus.OK);
    }

    //Alternativa 2 -> Pasar el Id por el Body
    @PutMapping("/employees/")
    public ResponseEntity<Employee> updateEmployeeBody(@RequestBody Employee employee) {
        Employee foundEmployee = employeeService.findById(employee.getId());
        if (employee.getName()!=null) {
            foundEmployee.setName(employee.getName());
        }
        if (employee.getCity()!=null) {
            foundEmployee.setCity(employee.getCity());
        }
        if (employee.getSalary()!=null) {
            foundEmployee.setSalary(employee.getSalary());
        }
        Employee newEmployee = employeeService.save(foundEmployee);
        return new ResponseEntity<Employee>(newEmployee, HttpStatus.OK);
    }


    @GetMapping("/employees/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=result_product";
        response.setHeader(headerKey, headerValue);

        List<Ninero_Universitario> employees = employeeService.listAll();

        EmployeeExcelExporter excelExporter = new EmployeeExcelExporter(
                niner);
        excelExporter.export(response);
    }








}
