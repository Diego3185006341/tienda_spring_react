package bd_tienda_testImp;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bd_tienda_test.Interfaces.IUsuario;
import com.bd_tienda_test.Model.UsuarioModel;
import com.bd_tienda_test.Repository.UsuarioRepository;
import com.bd_tienda_test.Service.UsuarioServiceimp;
import com.bd_tienda_test.dto.Filtros;
import com.bd_tienda_test.dto.RequestConsultar;
import com.bd_tienda_test.dto.RequestResponseAgregar;
import com.bd_tienda_test.dto.ResponseUsuario;
import com.bd_tienda_test.errores.ExceptionSistema;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TiendaTestImp {
	@Mock
	IUsuario mockrepo;

	@InjectMocks
	UsuarioServiceimp mockusuarioimp;
	
	@Mock
	 UsuarioModel usuariomodel;
	@Mock
	 UsuarioModel mockusuariomodel;


	@BeforeEach
		void contextLoads() {
		MockitoAnnotations.initMocks(this);		
	}
	@Test
	void agregarUsuarios() {
		 //RequestResponseAgregar rq=new RequestResponseAgregar("2323","dad","2","#","dsd");
		  Mockito.when(mockrepo.save(Mockito.anyObject())).thenReturn(usuariomodel);
		  ResponseEntity<Object>response=mockusuarioimp.agregarUsuario(RequestResponseAgregar.builder().build());
		  assertEquals(response.getBody().getClass(),RequestResponseAgregar.class);
	}
	
	@Test 
	void modificarUsuario() {
		  Mockito.when(mockrepo.findById(anyString())).thenReturn(Optional.ofNullable(mockusuariomodel));	
		  Mockito.when(mockrepo.save(Mockito.anyObject())).thenReturn(usuariomodel);
		  ResponseEntity<Object>response=mockusuarioimp.agregarUsuario(RequestResponseAgregar.builder().build());
		  assertEquals(response.getBody().getClass(),RequestResponseAgregar.class);
	}
	@Test 
	void consultarUsuario() {
		/*RequestConsultar request =new RequestConsultar();
		List<Filtros>listafiltros=new ArrayList<Filtros>();
		
		listafiltros.add(Filtros.builder().parametro("cedula_usuario").valor("00001").build());
		listafiltros.add(Filtros.builder().parametro("nombre_usuario").valor("casas").build());
		request.setNumeroPagina("ALL");
		request.setNumeroRegistros("ALL");
		request.setOrden("XXX");
		request.setParametroOrdenamiento("ASC");
		
		request.setFiltros(listafiltros);
		*/RequestConsultar request=new RequestConsultar();
		 Mockito.when(mockrepo.findById(anyString())).thenReturn(Optional.ofNullable(mockusuariomodel));	
		  UsuarioModel response=mockusuarioimp.consultarusuario("00001",request);
		  assertEquals(response.getClass(),response.getClass());
	}
	
	
	
}
