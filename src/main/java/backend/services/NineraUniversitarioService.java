package backend.services;

//import backend.entities.Employee;
import backend.entities.NineraUniversitario;


public interface NineraUniversitarioService {


    NineraUniversitario findById(int id);

    public NineraUniversitario save(NineraUniversitario nineraUniversitario);

    public void delete(int id);
}
