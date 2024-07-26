package com.fullstack_backend.fullstack_backend.Execption;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(Long id){
        super("Could not found the user with id" + id);
    }
}
