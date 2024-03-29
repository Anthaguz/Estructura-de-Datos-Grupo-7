//Github: https://github.com/Anthaguz/Estructura-de-Datos-Grupo-7
package com.estructuras;

import com.googolplex.Googolplex;
import java.util.ArrayList;
import java.util.List;

public class CacheNode{
    private Busqueda busqueda;
    private Pila resultados;
    private CacheNode siguiente;

    //<editor-fold defaultstate="collapsed" desc="Getters">
    public Busqueda getBusqueda(){return busqueda;}
    public Pila getResultados(){return resultados;}
    public CacheNode getSiguiente(){return siguiente;}
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Setters">
    public void setBusqueda( Busqueda busqueda ){this.busqueda = busqueda;}
    public void setResultados( Pila resultados ){this.resultados = resultados;}
    public void setSiguiente( CacheNode siguiente ){this.siguiente = siguiente;}
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public CacheNode(){}
    public CacheNode( Busqueda busqueda, Pila resultados ){
        this.busqueda = busqueda;
        this.resultados=resultados;
        this.resultados.ordenarPilaMayorAMenor(this.resultados);
        
    }
    //</editor-fold>

    @Override
    public String toString(){
        String resultado=busqueda.toString()+",";
        List<String[]> documentos=new ArrayList<>();
        documentos=resultados.imprimirPila();
        for(String[] documento:documentos){
            resultado+=documento[0];
        }
        return "CacheNode{" + "busqueda=" + busqueda + ", resultados=" + resultados + ", siguiente=" + siguiente + '}';
    }

    
}
