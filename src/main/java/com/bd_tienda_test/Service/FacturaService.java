package com.bd_tienda_test.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd_tienda_test.Interfaces.IFactura;
import com.bd_tienda_test.Interfaces.Service.IFacturaService;
import com.bd_tienda_test.Model.FacturaModel;



@Service
public class FacturaService implements IFacturaService {

	@Autowired
	private IFactura facturadb;

	@Override
	public int saveFactura (FacturaModel f) {
		// TODO Auto-generated method stub
		int res =0;
		FacturaModel factura = facturadb.save(f);
		if(!factura.equals(null)) {
			res=1;
		}
		return res;
	}

}