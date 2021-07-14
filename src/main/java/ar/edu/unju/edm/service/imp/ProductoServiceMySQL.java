package ar.edu.unju.edm.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.repository.IProductoDAO;
import ar.edu.unju.edm.service.IProductoService;

@Service
@Qualifier("prodmysql")
public class ProductoServiceMySQL implements IProductoService{
	
	@Autowired
	Producto unProducto;
	
	@Autowired
	IProductoDAO productoDAO;
	
	@Override
	public void guardarProducto(Producto unProducto) {
		// TODO Auto-generated method stub
		productoDAO.save(unProducto);
	}
	@Override
	public Producto obtenerProductoNuevo() {
		// TODO Auto-generated method stub
		return unProducto;
	}
	@Override
	public List<Producto> obtenerTodosProductos() {
		// TODO Auto-generated method stub
		return (List<Producto>) productoDAO.findAll();
	}
	@Override
	public void eliminarUnProducto(Producto productoAEliminar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto obtenerUnProducto(String NombreProducto) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Producto obtenerUltimoProducto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto encontrarUnProducto(int cod) {
		// TODO Auto-generated method stub
		System.out.println("ingrsando a busca"+cod);
		return productoDAO.findByCodProducto(cod);
	}

	@Override
	public void modificarProducto(Producto productoAModificar) {
		// TODO Auto-generated method stub
		Producto productoModificado = productoDAO.findByCodProducto(productoAModificar.getCodProducto());  
		cambiarproducto(productoAModificar, productoModificado);
		productoDAO.save(productoModificado);
	}
	private void cambiarproducto(Producto productoAModificar, Producto productoModificado) {
		// TODO Auto-generated method stub
		productoModificado.setNombre(productoAModificar.getNombre());
		productoModificado.setMarca(productoAModificar.getMarca());
		productoModificado.setPrecio(productoAModificar.getPrecio());
		productoModificado.setDescripcion(productoAModificar.getDescripcion());
		productoModificado.setStock(productoAModificar.getStock());
		productoModificado.setCodProducto(productoAModificar.getCodProducto());

		
	}
	@Override
	public void eliminarProducto(int id) {
		// TODO Auto-generated method stub
		Producto productoAEliminar= productoDAO.findByCodProducto(id);
	productoDAO.delete(productoAEliminar);
	}
	@Override
	public Producto obtenerProductoCodigo(int codigo) {
		// TODO Auto-generated method stub
		return productoDAO.findByCodProducto(codigo);
	}

}
