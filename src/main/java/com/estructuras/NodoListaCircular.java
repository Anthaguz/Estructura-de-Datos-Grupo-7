/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estructuras;

public class NodoListaCircular {
    
    private String dato;
    
    private NodoListaCircular siguiente;

    public NodoListaCircular(String dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return this.dato.toString();
    }

    /**
     * Get the value of siguiente
     *
     * @return the value of siguiente
     */
    public NodoListaCircular getSiguiente() {
        return siguiente;
    }

    /**
     * Set the value of siguiente
     *
     * @param siguiente new value of siguiente
     */
    public void setSiguiente(NodoListaCircular siguiente) {
        this.siguiente = siguiente;
    }


    /**
     * Get the value of dato
     *
     * @return the value of dato
     */
    public String getDato() {
        return dato;
    }

    /**
     * Set the value of dato
     *
     * @param dato new value of dato
     */
    public void setDato(String dato) {
        this.dato = dato;
    }

}
