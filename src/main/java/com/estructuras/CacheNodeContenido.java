//Github: https://github.com/Anthaguz/Estructura-de-Datos-Grupo-7
package com.estructuras;

import com.googolplex.Googolplex;
import java.util.ArrayList;
import java.util.List;

public class CacheNodeContenido{
    private String busqueda;
    private PilaContenido resultados;
    private CacheNodeContenido siguiente;

    //<editor-fold defaultstate="collapsed" desc="Getters">
    public String getBusqueda(){return busqueda;}
    public PilaContenido getResultados(){return resultados;}
    public CacheNodeContenido getSiguiente(){return siguiente;}
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Setters">
    public void setString( String busqueda ){this.busqueda = busqueda;}
    public void setResultados( PilaContenido resultados ){this.resultados = resultados;}
    public void setSiguiente( CacheNodeContenido siguiente ){this.siguiente = siguiente;}
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public CacheNodeContenido(){}
    public CacheNodeContenido( String busqueda, PilaContenidoNodo resultados ){
        this.busqueda = busqueda;
        this.resultados=new PilaContenido();
        this.resultados.apilar(resultados);
        this.resultados.ordenarPilaMayorAMenor(this.resultados);
        
    }
    //</editor-fold>
    
    public Pila getPilaDeDocumentosParaTabla(){
        Pila temp=resultados.getPilaDeDocumentosParaTabla(busqueda);
        return temp;
    }
    
    @Override
    public String toString(){
        String resultado=busqueda.toString()+",";
        List<String[]> documentos=new ArrayList<>();
//        documentos=resultados.imprimirPilaContenido();
        for(String[] documento:documentos){
            resultado+=documento[0];
        }
        return "CacheNode{" + "busqueda=" + busqueda + ", resultados=" + resultados + ", siguiente=" + siguiente + '}';
    }

    
}
