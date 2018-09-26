/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basedatos1.controladores;



import com.basedatos1.entidades.Usuario;
import com.basedatos1.repositorios.RepositorioUsuarios;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author root
 */

@CrossOrigin
@RestController
@RequestMapping("usuario")
@EnableJpaRepositories(basePackages = "com.basedatos1.repositorios")
public class ControladorUsuarios {
    
    @Autowired
    RepositorioUsuarios usuario;
    
    @RequestMapping(
            value = "/all",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public List<Usuario> getall(){
        List<Usuario> result = (List<Usuario>) usuario.findAll();
        
    return result;
    }
    
}
