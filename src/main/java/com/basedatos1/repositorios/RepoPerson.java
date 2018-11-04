/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basedatos1.repositorios;

import com.basedatos1.entidades.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 *
 * @author root
 */
public interface RepoPerson extends QueryByExampleExecutor<Persona>, PagingAndSortingRepository<Persona, Integer>{
    Optional <Persona> findByPnombre(String pnombre);
    
    @Query("SELECT p FROM Persona p\n"
            + "JOIN Usuario u ON u.personaid = p.id\n"
            + "WHERE u.usuario = :usuario")
    Persona findByUser(@Param("usuario") String usuario);
}
