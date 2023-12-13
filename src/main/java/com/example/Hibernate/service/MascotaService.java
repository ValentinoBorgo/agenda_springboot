package com.example.Hibernate.service;

import com.example.Hibernate.Repository.IMascotaRepository;
import com.example.Hibernate.model.Mascota;
import com.example.Hibernate.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService implements IMascotaService{

    @Autowired
    private IMascotaRepository mascotaRepository;

    @Override
    public List<Mascota> getMascotas() {
        List<Mascota> listMascotas = mascotaRepository.findAll();
        return  listMascotas;
    }

    @Override
    public void saveMascota(Mascota mascota) {
        mascotaRepository.save(mascota);
    }

    @Override
    public void deleteMascota(Long id) {
        mascotaRepository.deleteById(id);
    }

    @Override
    public Mascota findMascota(Long id) {
        Mascota mascota = mascotaRepository.findById(id).orElse(null);
        return mascota;
    }

    @Override
    public void editMascota(Long idOriginal, String nombreNuevo, String especieNueva, String razaNueva, String colorNuevo) {
        Mascota mascota = this.findMascota(idOriginal);
        mascota.setColor(colorNuevo);
        mascota.setNombre(nombreNuevo);
        mascota.setEspecie(especieNueva);
        mascota.setRaza(razaNueva);
        this.saveMascota(mascota);
    }
}
