package clases;

public class Docente {
	private int codDocente;
	private int calular;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String dni;
	private String especialidad;
	private String fechaIngreso;
	
	public Docente(int codDocente, int calular, String nombres, String apellidoPaterno, String apellidoMaterno,
			String dni, String especialidad, String fechaIngreso) {
		this.codDocente = codDocente;
		this.calular = calular;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.dni = dni;
		this.especialidad = especialidad;
		this.fechaIngreso = fechaIngreso;
	}

	public int getCodDocente() {
		return codDocente;
	}

	public void setCodDocente(int codDocente) {
		this.codDocente = codDocente;
	}

	public int getCalular() {
		return calular;
	}

	public void setCalular(int calular) {
		this.calular = calular;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	
	
}
