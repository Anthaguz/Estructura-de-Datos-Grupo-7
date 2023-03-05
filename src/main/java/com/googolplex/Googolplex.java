//Github: https://github.com/Anthaguz/Estructura-de-Datos-Grupo-7

package com.googolplex;

import java.io.IOException;
import java.net.ServerSocket;
import javax.swing.JOptionPane;

public class Googolplex{

    //<editor-fold defaultstate="collapsed" desc="inicializacion del programa y variables iniciales">
    public static Programa programa = new Programa();

    public static int consecutivoDeDocumentos = 0;

    //</editor-fold>
    public static void main( String[] args ){
        ServerSocket ss=null;
        try {
            ss = new ServerSocket(1044);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "La aplicacion ya esta abierta, cierre todas las instancias actuales antes de continuar.", "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println("La aplicacion ya esta abierta, cierre todas las instancias actuales antes de continuar.");
            System.exit(-1);
        }
        programa.run();
    }
}
