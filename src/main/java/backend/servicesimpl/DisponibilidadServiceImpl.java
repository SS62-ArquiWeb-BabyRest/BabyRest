package backend.servicesimpl;
import backend.entities.Disponibilidad;
import backend.repositories.DisponibilidadRepository;
import backend.services.DisponibilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

    @Service
    public class DisponibilidadServiceImpl implements DisponibilidadService {

        @Autowired
        private DisponibilidadRepository disponibilidadRepository;

        @Override
        public List<Disponibilidad> listAll() {
            return disponibilidadRepository.findAll();
        }

        @Override
        public Disponibilidad findById(Long id) {
            Optional<Disponibilidad> disponibilidadOptional = disponibilidadRepository.findById(id);
            return disponibilidadOptional.orElse(null);
        }

        @Override
        public Disponibilidad save(Disponibilidad disponibilidad) {
            return disponibilidadRepository.save(disponibilidad);
        }

        @Override
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

        @Override
        public void delete(Long id) {
            disponibilidadRepository.deleteById(id);
        }
    }


