/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basedatos1.controladores;

import com.basedatos1.Utilidades.Utilidades;
import com.basedatos1.entidades.Persona;
import com.basedatos1.entidades.Roles;
import com.basedatos1.entidades.Usuario;
import com.basedatos1.repositorios.RepoPerson;
import com.basedatos1.repositorios.RepositorioRoles;
import com.basedatos1.repositorios.RepositorioUsuarios;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
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
    RepositorioUsuarios usuarios;
    @Autowired
    RepoPerson personas;
    @Autowired
    RepositorioRoles roles;

    Utilidades util;

    @RequestMapping(
            value = "/all",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public List<Usuario> getUsuarios() {
        List<Usuario> result = (List<Usuario>) usuarios.findAll();

        return result;
    }

    @RequestMapping(
            value = "/crear",
            method = RequestMethod.POST,
            consumes = "application/json")
    public Object createUsuarios(@RequestBody String user) {
        try {
            util = new Utilidades();
            Optional<Persona> Per = personas.findByPnombre((String) util.ObtenerValor(user, "nombre", 2).toString().toUpperCase());

            Optional<Roles> ro = roles.findByRol((String) util.ObtenerValor(user, "rol", 2));

            if (!ro.isPresent()) {
                return "Rol no Existe por favor Verificar";
            }
            if (!Per.isPresent()) {
                return "Persona No existe por favor Verificar";
            }

            Usuario us = new Usuario(Per.get().getId(), (String) util.ObtenerValor(user, "usuario", 2), (String) util.ObtenerValor(user, "contrasena", 2));
            us.setPersonaid(Per.get());
            us.setRolid(ro.get());
            usuarios.save(us);

            return us;
        } catch (Exception e) {
            return "Verificar Datos Enviados";
        }
    }

    @RequestMapping(
            value = "/session",
            method = RequestMethod.POST,
            consumes = "application/json"
    )
    public Object sessionUsuarios(@RequestBody String user) {

        try {
            util = new Utilidades();
            //String usu = (String) util.ObtenerValor(user, "usuario", 2);
            //System.out.println(usu);
            Optional<Usuario> result = usuarios.findByUsuario( (String) util.ObtenerValor(user, "usuario", 2));
            //Optional<Usuario> result = usuarios.findByUsuario("jsamayoa");

            if (!result.isPresent()) {
                return false;
            }

            if (result.get().getUsuario().equals(util.ObtenerValor(user, "usuario", 2).toString())) {
               return true;
            }

            return result;

        } catch (Exception e) {
            return "Error " + e.getMessage();
        }
    }

}
