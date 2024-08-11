package com.java.Crud.controllers;

import com.java.Crud.models.DarwinModel;
import com.java.Crud.services.DarwinServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")

class DarwinController {
    @Autowired
    private DarwinServices userService;
    @GetMapping
    public ArrayList<DarwinModel>getUsers(){
        return this.userService.getUsers();
    }
    @PostMapping
    public DarwinModel saveUser(@RequestBody DarwinModel user ){
        return this.userService.saveUser(user);
    }
    @GetMapping(path = "/{id}")
    public Optional<DarwinModel> getUserById(@PathVariable Long id){
        return this.userService.getById(id);
    }
    @PutMapping(path = "/{id}")
    public DarwinModel updateUserById(@RequestBody DarwinModel request, @PathVariable("id") Long id){
        return this.userService.updateById(request, id);
    }
    @DeleteMapping(path = "/{id}")
    public String deleteUserById(@PathVariable("id")Long id){
        boolean ok=this.userService.deleteUser(id);

        if(ok){
            return "User with id "+ id+" deleted";
        }else {
            return "Error";
        }
    }

}
