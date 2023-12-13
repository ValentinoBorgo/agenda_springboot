package com.example.Hibernate.service;

import com.example.Hibernate.model.Persona;

import java.util.List;

public interface IPersonaService {

    public List<Persona> getPersonas();

    public void savePersona (Persona persona);

    public void deletePersona(Long id);

    public Persona findPersona(Long id);

    public void editPersona(Long idOriginal,
                            String nombreNuevo, String apellidoNuevo,
                            int edadNueva);

    public void editPersonaMascota(Persona persona);

}
