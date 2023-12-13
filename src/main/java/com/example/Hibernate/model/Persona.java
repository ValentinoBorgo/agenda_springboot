package com.example.Hibernate.model;

import jakarta.persistence.*;

@Entity
public class Persona {

    //Se utiliza notacion id para marcar como clave primaria
    @Id
    //Esto hace que sea incremental AI
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;

    @OneToOne
    //asocio la columna de id_mascota en persona con el id de la mascota en su respectiva tabla
    @JoinColumn(name = "mascota_id_mascota", referencedColumnName = "id_mascota")
    private Mascota mascota;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, int edad, Mascota mascota) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.mascota = mascota;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
