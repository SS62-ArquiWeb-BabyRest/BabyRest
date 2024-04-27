package backend.repositories;

import backend.entities.Favoritos;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FavoritosRepository extends JpaRepository<Project, Long> {
    List<Favoritos> findByPadreEmpleadorId(int padreEmpleadorId);
}
