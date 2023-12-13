package com.example.Hibernate.service;

import com.example.Hibernate.model.Mascota;
import com.example.Hibernate.model.Persona;

import java.util.List;

public interface IMascotaService {

    public List<Mascota> getMascotas();

    public void saveMascota (Mascota mascota);

    public void deleteMascota(Long id);

    public Mascota findMascota(Long id);

    public void editMascota(Long idOriginal,
                            String nombreNuevo, String especieNueva,
                            String razaNueva, String colorNuevo);

}
