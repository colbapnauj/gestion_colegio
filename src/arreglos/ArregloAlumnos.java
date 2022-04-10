package arreglos;

import clases.Alumno;

import java.io.*;
import java.util.ArrayList;

public class ArregloAlumnos {
    private ArrayList<Alumno> alumnos;

    public ArregloAlumnos() {
        alumnos = new ArrayList<Alumno>();
        cargarAlumnos();
    }

    public void adicionar(Alumno a) {
        alumnos.add(a);
    }

    public int tamanio() {
        return alumnos.size();
    }

    public Alumno obtener(int i) {
        return alumnos.get(i);
    }

    public Alumno buscar(int codigoAlumno) {
        for (int i = 0; i < tamanio(); i++)
            if (obtener(i).getCodAlumno() == codigoAlumno)
                return obtener(i);
        return null;
    }
    
    public void cambiarEstado(int codigoAlumno, int estado) {
        Alumno a = buscar(codigoAlumno);
        a.setEstado(estado);
    }

    public boolean existeDni(String dni) {
        for (int i = 0; i < tamanio(); i++)
            if (alumnos.get(i).getDni().equals(dni))
            	return true;
        return false;
    }

    public void eliminar(Alumno a) {
        alumnos.remove(a);
    }


    public void grabarAlumnos() {
        try {
            PrintWriter pw;
            String linea;
            Alumno a;
            pw = new PrintWriter(new FileWriter("alumnos.txt"));
            for (int i = 0; i < tamanio(); i++) {
                a = obtener(i);
                linea = a.getCodAlumno() + ";" +
                        a.getNombres() + ";" +
                        a.getApellidoPaterno() + ";" +
                        a.getApellidoMaterno() + ";" +
                        a.getDni() + ";" +
                        a.getEdad() + ";" +
                        a.getCelular() + ";" +
                        a.getEstado();
                pw.println(linea);
            }
            pw.close();
        } catch (Exception e) {
        	System.out.println(e);
        }
    }

    public void cargarAlumnos() {
        try {
            BufferedReader br;
            String linea;
            String[] s;
            int codigoAlumno;
            String nombres;
            String apaterno;
            String amaterno;
            String dni;
            int edad;
            int celular;
            int estado;
            br = new BufferedReader(new FileReader("alumnos.txt"));
            while ((linea = br.readLine()) != null) {
                s = linea.split(";");
                codigoAlumno = Integer.parseInt(s[0].trim());
                nombres = s[1].trim();
                apaterno = s[2].trim();
                amaterno = s[3].trim();
                dni = s[4].trim();
                edad = Integer.parseInt(s[5].trim());
                celular = Integer.parseInt(s[6].trim());
                estado = Integer.parseInt(s[7].trim());
                adicionar(new Alumno(codigoAlumno, nombres, apaterno, amaterno, dni, edad, celular, estado));
            }
            br.close();
        }
        catch (Exception e) {
        	System.out.println(e);
        }
    }

    public int codigoCorrelativo() {
        if (tamanio() == 0)
            return 202110001;
        else
            return obtener(tamanio() - 1).getCodAlumno() + 1;
    } 
    
    public boolean estaMatriculado(int codAlumno) {
		for (int i=tamanio()-1; i>=0; i--)
			if (obtener(i).getCodAlumno() == codAlumno &&  obtener(i).getEstado() == 1)
				return true;
		return false;
	}
}
