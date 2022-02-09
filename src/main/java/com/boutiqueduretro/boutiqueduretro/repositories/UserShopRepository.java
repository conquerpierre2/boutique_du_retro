package com.boutiqueduretro.boutiqueduretro.repositories;

import com.boutiqueduretro.boutiqueduretro.dto.UserShop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserShopRepository extends JpaRepository<UserShop,Long> {
    
}
