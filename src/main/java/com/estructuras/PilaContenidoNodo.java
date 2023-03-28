//Github: https://github.com/Anthaguz/Estructura-de-Datos-Grupo-7

package com.estructuras;

public class PilaContenidoNodo {

    private String documento;
    private int cantidad;
    private PilaContenidoNodo siguiente;


    
    //<editor-fold defaultstate="collapsed" desc="Getters">
    public String getDocumento() {return documento;}
    public PilaContenidoNodo getSiguiente() {return siguiente;}
    public int getCantidad() {return cantidad;}
    
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Setters">
    public void setSiguiente(PilaContenidoNodo siguiente) {this.siguiente = siguiente;}
    public void setDocumento(String documento) {this.documento = documento;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}
    
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public PilaContenidoNodo() {}
    
    public PilaContenidoNodo(String documento,int cantidad) {
        this.documento = documento;
        this.cantidad=cantidad;
    }
    //</editor-fold>
    
    @Override
    public String toString() {
        return documento;
    }
    
}
