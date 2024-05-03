package backend.services;

import backend.dtos.DTOUser;
import backend.entities.Usuario;

public interface UserService {

    public Usuario findById(Long id);

    public Usuario register(DTOUser user);

    public Usuario changePassword(DTOUser user);
}
