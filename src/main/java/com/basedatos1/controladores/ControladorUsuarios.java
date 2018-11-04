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
import org.json.JSONObject;
import java.util.List;
import java.util.Optional;
import org.json.JSONException;
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
    RepositorioUsuarios repousuarios;
    @Autowired
    RepoPerson repopersonas;
    @Autowired
    RepositorioRoles reporoles;

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
            consumes = "application/json")
    public Object createUsuarios(@RequestBody String user) {
        try {
            util = new Utilidades();
            //Optional<Persona> Per = repopersonas.findByPnombre((String) util.ObtenerValor(user, "nombre", 2).toString().toUpperCase());
            Optional<Persona> Per = repopersonas.findById((Integer) util.ObtenerValor(user, "idpersona", 1));

            Optional<Roles> ro = reporoles.findByRol((String) util.ObtenerValor(user, "rol", 2));

            if (!ro.isPresent()) {
                return "Rol no Existe por favor Verificar";
            }
            if (!Per.isPresent()) {
                return "Persona No existe por favor Verificar";
            }
                
            Usuario us = new Usuario(Per.get().getId(), (String) util.ObtenerValor(user, "usuario", 2), (String) util.ObtenerValor(user, "contrasena", 2));
            us.setPersonaid(Per.get());
            us.setRolid(ro.get());
            repousuarios.save(us);

            return us;
        } catch (Exception e) {
            return "Verificar Datos Enviados";
        }
    }

    @PostMapping(
            value = "/session",
            produces = "application/json"
    )
    public Object sessionUsuarios(@RequestBody String user) {
        JSONObject json;
        try {

            util = new Utilidades();
            Optional<Usuario> result = repousuarios.findByUsuario((String) util.ObtenerValor(user, "usuario", 2));

            if (!result.isPresent()) {
                json = new JSONObject();
                json.put("Status", 200);
                json.put("Respuesta", "Usuario No Existe");
                return json.toString();
            }

            String con = result.get().getContrasena();
            String use = result.get().getUsuario();
            String con1 = (String) util.ObtenerValor(user, "contrasena", 2);
            String use1 = (String) util.ObtenerValor(user, "usuario", 2);

            if (con.equals(con1) && use.equals(use1)) {
                Persona per = repopersonas.findByUser(use);
                JSONObject persona = new JSONObject();
                persona.put("nombre", per.getPnombre());
                persona.put("apellido", per.getPapellido());
                persona.put("nit", per.getNit());
                persona.put("usuario", result.get().getUsuario());
                json = new JSONObject();
//System.out.println(per);
                json.put("Status", 200);
                json.put("Respuesta", "Usuario Existe");
                json.put("Ingresa", con.equals(con1) && use.equals(use1));
                json.put("Persona", persona);
                return json.toString();
            } else {
                json = new JSONObject();
                json.put("Status", 200);
                json.put("Respuesta", "Usuario o Contrasena Inconrrectos");
                json.put("Ingresa", con.equals(con1) && use.equals(use1));
                return json.toString();
            }

        } catch (JSONException e) {
            json = new JSONObject();
            json.put("Status", 403);
            json.put("Error", e.getMessage());
            return json.toString();
        }
    }

}
