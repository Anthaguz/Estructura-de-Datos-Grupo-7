/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.googolplex;

import GUI.Create_Doc;
import com.estructuras.Cola;
import javax.swing.JFileChooser;
import java.io.File;

 public class Programa {
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    private Cola documentosRegistrados;
    private String pathRelativoDelPrograma;
    private String pathRelativoDeLosDocumentos;    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters">  
    public String getPathRelativoDelPrograma(){return pathRelativoDelPrograma;}
    public String getPathRelativoDeLosDocumentos() {return pathRelativoDeLosDocumentos;}
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Setters">
    public void setPathRelativoDelPrograma(String pathRelativoDelPrograma) {this.pathRelativoDelPrograma = pathRelativoDelPrograma;}
    public void setPathRelativoDeLosDocumentos(String pathRelativoDeLosDocumentos) {this.pathRelativoDeLosDocumentos = pathRelativoDeLosDocumentos;}
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Programa() {
        this.documentosRegistrados = new Cola();
        this.pathRelativoDelPrograma = System.getProperty("user.dir");;
        this.pathRelativoDeLosDocumentos="\\src\\main\\java\\docs";
    }
    //</editor-fold>
    
    
    
    
    public File leerArchivoExistente() {
        File archivo=null;
        JFileChooser selectorDeArchivos = new JFileChooser();
        int resultadoDelDialogo = selectorDeArchivos.showOpenDialog(null);
        if (resultadoDelDialogo == JFileChooser.APPROVE_OPTION) {
            archivo = selectorDeArchivos.getSelectedFile();
        }
        return archivo;
    }

    //<editor-fold defaultstate="collapsed" desc="Metodo principal donde corre todo el programa">
    public void run(){
        Create_Doc createDOC = new Create_Doc();
        createDOC.interfazG();
    }
    //</editor-fold>
}
