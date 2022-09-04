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
            pw = new PrintWriter(new FileWriter("db/matriculas.txt"));
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
            int codMatricula, codAlumno, codCurso, codDocente;
            String fecha, hora;
            br = new BufferedReader(new FileReader("db/matriculas.txt"));
            while ((linea = br.readLine()) != null) {
                s = linea.split(";");
                codMatricula = Integer.parseInt(s[0].trim());
                codAlumno = Integer.parseInt(s[1].trim());
                codCurso = Integer.parseInt(s[2].trim());
                codDocente = Integer.parseInt(s[3].trim());
                fecha = s[4].trim();
                hora = s[5].trim();
                
                adicionar(new Matricula(codMatricula, codAlumno, codCurso, codDocente, fecha, hora));
            }
            br.close();
        }
        catch (Exception e) {
        	System.out.println(e);
        }
    }

    public int codigoCorrelativo() {
        if (tamanio() == 0)
            return 200001;
        else
            return obtener(tamanio() - 1).getCodAlumno() + 1;
    }
}