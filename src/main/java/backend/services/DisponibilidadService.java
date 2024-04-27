package backend.services;

import backend.entities.Disponibilidad;
import backend.repositories.DisponibilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public interface DisponibilidadService {
    @Autowired
    private DisponibilidadRepository DisponibilidadRepository;

    public List<Disponibilidad> listAll() {
        return DisponibilidadRepository.findAll();
    }

    public Disponibilidad findById(Long id) {
        Optional<Disponibilidad> disponibilidadOptional = DisponibilidadRepository.findById(id);
        return disponibilidadOptional.orElse(null);
    }

    public Disponibilidad save(Disponibilidad disponibilidad) {
        return disponibilidadRepository.save(disponibilidad);
    }

    public Disponibilidad update(Long id, Disponibilidad disponibilidad) {
        Optional<Disponibilidad> disponibilidadActualizada = disponibilidadRepository.findById(id);
        if (disponibilidadActualizada.isPresent()) {
            disponibilidadActualizada.get().setDia(disponibilidad.getDia());
            disponibilidadActualizada.get().setHoraIni(disponibilidad.getHoraIni());
            disponibilidadActualizada.get().setHoraFin(disponibilidad.getHoraFin());
            disponibilidadActualizada.get().setNineraUniversitarioId(disponibilidad.getNineraUniversitarioId());
            return disponibilidadRepository.save(disponibilidadActualizada.get());
        } else {
            return null;
        }
    }

    public void delete(Long id) {
        disponibilidadRepository.deleteById(id);
    }

}
