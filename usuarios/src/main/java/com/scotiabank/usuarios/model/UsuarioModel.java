package com.scotiabank.usuarios.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USUARIOS")
public class UsuarioModel {
	

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "USUARIO_ID", unique = true)
	private Integer usuarioId;
	
	
	@Column(name = "PRIMER_NOMBRE")
	private String primerNombre;
	
	@Column(name = "SEGUNDO_NOMBRE")
	private String segundoNombre;
				
	@Column(name = "PRIMER_APELLIDO")
	private String primerApellido;
	
	@Column(name = "SEGUND_APELLIDO")
	private String segundoApellido;
	
	@Column(name = "TIPO_IDENTIFICACION")
	private String tipoIdentificacion;
	
	@Column(name = "NUMERO_IDENTIFICACION")
	private String numeroIdentificacion;
		
	@Column(name = "CELULAR")
	private String celular;
	
	@Column(name = "DIRECCION")
	private String direccion;
	
	@Column(name = "CORREO")
	private String correo;
	
	@Column(name = "FECHA_INGRESO")
	private LocalDate fechaIngreso;
	
	@Column(name = "FECHA_CREACION")
	private LocalDateTime fechaCreacion;	
	
	@Column(name = "FECHA_MODIFICACION ")
	private LocalDateTime fechaModificacion;

	
	
	

}
