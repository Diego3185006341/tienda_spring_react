package com.bd_tienda_test.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bd_tienda_test.Model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, String> {

	/*@Query(value="select cm from tabla_Usuarios cm"
			+ " where (cm.cedula_usuario=:cedula_usuario or :cedula_usuario is null)"
			+ "and (cm.nombre_usuario=:nombre_usuario or :nombre_usuario is null)"
			)*/
	@Query(value="select * from tabla_Usuarios where cedula_usuario=:cedula_usuario and nombre_usuario=:nombre_usuario",nativeQuery = true
			
			)
	Page<UsuarioModel> Consultarbd(@Param("cedula_usuario")String cedula_usuario,@Param("nombre_usuario")String nombre_usuario, Pageable pagination);
	
}
