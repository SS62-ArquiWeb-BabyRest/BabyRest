package backend.project.repositories;

import backend.project.entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuarios, Long> {

    public Usuarios findByUserName(String userName);

}
