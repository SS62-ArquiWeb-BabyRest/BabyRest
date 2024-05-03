package backend.repositories;

//import backend.entities.Employee;
import backend.entities.NineraUniversitario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NineraUniversitarioRepository extends JpaRepository<NineraUniversitario, Integer> {

    List<NineraUniversitario> findByNameContaining(String name);
}
