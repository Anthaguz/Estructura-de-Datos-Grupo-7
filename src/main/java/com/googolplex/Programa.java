/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.googolplex;

import GUI.Create_Doc;
import com.estructuras.Cola;
import com.estructuras.Documento;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.IOException;
import java.util.Date;

 public class Programa {
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    private Cola documentosRegistrados;
    private final String pathRelativoDelPrograma;
    private final String pathRelativoDeLosDocumentos;    
    private final String pathDeRegistros;    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters">  
    public String getPathRelativoDelPrograma(){return pathRelativoDelPrograma;}
    public String getPathRelativoDeLosDocumentos() {return pathRelativoDeLosDocumentos;}
    public String getPathDeRegistros() {return pathDeRegistros;}
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Setters">

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Programa() {
        this.documentosRegistrados = new Cola();
        this.pathRelativoDelPrograma = System.getProperty("user.dir");
        this.pathRelativoDeLosDocumentos="\\src\\main\\java\\docs\\";
        this.pathDeRegistros="src/main/java/registros/";
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodos para agregar documento existente">
    public File leerArchivoExistente() {
        File archivo=null;
        JFileChooser selectorDeArchivos = new JFileChooser();
        int resultadoDelDialogo = selectorDeArchivos.showOpenDialog(null);
        if (resultadoDelDialogo == JFileChooser.APPROVE_OPTION) {
            archivo = selectorDeArchivos.getSelectedFile();
        }
        return archivo;
    }
    
    public void documentoExistente(String nombreDelDocumento){
        Date fechaAdicion = new Date();
        Googolplex.consecutivoDeDocumentos++;
        documentosRegistrados.encolar(new Documento(Googolplex.consecutivoDeDocumentos, nombreDelDocumento, fechaAdicion));
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo principal donde corre todo el programa">
    public void run(){
        inicializadorDeRecursos("ArchivosRegistrados.txt");
        inicializadorDeRecursos("ConsecutivoDeArchivos.txt");
        Create_Doc createDOC = new Create_Doc();
        createDOC.interfazG();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Inicializador de archivos persistentes">
    public void inicializadorDeRecursos(String nombreDeRegistro){
        File registro = new File(pathDeRegistros+nombreDeRegistro);
        if (!registro.exists()) {
            try {
                registro.createNewFile();
                System.out.println("Log creado: " + registro.getName());
            } catch (IOException e) {
                System.out.println("Ocurrio un error.");
                e.printStackTrace();
            }
        } else {
            System.out.println("El log "+nombreDeRegistro+" ya existe.");
        }
    }
    //</editor-fold>
}
