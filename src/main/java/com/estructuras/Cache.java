//Github: https://github.com/Anthaguz/Estructura-de-Datos-Grupo-7
package com.estructuras;

import com.googolplex.Googolplex;
import java.util.Arrays;

public class Cache{
    //El cache solo va a guardar las 10 busquedas mas comunes, con la intension de que sea un cache manejable
    //esto permitiria ordenarlos y llevar un control, si no el cache podria crecer infinitamente.
    //Esto quiere decir que los nodos del cache necesitan una propiedad integer que lleve un control de cuantas veces se ha buscado todo.
    
    //Pensandolo nuevamente, esto de arriba nunca funcionaria, pues si se hiciera asi, el cache siempre mostraria los 10 documentos mas buscados.
    //Suena bien, pero si yo hago una busqueda nueva (que no esta en el top 10) entonces su numero de busquedas siempre va a ser 1.
    //Esto significa, que si de 11 busquedas, la menos buscada se elimina, entonces la busqueda que acabamos de hacer se eliminaria inmediatamente.
    //Por eso, ninguna busqueda reemplazaria a las actuales, y solo las primeras 10 busquedas en ser buscadas mas de una vez se almacenarian.
    //Por esto, la estrategia va a ser almacenar todas las busquedas indiscriminadamente, pero la cima va a ser siempre la busqueda "mas buscada".
    //Esto hara que el cache tenga un mejor rendimiento para las busquedas mas frecuentes.
    
    //La desventaja de esto es que el consumo de memoria incrementara bastante por cada busqueda hecha, pues todo se maneja en memoria.
    //Esta es una aplicacion que requiere un uso de base de datos adecuado para obtener el mejor rendimiento y utilizacion de recursos. 
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
        Pila resultadoDeBusqueda=Googolplex.programa.getDocumentosMasBuscados().encontrarTodoDocumentoQueCalce(entrada[1].toLowerCase());
        CacheNode nuevo = new CacheNode(busqueda,resultadoDeBusqueda);
        if (isEmpty()) {cima=nuevo;}
        else {
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
    }
    
    public boolean existeBusquedaReciente(String busqueda){
        CacheNode aux=cima;
        boolean resultado=false;
        while (aux!=null){
            if(aux.getBusqueda().getKeyword().equals(busqueda)){
                resultado=true;
                break;
            }
            aux=aux.getSiguiente();
        }
        return resultado;
    }
    
    public void modificarBusquedaAnterior(Busqueda busqueda){
        Pila temp=Googolplex.programa.getDocumentosMasBuscados().encontrarTodoDocumentoQueCalce(busqueda.getKeyword());
        CacheNode aux=cima;
        while (aux!=null){
            if(aux.getBusqueda().getKeyword().equals(busqueda.getKeyword())){
                aux.setResultados(temp);
                break;
            }
            aux=aux.getSiguiente();
        }
    }
    
    public Busqueda getBusqueda(String busqueda){
        CacheNode aux=cima;
        Busqueda resultado=null;
        while (aux!=null){
            if(aux.getBusqueda().getKeyword().equals(busqueda)){
                resultado=aux.getBusqueda();
                break;
            }
            aux=aux.getSiguiente();
        }
        return resultado;
    }
    
    public Pila getResultado(String busqueda){
        CacheNode aux=cima;
        Pila resultado=null;
        while (aux!=null){
            if(aux.getBusqueda().getKeyword().equals(busqueda)){
                resultado=aux.getResultados();
                break;
            }
            aux=aux.getSiguiente();
        }
        return resultado;
    }
}
