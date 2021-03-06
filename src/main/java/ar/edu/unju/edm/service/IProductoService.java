package ar.edu.unju.edm.service;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;



import ar.edu.unju.edm.model.Producto;
@Service
public interface IProductoService {
    //que hace con Producto
	public void guardarProducto(Producto unProducto);
	public void eliminarUnProducto(Producto productoAEliminar);
	public Producto obtenerUnProducto(String NombreProducto);
	public List<Producto> obtenerTodosProductos();
	public Producto obtenerProductoNuevo();
	public Producto obtenerUltimoProducto();
	public Producto encontrarUnProducto(int cod);
	public void modificarProducto(Producto productoAModificar);
	public void eliminarProducto(int id);
	public Producto obtenerProductoCodigo(Integer codigo);
}
