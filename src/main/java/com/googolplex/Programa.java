/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.googolplex;

import GUI.VentanaPrincipal;
import com.estructuras.Cola;
import com.estructuras.Documento;
import com.estructuras.Pila;
import java.io.BufferedReader;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

 public class Programa {
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    private Cola documentosRegistrados;
    private Pila documentosMasBuscados;
    private final String pathRelativoDelPrograma;
    private final String pathRelativoDeLosDocumentos;    
    private final String pathDeRegistros;    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters">  
    public String getPathRelativoDelPrograma(){return pathRelativoDelPrograma;}
    public String getPathRelativoDeLosDocumentos() {return pathRelativoDeLosDocumentos;}
    public String getPathDeRegistros() {return pathDeRegistros;}
    public Cola getDocumentosRegistrados() {return documentosRegistrados;}
    public Pila getDocumentosMasBuscados() {return documentosMasBuscados;}
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Setters">

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Programa() {
        this.documentosRegistrados = new Cola();
        this.pathRelativoDelPrograma = System.getProperty("user.dir");
        this.pathRelativoDeLosDocumentos="\\src\\main\\java\\docs\\";
        this.pathDeRegistros="/src/main/java/registros/";
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
        Documento nuevo = new Documento(Googolplex.consecutivoDeDocumentos, nombreDelDocumento, fechaAdicion);
        nuevo.toString();
        documentosRegistrados.encolar(nuevo);
        List<Documento> documentos = new ArrayList<Documento>();
        documentos.add(nuevo);
        addDocumentosARegistroPersistente(documentos);
        editarConsecutivoPersistente();
    }
    
    public void addDocumentosARegistroPersistente(List<Documento> documentos){
        File archivo = new File(pathRelativoDelPrograma+pathDeRegistros+"ArchivosRegistrados.txt");
        FileWriter writer = null;
        try {
            writer = new FileWriter(archivo,true);
            for (Documento documento :documentos){
                if(archivo.length()==0){
                    writer.write(documento.toString());
                }else{
                    writer.write(System.lineSeparator());
                    writer.write(documento.toString());
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: Ocurrio un error desconocido.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error: Ocurrio un error desconocido.", "Error", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();      
                }
            }
        }
    }
    
    public void editarConsecutivoPersistente(){
        File archivo = new File(pathRelativoDelPrograma+pathDeRegistros+"ConsecutivoDeArchivos.txt");
        FileWriter writer = null;
        try {
            writer = new FileWriter(archivo);
            writer.write(Integer.toString(Googolplex.consecutivoDeDocumentos));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error: Ocurrio un error desconocido.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error: Ocurrio un error desconocido.", "Error", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();      
                }
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Metodo para popular la tabla">
    public List<String[]> popularTabla(){
        return documentosRegistrados.imprimirCola();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodo principal donde corre todo el programa">
    public void run(){
        inicializadorDeRecursos("ArchivosRegistrados.txt");
        inicializadorDeRecursos("ConsecutivoDeArchivos.txt");
        inicializadorDeVariables();
        VentanaPrincipal createDOC = new VentanaPrincipal();
        createDOC.interfazG();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Inicializadores de archivos persistentes y variables globales">
    public void inicializadorDeRecursos(String nombreDeRegistro){
        File registro = new File(pathRelativoDelPrograma+pathDeRegistros+nombreDeRegistro);
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
    
    public void inicializadorDeVariables(){
        //<editor-fold defaultstate="collapsed" desc="Leyendo el registro de consecutivo de archivos">
        File consecutivoDeArchivos = new File(pathRelativoDelPrograma+pathDeRegistros+"ConsecutivoDeArchivos.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(consecutivoDeArchivos))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Googolplex.consecutivoDeDocumentos=Integer.parseInt(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Leyendo el registro de documentos">
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        File archivosRegistrados = new File(pathRelativoDelPrograma+pathDeRegistros+"ArchivosRegistrados.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(archivosRegistrados))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] documentos = linea.split(",");
                Date fecha= formatoFecha.parse(documentos[2]+" "+documentos[3]);
                documentosRegistrados.encolar(new Documento(Integer.parseInt(documentos[0]),documentos[1],fecha,Integer.parseInt(documentos[4])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException f){
            f.printStackTrace();
        }
        
        documentosMasBuscados=documentosRegistrados.toPila();
        documentosMasBuscados.ordenarPilaMayorAMenor(documentosMasBuscados);
        //</editor-fold>
    }
    //</editor-fold>
}
