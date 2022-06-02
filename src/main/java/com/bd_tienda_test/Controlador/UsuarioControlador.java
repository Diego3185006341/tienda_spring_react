package com.bd_tienda_test.Controlador;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bd_tienda_test.Interfaces.Service.IUsuarioService;
import com.bd_tienda_test.Model.UsuarioModel;
import com.bd_tienda_test.dto.FiltrosDto;
import com.bd_tienda_test.dto.RequestConsultar;
import com.bd_tienda_test.dto.RequestResponseAgregar;
import com.bd_tienda_test.dto.ResponseUsuario;





@CrossOrigin(origins = "*")
@RestController
//@RequestMapping
@RequestMapping("/api")
public class UsuarioControlador {

	@Autowired
	private IUsuarioService serviceUsuario;

	@PostMapping("/validar")
	public boolean validar(@RequestBody UsuarioModel p) {
		boolean valido = serviceUsuario.validarUsuario(p.getUsuario(), p.getClave_Usuario());
		if (valido) {
			return true;
		} else {
						
			return false;
			
		}

	}	

	
	@GetMapping("/listarUsuario")
	public ResponseEntity<List<UsuarioModel>> listarUsuario()
	{
		return serviceUsuario.listarUsuarios();
	}
	
		
	/*@PostMapping("/saveUsuario")
	public boolean saveUsuario (@RequestBody UsuarioModel u) {
		serviceUsuario.saveUsuario(u);
		return true;
	}*/	
	
	//@GetMapping("/newUsuario")
	//public String agregarUsuario (Model model) {
	//	model.addAttribute("usuario", new UsuarioModel());
	//	return "formUsuarios.html";
	//}
	
	@GetMapping ("/Usuario/{Cedula}")
	public UsuarioModel obtenerUsuarioPorCedula (@PathVariable String Cedula)
	{
		Optional <UsuarioModel> usuario =serviceUsuario.listarIdUsuario(Cedula);
		return usuario.get();
	}
	
	/*@PutMapping("/updateUsuario/{Cedula}")
	public boolean actualizarUsuarioPorCedula(@PathVariable String Cedula, UsuarioModel u) {
		Optional<UsuarioModel>usuario=serviceUsuario.listarIdUsuario(Cedula);
		if(usuario.isPresent()) {
			serviceUsuario.update(u);
		return true;
		}else {
			return false;
		}
	}
	*/
	
	/*@DeleteMapping ("eliminarUsuario/{Cedula}")
	public ResponseEntity<ResponseUsuario> deleteUsuario (@RequestBody RequestResponseAgregar request)
	{
		return serviceUsuario.deleteUsuario(request);
		
	}*/
	@DeleteMapping ("eliminarUsuario/{Cedula}")
	public ResponseEntity<ResponseUsuario> deleteUsuario (@PathVariable String Cedula)
	{
		return serviceUsuario.deleteUsuario(Cedula);
		
	}
	@PostMapping("/agregarUsuario")
	public ResponseEntity<Object> AgregarUsuario (@RequestBody RequestResponseAgregar request) {
		
		return serviceUsuario.agregarUsuario(request);
	}	

	@PostMapping("/modificarUsuario")
	public ResponseEntity<Object> modificarUsuario (@RequestBody RequestResponseAgregar request) {
		
		return serviceUsuario.modificarUsuario(request );
	}
	

	@GetMapping ("/consultarUsuario/{Cedula}")
	public ResponseEntity<RequestResponseAgregar> consultarUsuarioPorCedula (@PathVariable String Cedula,RequestResponseAgregar request)
	{
		return  serviceUsuario.consultarusuario(Cedula,request);
	}
	
	@PostMapping("/filtros")
	public  ResponseEntity<Object> consultafiltros (@RequestBody FiltrosDto request ) {
		return serviceUsuario.consultafiltros(request);
		
	}
}
