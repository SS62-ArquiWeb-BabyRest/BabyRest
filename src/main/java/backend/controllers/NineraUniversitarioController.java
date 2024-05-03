package backend.controllers;
import backend.entities.NineraUniversitario;

import backend.services.NineraUniversitarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class NineraUniversitarioController {

    @Autowired
    NineraUniversitarioService nineraUniversitarioService;

    //http://localhost:8080/api/employees


    @GetMapping("/employees/{id}")
    public ResponseEntity<NineraUniversitario> getANineraUniversitarioById(@PathVariable("id") int id) {
        NineraUniversitario nineraUniversitario = nineraUniversitarioService.findById(id);
        return new ResponseEntity<NineraUniversitario>(nineraUniversitario, HttpStatus.OK);
    }

    @PostMapping("/ninera_universitario")
    public ResponseEntity<NineraUniversitario> createEmployee(@RequestBody NineraUniversitario nineraUniversitario) {
        NineraUniversitario newNineraUniversitario = nineraUniversitarioService.save(nineraUniversitario);
        return new ResponseEntity<NineraUniversitario>(newNineraUniversitario, HttpStatus.CREATED);
    }


    @DeleteMapping("/ninera_universitario/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") int id) {
        nineraUniversitarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

