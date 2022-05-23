package com.scotiabank.usuarios.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.scotiabank.usuarios.dto.FiltrosDto;
import com.scotiabank.usuarios.dto.FiltroDetalle;
import com.scotiabank.usuarios.dto.RequesDto;
import com.scotiabank.usuarios.dto.RequestResponseDto;
import com.scotiabank.usuarios.dto.ResponseMenssage;
import com.scotiabank.usuarios.model.UsuarioModel;
import com.scotiabank.usuarios.repository.UsuarioRepository;
import com.scotiabank.usuarios.service.UsuarioService;

@Service
public class UsuariosServiceImpl implements UsuarioService {

	@Autowired
	UsuarioRepository repositoryUsuario;

	@Override
	public ResponseEntity<RequestResponseDto> consultaUsuario(RequesDto request) {

		try {

			RequestResponseDto respuesta = new RequestResponseDto();
			Optional<UsuarioModel> consultaData = repositoryUsuario
					.findByNumeroIdentificacion(request.getNumeroIdentificacion());
			if (consultaData.isPresent()) {
				UsuarioModel consulta = consultaData.get();
				respuesta.setUsuarioId(consulta.getUsuarioId());
				respuesta.setPrimerNombre(consulta.getPrimerNombre());
				respuesta.setSegundoNombre(consulta.getSegundoNombre());
				respuesta.setSegundoApellido(consulta.getSegundoApellido());
				respuesta.setTipoIdentificacion(consulta.getTipoIdentificacion());
				respuesta.setNumeroIdentificacion(consulta.getNumeroIdentificacion());
				respuesta.setPrimerApellido(consulta.getPrimerApellido());
				respuesta.setCelular(consulta.getCelular());
				respuesta.setDireccion(consulta.getDireccion());
				respuesta.setCorreo(consulta.getCorreo());
				respuesta.setFechaIngreso(consulta.getFechaIngreso());
				respuesta.setFechaCreacion(consulta.getFechaCreacion());
				respuesta.setFechaModificacion(consulta.getFechaModificacion());

			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return ResponseEntity.ok(respuesta);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<Object> consultaUsuarios() {
		try {

			List<RequestResponseDto> respuesta = new ArrayList<>();
			repositoryUsuario.findAll().forEach(value -> respuesta.add(RequestResponseDto.builder()
					.usuarioId(value.getUsuarioId()).primerNombre(value.getPrimerNombre())
					.segundoNombre(value.getSegundoNombre()).primerApellido(value.getPrimerApellido())
					.segundoApellido(value.getSegundoApellido()).tipoIdentificacion(value.getTipoIdentificacion())
					.numeroIdentificacion(value.getNumeroIdentificacion()).celular(value.getCelular())
					.direccion(value.getDireccion()).correo(value.getCorreo()).fechaIngreso(value.getFechaIngreso())
					.fechaCreacion(value.getFechaCreacion()).fechaModificacion(value.getFechaModificacion()).build()));
			return ResponseEntity.ok(respuesta);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ResponseMenssage> agregarUsuarios(RequestResponseDto request) {

		try {

			ResponseMenssage respuesta = new ResponseMenssage();
			UsuarioModel registro = new UsuarioModel();

			Optional<UsuarioModel> consulta = repositoryUsuario
					.findByNumeroIdentificacion(request.getNumeroIdentificacion());
			if (consulta.isEmpty()) {
				registro.setPrimerNombre(request.getPrimerNombre());
				registro.setSegundoNombre(request.getSegundoNombre());
				registro.setPrimerApellido(request.getPrimerApellido());
				registro.setSegundoApellido(request.getSegundoApellido());
				registro.setTipoIdentificacion(request.getTipoIdentificacion());
				registro.setNumeroIdentificacion(request.getNumeroIdentificacion());
				registro.setCelular(request.getCelular());
				registro.setDireccion(request.getDireccion());
				registro.setCorreo(request.getCorreo());
				registro.setFechaIngreso(request.getFechaIngreso());
				registro.setFechaCreacion(LocalDateTime.now());

				UsuarioModel id = repositoryUsuario.save(registro);

				respuesta.setMessage("Usuario agregado, IdUsuario: " + id.getUsuarioId() + " usuario:"
						+ id.getPrimerNombre() + " " + id.getPrimerApellido());

			} else {
				respuesta.setMessage("el usuario con numero de idenrificacion:" + request.getNumeroIdentificacion()
						+ " ya se encuentra registrado ");
			}
			return ResponseEntity.ok(respuesta);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<ResponseMenssage> modificarUsuario(RequestResponseDto request) {

		try {

			UsuarioModel modificar = new UsuarioModel();
			ResponseMenssage response = new ResponseMenssage();

			Optional<UsuarioModel> consulta = repositoryUsuario
					.findByNumeroIdentificacion(request.getNumeroIdentificacion());
			if (consulta.isPresent()) {

				modificar.setUsuarioId(consulta.get().getUsuarioId());
				modificar.setPrimerNombre(request.getPrimerNombre());
				modificar.setSegundoNombre(request.getSegundoNombre());
				modificar.setPrimerApellido(request.getPrimerApellido());
				modificar.setSegundoApellido(request.getSegundoApellido());
				modificar.setTipoIdentificacion(request.getTipoIdentificacion());
				modificar.setNumeroIdentificacion(request.getNumeroIdentificacion());
				modificar.setCelular(request.getCelular());
				modificar.setDireccion(request.getDireccion());
				modificar.setCorreo(request.getCorreo());
				modificar.setFechaIngreso(request.getFechaIngreso());
				modificar.setFechaCreacion(consulta.get().getFechaCreacion());
				modificar.setFechaModificacion(LocalDateTime.now());

				repositoryUsuario.save(modificar);

				response.setMessage("Usuario modificado");

			} else {
				response.setMessage("Id usuario no encontrado");
			}

			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override
	public ResponseEntity<ResponseMenssage> eliminarUsuario(RequesDto request) {

		try {

			ResponseMenssage response = new ResponseMenssage();
			Optional<UsuarioModel> consulta = repositoryUsuario
					.findByNumeroIdentificacion(request.getNumeroIdentificacion());
			if (consulta.isPresent()) {

				repositoryUsuario.deleteById(consulta.get().getUsuarioId());
				response.setMessage("Usuario eliminado");
			} else {
				response.setMessage("Usuario identificado con numero : " + request.getNumeroIdentificacion()
						+ ", No se encontrado");
			}

			return ResponseEntity.ok(response);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<Object> consultafiltros(FiltrosDto request) {
		try {

			LocalDate fechaInicioRangoIngreso = null;
			LocalDate fechaFinRangoIngreso = null;
			if (request.getFiltros() == null || request.getFiltros().isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			} else {
				Map<String, String> obtenerFiltros = filtrosUsuario(request.getFiltros());

				fechaInicioRangoIngreso = obtenerFiltros.get("fechaInicioRangoIngreso") != null
						? LocalDate.parse(obtenerFiltros.get("fechaInicioRangoIngreso"))
						: null;
				fechaFinRangoIngreso = obtenerFiltros.get("fechaFinRangoIngreso") != null
						? LocalDate.parse(obtenerFiltros.get("fechaFinRangoIngreso"))
						: null;
			}

			List<UsuarioModel> consultaData = repositoryUsuario.consultaUsuarios(fechaInicioRangoIngreso,
					fechaFinRangoIngreso);
			List<RequestResponseDto> respuesta = new ArrayList<>();
			consultaData.forEach(value -> respuesta.add(RequestResponseDto.builder().usuarioId(value.getUsuarioId())
					.primerNombre(value.getPrimerNombre()).segundoNombre(value.getSegundoNombre())
					.primerApellido(value.getPrimerApellido()).segundoApellido(value.getSegundoApellido())
					.tipoIdentificacion(value.getTipoIdentificacion())
					.numeroIdentificacion(value.getNumeroIdentificacion()).celular(value.getCelular())
					.direccion(value.getDireccion()).correo(value.getCorreo()).fechaIngreso(value.getFechaIngreso())
					.fechaCreacion(value.getFechaCreacion()).fechaModificacion(value.getFechaModificacion()).build()));

			return ResponseEntity.ok(respuesta);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	private Map<String, String> filtrosUsuario(List<FiltroDetalle> filtros) {
		Map<String, String> returnFiltros = new HashMap<>();

		for (FiltroDetalle filtro : filtros) {
			returnFiltros.put(filtro.getParametro(), filtro.getValor());
		}

		return returnFiltros;
	}

}
