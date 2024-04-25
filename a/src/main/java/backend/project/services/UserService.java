package backend.project.services;

import backend.project.dtos.DTOUser;
import backend.project.entities.Usuarios;

public interface UserService {

    public Usuarios findById(Long id);

    public Usuarios register(DTOUser user);

    public Usuarios changePassword(DTOUser user);
}
