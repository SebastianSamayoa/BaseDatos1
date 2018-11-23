/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basedatos1.controladores;

import com.basedatos1.Utilidades.Utilidades;
import com.basedatos1.entidades.Cliente;
import com.basedatos1.repositorios.RepositorioCliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jhoansamayoa
 */
@CrossOrigin
@EnableJpaRepositories(basePackages = "com.basedatos1.repositorios")
@RestController
@RequestMapping("cliente")

public class ControladorCliente {
    @Autowired
    RepositorioCliente repocliente;
    
    Utilidades util;
    
    @PostMapping(
            value ="/crearcliente",
            consumes="application/json"
    )
    public Object crearCliente(@RequestBody Cliente cli){
        try {
            return repocliente.save(cli);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    @GetMapping(
            value = "/clientestodos",
            produces = "application/json"
    )
    public List<Cliente> obtenercliente(@RequestBody String cliente){
        List<Cliente> rest = (List<Cliente>) repocliente.findAll();
        return rest;
    }
}
