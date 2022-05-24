package com.scotiabank.usuarios.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.scotiabank.usuarios.dto.RequesDto;
import com.scotiabank.usuarios.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

	// UsuarioModel findByUsuarioId(@Param("usuarioId") Integer usuarioId);

	Optional<UsuarioModel> findByNumeroIdentificacion(@Param("numeroIdentificacion") String numeroIdentificacion);
	
	
	@Query(nativeQuery = true, value = "SELECT U.USUARIO_ID,U.PRIMER_NOMBRE, \r\n"
			+ "U.SEGUNDO_NOMBRE,U.PRIMER_APELLIDO,U.SEGUND_APELLIDO,\r\n"
			+ "U.TIPO_IDENTIFICACION,U.NUMERO_IDENTIFICACION,U.CELULAR,U.DIRECCION,U.CORREO,U.FECHA_INGRESO,U.FECHA_CREACION,U.FECHA_MODIFICACION FROM USUARIOS U\r\n"
			+ "WHERE(U.FECHA_INGRESO  BETWEEN :fechaInicioRangoIngreso and :fechaFinRangoIngreso)\r\n"
			+ "")
	List<UsuarioModel> consultaUsuarios(@Param("fechaInicioRangoIngreso") LocalDate fechaInicioRangoIngreso,
			@Param("fechaFinRangoIngreso") LocalDate fechaFinRangoIngreso);



}
