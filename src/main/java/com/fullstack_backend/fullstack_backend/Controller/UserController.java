package com.fullstack_backend.fullstack_backend.Controller;

import com.fullstack_backend.fullstack_backend.Execption.UserNotFoundException;
import com.fullstack_backend.fullstack_backend.Module.User;
import com.fullstack_backend.fullstack_backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController                         // indicates that the class is controller with methods that handle HTTP
@CrossOrigin("http://localhost:3000/")
public class UserController {
    @Autowired                         // injecting UserRepository to UserController

    private UserRepository userRepository;

    @PostMapping("/user")             // method handles POST requests

    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users")               // method handles GET requests
    List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @GetMapping("/user/{id}")
    User getUserById(@PathVariable Long id ) {     // PathVariabele = fetches a single id
        return userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException(id));
    }

    @PutMapping("user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id) {
        return userRepository.findById(id)
                .map(user->{
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException(id));

    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id"+id+"has been deletead success";
    }

}
