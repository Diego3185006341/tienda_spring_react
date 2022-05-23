package com.scotiabank.usuarios.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.scotiabank.usuarios.dto.FiltrosDto;
import com.scotiabank.usuarios.dto.RequesDto;
import com.scotiabank.usuarios.dto.RequestResponseDto;
import com.scotiabank.usuarios.dto.ResponseMenssage;
import com.scotiabank.usuarios.service.UsuarioService;

class UsuariosControllerTest {

	@InjectMocks
	UsuariosController usuarioController;
	
	@Mock
	UsuarioService usuarioservice;
	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	
	@Test
	void test() {
		
		RequesDto request = null;
		
		
		Mockito.when(usuarioservice.consultaUsuario(request)).thenReturn(ResponseEntity.ok().body(RequestResponseDto.builder()
				.build()));
		
		ResponseEntity<RequestResponseDto> respuesta = usuarioController.consulta(request);
		assertEquals(respuesta.getBody().getClass(), RequestResponseDto.class);
		
		
	}
	
	@Test
	void testusuarios() {
		
		
		
		
		
		Mockito.when(usuarioservice.consultaUsuarios()).thenReturn(ResponseEntity.ok().body(RequestResponseDto.builder()
				.build()));
		
		ResponseEntity<Object> respuesta = usuarioController.consultausuarios();
		assertEquals(respuesta.getBody().getClass(), RequestResponseDto.class);
	
		
		
		
	}
	
	@Test
	void testagregarUsuarios() {
		
		
		
		RequestResponseDto request = null;
		
		Mockito.when(usuarioservice.agregarUsuarios(request)).thenReturn(ResponseEntity.ok().body(ResponseMenssage.builder().build()));
	    ResponseEntity<ResponseMenssage> respuesta = usuarioController.agregarUsuarios(request);
		assertEquals(respuesta.getBody().getClass(), ResponseMenssage.class);
		
		
	}
	
	@Test
	void testModificarUsuarios() {
		
		
		
		RequestResponseDto request = null;
		
		Mockito.when(usuarioservice.modificarUsuario(request)).thenReturn(ResponseEntity.ok().body(ResponseMenssage.builder().build()));
	    ResponseEntity<ResponseMenssage> respuesta = usuarioController.modificarUsuario(request);
		assertEquals(respuesta.getBody().getClass(), ResponseMenssage.class);
		
		
	}
	
	@Test
	void testEliminarUsuario() {
		
		
		
		RequesDto request = null;
		
		Mockito.when(usuarioservice.eliminarUsuario(request)).thenReturn(ResponseEntity.ok().body(ResponseMenssage.builder().build()));
	    ResponseEntity<ResponseMenssage> respuesta = usuarioController.eliminarUsuario(request);
		assertEquals(respuesta.getBody().getClass(), ResponseMenssage.class);
		
		
	}
	
	
	@Test
	void testFiltro() {
		
		FiltrosDto request = null;
		
		
		Mockito.when(usuarioservice.consultafiltros(request)).thenReturn(ResponseEntity.ok().body(RequestResponseDto.builder()
				.build()));
		
		ResponseEntity<Object> respuesta = usuarioController.consultafiltros(request);
		assertEquals(respuesta.getBody().getClass(), RequestResponseDto.class);
		
		
	}

}
