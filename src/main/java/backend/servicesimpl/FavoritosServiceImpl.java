package backend.services.impl;

import backend.entities.Favoritos;
import backend.repositories.FavoritosRepository;
import backend.services.FavoritosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoritosServiceImpl implements FavoritosService {

    @Autowired
    private FavoritosRepository favoritosRepository;

    @Override
    public List<Favoritos> listAll() {
        return favoritosRepository.findAll();
    }

    @Override
    public Favoritos findById(Long id) {
        Optional<Favoritos> favoritoOptional = favoritosRepository.findById(id);
        return favoritoOptional.orElse(null);
    }

    @Override
    public Favoritos save(Favoritos favorito) {
        return favoritosRepository.save(favorito);
    }

    @Override
    public Favoritos update(Long id, Favoritos favorito) {
        Optional<Favoritos> favoritoToUpdate = favoritosRepository.findById(id);
        if (favoritoToUpdate.isPresent()) {
            favoritoToUpdate.get().setPadreEmpleadorId(favorito.getPadreEmpleadorId());
            favoritoToUpdate.get().setNineraUniversitarioId(favorito.getNineraUniversitarioId());
            return favoritosRepository.save(favoritoToUpdate.get());
        } else {
            System.err.println("Favorito with ID " + id + " not found. Cannot update.");
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        favoritosRepository.deleteById(id);
    }
}
