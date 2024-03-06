package com.RefugioAnimal.service.impl;

import com.RefugioAnimal.dao.MascotaDao;
import com.RefugioAnimal.domain.Mascota;
import com.RefugioAnimal.service.MascotaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MascotaServiceImpl implements MascotaService{
    
    @Autowired
    private MascotaDao mascotaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Mascota> getMascotas(boolean activos) {
        List<Mascota> lista = mascotaDao.findAll();
        
        if(activos) {
            lista.removeIf(c -> !c.isActivo());
        }
        
        return lista;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Mascota getMascota(Mascota mascota) {
        return mascotaDao.findById(mascota.getIdMascota()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Mascota mascota) {
        mascotaDao.save(mascota);
    }

    @Override
    @Transactional
    public void delete(Mascota mascota) {
        mascotaDao.delete(mascota);
    }
}
