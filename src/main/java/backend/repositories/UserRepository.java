package backend.repositories;

import backend.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByUserName(String userName);

}
