package com.boutiqueduretro.boutiqueduretro.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.boutiqueduretro.boutiqueduretro.dto.UserShop;
import com.boutiqueduretro.boutiqueduretro.repositories.UserShopRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userShopService")
public class UserShopService  {

    @Autowired
    UserShopRepository userRepository;

    public List<UserShop> getAllUsers()
    {
        List<UserShop> userList = userRepository.findAll();
         
        if(userList.size() > 0) {
            return userList;
        } else {
            return new ArrayList<UserShop>();
        }
    }

    public UserShop getUserById(Long id) throws Exception 
    {
        Optional<UserShop> user = userRepository.findById(id);
         
        if(user.isPresent()) {
            return user.get();
        } else {
            throw new Exception("No user exists for given id");
        }
    }

    public UserShop createOrUpdateUser(UserShop entity) throws Exception 
    {
        Optional<UserShop> user = userRepository.findById(entity.getId());
         
        if(user.isPresent()) 
        {
            UserShop newEntity = user.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
            newEntity.setAmountMoney(entity.getAmountMoney());
 
            newEntity = userRepository.save(newEntity);
             
            return newEntity;
        } else {
            entity = userRepository.save(entity);
             
            return entity;
        }
    }
    
    public void deleteUserById(Long id) throws Exception 
    {
        Optional<UserShop> user = userRepository.findById(id);
         
        if(user.isPresent()) 
        {
            userRepository.deleteById(id);
        } else {
            throw new Exception("No user exists for given id");
        }
    } 


}