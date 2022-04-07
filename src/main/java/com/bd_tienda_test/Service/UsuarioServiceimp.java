package com.bd_tienda_test.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bd_tienda_test.Interfaces.IUsuario;
import com.bd_tienda_test.Interfaces.Service.IUsuarioService;
import com.bd_tienda_test.Model.UsuarioModel;
import com.bd_tienda_test.dto.RequestResponseAgregar;
import com.bd_tienda_test.dto.ResponseUsuario;

import lombok.Builder;



@Service
public class UsuarioServiceimp implements IUsuarioService {

	@Autowired
	private IUsuario usuariodb;
	
	@Override
	public boolean validarUsuario(String Usuario, String Clave) {
		UsuarioModel usuario= usuariodb.findByUsuarioAndPassword(Usuario, Clave);
		return usuario!=null;
	}

	@Override
	public List<UsuarioModel> listarUsuarios() {
		return (List<UsuarioModel>)usuariodb.findAll();
	}

	@Override
	public Optional<UsuarioModel> listarIdUsuario(String Cedula) {		
		return usuariodb.findById(Cedula);
	}

	@Override
	public int saveUsuario (UsuarioModel u) {
		// TODO Auto-generated method stub
		int res =0;
		UsuarioModel usuario = usuariodb.save(u);
		if(!usuario.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void deleteUsuario (String cedula) {
		usuariodb.deleteById(cedula);
		
	}

	@Override
	public int update(UsuarioModel u) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ResponseEntity<Object> agregarUsuario(RequestResponseAgregar request) {
		try {
			Optional<UsuarioModel>u=usuariodb.findById(request.getCedula_Usuario());
				
			if(u.isEmpty()) {
				
				usuariodb.save(UsuarioModel.builder().cedula_Usuario(request.getCedula_Usuario()).nombre_Usuario(request.getNombre_Usuario())
				.correo_Usuario(request.getCorreo_Usuario()).usuario(request.getUsuario()).clave_Usuario(request.getClave_Usuario()).build());
				return ResponseEntity.ok().body(request);
				
			}
			else {
				System.out.println("error");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public ResponseEntity<Object> modificarUsuario(RequestResponseAgregar request) {
		try {
			Optional<UsuarioModel>u=usuariodb.findById(request.getCedula_Usuario());
			if(u.isPresent()) {
			
			usuariodb.save(UsuarioModel.builder().cedula_Usuario(request.getCedula_Usuario()).nombre_Usuario(request.getNombre_Usuario())
			.correo_Usuario(request.getCorreo_Usuario()).usuario(request.getUsuario()).clave_Usuario(request.getClave_Usuario()).build());
			return ResponseEntity.ok().body(request);
			
			}
		
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
		return null;
	}

	@Override
	public UsuarioModel consultarusuario(String Cedula) {
		try {
			
			Optional<UsuarioModel>u=usuariodb.findById(Cedula);
			if(u.isPresent()) {
				
			
			return u.get();
			
			}
		
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
		return null;
	}




	

	//@Override
	/*public ResponseEntity<Object> update(UsuarioModel u) {
		try {
			Optional <UsuarioModel> usuario =usuariodb.findById(u.getCedula_Usuario());
			if(usuario.isPresent()) {
				usuariodb.save(UsuarioModel.builder().cedula_Usuario(u.getCedula_Usuario()).nombre_Usuario(u.getNombre_Usuario()).correo_Usuario(u.getCorreo_Usuario()).clave_Usuario(u.getClave_Usuario()).usuario(u.getUsuario()).build());
				
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return ResponseEntity.ok().body(u);
		 
	}*/

	

		
}
