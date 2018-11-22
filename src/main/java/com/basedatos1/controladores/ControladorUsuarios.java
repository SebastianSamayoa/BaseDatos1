/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basedatos1.controladores;

import com.basedatos1.Utilidades.Utilidades;
import com.basedatos1.entidades.Usuario;
import com.basedatos1.repositorios.RepositorioPersona;
import com.basedatos1.repositorios.RepositorioRol;
import com.basedatos1.repositorios.RepositorioUsuario;
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
 * @author root
 */
@CrossOrigin
@RestController
@RequestMapping("usuario")
@EnableJpaRepositories(basePackages = "com.basedatos1.repositorios")
public class ControladorUsuarios {

    @Autowired
    RepositorioUsuario repousuarios;
    @Autowired
    RepositorioPersona repopersonas;
    @Autowired
    RepositorioRol reporoles;

    Utilidades util;

    @GetMapping(
            value = "/all",
            produces = "application/json"
    )
    public List<Usuario> getUsuarios() {
        List<Usuario> result = (List<Usuario>) repousuarios.findAll();

        return result;
    }

    @PostMapping(
            value = "/crear",
            consumes = "application/json"
    )
    public Object crearUsuario(@RequestBody String Datos) {

        util = new Utilidades();
        try {
            if (!repopersonas.findById((Integer) util.ObtenerValor(Datos, "idpersona", 1)).isPresent() || !reporoles.findById((Integer) util.ObtenerValor(Datos, "idrol", 1)).isPresent()) {
                return "Persona o Rol no Existe";
            }
            Usuario user = new Usuario();
            user.setUsuario((String) util.ObtenerValor(Datos, "usuario", 2));
            user.setContrasena((String) util.ObtenerValor(Datos, "contrasena", 2));
            user.setIdpersona((Integer) util.ObtenerValor(Datos, "idpersona", 1));
            user.setIdrol((Integer) util.ObtenerValor(Datos, "idrol", 1));
            return repousuarios.save(user);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @GetMapping(
            value="/sesion",
            produces="application/json"
    )
    public Object CrearSesion(@RequestBody String Sesion){
        try {
            util = new Utilidades();
            String us = (String) util.ObtenerValor(Sesion, "usuario", 2).toString();
            System.out.println(repousuarios.findByUsuario(us));
            if(!repousuarios.findByUsuario(us).isPresent()){
                return "usuario no existe";
            }
            return repousuarios.findByUsuario(us);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return e.getMessage();
            
        }
    }
}
