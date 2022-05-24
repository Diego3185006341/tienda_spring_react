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
	public ResponseEntity<List<UsuarioModel>> listarUsuarios();
	public Optional<UsuarioModel> listarIdUsuario(String Cedula);
	public int saveUsuario (UsuarioModel u);	
	public int update(UsuarioModel u);
	public ResponseEntity<Object> deleteUsuario (String cedula);
	public ResponseEntity<Object> agregarUsuario(RequestResponseAgregar request);
	public ResponseEntity<Object> modificarUsuario(RequestResponseAgregar request,String Cedula);
	public ResponseEntity<RequestResponseAgregar> consultarusuario(String Cedula,RequestResponseAgregar request);
	
}
