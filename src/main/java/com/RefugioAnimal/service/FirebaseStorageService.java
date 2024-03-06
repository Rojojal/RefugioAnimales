package com.RefugioAnimal.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService {
    
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    final String BucketName = "refugio-animal-6e767.appspot.com";

    final String rutaSuperiorStorage = "Patitas Felices";

    final String rutaJsonFile = "firebase";
    
    final String archivoJsonFile = "refugio-animal-6e767-firebase-adminsdk-ftg15-0d0f22b7c6.json";
}
