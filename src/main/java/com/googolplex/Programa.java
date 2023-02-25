/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.googolplex;

import GUI.Create_Doc;
import com.estructuras.Cola;

 public class Programa {
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    private Cola documentosRegistrados;
    //</editor-fold>
    
    
    
    
    public void insertarArchivo(){
       Create_Doc createDOC = new Create_Doc();
       createDOC.interfazG();
    }


    //<editor-fold defaultstate="collapsed" desc="Metodo principal donde corre todo el programa">
    public void run(){
        insertarArchivo();
    }
    //</editor-fold>
}
