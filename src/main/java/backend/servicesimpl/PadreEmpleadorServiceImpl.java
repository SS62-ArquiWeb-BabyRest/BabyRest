package backend.servicesimpl;


import backend.entities.PadreEmpleador;
import backend.exceptions.IncompleteDataException;
import backend.exceptions.KeyRepeatedDataException;
import backend.exceptions.ResourceNotFoundException;
import backend.repositories.PadreEmpleadorRepository;
import backend.services.PadreEmpleadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PadreEmpleadorServiceImpl implements PadreEmpleadorService {

    @Autowired
    PadreEmpleadorRepository PadreEmpleadorRepository;



    @Override
    public PadreEmpleador findById(int id) {
        PadreEmpleador padreEmpleadorFound = PadreEmpleadorRepository.findById(id).orElse(null);
        if (padreEmpleadorFound == null) {
            throw new ResourceNotFoundException("There are no Employee with the id: " + String.valueOf(id));
        }
        return padreEmpleadorFound;
    }

    @Override
    public PadreEmpleador save(PadreEmpleador padreEmpleador) {
        if (padreEmpleador.getNombre_padre() == null || padreEmpleador.getNombre_padre().isEmpty()) {
            throw new IncompleteDataException("Padre name can not be null or empty");
        }
        List<PadreEmpleador> listPadreEmpleadorNameDuplicated = PadreEmpleadorRepository.findByNameContaining(padreEmpleador.getNombre_padre());
        if (listPadreEmpleadorNameDuplicated.size() > 1 || (listPadreEmpleadorNameDuplicated.size() == 1 && !listPadreEmpleadorNameDuplicated.get(0).getId().equals(padreEmpleador.getId()))) {
            throw new KeyRepeatedDataException("Padre name can not be duplicated");
        }

        return PadreEmpleadorRepository.save(padreEmpleador);
    }

    @Override
    public void delete(int id) {
        PadreEmpleador padreEmpleador = findById(id);
        PadreEmpleadorRepository.delete(padreEmpleador);
    }

}
