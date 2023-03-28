//Github: https://github.com/Anthaguz/Estructura-de-Datos-Grupo-7
package com.estructuras;

import com.googolplex.Googolplex;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CacheContenido{
    private CacheNodeContenido cima;
    
    public CacheContenido(){
        this.cima=null;
    }
    
    public boolean isEmpty(){
        if (cima==null) {return true;}
        return false;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Podria usarse despues">
    

//    
//    public boolean existeBusquedaReciente(String busqueda){
//        CacheNode aux=cima;
//        boolean resultado=false;
//        while (aux!=null){
//            if(aux.getBusqueda().getKeyword().equals(busqueda)){
//                resultado=true;
//                break;
//            }
//            aux=aux.getSiguiente();
//        }
//        return resultado;
//    }
//    
//    public void modificarBusquedaAnterior(Busqueda busqueda){
//        Pila temp=Googolplex.programa.getDocumentosMasBuscados().encontrarTodoDocumentoQueCalce(busqueda.getKeyword());
//        CacheNode aux=cima;
//        while (aux!=null){
//            if(aux.getBusqueda().getKeyword().equals(busqueda.getKeyword())){
//                aux.setResultados(temp);
//                break;
//            }
//            aux=aux.getSiguiente();
//        }
//    }
//    
//    public Busqueda getBusqueda(String busqueda){
//        CacheNode aux=cima;
//        Busqueda resultado=null;
//        while (aux!=null){
//            if(aux.getBusqueda().getKeyword().equals(busqueda)){
//                resultado=aux.getBusqueda();
//                break;
//            }
//            aux=aux.getSiguiente();
//        }
//        return resultado;
//    }
//    
//    public Pila getResultado(String busqueda){
//        CacheNode aux=cima;
//        Pila resultado=null;
//        while (aux!=null){
//            if(aux.getBusqueda().getKeyword().equals(busqueda)){
//                resultado=aux.getResultados();
//                break;
//            }
//            aux=aux.getSiguiente();
//        }
//        return resultado;
//    }
    
//    public Pila pilaVecesBusquedaEnDocumento(String busqueda){
//        String path = Googolplex.programa.getPathRelativoDeLosDocumentos();
//        File archivosRegistrados = new File(pathRelativoDelPrograma+pathDeRegistros+"ArchivosRegistrados.txt");
//        try (BufferedReader reader = new BufferedReader(new FileReader(archivosRegistrados))) {
//            String linea;
//            while ((linea = reader.readLine()) != null) {
//                String[] documentos = linea.split(",");
//                Date fecha= formatoFecha.parse(documentos[2]+" "+documentos[3]);
//                documentosRegistrados.encolar(new Documento(Integer.parseInt(documentos[0]),documentos[1],fecha,Integer.parseInt(documentos[4])));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException f){
//            f.printStackTrace();
//        }
//    }
    //</editor-fold>
    
    public List<List<String>> listaDePalabrasEnDocumentp(File archivo){
        int counter=0;
        List<String> resultado=new ArrayList<>();
        List<List<String>> resultado2=new ArrayList<>();
        try {
            FileReader lector=new FileReader(archivo);
            try (BufferedReader reader = new BufferedReader(lector)) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    String[] palabras = linea.split("\\s*(\\s|,|\\.)\\s*");
                    for(String palabra:palabras){
                        if(palabra.toLowerCase().equals("to".toLowerCase())){
                            counter++;
                        }
                        resultado.add(palabra);
                    }
                }
                Collections.sort(resultado);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch(IOException e){
            System.err.println(e);
        }
        int end=resultado.size();
        int x=0;
        while(x<end){
            counter++;
            String temp=resultado.get(x);
            try{
                while(resultado.get(x).equals(resultado.get(x+1))){
                    counter++;
                    x++;
                }
            }catch(IndexOutOfBoundsException e){
                
            }
            List<String> temp2=new ArrayList<>();
            temp2.add(Integer.toString(counter));
            temp2.add(temp);
            resultado2.add(temp2);
            counter=0;
            x++;
        }
        for(List palabra:resultado2){
            System.out.println(palabra);
        }
        return resultado2;
    }
    
    public void apilarPalabra(List<String> palabra,String nombreDeArchivo){
        //Nodo CacheNodeContenido usando el indice 1 de la lista para la palabra a buscar y el indice 0 + nombreDeArchivo para apilar ordenadamente el documento añadido 
        CacheNodeContenido temp=existePalabra(palabra.get(1).toLowerCase());
        if(temp!=null){
            temp.getResultados().apilar(Integer.parseInt(palabra.get(0)),nombreDeArchivo);
            
            System.out.println("asd");
        }else{
            CacheNodeContenido nuevo=new CacheNodeContenido(palabra.get(1),new PilaContenidoNodo(Integer.parseInt(palabra.get(0)),nombreDeArchivo));
            if (isEmpty()) {
                cima = nuevo;
            } else {
                nuevo.setSiguiente(cima);
                cima = nuevo;
            }
        }
        System.out.println("asd");

//    }
    }
    
    public CacheNodeContenido existePalabra(String busqueda){
        CacheNodeContenido aux=cima;
        CacheNodeContenido resultado=null;
        while (aux!=null){
            if(aux.getBusqueda().toLowerCase().equals(busqueda)){
                resultado=aux;
                break;
            }
            aux=aux.getSiguiente();
        }
        return resultado;
    }
    
    public void analizar(File nombreDelDocumento){
        List<List<String>> palabrasEnDocumento=listaDePalabrasEnDocumentp(nombreDelDocumento);
        for(List<String> palabra:palabrasEnDocumento){
            apilarPalabra(palabra,nombreDelDocumento.getName());
        }
    }
    
    
}
