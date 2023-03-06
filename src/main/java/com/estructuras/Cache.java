//Github: https://github.com/Anthaguz/Estructura-de-Datos-Grupo-7
package com.estructuras;

import java.util.Arrays;

public class Cache{
    private CacheNode cima;
    
    public Cache(){
        this.cima=null;
    }
    
    public boolean isEmpty(){
        if (cima==null) {return true;}
        return false;
    }
    
    public void apilar(String[] entrada){
        Busqueda busqueda=new Busqueda(Integer.parseInt(entrada[0]),entrada[1]);
        String[] resultadosDeBusqueda = Arrays.copyOfRange(entrada, 2, entrada.length);
        CacheNode nuevo = new CacheNode(busqueda,resultadosDeBusqueda);
        if (isEmpty()) {cima=nuevo;}
        else {
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
    }
    
}
