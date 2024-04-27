package backend.services;

import backend.entities.Favoritos;
import backend.repositories.FavoritosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritosService {

    @Autowired
    private FavoritosRepository favoritosRepository;

    public List<Favoritos> listAll() {
        return favoritosRepository.findAll();
    }

    public Favoritos findById(Long id) {
        Optional<Favoritos> favoritoOptional = favoritosRepository.findById(id);
        return favoritoOptional.orElse(null);
    }

    public Favoritos save(Favoritos favorito) {
        return favoritosRepository.save(favorito);
    }

    public Favoritos update(Long id, Favoritos favorito) {
        Optional<Favoritos> favoritoToUpdate = favoritosRepository.findById(id);
        if (favoritoToUpdate.isPresent()) {
            favoritoToUpdate.get().setPadreEmpleadorId(favorito.getPadreEmpleadorId());
            favoritoToUpdate.get().setNineraUniversitarioId(favorito.getNineraUniversitarioId());
            return favoritosRepository.save(favoritoToUpdate.get());
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        favoritosRepository.deleteById(id);
    }
}
