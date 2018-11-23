/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basedatos1.controladores;

import com.basedatos1.entidades.Detallefactura;
import com.basedatos1.entidades.Factura;
import com.basedatos1.repositorios.RepositorioDetalleFactura;
import com.basedatos1.repositorios.RepositorioFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jhoansamayoa
 */
@CrossOrigin
@RequestMapping("factura")
@EnableJpaRepositories(basePackages = "com.basedatos1.repositorios")
@RestController
public class ControladorFactura {
    @Autowired
    RepositorioFactura repofactura;
    @Autowired
    RepositorioDetalleFactura repodetallefactura;
    
    @PostMapping(
            value = "/crearfactura",
            consumes = "application/json"
    )
    public Object crearFactura(@RequestBody Factura fact){
        try {
            return repofactura.save(fact);
        } catch (Exception e) {
            return e.getMessage();
        }
        
    }
    
    @PostMapping(
            value = "/creardetalle",
            consumes = "application/json"
    )
    public Object crearDetalle(@RequestBody Detallefactura det){
        try {
            return repodetallefactura.save(det);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    
}
