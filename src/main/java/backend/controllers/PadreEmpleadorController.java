package backend.controllers;


import backend.entities.PadreEmpleador;

import backend.services.PadreEmpleadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PadreEmpleadorController {

    @Autowired
    PadreEmpleadorService padreEmpleadorService;

    //http://localhost:8080/api/employees


    @GetMapping("/employees/{id}")
    public ResponseEntity<PadreEmpleador> getAPadreEmpleadorById(@PathVariable("id") int id) {
        PadreEmpleador padreEmpleador = padreEmpleadorService.findById(id);
        return new ResponseEntity<PadreEmpleador>(padreEmpleador, HttpStatus.OK);
    }

    @PostMapping("/padre_empleador")
    public ResponseEntity<PadreEmpleador> createEmployee(@RequestBody PadreEmpleador padreEmpleador) {
        PadreEmpleador newPadreEmpleador = padreEmpleadorService.save(padreEmpleador);
        return new ResponseEntity<PadreEmpleador>(newPadreEmpleador, HttpStatus.CREATED);
    }


    @DeleteMapping("/padre_empleador/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") int id) {
        padreEmpleadorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
