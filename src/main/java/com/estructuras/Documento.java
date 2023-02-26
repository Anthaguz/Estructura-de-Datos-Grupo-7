package com.estructuras;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Documento {

    //<editor-fold defaultstate="collapsed" desc="Variables">
    private int numeroDeDocumento;
    private int numeroDeBusquedas;//Se incrementa al abrir el archivo, no al buscarlo
    private String nombre;
    private String fechaAdicion;
    private String horaAdicion;
    //</editor-fold>
 
    //<editor-fold defaultstate="collapsed" desc="Getters">
    public int getNumeroDeDocumento() {return numeroDeDocumento;}
    public String getNombre() {return nombre;}
    public Date getFechaAdicion() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha;
        try {
            fecha = formatoFecha.parse(fechaAdicion);
            return fecha;
        } catch (ParseException ex) {
            Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Date getHoraAdicion() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("HH:mm:ss");
        Date fecha;
        try {
            fecha = formatoFecha.parse(fechaAdicion);
            return fecha;
        } catch (ParseException ex) {
            Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int getNumeroDeBusquedas(){return numeroDeBusquedas;}
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Setters">
    public void setNumeroDeDocumento(int numeroDeDocumento) {this.numeroDeDocumento = numeroDeDocumento;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setFecha(Date fecha){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        setFechaAdicion(formatoFecha.format(fecha));
        setHoraAdicion(formatoHora.format(fecha));
    }
    public void setFechaAdicion(String fechaAdicion) {this.fechaAdicion = fechaAdicion;}
    public void setHoraAdicion(String horaAdicion) {this.horaAdicion = horaAdicion;}
    public void setNumeroDeBusquedas(int numeroDeBusquedas) {this.numeroDeBusquedas = numeroDeBusquedas;}
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Documento(){}
    public Documento(int numeroDeDocumento, String nombre, Date fecha) {
       this.numeroDeDocumento = numeroDeDocumento;
       this.nombre = nombre;
       setFecha(fecha);
       numeroDeBusquedas=0;
    }
    public Documento(int numeroDeDocumento, String nombre, Date fecha,int busquedas) {
       this.numeroDeDocumento = numeroDeDocumento;
       this.nombre = nombre;
       setFecha(fecha);
       numeroDeBusquedas=busquedas;
    }
    
    //</editor-fold>

    public String toStringParaTabla(){
        return numeroDeDocumento+","+nombre+","+fechaAdicion+"     "+horaAdicion;
    }
    
    @Override
    public String toString() {
        return numeroDeDocumento + "," + nombre + "," + fechaAdicion +","+horaAdicion+","+numeroDeBusquedas;
    }
}
