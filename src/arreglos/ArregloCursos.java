package arreglos;

import clases.Curso;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class ArregloCursos {
    private ArrayList<Curso> cursos;

    public ArregloCursos() {
        cursos = new ArrayList<Curso>();
        cargarCursos();
    }

    public void adicionar(Curso a) {
        cursos.add(a);
    }

    public int tamanio() {
        return cursos.size();
    }

    public Curso obtener(int i) {
        return cursos.get(i);
    }

    public Curso buscar(int codCurso) {
        for (int i = 0; i < tamanio(); i++)
            if (obtener(i).getCodCurso() == codCurso)
                return obtener(i);
        return null;
    }

     public boolean existeCod(int cod) {
         for (int i = 0; i < tamanio(); i++)
             if (cursos.get(i).getCodCurso() == cod)
             	return true;
         return false;
    }
     
    public void ordenar() {
    	cursos.sort(Comparator.comparing(Curso::getCodCurso));
    }

    public void eliminar(Curso c) {
        cursos.remove(c);
    }

    public void grabarCursos() {
        try {
            PrintWriter pw;
            String linea;
            Curso a;
            pw = new PrintWriter(new FileWriter("cursos.txt"));
            for (int i = 0; i < tamanio(); i++) {
                a = obtener(i);
                linea = a.getCodCurso() + ";" +
                        a.getCiclo() + ";" +
                        a.getCreditos() + ";" +
                        a.getHoras() + ";" +
                        a.getAsignatura();
                pw.println(linea);
            }
            pw.close();
        } catch (Exception e) {
        	System.out.println(e);
        }
    }

    public void cargarCursos() {
        try {
            BufferedReader br;
            String linea;
            String[] s;
            int codCurso;
            int ciclo;
            int creditos;
            int horas;
            String asignatura;
            br = new BufferedReader(new FileReader("cursos.txt"));
            while ((linea = br.readLine()) != null) {
                s = linea.split(";");
                codCurso = Integer.parseInt(s[0].trim());
                ciclo = Integer.parseInt(s[1].trim());
                creditos = Integer.parseInt(s[2].trim());
                horas = Integer.parseInt(s[3].trim());
                asignatura = s[4].trim();
                adicionar(new Curso(codCurso, ciclo, creditos, horas, asignatura));
            }
            br.close();
        }
        catch (Exception e) {
        	System.out.println(e);
        }
    }
}
