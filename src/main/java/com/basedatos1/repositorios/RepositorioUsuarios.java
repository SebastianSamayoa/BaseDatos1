/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basedatos1.repositorios;

import com.basedatos1.entidades.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

/**
 *
 * @author root
 */
public interface RepositorioUsuarios extends QueryByExampleExecutor<Usuario>, PagingAndSortingRepository<Usuario, Integer>{
    Optional<Usuario> findByUsuario(String usuario);
}
