package com.estructuras;

public class NodoArbol {
    
    private Documento doc;
    
    private NodoArbol hijoIzq;
    
    private NodoArbol hijoDer;

    public NodoArbol(Documento doc) {
        this.doc = doc;
    }

    public NodoArbol getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(NodoArbol hijoDer) {
        this.hijoDer = hijoDer;
    }

    public NodoArbol getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoArbol hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public Documento getDoc() {
        return doc;
    }

    public void setId(Documento doc) {
        this.doc = doc;
    }

}
