package backend.repositories;

import backend.entities.Employee;
import backend.entities.PadreEmpleador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PadreEmpleadorRepository extends JpaRepository<PadreEmpleador, Integer> {

    List<PadreEmpleador> findByNameContaining(String name);
}
