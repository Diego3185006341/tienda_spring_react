package com.bd_tienda_test.dto;

import java.util.List;

import com.bd_tienda_test.Model.UsuarioModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ResponseUsuario {

	List<UsuarioModel>contenido;
}
