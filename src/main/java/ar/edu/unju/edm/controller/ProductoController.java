package ar.edu.unju.edm.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.service.IProductoService;


@Controller
public class ProductoController {
	private static final Log LARA = LogFactory.getLog(ProductoController.class);
//@Autowired
//@Qualifier("otroImp")
//IProductoService iProductoService;
	
@Autowired
@Qualifier("prodmysql")
IProductoService iProductoService;


	@GetMapping("/producto/mostrar")
	public String cargarProducto(Model model) {
		model.addAttribute("unProducto", iProductoService.obtenerProductoNuevo());
		model.addAttribute("productos",iProductoService.obtenerTodosProductos());
		return("producto");
	}
	@PostMapping("/producto/guardar")
	public String nuevoUsuarioPost(@Valid @ModelAttribute("unProducto") Producto nuevoProducto,BindingResult resultado, Model model) {
		if(resultado.hasErrors())
		{
			model.addAttribute("unProducto", nuevoProducto);
			model.addAttribute("productos", iProductoService.obtenerTodosProductos());
			return ("producto");
		}
		else {
		
		iProductoService.guardarProducto(nuevoProducto);
		System.out.println(iProductoService.obtenerTodosProductos().get(0).getMarca());
	
		LARA.error("solo de prueba");
		return "redirect:/producto/mostrar";
		}
	}
	@GetMapping("/producto/editar/{codProducto}")
	public String editarCliente(Model model, @PathVariable(name="codProducto") int cod) throws Exception 
	{
		try {
			LARA.error("ingrsando a buscar producto");
			Producto productoEncontrado = iProductoService.encontrarUnProducto(cod);
			LARA.error("encontrado"+productoEncontrado.getNombre());
			model.addAttribute("unProducto", productoEncontrado);
			model.addAttribute("productos",iProductoService.obtenerTodosProductos());
			model.addAttribute("editMode", "true");
		}
		catch (Exception e) {
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());
			model.addAttribute("unProducto", iProductoService.obtenerProductoNuevo());
			model.addAttribute("editMode", "false");
		
		
		}
		model.addAttribute("productos", iProductoService.obtenerTodosProductos());
		return("producto");
		}
	@PostMapping("/producto/modificar")
	public String modificarCliente(@ModelAttribute("unProducto") Producto productoAModificar, Model model) {
	
	try {
				iProductoService.modificarProducto(productoAModificar);
				model.addAttribute("unProducto", new Producto());				
				model.addAttribute("editMode", "false");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// pasar las excepciones al html
				model.addAttribute("formUsuarioErrorMessage",e.getMessage());
				model.addAttribute("unProducto", productoAModificar);			
				model.addAttribute("productos", iProductoService.obtenerTodosProductos());
				model.addAttribute("editMode","true");
				
			
		
		}
	model.addAttribute("productos", iProductoService.obtenerTodosProductos());
	return("producto");
	}
	
	@GetMapping("/ultimo")
	public String cargarUltimoProducto(Model model) {
		model.addAttribute("ultimoProducto", iProductoService.obtenerUltimoProducto());
		
		return("mostrar-ultimo");
	}
	@GetMapping("/volver")
	public String cargarNuevoProducto(Model model) {
		//model.addAttribute("unProducto", iProductoService.obtenerProductoNuevo());
		
		return("redirect:/producto");
	}
	@GetMapping("/producto/eliminarProducto/{id}")
	public String eliminarProducto(Model model, @PathVariable(name="id") int id) {		
		try {			iProductoService.eliminarProducto(id);			
		}
		catch(Exception e){
			model.addAttribute("listErrorMessage",e.getMessage());
		}			
		return "redirect:/producto/mostrar";
	}
	@GetMapping("/cancelar")
	public String cancelar() {
		return "redirect:/producto/mostrar";
	}
	/** producto
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	}

