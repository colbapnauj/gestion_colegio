package clases;

public class Alumno {
	private int codAlumno;
	// TODO En lugar de edad debo registrar la fecha de nacimiento
	private int edad;
	private int celular;
	private int estado;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String dni;
	
	public Alumno(
		int codAlumno, 
		String nombres, 
		String apellidoPaterno,
		String apellidoMaterno, 
		String dni,
		int edad, 
		int celular, 
		int estado) {
		this.codAlumno = codAlumno;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.dni = dni;
		this.edad = edad;
		this.celular = celular;
		this.estado = estado;
	}

	public int getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
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
	
	
	
}
