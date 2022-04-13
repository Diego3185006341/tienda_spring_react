package com.bd_tienda_test.Interfaces.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bd_tienda_test.Model.UsuarioModel;
import com.bd_tienda_test.dto.RequestConsultar;
import com.bd_tienda_test.dto.RequestResponseAgregar;

public interface IUsuarioService {

	public boolean validarUsuario(String Usuario, String Clave);
	public List<UsuarioModel> listarUsuarios();
	public Optional<UsuarioModel> listarIdUsuario(String Cedula);
	public int saveUsuario (UsuarioModel u);	
	public int update(UsuarioModel u);
	public void deleteUsuario (String cedula);
	public ResponseEntity<Object> agregarUsuario(RequestResponseAgregar request);
	public ResponseEntity<Object> modificarUsuario(RequestResponseAgregar request);
	public UsuarioModel consultarusuario(String Cedula,RequestConsultar request);
	
}
