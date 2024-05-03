package backend;


import backend.entities.*;
import backend.repositories.*;
import backend.services.EmployeeProjectService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(
			EmployeeRepository employeeRepository,
			ProjectRepository projectRepository,
			EmployeeProjectRepository employeeProjectRepository,
			EmployeeProjectService employeeProjectService,

			AuthorityRepository authorityRepository,
			UserRepository userRepository
	) {
		return args -> {
            //CRUD

			authorityRepository.save(new Authority(AuthorityName.ROLE_ADMIN));
			authorityRepository.save(new Authority(AuthorityName.ROLE_STUDENT));
			authorityRepository.save(new Authority(AuthorityName.ROLE_PRINCIPAL));
			authorityRepository.save(new Authority(AuthorityName.ROLE_TEACHER));

			authorityRepository.saveAll(
					List.of(
							new Authority(AuthorityName.READ),
							new Authority(AuthorityName.WRITE)
					)
			);


			userRepository.save(
					new Usuario("gmorip", new BCryptPasswordEncoder().encode("UPC2023!"),true,new Date(),
							List.of(
									authorityRepository.findByName(AuthorityName.ROLE_PRINCIPAL),
									authorityRepository.findByName(AuthorityName.ROLE_ADMIN),
									authorityRepository.findByName(AuthorityName.WRITE)
								)
							)
			);

			userRepository.save(
					new Usuario("crevilla", new BCryptPasswordEncoder().encode("DISEÑOPERU18!"),true,new Date(),
							List.of(
									authorityRepository.findByName(AuthorityName.ROLE_STUDENT),
									authorityRepository.findByName(AuthorityName.READ)
							)
					)
			);


			Employee employeeSaved = employeeRepository.save(new Employee(Long.valueOf(0),"Cinthy","Lima",15000.0,null));
			employeeRepository.save(new Employee(Long.valueOf(0),"Gonzalo","Lima",15000.0,null));
			employeeRepository.save(new Employee(Long.valueOf(0),"Gladys","Cuzco",5000.0,null));
			employeeRepository.save(new Employee(Long.valueOf(0),"Walter","Lima",9000.0,null));
			employeeRepository.save(new Employee(Long.valueOf(0),"Emma","Lima",10000.0,null));
			employeeRepository.save(new Employee(Long.valueOf(0),"Ana Paula","Piura",1300.0,null));
			employeeRepository.save(new Employee(Long.valueOf(0),"Regina","Tacna",12000.0,null));
			employeeRepository.save(new Employee(Long.valueOf(0),"Pilar","Piura",3000.0,null));

			employeeSaved.setCity("Arequipa");
			employeeSaved.setSalary(18000.0);
			employeeRepository.save(employeeSaved);

			employeeRepository.delete(employeeSaved);

			//Un solo objeto como resultado

			Employee employeeFound = employeeRepository.findById(Long.valueOf(3)).get();

			//Una lista de objetos como resultado

			List<Employee> employeeAll = employeeRepository.findAll();
			System.out.println("\nLista Completa");
			for(Employee e: employeeAll) {
				System.out.println(e);
			}

			System.out.println("\nLista por Ciudad");
			List<Employee> employeeCiudad= employeeRepository.findByCityOrderByNameDesc("Lima");
			for(Employee e: employeeCiudad) {
				System.out.println(e);
			}

			System.out.println("\nLista por Ciudad y Nombre");
			List<Employee> employeeCiudadNombre = employeeRepository.findByCityAndName("Lima","Gonzalo");
			for(Employee e: employeeCiudadNombre) {
				System.out.println(e);
			}


			System.out.println("\nLista por similitud Nombre");
			List<Employee> employeeNombreParecido = employeeRepository.findByNameContaining("G");
			for(Employee e: employeeNombreParecido) {
				System.out.println(e);
			}

			System.out.println("\nLista por Ciudad y Menor Salario");
			//List<Employee> employeeCiudadMenorSalario = employeeRepository.findByCityAndLowerSalary("Lima", 10000.0);
			//List<Employee> employeeCiudadMenorSalario = employeeRepository.findByCityAndSalaryLessThan("Lima", 10000.0);
			List<Employee> employeeCiudadMenorSalario = employeeRepository.findByCityAndLowerSalaryJPQL("Lima", 10000.0);
			for(Employee e: employeeCiudadMenorSalario) {
				System.out.println(e);
			}

			System.out.println("\nLista por Rango Salario");
			List<Employee> employeeRangoSalario = employeeRepository.findBySalaryBetween(1000.0, 10000.0);
			for(Employee e: employeeRangoSalario) {
				System.out.println(e);
			}

			//UPDATE ERROR COMUN
			//Ejemplo: Cuando te pasan un ID y el nuevo salario
			//Version que elimina datos equivocadamente
			/*
			Long idEmployeePromoted = Long.valueOf(8);
			Double newSalaryEmployeePromoted = 5000.0;

			Employee e = new Employee();
			e.setSalary(newSalaryEmployeePromoted);
			e.setId(idEmployeePromoted);
			Employee employeePromoted =  employeeRepository.save(e);
			System.out.println("\n"+employeePromoted);
			*/
			//Version que es la correcta
			Long idEmployeePromoted = Long.valueOf(8);
			Double newSalaryEmployeePromoted = 5000.0;
			Employee e = employeeRepository.findById(idEmployeePromoted).get();
			e.setSalary(newSalaryEmployeePromoted);
			e.setId(idEmployeePromoted);
			Employee employeePromoted =  employeeRepository.save(e);
			System.out.println("\n"+employeePromoted);


			//*** PROJECT *** /
			projectRepository.save(new Project(Long.valueOf(0),"Frontend RRHH", 17500.0,null));
			projectRepository.save(new Project(Long.valueOf(0),"Backend RRHH", 25000.0,null));
			projectRepository.save(new Project(Long.valueOf(0),"Security Check 2023", 7000.0,null));

			Project project1 = projectRepository.findById(Long.valueOf(1)).get();
			Project project2 = projectRepository.findById(Long.valueOf(2)).get();

			Employee employee1 = employeeRepository.findById(Long.valueOf(2)).get();
			Employee employee2 = employeeRepository.findById(Long.valueOf(4)).get();
			Employee employee3 = employeeRepository.findById(Long.valueOf(6)).get();
			Employee employee4 = employeeRepository.findById(Long.valueOf(7)).get();
			Employee employee5 = employeeRepository.findById(Long.valueOf(8)).get();


			employeeProjectRepository.save(new EmployeeProject(Long.valueOf(0), project1, employee1, 14, false));
			employeeProjectRepository.save(new EmployeeProject(Long.valueOf(0), project1, employee3, 10, true));
			employeeProjectRepository.save(new EmployeeProject(Long.valueOf(0), project1, employee5, 9, false));
			employeeProjectRepository.save(new EmployeeProject(Long.valueOf(0), project2, employee1, 28, true));
			employeeProjectRepository.save(new EmployeeProject(Long.valueOf(0), project2, employee2, 15, false));
			employeeProjectRepository.save(new EmployeeProject(Long.valueOf(0), project2, employee3, 4, true));
			employeeProjectRepository.save(new EmployeeProject(Long.valueOf(0), project2, employee4, 18, true));
			employeeProjectRepository.save(new EmployeeProject(Long.valueOf(0), project2, employee5, 9, false));


			System.out.println("-------------");

			List<EmployeeProject> employeeProjectList = employeeProjectService.listAll();
			for (EmployeeProject ep: employeeProjectList) {
				System.out.println(ep);
			}







		};
	}

}
