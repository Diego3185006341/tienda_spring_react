package com.bd_tienda_test.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bd_tienda_test.Model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, String> {
	
	@Query(value="select * from tabla_Usuarios where nombre_usuario=:nombre_usuario or correo_usuario=:correo_usuario",nativeQuery = true	
			)

	List<UsuarioModel> consultaUsuarios(@Param("nombre_usuario")String nombre_usuario,@Param("correo_usuario") String correo_usuario);

	/*@Query(value="select cm from tabla_Usuarios cm"
			+ " where (cm.cedula_usuario=:cedula_usuario or :cedula_usuario is null)"
			+ "and (cm.nombre_usuario=:nombre_usuario or :nombre_usuario is null)"
			)*/

	
	
	
}
