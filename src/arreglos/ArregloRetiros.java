package arreglos;
import clases.Retiro;

import java.io.*;
import java.util.ArrayList;

public class ArregloRetiros {
    private ArrayList<Retiro> retiros;

    public ArregloRetiros() {
        retiros = new ArrayList<Retiro>();
        cargarRetiros();
    }

    public void adicionar(Retiro a) {
        retiros.add(a);
    }

    public int tamanio() {
        return retiros.size();
    }

    public Retiro obtener(int i) {
        return retiros.get(i);
    }

    public Retiro buscar(int codRetiro) {
        for (int i = 0; i < tamanio(); i++)
            if (obtener(i).getNumRetiro() == codRetiro)
                return obtener(i);
        return null;
    }

    public void eliminar(Retiro a) {
        retiros.remove(a);
    }

    public void grabarRetiros() {
        try {
            PrintWriter pw;
            String linea;
            Retiro r;
            pw = new PrintWriter(new FileWriter("retiros.txt"));
            for (int i = 0; i < tamanio(); i++) {
                r = obtener(i);
                linea = r.getNumRetiro() + ";" +
                        r.getNumMatricula() + ";" +
                        r.getFecha() + ";" +
                        r.getHora();       
                pw.println(linea);
            }
            pw.close();
        } catch (Exception e) {
        	System.out.println(e);
        }
    }

    public void cargarRetiros() {
        try {
            BufferedReader br;
            String linea;
            String[] s;
            int codRet, codMat;
            String fecha, hora;
            br = new BufferedReader(new FileReader("retiros.txt"));
            while ((linea = br.readLine()) != null) {
                s = linea.split(";");
                codRet = Integer.parseInt(s[0].trim());
                codMat = Integer.parseInt(s[1].trim());
                fecha = s[4].trim();
                hora = s[5].trim();
                
                adicionar(new Retiro(codRet, codMat, fecha, hora));
            }
            br.close();
        }
        catch (Exception e) {
        	System.out.println(e);
        }
    }

    public int codigoCorrelativo() {
        if (tamanio() == 0)
            return 300001;
        else
            return obtener(tamanio() - 1).getNumRetiro() + 1;
    }
}