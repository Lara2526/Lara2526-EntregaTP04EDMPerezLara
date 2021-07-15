package ar.edu.unju.edm.service.imp;

//import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.service.IProductoService;

import ar.edu.unju.edm.util.ListadoProducto;
@Service
//@Qualifier("productoserviceimp")
public class ProductoServiceImp implements IProductoService {
	
	private static final Log LOGGER = LogFactory.getLog(ProductoServiceImp.class);
	//Como se hace la solucion del problema
	
	@Autowired
	Producto unProducto;
	
	//estructura que guarda
	//ArrayList<Producto> listaDeProductos = new ArrayList<Producto>();
	private List<Producto> listaDeProductos = ListadoProducto.productos;
	@Override
	public void guardarProducto(Producto unProducto) {
		// TODO Auto-generated method stub
		//escribe en la consola
		System.out.println(unProducto.getNombre());
		listaDeProductos.add(unProducto);
		
		// línea de control
		//cantidad de elementos hay en el arreglo
		System.out.println(listaDeProductos.size());
		
		LOGGER.info("METHOD: ingresando a Guardar Producto");
		LOGGER.info("RESULT: guardado " + listaDeProductos.get(listaDeProductos.size()-1).getNombre());
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
	public List<Producto> obtenerTodosProductos() {
		
		// TODO Auto-generated method stub
	//2return listaDeProductos;
		return ListadoProducto.productos ;
		//1return null;
	}

	@Override
	public Producto obtenerProductoNuevo() {
		// TODO Auto-generated method stub
		return unProducto;
	}
	@Override
	public Producto obtenerUltimoProducto() {
		// TODO Auto-generated method stub
	int i = listaDeProductos.size() - 1;
		return listaDeProductos.get(i);
	}
	@Override
	public Producto encontrarUnProducto(int cod) {
		for (int i = 0; i < listaDeProductos.size(); i++){
		    if (listaDeProductos.get(i).getCodProducto() == cod) {
		    	unProducto = listaDeProductos.get(i);
		    }
		}
		return unProducto;
	}
	
	@Override
	public void modificarProducto(Producto productoAModificar) {
		// TODO Auto-generated method stub
		for (int i = 0; i < listaDeProductos.size(); i++){
		    if (listaDeProductos.get(i).getCodProducto() == productoAModificar.getCodProducto()) {
		    	listaDeProductos.set(i, productoAModificar);
		    }
		}
		
	}
	/**
	 * @Override
	public void eliminarProducto(int id) {
	for(int i=0; i<listade producto.zise;i++){
	if(listadeProducto.get(i).getCodProducto() == id)
	{
		listaDeProducto.remove(i);
	}
	}}
	 * 
	 * */



	@Override
	public void eliminarProducto(int id) {
		// TODO Auto-generated method stub
		for (int i = 0; i < listaDeProductos.size(); i++){
		    if (listaDeProductos.get(i).getCodProducto() == id) {
		    	listaDeProductos.remove(i);
		    }
		}
		
	}



	@Override
	public Producto obtenerProductoCodigo(Integer codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
