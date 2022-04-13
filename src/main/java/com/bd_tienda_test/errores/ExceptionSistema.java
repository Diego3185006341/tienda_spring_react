package com.bd_tienda_test.errores;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ExceptionSistema {
	
	
	private String codigo ;
	private String description;

}
