package com.bd_tienda_test.Service;

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
			
				
			}
			else {
				System.out.println("error");
			}
			
			
			
		} catch (Exception e) {
			
		}
		return ResponseEntity.ok().body(request);
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
		return ResponseEntity.ok().body(request);
	}

	@Override
	public UsuarioModel consultarusuario(String Cedula,RequestConsultar request) {
		Optional<UsuarioModel> u=usuariodb.findById(Cedula);
		try {
			
		
		
		
	} catch (Exception e) {
		System.out.println("error");
	}
		return u.get();
		
	}

}


	/*public ResponseEntity<Object> consultarusuario(RequestConsultar request) {
		
		try {
			
			String cedula_usuario=null;
			String nombre_usuario=null;
			
			for(Filtros filtros :request.getFiltros()) {
				if(filtros.getValor()!=null && !filtros.getValor().isEmpty()) {
					
					switch(filtros.getParametro()) {
					case "cedula_usuario":
						cedula_usuario=filtros.getValor();
						break;
					case "nombre_usuario":
						nombre_usuario=filtros.getValor();
					default:
						break;
					
					}
					
				}
				
				
			}
		Pageable pagination=crearPaginador(request);
		Page<UsuarioModel>UsuarioConsultar=usuarioR.Consultarbd(cedula_usuario,nombre_usuario,pagination);
			if()
		
		return ResponseEntity.ok(ResponseUsuario.builder().contenido(UsuarioConsultar.getContent()).build());
				
	} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ExceptionSistema.builder().codigo(UsuariosConstantes.CODIGO_ERROR_SERVICE)
				.description(UsuariosConstantes.ERROR_SERVICE_Errorparcero).build());
	}
		
		
	}

	private Pageable crearPaginador(RequestConsultar request) {
		Integer maximoPaginador=0;
		Integer numeroPagina=0;
		if(UsuariosConstantes.TIPO_CONSULTA.equalsIgnoreCase(request.getNumeroPagina())) {
			maximoPaginador=Integer.MAX_VALUE;
		}
		else {
			Integer pagina=Integer.parseInt(request.getNumeroPagina());
			numeroPagina=(pagina > 0)? pagina-1:pagina;
			maximoPaginador=Integer.parseInt(request.getNumeroRegistros());
		}
		if(UsuariosConstantes.PARAMETRO_ORDENAMIENTO.equalsIgnoreCase(request.getOrden())) {
			return PageRequest.of(numeroPagina, maximoPaginador,
					Sort.by(request.getParametroOrdenamiento()).ascending());
		}
		return PageRequest.of(numeroPagina, maximoPaginador,
				Sort.by(request.getParametroOrdenamiento()).descending());
	}

	

	

	

		
}
*/