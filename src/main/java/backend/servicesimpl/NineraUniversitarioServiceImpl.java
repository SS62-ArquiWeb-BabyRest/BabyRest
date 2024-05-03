package backend.servicesimpl;

import backend.entities.NineraUniversitario;
import backend.exceptions.IncompleteDataException;
import backend.exceptions.KeyRepeatedDataException;
import backend.exceptions.ResourceNotFoundException;
import backend.repositories.NineraUniversitarioRepository;
import backend.services.NineraUniversitarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NineraUniversitarioServiceImpl implements NineraUniversitarioService {

    @Autowired
    NineraUniversitarioRepository NineraUniversitarioRepository;



    @Override
    public NineraUniversitario findById(int id) {
        NineraUniversitario nineraUniversitarioFound = NineraUniversitarioRepository.findById(id).orElse(null);
        if (nineraUniversitarioFound == null) {
            throw new ResourceNotFoundException("There are no Employee with the id: " + String.valueOf(id));
        }
        return nineraUniversitarioFound;
    }

    @Override
    public NineraUniversitario save(NineraUniversitario nineraUniversitario) {
        if (nineraUniversitario.getNombre_ninera() == null || nineraUniversitario.getNombre_ninera().isEmpty()) {
            throw new IncompleteDataException("Ninera name can not be null or empty");
        }
        List<NineraUniversitario> listNineraUniversitarioNameDuplicated = NineraUniversitarioRepository.findByNameContaining(nineraUniversitario.getNombre_ninera());
        if (listNineraUniversitarioNameDuplicated.size() > 1 || (listNineraUniversitarioNameDuplicated.size() == 1 && !listNineraUniversitarioNameDuplicated.get(0).getId().equals(nineraUniversitario.getId()))) {
            throw new KeyRepeatedDataException("Ninera name can not be duplicated");
        }

        return NineraUniversitarioRepository.save(nineraUniversitario);
    }

    @Override
    public void delete(int id) {
        NineraUniversitario nineraUniversitario = findById(id);
        NineraUniversitarioRepository.delete(nineraUniversitario);
    }

}