package com.scotiabank.usuarios.service.impl;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.scotiabank.usuarios.dto.FiltroDetalle;
import com.scotiabank.usuarios.dto.FiltrosDto;
import com.scotiabank.usuarios.dto.RequesDto;
import com.scotiabank.usuarios.dto.RequestResponseDto;
import com.scotiabank.usuarios.dto.ResponseMenssage;
import com.scotiabank.usuarios.model.UsuarioModel;
import com.scotiabank.usuarios.repository.UsuarioRepository;

class UsuariosServiceImplTest {

	@InjectMocks
	UsuariosServiceImpl usuariosServiceImpl;

	@Mock
	UsuarioRepository usuarioRepository;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Test para Consulta Usuario
	 * 
	 */

	@Test
	void consultaUsuario() {

		Optional<UsuarioModel> usuario = Optional.of(dataUsuarios());
		RequesDto request = new RequesDto();
		String numero = "123456";
		request.setNumeroIdentificacion(numero);
		Mockito.when(usuarioRepository.findByNumeroIdentificacion(Mockito.anyString())).thenReturn(usuario);

		ResponseEntity<RequestResponseDto> respuesta = usuariosServiceImpl.consultaUsuario(request);
		assertEquals(respuesta.getBody().getClass(), RequestResponseDto.class);

	}

	private UsuarioModel dataUsuarios() {
		UsuarioModel prueba = new UsuarioModel();
		prueba.setUsuarioId(1);
		prueba.setPrimerNombre("Julian");
		prueba.setSegundoNombre("Alexander");
		return prueba;
	}

	@Test
	void consultaUsuarioVacio() {

		Optional<UsuarioModel> usuario = Optional.empty();
		RequesDto request = new RequesDto();
		String numero = "123456";
		request.setNumeroIdentificacion(numero);
		Mockito.when(usuarioRepository.findByNumeroIdentificacion(Mockito.anyString())).thenReturn(usuario);

		ResponseEntity<RequestResponseDto> respuesta = usuariosServiceImpl.consultaUsuario(request);
		assertThatExceptionOfType(BadRequest.class);

	}

	@Test
	void consultaUsuarioNull() {

		Optional<UsuarioModel> usuario = null;
		RequesDto request = new RequesDto();
		String numero = "";
		request.setNumeroIdentificacion(numero);
		Mockito.when(usuarioRepository.findByNumeroIdentificacion(Mockito.anyString())).thenReturn(usuario);

		ResponseEntity<RequestResponseDto> respuesta = usuariosServiceImpl.consultaUsuario(request);
		assertThatExceptionOfType(InternalError.class);

	}

	/**
	 * Test para Consultar todos los Usuario
	 * 
	 */

	@Test
	void consultaUsuarios() {

		List<UsuarioModel> usuario = new ArrayList<>();
		usuario.add(UsuarioModel.builder().usuarioId(1).primerNombre("Julian").build());

		Mockito.when(usuarioRepository.findAll()).thenReturn(usuario);

		ResponseEntity<Object> respuesta = usuariosServiceImpl.consultaUsuarios();
		assertEquals(respuesta.getBody().getClass(), RequestResponseDto.class);

	}

	/**
	 * 
	 * Test agregar Usuario
	 * 
	 */

	@Test
	void testAgregarUsuario() {

		Optional<UsuarioModel> usuario = Optional.empty();
		RequestResponseDto request = new RequestResponseDto();
		String numero = "123456";
		request.setUsuarioId(1);
		request.setNumeroIdentificacion(numero);
		request.setPrimerNombre("Julian");
		request.setPrimerApellido("Osma");
		request.setSegundoApellido("Ariza");
		Mockito.when(usuarioRepository.findByNumeroIdentificacion(Mockito.anyString())).thenReturn(usuario);
		Mockito.when(usuarioRepository.save(Mockito.any())).thenReturn(UsuarioModel.builder().build());
		ResponseEntity<ResponseMenssage> respuesta = usuariosServiceImpl.agregarUsuarios(request);
		assertEquals(respuesta.getBody().getClass(), ResponseMenssage.class);

	}

	@Test
	void testAgregarUsuario2() {

		Optional<UsuarioModel> usuario = Optional.of(dataUsuarios());
		RequestResponseDto request = new RequestResponseDto();
		String numero = "123456";
		request.setNumeroIdentificacion(numero);
		Mockito.when(usuarioRepository.findByNumeroIdentificacion(Mockito.anyString())).thenReturn(usuario);

		ResponseEntity<ResponseMenssage> respuesta = usuariosServiceImpl.agregarUsuarios(request);
		assertEquals(respuesta.getBody().getClass(), ResponseMenssage.class);

	}

	/**
	 * 
	 * Test Modificar Usuario
	 * 
	 */

	@Test
	void testModificarUsuario() {

		Optional<UsuarioModel> usuario = Optional.of(dataUsuarios());
		RequestResponseDto request = new RequestResponseDto();
		String numero = "123456";
		request.setUsuarioId(1);
		request.setNumeroIdentificacion(numero);
		request.setPrimerNombre("Julian");
		request.setPrimerApellido("Osma");
		request.setSegundoApellido("Ariza");
		Mockito.when(usuarioRepository.findByNumeroIdentificacion(Mockito.anyString())).thenReturn(usuario);
		Mockito.when(usuarioRepository.save(Mockito.any())).thenReturn(UsuarioModel.builder().build());
		ResponseEntity<ResponseMenssage> respuesta = usuariosServiceImpl.modificarUsuario(request);
		assertEquals(respuesta.getBody().getClass(), ResponseMenssage.class);

	}

	/***
	 * 
	 * 
	 * Eliminar Usuario
	 * 
	 */

	@Test
	void testEliminarUsuario() {

		Optional<UsuarioModel> usuario = Optional.of(dataUsuarios());
		RequesDto request = new RequesDto();
		String numero = "123456";
		request.setNumeroIdentificacion(numero);
		Mockito.when(usuarioRepository.findByNumeroIdentificacion(Mockito.anyString())).thenReturn(usuario);
		ResponseEntity<ResponseMenssage> respuesta = usuariosServiceImpl.eliminarUsuario(request);
		assertEquals(respuesta.getBody().getClass(), ResponseMenssage.class);

	}

	@Test
	void testEliminarUsuarioVacio() {

		Optional<UsuarioModel> usuario = Optional.empty();
		RequesDto request = new RequesDto();
		String numero = "123456";
		request.setNumeroIdentificacion(numero);
		Mockito.when(usuarioRepository.findByNumeroIdentificacion(Mockito.anyString())).thenReturn(usuario);
		ResponseEntity<ResponseMenssage> respuesta = usuariosServiceImpl.eliminarUsuario(request);
		assertEquals(respuesta.getBody().getClass(), ResponseMenssage.class);

	}

	/***
	 * 
	 * 
	 * Filtros por rango de fecha
	 * 
	 */

	@Test
	void testFiltros() {

		List<UsuarioModel> usuario = new ArrayList<>();
		FiltrosDto request = new FiltrosDto();
		List<FiltroDetalle> ListFiltroDetalle = new ArrayList<>();

		usuario.add(UsuarioModel.builder().usuarioId(1).primerNombre("Julian").segundoNombre("Alexander")
				.primerApellido("Osma").segundoApellido("Ariza").tipoIdentificacion("CC").numeroIdentificacion("123456")
				.celular("654321").direccion("Calle85").correo("@nntdata")
				.fechaIngreso(LocalDate.parse("2018-10-30"))
				.fechaCreacion(LocalDateTime.parse("2022-05-18T00:00:00"))
				.fechaModificacion(LocalDateTime.parse("2022-05-18T00:00:00"))				
				.build());
		
		ListFiltroDetalle.add(FiltroDetalle.builder().parametro("fechaInicioRangoIngreso").valor("2018-10-30").build());
		ListFiltroDetalle.add(FiltroDetalle.builder().parametro("fechaFinRangoIngreso").valor("2020-10-30").build());
		request.setFiltros(ListFiltroDetalle);

		LocalDate fechaInicioRangoIngreso = LocalDate.parse("2018-10-30");
		LocalDate fechaFinRangoIngreso = LocalDate.parse("2022-05-10");

		Mockito.when(usuarioRepository.consultaUsuarios(fechaInicioRangoIngreso, fechaFinRangoIngreso))
				.thenReturn(usuario);
		ResponseEntity<Object> respuesta = usuariosServiceImpl.consultafiltros(request);
		assertEquals(respuesta.getBody().getClass(), RequestResponseDto.class);

	}

	
	@Test
	void testFiltros3() {

		List<UsuarioModel> usuario = new ArrayList<>();
		FiltrosDto request = new FiltrosDto();
		List<FiltroDetalle> ListFiltroDetalle = new ArrayList<>();

		usuario.add(UsuarioModel.builder().usuarioId(1).primerNombre("Julian").segundoNombre("Alexander")
				.primerApellido("Osma").segundoApellido("Ariza").tipoIdentificacion("CC").numeroIdentificacion("123456")
				.celular("654321").direccion("Calle85").correo("@nntdata")
				.fechaCreacion(LocalDateTime.parse("2022-05-18T00:00:00")).fechaIngreso(LocalDate.parse("2018-10-30"))
				.build());
		
		ListFiltroDetalle.add(FiltroDetalle.builder().parametro("fechaInicioRangoIngreso").valor(null).build());
		ListFiltroDetalle.add(FiltroDetalle.builder().parametro("fechaFinRangoIngreso").valor(null).build());
		request.setFiltros(ListFiltroDetalle);

		LocalDate fechaInicioRangoIngreso = LocalDate.parse("2018-10-30");
		LocalDate fechaFinRangoIngreso = LocalDate.parse("2022-05-10");

		Mockito.when(usuarioRepository.consultaUsuarios(fechaInicioRangoIngreso, fechaFinRangoIngreso))
				.thenReturn(usuario);
		ResponseEntity<Object> respuesta = usuariosServiceImpl.consultafiltros(request);
		assertEquals(respuesta.getBody().getClass(), RequestResponseDto.class);
				

	}
		
	
	@Test
	void testFiltros2() {

		List<UsuarioModel> usuario = new ArrayList<>();
		FiltrosDto request = new FiltrosDto();
		List<FiltroDetalle> ListFiltroDetalle = new ArrayList<>();

		usuario.add(UsuarioModel.builder().usuarioId(1).primerNombre("Julian").segundoNombre("Alexander")
				.primerApellido("Osma").segundoApellido("Ariza").tipoIdentificacion("CC").numeroIdentificacion("123456")
				.celular("654321").direccion("Calle85").correo("@nntdata")
				.fechaCreacion(LocalDateTime.parse("2022-05-18T00:00:00")).fechaIngreso(LocalDate.parse("2018-10-30"))
				.build());

		LocalDate fechaInicioRangoIngreso = LocalDate.parse("2018-10-30");
		LocalDate fechaFinRangoIngreso = LocalDate.parse("2022-05-10");

		Mockito.when(usuarioRepository.consultaUsuarios(fechaInicioRangoIngreso, fechaFinRangoIngreso))
				.thenReturn(usuario);
		ResponseEntity<Object> respuesta = usuariosServiceImpl.consultafiltros(request);
		assertThatExceptionOfType(BadRequest.class);

	}
}
