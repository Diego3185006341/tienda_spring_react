package com.bd_tienda_test.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bd_tienda_test.Model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, String> {

}
