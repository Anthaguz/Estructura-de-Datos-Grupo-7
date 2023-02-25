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
    public Nodo() {
        this.siguiente = null;
    }
    //</editor-fold>
}
