package com.example.Hibernate.Controller;

import com.example.Hibernate.model.Persona;
import com.example.Hibernate.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private IPersonaService personaService;

    @GetMapping("/personas/all")
    public List<Persona> getPersonas(){
        return personaService.getPersonas();
    }

    @PostMapping("/personas/create")
    public String createPerson(@RequestBody Persona persona){
        personaService.savePersona(persona);
        return "Persona Agregada correctamente";
    }


    @DeleteMapping("/personas/delete/{id}")
    public String deletePerson(@PathVariable Long id){
        personaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }

    @PutMapping("/personas/edit/{idOri}")
    public Persona editPerson(@PathVariable Long idOri,
                              @RequestBody Persona persona
                              ){

        String nombre = persona.getNombre();
        String apellido = persona.getApellido();
        int edad = persona.getEdad();

        personaService.editPersona(idOri, nombre, apellido, edad);
        Persona personaModi = personaService.findPersona(idOri);
        return personaModi;
    }

    @PutMapping("/personas/edit_mascota")
    public Persona editMascota(@RequestBody Persona persona
    ){
             personaService.editPersonaMascota(persona);
            return personaService.findPersona(persona.getId());
        }

}
