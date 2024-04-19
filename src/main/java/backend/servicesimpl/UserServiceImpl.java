package backend.servicesimpl;

import backend.dtos.DTOUser;
import backend.entities.AuthorityName;
import backend.entities.User;
import backend.exceptions.IncompleteDataException;
import backend.exceptions.KeyRepeatedDataException;
import backend.exceptions.ResourceNotFoundException;
import backend.repositories.AuthorityRepository;
import backend.repositories.UserRepository;
import backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public User findById(Long id) {
        User userFound = userRepository.findById(id).orElse(null);
        if (userFound == null) {
            throw new ResourceNotFoundException("There are no User with the id: "+String.valueOf(id));
        }
        return userFound;
    }

    @Override
    public User register(DTOUser user) {

        if (user.getUserName().length()>4 && user.getPassword().length()>4) {

            User userFound = userRepository.findByUserName(user.getUserName());
            if (userFound != null) {
                throw new KeyRepeatedDataException("User name can not be duplicated");
            };

            User newUser = new User();
            newUser.setUserName(user.getUserName());
            newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            newUser.setEnabled(true);
            newUser.setPasswordLastUpdate(new Date());
            AuthorityName authorityName=AuthorityName.ROLE_STUDENT;
            if (user.getType().equals("ROLE_STUDENT")) authorityName= AuthorityName.ROLE_STUDENT;
            if (user.getType().equals("ROLE_TEACHER")) authorityName= AuthorityName.ROLE_TEACHER;
            if (user.getType().equals("ROLE_PRINCIPAL")) authorityName= AuthorityName.ROLE_PRINCIPAL;
            newUser.setAuthorities(
                    List.of(
                            authorityRepository.findByName(authorityName)
                    )
            );

            return userRepository.save(newUser);
        } else {
            throw new IncompleteDataException("User name and password length can not be less than 4 characters");
        }
    }

    @Override
    public User changePassword(DTOUser user) {
        if (user.getUserName().length()>4 && user.getPassword().length()>4) {

            User userFound = userRepository.findByUserName(user.getUserName());
            if (userFound == null) {
                throw new ResourceNotFoundException("User name can not be found");
            };

            userFound.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            userFound.setPasswordLastUpdate(new Date());
            return userRepository.save(userFound);
        } else {
            throw new IncompleteDataException("User name and password length can not be less than 4 characters");
        }
    }
}
