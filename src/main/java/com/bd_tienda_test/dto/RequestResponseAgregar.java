package com.bd_tienda_test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class RequestResponseAgregar {
	private String cedula_Usuario;
	private String nombre_Usuario;
	private String correo_Usuario;
	private String usuario;
	private String clave_Usuario;

}
