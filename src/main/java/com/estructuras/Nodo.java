package com.estructuras;

public class Nodo {

    private Documento documento;
    private Nodo siguiente;

    public Nodo() {
        this.siguiente = null;
    }
    
    //Getters
    public Documento getDocumento() {return documento;}
    public Nodo getSiguiente() {return siguiente;}

    //Setters
    public void setSiguiente(Nodo siguiente) {this.siguiente = siguiente;}
    public void setDocumento(Documento documento) {this.documento = documento;}
}
