//Github: https://github.com/Anthaguz/Estructura-de-Datos-Grupo-7

package com.estructuras;

public class Nodo {

    private Documento documento;
    private Nodo siguiente;


    
    //<editor-fold defaultstate="collapsed" desc="Getters">
    public Documento getDocumento() {return documento;}
    public Nodo getSiguiente() {return siguiente;}
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Setters">
    public void setSiguiente(Nodo siguiente) {this.siguiente = siguiente;}
    public void setDocumento(Documento documento) {this.documento = documento;}
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Nodo() {}
    
    
    //</editor-fold>

    public Nodo(Documento documento) {
        this.documento = documento;
    }
    
    @Override
    public String toString() {
        return documento.toStringParaTabla();
    }
    
}
