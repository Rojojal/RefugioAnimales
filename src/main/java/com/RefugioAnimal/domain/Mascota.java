package com.RefugioAnimal.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity 
@Table(name="mascota")
public class Mascota implements Serializable{
    
    private static final long serialVersionUID = 1L; //
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Long idMascota;
    private String animal;
    private String genero;
    private String raza;
    private String nombre;
    private int edad;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    public Mascota() {
    }

    public Mascota(String animal, String genero, String raza, String nombre, int edad, String descripcion, String rutaImagen, boolean activo) {
        this.animal = animal;
        this.genero = genero;
        this.raza = raza;
        this.nombre = nombre;
        this.edad = edad;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
    }
    
}
