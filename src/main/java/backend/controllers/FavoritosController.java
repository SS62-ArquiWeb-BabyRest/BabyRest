package backend.controllers;
import backend.entities.Favoritos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/favoritos")
public class FavoritosController {
    @Autowired
    FavoritosService favoritosService;

    @GetMapping
    public ResponseEntity<List<Favoritos>> getAllFavoritos() {
        List<Favoritos> favoritos = favoritosService.listAll();
        return new ResponseEntity<>(favoritos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favoritos> getFavoritoById(@PathVariable Long id) {
        Favoritos favorito = favoritosService.findById(id);
        if (favorito == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(favorito, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Favoritos> createFavorito(@RequestBody Favoritos favorito) {
        Favoritos nuevoFavorito = favoritosService.save(favorito);
        return new ResponseEntity<>(nuevoFavorito, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Favoritos> updateFavorito(@PathVariable Long id, @RequestBody Favoritos favorito) {
        Favoritos favoritoActualizado = favoritosService.update(id, favorito);
        if (favoritoActualizado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(favoritoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavorito(@PathVariable Long id) {
        favoritosService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
