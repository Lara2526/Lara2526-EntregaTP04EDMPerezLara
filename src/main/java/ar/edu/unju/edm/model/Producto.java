package ar.edu.unju.edm.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;
//entidad esterotipo 
@Entity
@Table (name="PRODUCTOS")
@Component
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idProducto;
	@Column
	private int codProducto;
	@Column
	@NotBlank(message="debe tener nombre")
	private String nombre;
	@Column
	private double precio;
	@Column
	private String marca;
	@Column

	private int stock;
	//agregar descripcion
	@Column
	private String descripcion;
//@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
//	private List<Venta> ventasrealizadas ;
	

	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public int getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

/*	public List<Venta> getVentasrealizadas() {
		return ventasrealizadas;
	}

	public void setVentasrealizadas(List<Venta> ventasrealizadas) {
		this.ventasrealizadas = ventasrealizadas;
	}
	*/
	
	
}
