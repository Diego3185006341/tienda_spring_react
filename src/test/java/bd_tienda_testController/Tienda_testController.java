package bd_tienda_testController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.bd_tienda_test.Controlador.UsuarioControlador;
import com.bd_tienda_test.Interfaces.Service.IUsuarioService;
import com.bd_tienda_test.Model.UsuarioModel;
import com.bd_tienda_test.dto.RequestConsultar;
import com.bd_tienda_test.dto.RequestResponseAgregar;
import com.bd_tienda_test.dto.ResponseUsuario;

import lombok.Data;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Data
public class Tienda_testController {
	
	@Mock
	IUsuarioService service;
	@Mock
	ResponseEntity<UsuarioModel> usuariom;


	@InjectMocks
	UsuarioControlador controller;
	
	@BeforeEach
	public void setUp()throws Exception {
		MockitoAnnotations.initMocks(this);
			
	}
	@Test
	void agregarUsuarios(){
	RequestResponseAgregar request = new RequestResponseAgregar();
	Mockito.when(service.agregarUsuario(request)).thenReturn(ResponseEntity.ok().body(RequestResponseAgregar.builder().build()));
	ResponseEntity<Object>respuesta=controller.AgregarUsuario(request);
	assertEquals(respuesta.getBody().getClass(),RequestResponseAgregar.class);
	}
	@Test
	void modificarUsuario(){
	RequestResponseAgregar request = new RequestResponseAgregar();
	String Cedula="01233";
	Mockito.when(service.modificarUsuario(request,Cedula)).thenReturn(ResponseEntity.ok().body(RequestResponseAgregar.builder().build()));
	ResponseEntity<Object>respuesta=controller.modificarUsuario(request,Cedula);
	assertEquals(respuesta.getBody().getClass(),RequestResponseAgregar.class);
	}
	@Test
	void consultarUsuario(){
	RequestConsultar request = new RequestConsultar();
	String Cedula="00001";
	Mockito.when(service.consultarusuario(Cedula,request)).thenReturn(usuariom);
	ResponseEntity<UsuarioModel> respuesta=controller.consultarUsuarioPorCedula(Cedula,request);
	assertEquals(respuesta.getClass(),respuesta.getClass());
	}
	}
	
	
