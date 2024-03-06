package com.RefugioAnimal.dao;

import com.RefugioAnimal.domain.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MascotaDao extends JpaRepository<Mascota, Long>{
    
}
