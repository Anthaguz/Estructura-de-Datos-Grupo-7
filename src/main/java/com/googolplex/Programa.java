//Github: https://github.com/Anthaguz/Estructura-de-Datos-Grupo-7

package com.googolplex;

import GUI.VentanaPrincipal;
import com.estructuras.Cache;
import com.estructuras.Cola;
import com.estructuras.Documento;
import com.estructuras.Pila;
import java.awt.Dimension;
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
    private Cache cacheDeBusquedas;
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
    public Cache getCacheDeBusquedas() {return cacheDeBusquedas;}
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="No hay Setters">
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Programa() {
        this.documentosRegistrados = new Cola();
        this.pathRelativoDelPrograma = System.getProperty("user.dir");
        this.pathRelativoDeLosDocumentos="\\src\\main\\java\\docs\\";
        this.pathDeRegistros="/src/main/java/registros/";
        this.cacheDeBusquedas=new Cache();
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Metodos para agregar documento existente">
    public File leerArchivoExistente() {
        File archivo=null;
        JFileChooser selectorDeArchivos = new JFileChooser();
        selectorDeArchivos.setPreferredSize(new Dimension(1000, 900));
        try{
            selectorDeArchivos.setCurrentDirectory(new File("D:\\Universidad\\2023 1Q\\Estructura de datos\\Archivos Demos"));
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
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
        documentosMasBuscados.apilar(nuevo);
        documentosMasBuscados.ordenarPilaMayorAMenor(documentosMasBuscados);
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
    
    //<editor-fold defaultstate="collapsed" desc="Metodo para editar la linea del registro permanente que pertenece al Documento editado">
    public void editarLineaDeDocumentoEditado(Documento aEditar){
        List<String> documentos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(getPathRelativoDelPrograma()+getPathDeRegistros()+"ArchivosRegistrados.txt"))) {
            String documento;
            while ((documento = reader.readLine()) != null) {
                documentos.add(documento);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int numeroDeDocumento = aEditar.getNumeroDeDocumento();
        try{
            for (String documento : documentos) {
                if (documento.startsWith(numeroDeDocumento + ",")) {
                    String[] propiedadesDelDocumento = documento.split(",");
                    propiedadesDelDocumento[4] = Integer.toString(aEditar.getNumeroDeBusquedas());
                    String modifiedLine = String.join(",", propiedadesDelDocumento);
                    documentos.set(numeroDeDocumento - 1, modifiedLine);
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("El registro de archivos tiene un consecutivo corrupto, con una linea faltante.");
        }
        try (FileWriter writer = new FileWriter(getPathRelativoDelPrograma()+getPathDeRegistros()+"ArchivosRegistrados.txt")) {
            for (String line : documentos) {
                writer.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    private void crearFolder( File folder ){
        if(!folder.exists()){
            folder.mkdir();
            System.out.println(
                    "El folder \""+folder.getName()+"\" fue creado");
        }
    }
    
    public void inicializadorDeRecursos(String nombreDeRegistro){

        File folderRegistro=new File(pathRelativoDelPrograma+pathDeRegistros);
        File folderArchivos=new File(pathRelativoDelPrograma+pathRelativoDeLosDocumentos);
        crearFolder(folderRegistro);
        crearFolder(folderArchivos);
        
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
        //<editor-fold defaultstate="collapsed" desc="Leyendo el Cache Permanente">
        
        //</editor-fold>
    }
    //</editor-fold>
}
