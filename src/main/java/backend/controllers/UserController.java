package backend.controllers;

import backend.dtos.DTOToken;
import backend.dtos.DTOUser;
import backend.entities.Usuario;
import backend.security.JwtUtilService;
import backend.security.SecurityUser;
import backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    private JwtUtilService jwtUtilService;

    @Autowired
    UserService userService;

    @PostMapping("/users/register")
    public ResponseEntity<Usuario> createUser(@RequestBody DTOUser user) {
        Usuario newUser = userService.register(user);
        return new ResponseEntity<Usuario>(newUser, HttpStatus.CREATED);
    }


    @PutMapping("/users")
    public ResponseEntity<Usuario> updateUser(@RequestBody DTOUser user) {
        Usuario newUser = userService.changePassword(user);
        return new ResponseEntity<Usuario>(newUser, HttpStatus.OK);
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable("id") Long id) {
        Usuario user = userService.findById(id);
        return new ResponseEntity<Usuario>(user, HttpStatus.OK);
    }





    @PostMapping("/users/login")
    public ResponseEntity<DTOToken> authenticate(@RequestBody DTOUser user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUserName(),
                        user.getPassword()));
        SecurityUser securityUser = (SecurityUser) this.userDetailsService.loadUserByUsername(
                user.getUserName());
        String jwt = jwtUtilService.generateToken(securityUser);
        Long id = securityUser.getUser().getId();

        String authoritiesString=securityUser.getUser().getAuthorities().stream()
                .map(n -> String.valueOf(n.getName().toString()))
                .collect(Collectors.joining(";", "", ""));
System.out.println(authoritiesString);
        return new ResponseEntity<DTOToken>(new DTOToken(jwt, id, authoritiesString), HttpStatus.OK);

    }


}
