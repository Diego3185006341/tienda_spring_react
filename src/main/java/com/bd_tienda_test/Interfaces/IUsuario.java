package com.bd_tienda_test.Interfaces;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bd_tienda_test.Model.UsuarioModel;

@Repository
public interface IUsuario extends JpaRepository<UsuarioModel, String>{

	@Query(value="select * from tabla_Usuarios where usuario=:usuario and clave_Usuario=:clave", nativeQuery = true)
	UsuarioModel findByUsuarioAndPassword(String usuario, String clave);

	/*@Query(value="select UM from tabla_Usuarios UM"
			+ " where (UM.cedula_usuario= :cedula_usuario or :cedula_usuario is =null)"
			+ "and (UM.nombre_usuario= :nombre_usuario or :nombre_usuario is null)"
			)
	Page<UsuarioModel> Consultarbd(@Param("cedula_usuario")String cedula_usuario,@Param("cedula_nombre")String nombre_usuario, Pageable pagination);
	*/
	  
	/*@Query(value="select * from tabla_Usuarios where cedula_usuario=:cedula_Usuario", nativeQuery = true)

	Page<UsuarioModel> consultarUsuarioId(@Param("cedula_Usuario") String cedula_Usuario);
*/
}



