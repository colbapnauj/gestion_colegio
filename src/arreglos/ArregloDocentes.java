package arreglos;

import clases.Docente;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class ArregloDocentes {
    private ArrayList<Docente> docentes;

    public ArregloDocentes() {
        docentes = new ArrayList<Docente>();
        cargarDocentes();
    }

    public void adicionar(Docente a) {
        docentes.add(a);
    }

    public int tamanio() {
        return docentes.size();
    }

    public Docente obtener(int i) {
        return docentes.get(i);
    }

    public Docente buscar(int codDocente) {
        for (int i = 0; i < tamanio(); i++)
            if (obtener(i).getCodDocente() == codDocente)
                return obtener(i);
        return null;
    }

     public boolean existeCod(int cod) {
         for (int i = 0; i < tamanio(); i++)
             if (docentes.get(i).getCodDocente() == cod)
             	return true;
         return false;
    }
     
    public void ordenar() {
    	docentes.sort(Comparator.comparing(Docente::getCodDocente));
    }

    public void eliminar(Docente c) {
        docentes.remove(c);
    }
    
    public int codigoCorrelativo() {
        if (tamanio() == 0)
            return 2001;
        else
            return obtener(tamanio() - 1).getCodDocente() + 1;
    }

    public void grabarDocentes() {
        try {
            PrintWriter pw;
            String linea;
            Docente x;
            pw = new PrintWriter(new FileWriter("docentes.txt"));
            for (int i = 0; i < tamanio(); i++) {
                x = obtener(i);
                linea = x.getCodDocente() + ";" +
                        x.getNombres() + ";" +
                		x.getApellidoPaterno() + ";" +
                        x.getApellidoMaterno() + ";" +
                		x.getDni() + ";" +
                        x.getCelular() + ";" +
                        x.getEspecialidad() + ";" +
                        x.getFechaIngreso();
                pw.println(linea);
            }
            pw.close();
        } catch (Exception e) {
        	System.out.println(e);
        }
    }

    public void cargarDocentes() {
        try {
            BufferedReader br;
            String linea;
            String[] s;
            int codDocente;
            String nombres;
            String apaterno;
            String amaterno;
            String dni;
            int celular;
            String especialidad;
            String fechaIngreso;
            
            br = new BufferedReader(new FileReader("docentes.txt"));
            while ((linea = br.readLine()) != null) {
                s = linea.split(";");
                codDocente = Integer.parseInt(s[0].trim());
                nombres = s[1].trim();
                apaterno = s[2].trim();
                amaterno = s[3].trim();
                dni = s[4].trim();
                celular = Integer.parseInt(s[5].trim());
                especialidad = s[6].trim();
                fechaIngreso = s[7].trim();
                
                adicionar(new Docente(codDocente, nombres, apaterno, amaterno, dni, celular, especialidad, fechaIngreso));
            }
            br.close();
        }
        catch (Exception e) {
        	System.out.println(e);
        }
    }
}
