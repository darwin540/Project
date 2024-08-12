package com.java.Crud.services;

import com.java.Crud.models.UserModel;
import com.java.Crud.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    IUserRepository userRepository;

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>)userRepository.findAll();
    }
    public UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public Optional<UserModel> getById(long id){
        return userRepository.findById(id);
    }

    public UserModel updateById(UserModel request, Long id){
        Optional<UserModel> user = userRepository.findById(id);
        if (user.isPresent()) {
            UserModel userUpdate = user.get();
            userUpdate.setNombre(request.getNombre());
            userUpdate.setApellido(request.getApellido());
            userUpdate.setEmail(request.getEmail());


            return userRepository.save(userUpdate);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }

        //user.setNombre(request.getNombre());
        //user.setApellido(request.getApellido());
        //user.setEmail(request.getEmail());
        //return user;
    }
    public Boolean deleteUser(Long id){
        try {
            userRepository.deleteById(id);
            return true;    
        }catch (Exception e){
            return false;
        }
    }

}
