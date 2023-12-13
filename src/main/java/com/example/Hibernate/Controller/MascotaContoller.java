package com.example.Hibernate.Controller;

import com.example.Hibernate.model.Mascota;
import com.example.Hibernate.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MascotaContoller {

    @Autowired
    private IMascotaService mascotaService;

    @GetMapping("/mascotas/all")
    public List<Mascota> getMascotas(){
        List<Mascota> mascotas = mascotaService.getMascotas();
        return mascotas;
    }

    @PostMapping("/mascotas/create")
    public String createMascotas(@RequestBody Mascota mascota){
        mascotaService.saveMascota(mascota);
        return "Mascota creada efectivamente";
    }

}
