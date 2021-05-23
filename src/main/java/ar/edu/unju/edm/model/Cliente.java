package ar.edu.unju.edm.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
//import java.util.Date;
import java.time.Period;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table (name="CLIENTES")
@Component
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int nroDocumento;
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaUltimaCompra;
	//Calendar
	//private Date fechaUltimCompra = new Date();
	@Column
	private String tipoDocumento;
	@Column
	private String nombreApellido;
	@Column
	private int codigoAreaTelefono;
	@Column
	private int numTelefono;
	@Column
	private String email;
	@Column
	private String password;
//	private int edad;
	@Column
	private String datosAdicionales;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	public String getDatosAdicionales() {
		return datosAdicionales;
	}

	public void setDatosAdicionales(String datosAdicionales) {
		this.datosAdicionales = datosAdicionales;
	}

	public int getEdad() {
		int edad = 0;
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(fechaNacimiento, hoy);
		edad = periodo.getYears();		
		return edad;
		
	}

//	public void setEdad(int edad) {
	//	this.edad = edad;
//	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}

	public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}

	public int getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getCodigoAreaTelefono() {
		return codigoAreaTelefono;
	}

	public void setCodigoAreaTelefono(int codigoAreaTelefono) {
		this.codigoAreaTelefono = codigoAreaTelefono;
	}

	public int getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(int numTelefono) {
		this.numTelefono = numTelefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTiempoDesdeUltimaCompra() {
		LocalDate fechaActual = LocalDate.now();
	
		Period periodo = Period.between(fechaUltimaCompra, fechaActual);
		
		
	return " TUltimaCompra  Año: " + periodo.getYears() + " Mes: " + periodo.getMonths() + " Dia: " + periodo.getDays() ;		

	}
	//public String getTiempoHastaCumpleanios() {
//		LocalDate fechaAct = LocalDate.now();
//		Period periodos = Period.between(fechaNacimiento, fechaAct);
		
//		return " THCumpleaños Año: " + periodos.getYears() + " Mes: " + periodos.getMonths() + " Dia: " + periodos.getDays() ;		

//	}
	public String getTiempoHastaCumpleanios() {
	
		LocalDate fechaAct = LocalDate.now();
		LocalDateTime hora= LocalDateTime.now();
		int anio;
		if(fechaAct.getMonthValue()< fechaNacimiento.getMonthValue())
		{
			anio =fechaAct.getYear();
		}
		else {
			anio =fechaAct.getYear()+1;
	}
		LocalDate fechaproxcumple = 	LocalDate.of(anio, fechaNacimiento.getMonth(), fechaNacimiento.getDayOfMonth()) ;
		Period periodos = Period.between(fechaAct, fechaproxcumple);
		
		LocalDateTime  horaproxcumple = LocalDateTime.of(anio, fechaNacimiento.getMonth(), fechaNacimiento.getDayOfMonth(), 0, 0,0);
		Duration tiempo =Duration.between(hora, horaproxcumple);
		
		return "  THCumpleaños Año: " + periodos.getYears() + " Mes: " + periodos.getMonths() + " Dia: " + periodos.getDays() + "Hr: " + tiempo.toHoursPart()+"	Min: "+tiempo.toMinutesPart()+"Seg: " + tiempo.toSecondsPart()  ;		

	}

}