package ar.edu.unju.edm.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Cliente;
import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.repository.IClienteDAO;
import ar.edu.unju.edm.service.IClienteService;

@Service
@Qualifier("impmysql")

public class ClienteServiceMySQL implements IClienteService {

	@Autowired
	Cliente unCliente;
	
	@Autowired
	IClienteDAO clienteDAO;


	
	@Override
	public void guardarCliente(Cliente unCliente) {
		// TODO Auto-generated method stub
		clienteDAO.save(unCliente);
	}

	@Override
	public Cliente crearCliente() {
		// TODO Auto-generated method stub
		return unCliente;
	}

	@Override
	public List<Cliente> obtenerTodosClientes() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDAO.findAll();
	}

	@Override
	public Cliente encontrarUnCliente(int dni) {
		// TODO Auto-generated method stub
		return clienteDAO.findBynroDocumento(dni);
	}

	@Override
	public void modificarCliente(Cliente clienteModificado) {
		// TODO Auto-generated method stub
		Cliente clienteAModificado = clienteDAO.findBynroDocumento( clienteModificado.getNroDocumento());  
		cambiarcliente( clienteModificado, clienteAModificado);
		clienteDAO.save(clienteAModificado);
		
	}
	private void cambiarcliente(Cliente clienteModificado, Cliente clienteAModificado) {
		// TODO Auto-generated method stub
		clienteAModificado.setNombreApellido(clienteModificado.getNombreApellido());
		clienteAModificado.setNroDocumento(clienteModificado.getNroDocumento());
		clienteAModificado.setFechaNacimiento(clienteModificado.getFechaNacimiento());
		clienteAModificado.setCodigoAreaTelefono(clienteModificado.getCodigoAreaTelefono());;
		clienteAModificado.setDatosAdicionales(clienteModificado.getDatosAdicionales());
		clienteAModificado.setEmail(clienteModificado.getEmail());
		clienteAModificado.setFechaUltimaCompra(clienteModificado.getFechaUltimaCompra());;
		clienteAModificado.setNumTelefono(clienteAModificado.getNumTelefono());
		clienteAModificado.setTipoDocumento(clienteAModificado.getTipoDocumento());
		
		
	}
	@Override
	public void eliminarCliente(int id) {
		// TODO Auto-generated method stub
		Cliente clienteAEliminar= clienteDAO.findBynroDocumento(id);
		clienteDAO.delete(clienteAEliminar);
	}

}
