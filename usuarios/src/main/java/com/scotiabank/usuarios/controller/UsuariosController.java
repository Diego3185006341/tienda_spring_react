package com.scotiabank.usuarios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scotiabank.usuarios.dto.FiltrosDto;
import com.scotiabank.usuarios.dto.RequesDto;
import com.scotiabank.usuarios.dto.RequestResponseDto;
import com.scotiabank.usuarios.dto.ResponseMenssage;
import com.scotiabank.usuarios.service.UsuarioService;

/**
 * 
 * Clase encargada de las peticiones rest
 * @author julian Alexander Osma -nttdata
 * @version 1.0
 * @date 17/05/2022
 * 
 */

@RestController
@RequestMapping("/v1/users")
public class UsuariosController {
	
	@Autowired 
	UsuarioService usuarioService;
	
	/**
	 * 
	 * Metodo encargado de consultar por Id del usuario
	 * @param request
	 * @return
	 * 
	 */
	@GetMapping("/consultaUsuario")
	public  ResponseEntity<RequestResponseDto> consulta (@RequestBody RequesDto request ) {
		return usuarioService.consultaUsuario(request);
		
	}
	
	
	/**
	 * 
	 * Metodo encargado de consultar todos los usuarios
	 * @param request
	 * @return
	 */
	@GetMapping("/consultaDeUsuarios")
	public  ResponseEntity<Object>  consultausuarios (){
		
		return usuarioService.consultaUsuarios();
		
	}
	
	
	
	/**
	 * 
	 * Metodo encargado de agregar usuarios
	 * @param request
	 * @return
	 */
	@PutMapping("/agregarUsuarios")
	public  ResponseEntity<ResponseMenssage> agregarUsuarios (@RequestBody RequestResponseDto request ) {
		return usuarioService.agregarUsuarios(request);
		
	}
	
	
	/**
	 * 
	 * Metodo encargado de modificar usuarios
	 * @param request
	 * @return
	 */
	@PostMapping("/modificarUsuario")
	public  ResponseEntity<ResponseMenssage> modificarUsuario (@RequestBody RequestResponseDto request ) {
		return usuarioService.modificarUsuario(request);
		
	}
	
	
	/**
	 * 
	 * Metodo encargado de modificar usuarios
	 * @param request
	 * @return
	 */
	@DeleteMapping("/eliminarUsuario")
	public  ResponseEntity<ResponseMenssage> eliminarUsuario (@RequestBody RequesDto request ) {
		return usuarioService.eliminarUsuario(request);
		
	}
	
	
	/**
	 * 
	 * Metodo encargado de modificar usuarios
	 * @param request
	 * @return
	 */
	@PostMapping("/filtros")
	public  ResponseEntity<Object> consultafiltros (@RequestBody FiltrosDto request ) {
		return usuarioService.consultafiltros(request);
		
	}
	
}
