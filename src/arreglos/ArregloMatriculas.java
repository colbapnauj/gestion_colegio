package arreglos;

import clases.Alumno;
import clases.Matricula;

import java.io.*;
import java.util.ArrayList;

public class ArregloMatriculas {
    private ArrayList<Matricula> matriculas;

    public ArregloMatriculas() {
        matriculas = new ArrayList<Matricula>();
        cargarMatriculas();
    }

    public void adicionar(Matricula a) {
        matriculas.add(a);
    }

    public int tamanio() {
        return matriculas.size();
    }

    public Matricula obtener(int i) {
        return matriculas.get(i);
    }

    public Matricula buscar(int codigoAlumno) {
        for (int i = 0; i < tamanio(); i++)
            if (obtener(i).getCodAlumno() == codigoAlumno)
                return obtener(i);
        return null;
    }

//    public boolean existeDni(String dni) {
//        for (int i = 0; i < tamanio(); i++)
//            if (matriculas.get(i).getDni().equals(dni))
//            	return true;
//        return false;
//    }

    public void eliminar(Matricula a) {
        matriculas.remove(a);
    }

    public void grabarMatriculas() {
        try {
            PrintWriter pw;
            String linea;
            Matricula a;
            pw = new PrintWriter(new FileWriter("matriculas.txt"));
            for (int i = 0; i < tamanio(); i++) {
                a = obtener(i);
                linea = a.getNumMatricula() + ";" +
                        a.getCodAlumno() + ";" +
                        a.getCodCurso() + ";" +
                        a.getCodDocente() + ";" +
                        a.getFecha() + ";" +
                        a.getHora();       
                pw.println(linea);
            }
            pw.close();
        } catch (Exception e) {
        	System.out.println(e);
        }
    }

    public void cargarMatriculas() {
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
                adicionar(new Matricula(codigoAlumno, nombres, apaterno, amaterno, dni, edad, celular, estado));
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
}