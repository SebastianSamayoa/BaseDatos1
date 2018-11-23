/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basedatos1.controladores;

import com.basedatos1.entidades.Producto;
import com.basedatos1.repositorios.RepositorioProducto;
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
@RequestMapping("producto")
public class ControladorProducto {

    @Autowired
    RepositorioProducto repoproducto;

    @PostMapping(
            value = "/crearproducto",
            consumes = "application/json"
    )
    public Object crearProducto(@RequestBody Producto pro) {
        try {
            return repoproducto.save(pro);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    @GetMapping(
            value="/productostodos",
            produces = "application/json"
    )
    public List<Producto> obtenerProductos() {
        List<Producto> rest = (List<Producto>) repoproducto.findAll();
        return rest;
    }
}
