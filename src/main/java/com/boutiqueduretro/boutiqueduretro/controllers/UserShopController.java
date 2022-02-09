package com.boutiqueduretro.boutiqueduretro.controllers;

import java.util.List;

import com.boutiqueduretro.boutiqueduretro.dto.UserShop;
import com.boutiqueduretro.boutiqueduretro.services.UserShopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/users")
public class UserShopController {

    @Autowired
    UserShopService service;

    @GetMapping
    public ResponseEntity<List<UserShop>> getAllUsers() {
        List<UserShop> list = service.getAllUsers();
 
        return new ResponseEntity<List<UserShop>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserShop> getUserById(@PathVariable("id") Long id) 
                                                    throws Exception {
        UserShop entity = service.getUserById(id);
 
        return new ResponseEntity<UserShop>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserShop> createOrUpdateUser(UserShop user)
                                                    throws Exception {
        UserShop updated = service.createOrUpdateUser(user);
        return new ResponseEntity<UserShop>(updated, new HttpHeaders(), HttpStatus.OK);
    }
 
    @DeleteMapping("/{id}")
    public HttpStatus deleteUserById(@PathVariable("id") Long id) 
                                                    throws Exception {
        service.deleteUserById(id);
        return HttpStatus.FORBIDDEN;
    }



}