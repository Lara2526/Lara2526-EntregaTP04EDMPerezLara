package ar.edu.unju.edm.controller;

import javax.validation.Valid;

//import java.time.LocalDate;
//import java.time.Period;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.model.Cliente;
import ar.edu.unju.edm.service.IClienteService;

@Controller
public class ClienteController {
	private static final Log LOGGER = LogFactory.getLog(ClienteController.class);

	//@Autowired("unImp")
	@Autowired
//	@Qualifier("productoservicemysql")
	//LIST
	//@Qualifier("clienteServiceImp")
	//BD MySQL
	@Qualifier("impmysql")
	IClienteService clienteService;

	
//	@Autowired()
//	@Qualifier("OtraImp")
//	IClienteService otroClienteService;
	@GetMapping("/cliente/mostrar")
	public String cargarCliente(Model model) {
		model.addAttribute("unCliente", clienteService.crearCliente());
		model.addAttribute("clientes", clienteService.obtenerTodosClientes());
		return("cliente");
	}

	@PostMapping("/cliente/guardar")
	public String guardarNuevoProducto(@Valid @ModelAttribute("unCliente") Cliente nuevoCliente,BindingResult resultado, Model model) {
		LOGGER.info("METHOD: ingresando el metodo Guardar");	
		if(resultado.hasErrors())
		{LOGGER.info("METHOD: ingresando error");	
			model.addAttribute("unCliente", nuevoCliente);
			model.addAttribute("clientes", clienteService.obtenerTodosClientes());
			return ("cliente");
		}
		else {
		clienteService.guardarCliente(nuevoCliente);		
		LOGGER.info("Tama??o del Listado: "+ clienteService.obtenerTodosClientes().size());
		//trabajarConFecha();
		return "redirect:/cliente/mostrar";}
	}
	@GetMapping("/cliente/editar/{nroDocumento}")
	public String editarCliente(Model model, @PathVariable(name="nroDocumento") int dni) throws Exception 
	{
		try {
			Cliente clienteEncontrado = clienteService.encontrarUnCliente(dni);
			model.addAttribute("unCliente", clienteEncontrado);
			model.addAttribute("editMode", "true");
		}
		catch (Exception e) {
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());
			model.addAttribute("unCliente", clienteService.crearCliente());
			model.addAttribute("editMode", "false");
		
		
		}
		model.addAttribute("clientes", clienteService.obtenerTodosClientes());
		return("cliente");
		}

@PostMapping("/cliente/modificar")
	public String modificarCliente(@ModelAttribute("unCliente") Cliente clienteModificado, Model model) {
	
	try {
				clienteService.modificarCliente(clienteModificado);
				model.addAttribute("unCliente", new Cliente());				
				model.addAttribute("editMode", "false");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				// pasar las excepciones al html
				model.addAttribute("formUsuarioErrorMessage",e.getMessage());
				model.addAttribute("unCliente", clienteModificado);			
				model.addAttribute("clientes", clienteService.obtenerTodosClientes());
				model.addAttribute("editMode","true");
				
			
		
		}
	model.addAttribute("clientes", clienteService.obtenerTodosClientes());
	return("cliente");
	}		

	@GetMapping("/cliente/eliminarCliente/{id}")
	public String eliminarCliente(Model model, @PathVariable(name="id") int id) {		
	try {			
		clienteService.eliminarCliente(id);			
	}
	catch(Exception e){
		model.addAttribute("listErrorMessage",e.getMessage());
	}			
	return "redirect:/cliente/mostrar";
	}
	
	@GetMapping("/retirar")
	public String retirar() {
		return "redirect:/cliente/mostrar";
	}
}


//	public void trabajarConFechas(){
	//algunas cosas con fecha;
			//obtengo tres fechas
//			LocalDate fecha1 = clienteService.obtenerTodosClientes().get(0).getFechaNacimiento();
//			LocalDate fecha2 = LocalDate.now();
//			LocalDate fecha3 = LocalDate.of(2020, 11, 21);
			//calculo el per??odo entre dos de ellas
//		Period periodo = Period.between(fecha1,fecha2);
//		Period otroperiodo =Period.between(fecha1,fecha3);
			//una vez que tengo el per??odo puedo saber sus cantidades en d??as meses y a??os
//		int dias = periodo.getDays();		
//			System.out.println("dias: "+dias);
//			dias = otroperiodo.getDays();
//			System.out.println("dias: "+dias);
			//revisen la salida en la consola, deber??a dar la diferencia en d??as
			//todo esto nos debe hacer revisar la documentaci??n de las clases LocalDate, LocalTime, LocalDateTime y Periods
//}
