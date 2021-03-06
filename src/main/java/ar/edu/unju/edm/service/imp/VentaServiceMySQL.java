package ar.edu.unju.edm.service.imp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ar.edu.unju.edm.model.Venta;
import ar.edu.unju.edm.repository.IVentaDAO;
import ar.edu.unju.edm.service.IVentaService;
@Service
public class VentaServiceMySQL implements IVentaService{
	@Autowired
	Venta venta;
	
	@Autowired
	IVentaDAO iVentaDAO;
	@Override
	public void guardarVenta(Venta unaVenta) {
		LocalDate DATE = LocalDate.now();
		unaVenta.setFechaVenta(DATE);
		iVentaDAO.save(unaVenta);
		
	}

	@Override
	public Venta crearVenta() {
		// TODO Auto-generated method stub
		
	return venta;
	}

/*	@Override
	public List<Venta> obtenerTodosProductos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venta> obtenerTodosVenta() {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public Venta encontrarUnVenta(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venta> obtenerTodaVenta() {
		// TODO Auto-generated method stub
		return (List<Venta>) iVentaDAO.findAll();
	}

}
