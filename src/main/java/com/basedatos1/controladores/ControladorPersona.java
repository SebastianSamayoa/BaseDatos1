/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basedatos1.controladores;

import com.basedatos1.Utilidades.Utilidades;
import com.basedatos1.entidades.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.basedatos1.repositorios.RepositorioPersona;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author root
 */
@CrossOrigin
@RestController
@RequestMapping("persona")
@EnableJpaRepositories(basePackages = "com.basedatos1.repositorios")
public class ControladorPersona {

    @Autowired
    RepositorioPersona persona;

    Utilidades util;
    
    @RequestMapping(
            value = "/all",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public List<Persona> getall() {
        List<Persona> result = (List<Persona>) persona.findAll();
        return result;
    }

    @RequestMapping(
            value = "/crear",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    public Persona crear(@RequestBody Persona person) {
        Persona result = persona.save(person);
        return result;
    }

    @GetMapping(
            value = "/buscar",
            produces = "application/json"
    )
    public Optional<Persona> getone(@RequestBody String datos) {
        util = new Utilidades();
        return persona.findById((Integer) util.ObtenerValor(datos, "codigo", 1));
    }
}
