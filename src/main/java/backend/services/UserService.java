package backend.services;

import backend.dtos.DTOUser;
import backend.entities.User;

public interface UserService {

    public User findById(Long id);

    public User register(DTOUser user);

    public User changePassword(DTOUser user);
}
