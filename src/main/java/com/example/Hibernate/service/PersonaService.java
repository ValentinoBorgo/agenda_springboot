package com.example.Hibernate.service;

import com.example.Hibernate.Repository.IPersonaRepository;
import com.example.Hibernate.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService{

    //Inyeccion de dependencias
    @Autowired
    private IPersonaRepository IPersonaRepository;

    @Override
    public List<Persona> getPersonas() {
        List<Persona> listaPersonas = IPersonaRepository.findAll();
        return listaPersonas;
    }

    @Override
    public void savePersona(Persona persona) {
        IPersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        IPersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = IPersonaRepository.findById(id).orElse(null);
        return persona;
    }

    @Override
    public void editPersona(Long idOriginal, String nombreNuevo, String apellidoNuevo, int edadNueva) {
        Persona persona = this.findPersona(idOriginal);
        persona.setApellido(apellidoNuevo);
        persona.setNombre(nombreNuevo);
        persona.setEdad(edadNueva);
        this.savePersona(persona);
    }
}
