/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basedatos1.repositorios;

import com.basedatos1.entidades.Usuario;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 *
 * @author jhoansamayoa
 */
public interface RepositorioUsuario extends PagingAndSortingRepository<Usuario, Integer>, QueryByExampleExecutor<Usuario> {
    
    Optional<Usuario> findByUsuario(String usuario);
}
