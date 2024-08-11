package com.java.Crud.services;

import com.java.Crud.models.DarwinModel;
import com.java.Crud.repositories.IDarwinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DarwinServices {

    @Autowired
    IDarwinRepository userRepository;

    public ArrayList<DarwinModel> getUsers(){
        return (ArrayList<DarwinModel>)userRepository.findAll();
    }
    public DarwinModel saveUser(DarwinModel user){
        return userRepository.save(user);
    }

    public Optional<DarwinModel> getById(long id){
        return userRepository.findById(id);
    }

    public DarwinModel updateById(DarwinModel request, Long id){
        DarwinModel user = userRepository.findById(id).get();

        user.setNombre(request.getNombre());
        user.setApellido(request.getApellido());
        user.setEmail(request.getEmail());
        return user;
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
