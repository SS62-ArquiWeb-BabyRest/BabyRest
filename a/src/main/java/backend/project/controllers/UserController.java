package backend.project.controllers;

import backend.project.dtos.DTOToken;
import backend.project.dtos.DTOUser;
import backend.project.entities.Usuarios;
import backend.project.security.JwtUtilService;
import backend.project.security.SecurityUser;
import backend.project.services.UserService;
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
    public ResponseEntity<Usuarios> createUser(@RequestBody DTOUser user) {
        Usuarios newUser = userService.register(user);
        return new ResponseEntity<Usuarios>(newUser, HttpStatus.CREATED);
    }


    @PutMapping("/users")
    public ResponseEntity<Usuarios> updateUser(@RequestBody DTOUser user) {
        Usuarios newUser = userService.changePassword(user);
        return new ResponseEntity<Usuarios>(newUser, HttpStatus.OK);
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<Usuarios> getUserById(@PathVariable("id") Long id) {
        Usuarios user = userService.findById(id);
        return new ResponseEntity<Usuarios>(user, HttpStatus.OK);
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
