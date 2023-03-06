//Github: https://github.com/Anthaguz/Estructura-de-Datos-Grupo-7
package com.estructuras;

public class Busqueda{
    private int cantidad;
    private String keyword;

    //<editor-fold defaultstate="collapsed" desc="Getters">
    public int getCantidad(){
        return cantidad;
    }

    public String getKeyword(){
        return keyword;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Setters">
    public void setCantidad( int cantidad ){
        this.cantidad = cantidad;
    }

    public void setKeyword( String keyword ){
        this.keyword = keyword;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Busqueda( String keyword ){
        this.cantidad=1;
        this.keyword = keyword;
    }
    
    public Busqueda( int cantidad,String keyword ){
        this.cantidad = cantidad;
        this.keyword = keyword;
    }
    //</editor-fold>

    @Override
    public String toString(){
        return Integer.toString(cantidad)+","+keyword; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
