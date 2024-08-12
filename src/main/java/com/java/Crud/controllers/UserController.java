package com.java.Crud.controllers;

import com.java.Crud.models.UserModel;
import com.java.Crud.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")

class UserController {
    @Autowired
    private UserServices userService;
    @GetMapping
    public ArrayList<UserModel>getUsers(){
        return this.userService.getUsers();
    }
    @PostMapping
    public UserModel saveUser(@RequestBody UserModel user ){
        return this.userService.saveUser(user);
    }
    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable Long id) {
        return this.userService.getById(id);
    }
    /*
    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable("id") Long id){
        return this.userService.updateById(request, id);
    }

     */

    @PutMapping(path = "/{id}")
    public String updateUserById(@RequestBody UserModel request, @PathVariable("id") Long id) {
        this.userService.updateById(request, id);
        return "Usuario " + id + " fue actualizado correctamente!";
    }


    @DeleteMapping(path = "/{id}")
    public String deleteUserById(@PathVariable("id")Long id){
        boolean ok=this.userService.deleteUser(id);

        if(ok){
            return "Usuario con id "+ id+" eliminado correctamente";
        }else {
            return "Error";
        }
    }

}
