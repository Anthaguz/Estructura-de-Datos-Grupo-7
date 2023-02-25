package com.estructuras;

import java.util.Date;

public class Documento {

    private int numeroDeDocumento;
    private String nombre;
    private Date fechaAdicion;

    //<editor-fold defaultstate="collapsed" desc="Getters">
    public int getNumeroDeDocumento() {return numeroDeDocumento;}
    public String getNombre() {return nombre;}
    public Date getFechaAdicion() {return fechaAdicion;}
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Setters">
    public void setNumeroDeDocumento(int numeroDeDocumento) {this.numeroDeDocumento = numeroDeDocumento;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setFechaAdicion(Date fechaAdicion) {this.fechaAdicion = fechaAdicion;}
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Documento(){}
    public Documento(int numeroDeDocumento, String nombre, Date fechaAdicion) {
       this.numeroDeDocumento = numeroDeDocumento;
       this.nombre = nombre;
       this.fechaAdicion = fechaAdicion;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return numeroDeDocumento + "," + nombre + "," + fechaAdicion;
    }
}
