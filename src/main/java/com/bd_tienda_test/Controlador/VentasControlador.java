package com.bd_tienda_test.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bd_tienda_test.Interfaces.Service.IFacturaService;
import com.bd_tienda_test.Model.FacturaModel;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping
public class VentasControlador {

	
	@Autowired
	private IFacturaService serviceFactura;
	
	
	//@GetMapping("/mostrarFormVentas")
	//public String mostarFormVentas(Model model) {
	//	model.addAttribute("usuarios",serviceUsuario.listarUsuarios());
	//	model.addAttribute("clientes",serviceCliente.listarClientes());
	//	model.addAttribute("productos",serviceProducto.listarProductos());
	//	return "ventas2.html";
	//}
	
	@PostMapping("/saveFactura")
	public boolean saveFactura (@RequestBody FacturaModel f) {
		serviceFactura.saveFactura(f);
		return true;
	}
	
	
	
	
}
