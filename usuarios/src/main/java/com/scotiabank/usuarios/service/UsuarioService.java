package com.scotiabank.usuarios.service;

import org.springframework.http.ResponseEntity;

import com.scotiabank.usuarios.dto.FiltrosDto;
import com.scotiabank.usuarios.dto.RequesDto;
import com.scotiabank.usuarios.dto.RequestResponseDto;
import com.scotiabank.usuarios.dto.ResponseMenssage;

public interface UsuarioService {

	ResponseEntity<RequestResponseDto> consultaUsuario(RequesDto request) ;

	ResponseEntity<ResponseMenssage> agregarUsuarios(RequestResponseDto request);

	ResponseEntity<ResponseMenssage> modificarUsuario(RequestResponseDto request);

	ResponseEntity<ResponseMenssage> eliminarUsuario(RequesDto request);


	ResponseEntity<Object> consultaUsuarios();

	ResponseEntity<Object> consultafiltros(FiltrosDto request);

}
