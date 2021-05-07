package ar.edu.unju.edm.service;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;



import ar.edu.unju.edm.model.Producto;
@Service
public interface IProductoService {
    //que hace con Producto
	
	public void guardarProducto(Producto unProducto);
	public void modificarProducto(Producto productoAModificar);
	public void eliminarUnProducto(Producto productoAEliminar);
	public Producto obtenerUnProducto(String NombreProducto);
	public List<Producto> obtenerTodosProductos();
	public Producto obtenerProductoNuevo();
	public Producto obtenerUltimoProducto();
	//pulic void eliminarproducto(int id); 
}
