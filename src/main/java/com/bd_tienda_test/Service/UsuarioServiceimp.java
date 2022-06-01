package com.bd_tienda_test.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bd_tienda_test.Controlador.UsuarioControlador;
import com.bd_tienda_test.Interfaces.IUsuario;
import com.bd_tienda_test.Interfaces.Service.IUsuarioService;
import com.bd_tienda_test.Model.UsuarioModel;
import com.bd_tienda_test.Repository.UsuarioRepository;
import com.bd_tienda_test.dto.Filtros;
import com.bd_tienda_test.dto.RequestConsultar;
import com.bd_tienda_test.dto.RequestResponseAgregar;
import com.bd_tienda_test.dto.ResponseUsuario;
import com.bd_tienda_test.errores.ExceptionSistema;
import com.bd_tienda_test.itils.UsuariosConstantes;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;



@Service
@Slf4j
public class UsuarioServiceimp implements IUsuarioService {

	@Autowired
	private IUsuario usuariodb;
	@Autowired
	private UsuarioRepository usuarioR;
	
	@Override
	public boolean validarUsuario(String Usuario, String Clave) {
		UsuarioModel usuario= usuariodb.findByUsuarioAndPassword(Usuario, Clave);
		return usuario!=null;
	}

	@Override
	public ResponseEntity<List<UsuarioModel>> listarUsuarios() {
		
		try {
			List<UsuarioModel>usuario=new ArrayList<UsuarioModel>();
			
			usuariodb.findAll().forEach(usuario ::add);
			return new ResponseEntity<>(usuario,HttpStatus.OK); 
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	/*/@Override
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
*/  
	@Override
	public ResponseEntity<ResponseUsuario> deleteUsuario (String Cedula) {
		/*try {
			ResponseUsuario response=new ResponseUsuario();
			Optional<UsuarioModel> consulta = 
					usuariodb.findById(request.getCedula_Usuario());
			
			if(consulta.isPresent()) {
				usuariodb.deleteById(consulta.get().getCedula_Usuario());
				response.setMessage("se elimino usuario");
				
				
			}else {
				
				
				response.setMessage("no se encontro usuario");
			}
			return ResponseEntity.ok(response);	
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
			}
		*/
		try {
			ResponseUsuario response=new ResponseUsuario();
			usuariodb.deleteById(Cedula);
			response.setMessage("se elimino usuario");
			return new ResponseEntity<>(response,HttpStatus.OK);
			
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);		
			}
		
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
				
			if(u.isPresent()) {
				
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
			}else {
			usuariodb.save(UsuarioModel.builder().cedula_Usuario(request.getCedula_Usuario()).nombre_Usuario(request.getNombre_Usuario())
					.correo_Usuario(request.getCorreo_Usuario()).usuario(request.getUsuario()).clave_Usuario(request.getClave_Usuario()).build());
					
			return new ResponseEntity<>(request,HttpStatus.CREATED);
			
			
			}	
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@Override
	public ResponseEntity<Object> modificarUsuario(RequestResponseAgregar request) {
		try {
			Optional<UsuarioModel>u=usuariodb.findById(request.getCedula_Usuario());
				
			if(u.isEmpty()) {
				
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
			}else {
				UsuarioModel usuario=u.get();
				usuario.setCedula_Usuario(request.getCedula_Usuario());
				usuario.setClave_Usuario(request.getClave_Usuario());
				usuario.setCorreo_Usuario(request.getCorreo_Usuario());
				usuario.setNombre_Usuario(request.getNombre_Usuario());
				usuario.setUsuario(request.getUsuario());
					
			return new ResponseEntity<>(usuariodb.save(usuario),HttpStatus.OK);
			
			
			}	
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	/*public UsuarioModel consultarusuario(String Cedula,RequestConsultar request) {
		Optional<UsuarioModel> u=usuariodb.findById(Cedula);
		try {
			
		
		
		
	} catch (Exception e) {
		System.out.println("error");
	}
		return u.get();
		
	}

}
*/

	public ResponseEntity<RequestResponseAgregar> consultarusuario(String Cedula,RequestResponseAgregar request) {
		
	   try {
		   Optional<UsuarioModel>u=usuariodb.findById(Cedula);
			
			if(u.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				
			}
			else {
				UsuarioModel consulta=u.get();
				RequestResponseAgregar respuesta=new RequestResponseAgregar();
				respuesta.setCedula_Usuario(consulta.getCedula_Usuario());
				respuesta.setClave_Usuario(consulta.getClave_Usuario());
				respuesta.setCorreo_Usuario(consulta.getCorreo_Usuario());
				respuesta.setNombre_Usuario(consulta.getNombre_Usuario());
				respuesta.setUsuario(consulta.getUsuario());
				return new ResponseEntity<>(respuesta,HttpStatus.OK);
			}
		
	} catch (Exception e) {
		return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
		
		
	 
		
}

	@Override
	public Optional<UsuarioModel> listarIdUsuario(String Cedula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveUsuario(UsuarioModel u) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}