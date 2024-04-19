package backend.servicesimpl;

import backend.entities.Employee;
import backend.exceptions.IncompleteDataException;
import backend.exceptions.KeyRepeatedDataException;
import backend.exceptions.ResourceNotFoundException;
import backend.repositories.EmployeeRepository;
import backend.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> listAll() {
        List<Employee> employees = employeeRepository.findAll();
        for (Employee e: employees) {
            e.setEmployeeProjects(null);
        }
        return employees;
    }

    @Override
    public List<Employee> listByName(String name) {
        List<Employee> employees = employeeRepository.findByNameContaining(name);
        return employees;
    }

    @Override
    public Employee findById(Long id) {
        Employee employeeFound = employeeRepository.findById(id).orElse(null);
        if (employeeFound == null) {
            throw new ResourceNotFoundException("There are no Employee with the id: "+String.valueOf(id));
        }
        return employeeFound;
    }

    @Override
    public Employee save(Employee employee) {
        if (employee.getName()==null || employee.getName().isEmpty()) {
            throw new IncompleteDataException("Employee name can not be null or empty");
        }
        List<Employee> listEmployeeNameDuplicated= employeeRepository.findByNameContaining(employee.getName());
        if (listEmployeeNameDuplicated.size()>1 || (listEmployeeNameDuplicated.size()==1 && !listEmployeeNameDuplicated.get(0).getId().equals(employee.getId())) ) {
            throw new KeyRepeatedDataException("Employee name can not be duplicated");
        }

        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        Employee employee = findById(id);
        employeeRepository.delete(employee);
    }
}
