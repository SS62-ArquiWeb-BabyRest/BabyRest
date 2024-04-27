package backend.entities;

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double budget;

    @JsonIgnore
    @OneToMany(mappedBy = "project")
    private List<EmployeeProject> employeeProjects;

}
