package com.scotiabank.usuarios.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestResponseDto {
	
	private Integer usuarioId;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String tipoIdentificacion;
	private String numeroIdentificacion;
	private String celular;
	private String direccion;
	private String correo;
	private LocalDate fechaIngreso;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaModificacion;
	

}
