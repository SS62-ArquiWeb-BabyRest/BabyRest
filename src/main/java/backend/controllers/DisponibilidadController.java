package backend.controllers;
import backend.entities.Disponibilidad;
import backend.services.DisponibilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/disponibilidades")
public class DisponibilidadController {
    @Autowired
    DisponibilidadService disponibilidadService;


    @GetMapping
    public ResponseEntity<List<Disponibilidad>> getAllDisponibilidades() {
        List<Disponibilidad> disponibilidades = disponibilidadService.listAll();
        return new ResponseEntity<>(disponibilidades, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disponibilidad> getDisponibilidadById(@PathVariable Long id) {
        Disponibilidad disponibilidad = disponibilidadService.findById(id);
        if (disponibilidad == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(disponibilidad, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Disponibilidad> createDisponibilidad(@RequestBody Disponibilidad disponibilidad) {
        Disponibilidad nuevaDisponibilidad = disponibilidadService.save(disponibilidad);
        return new ResponseEntity<>(nuevaDisponibilidad, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disponibilidad> updateDisponibilidad(@PathVariable Long id, @RequestBody Disponibilidad disponibilidad) {
        Disponibilidad disponibilidadActualizada = disponibilidadService.update(id, disponibilidad);
        if (disponibilidadActualizada == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(disponibilidadActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisponibilidad(@PathVariable Long id) {
        disponibilidadService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
