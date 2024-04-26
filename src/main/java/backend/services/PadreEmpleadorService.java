package backend.services;

import backend.entities.Employee;
import backend.entities.PadreEmpleador;


public interface PadreEmpleadorService {


    PadreEmpleador findById(int id);

    public PadreEmpleador save(PadreEmpleador padreEmpleador);

    public void delete(int id);
}
