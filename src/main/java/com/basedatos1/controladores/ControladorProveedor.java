/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basedatos1.controladores;

import com.basedatos1.entidades.Proveedor;
import com.basedatos1.repositorios.RepositorioProveedor;
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
@RestController
@RequestMapping("proveedor")
@EnableJpaRepositories(basePackages = "com.basedatos1.repositorios")
public class ControladorProveedor {

    @Autowired
    RepositorioProveedor reprovedor;

    @GetMapping(
            value="/proveedorestodos"
    )
    public List<Proveedor> obtenerProveedores() {
        return (List<Proveedor>) reprovedor.findAll();
    }
    
    @PostMapping(
            value="/crearproveedor",
            consumes = "application/json"
    )
    public Object crearProveedor(@RequestBody Proveedor prov){
        try {
            return reprovedor.save(prov); 
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
