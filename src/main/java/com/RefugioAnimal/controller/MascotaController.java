package com.RefugioAnimal.controller;

import com.RefugioAnimal.domain.Mascota;
import com.RefugioAnimal.service.MascotaService;
import com.RefugioAnimal.service.impl.FirebaseStorageServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/mascota")
public class MascotaController {
    
    @Autowired
    MascotaService mascotaService;
            
    @GetMapping("/listado")
    public String listado(Model model) {
        List<Mascota> lista = mascotaService.getMascotas(false);
        model.addAttribute("mascotas", lista);
        model.addAttribute("totalMascotas", lista.size());
        return "/mascota/listado";
    }
    
    @GetMapping("/nuevo")
    public String mascotaNuevo(Mascota mascota) {
        return "/mascota/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String mascotaGuardar(Mascota mascota,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            mascotaService.save(mascota);
            mascota.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "mascota", 
                            mascota.getIdMascota()));
        }
        mascotaService.save(mascota);
        return "redirect:/mascota/listado";
    }

    @GetMapping("/eliminar/{idMascota}")
    public String mascotaEliminar(Mascota mascota) {
        mascotaService.delete(mascota);
        return "redirect:/mascota/listado";
    }

    @GetMapping("/modificar/{idMascota}")
    public String mascotaModificar(Mascota mascota, Model model) {
        mascota = mascotaService.getMascota(mascota);
        model.addAttribute("mascota", mascota);
        return "/mascota/modifica";
    }
    
}
