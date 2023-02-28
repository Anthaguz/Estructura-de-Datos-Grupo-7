//Github: https://github.com/Anthaguz/Estructura-de-Datos-Grupo-7

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
    
    /**
     * Obtiene el identificador del Documento.
     *
     * @return Un integer con el numero del documento
     */
    public int getNumeroDeDocumento() {return numeroDeDocumento;}
    /**
     * Obtiene el nombre del Documento.
     *
     * @return String con el nombre del documento
     */
    public String getNombre() {return nombre;}
    /**
     * Obtiene la fecha de adicion sin la hora.
     *
     * @return el contenido de la fecha tipo Date y con el formato "yyyy-MM-dd"
     */
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
    /**
     * Obtiene la hora de adicion sin la fecha.
     *
     * @return el contenido de la hora tipo Date y con el formato "HH:mm:ss"
     */
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
    /**
     * Obtiene el numero de veces que el documento ha sido abierto.
     *
     * @return int de la cantidad de veces que ha sido abierto
     */
    public int getNumeroDeBusquedas(){return numeroDeBusquedas;}
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Setters">
    
    /**
     * Utilizado para especificar el numero de documento.
     *
     * @param numeroDeDocumento  no puede ser null
     */
    public void setNumeroDeDocumento(int numeroDeDocumento) {this.numeroDeDocumento = numeroDeDocumento;}
    /**
     * Utilizado para especificar el nombre del documento.
     *
     * @param nombre  no puede ser null
     */
    public void setNombre(String nombre) {this.nombre = nombre;}
    /**
     * Utilizado para especificar el hora de adicion del documento.
     *
     * @param fecha  formato: "yyyy-MM-dd HH:mm:ss", no puede ser null
     */
    public void setFecha(Date fecha){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        setFechaAdicion(formatoFecha.format(fecha));
        setHoraAdicion(formatoHora.format(fecha));
    }
    private void setFechaAdicion(String fechaAdicion) {this.fechaAdicion = fechaAdicion;}
    private void setHoraAdicion(String horaAdicion) {this.horaAdicion = horaAdicion;}
    /**
     * Utilizado para especificar la cantidad de veces que el documento 
     * ha sido buscado/abierto.
     *
     * @param numeroDeBusquedas  ((documento).getNumeroDeBusquedas+1), no puede ser null
     */
    public void setNumeroDeBusquedas(int numeroDeBusquedas) {this.numeroDeBusquedas = numeroDeBusquedas;}
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea un objeto de tipo Documento. Este es un constructor 
     * vacio sin parametros.
     *
     */
    public Documento(){}
    /**
     * Crea un objeto de tipo Documento.
     *
     * @param numeroDeDocumento  int que deberia provenir de la 
     * variable global consecutivoDeDocumentos+1, not null
     * @param nombre  String con el nombre del documento, not null
     * @param fecha  Date con el formato "yyyy-MM-dd HH:mm:ss", not null
     */
    public Documento(int numeroDeDocumento, String nombre, Date fecha) {
       this.numeroDeDocumento = numeroDeDocumento;
       this.nombre = nombre;
       setFecha(fecha);
       numeroDeBusquedas=0;
    }
    /**
     * Crea un objeto de tipo Documento.
     *
     * @param numeroDeDocumento  int que deberia provenir de la 
     * variable global consecutivoDeDocumentos+1, not null
     * @param nombre  String con el nombre del documento, not null
     * @param fecha  Date con el formato "yyyy-MM-dd HH:mm:ss", not null
     * @param busquedas  int que lleva la cuenta de busquedas por documento, not null
     */
    public Documento(int numeroDeDocumento, String nombre, Date fecha,int busquedas) {
       this.numeroDeDocumento = numeroDeDocumento;
       this.nombre = nombre;
       setFecha(fecha);
       numeroDeBusquedas=busquedas;
    }
    
    //</editor-fold>

    /**
     * Da formato al documento en un String para ser añadido a la tabla.
     *
     * @return un String que representa el objeto Documento
     */
    public String toStringParaTabla(){
        return numeroDeDocumento+","+nombre+","+fechaAdicion+"     "+horaAdicion;
    }
    
    /**
     * Da formato al documento en un String para ser añadido a el registro permanente.
     *
     * @return un String que representa el objeto Documento
     */
    @Override
    public String toString() {
        return numeroDeDocumento + "," + nombre + "," + fechaAdicion +","+horaAdicion+","+numeroDeBusquedas;
    }
}
