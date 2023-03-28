//Github: https://github.com/Anthaguz/Estructura-de-Datos-Grupo-7
package com.estructuras;

import com.googolplex.Googolplex;
import java.util.ArrayList;
import java.util.List;

public class PilaContenido {
    private PilaContenidoNodo cima;
    
    public PilaContenido(){
        this.cima=null;
    }
    
    public boolean esVacia(){
        if (cima==null) {return true;}
        return false;
    }
    
    public void apilar(int cantidad,String nombreDelArchivo){
        PilaContenidoNodo nuevo = new PilaContenidoNodo(cantidad,nombreDelArchivo);
        if (esVacia()) {cima=nuevo;}
        else {
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
    }
    
    public void apilar(PilaContenidoNodo nuevo){
        if (esVacia()) {cima=nuevo;}
        else {
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
    }
    
    public void prepararDocumentos(PilaContenido pila, Pila temp){
        PilaContenidoNodo nodo=pila.extraer();
        if(!pila.esVacia())prepararDocumentos(pila, temp);
        Documento doc=Googolplex.programa.getDocumentosRegistrados().encontrarPorNombre(nodo.getDocumento());
        if(doc!=null){
            temp.apilar(doc);
        }
        pila.apilar(nodo);
    }
    
    public Pila getPilaDeDocumentosParaTabla(String busqueda){
        Pila temp=new Pila();
        prepararDocumentos(this,temp);
        return temp;
//        PilaContenidoNodo aux=cima;
//        while(aux!=null){
//            Documento tempDoc = Googolplex.programa.getDocumentosRegistrados().encontrarPorNombre(aux.getDocumento());
//            if(tempDoc!=null){
//                
//            }
//        }
    }
        //<editor-fold defaultstate="collapsed" desc="Ordenar de mayor a menor">

    public void insertarOrdenadoMayorAMenor(PilaContenido pila, PilaContenidoNodo cima)  
    {  
        if (pila.esVacia() || cima.getCantidad() > pila.cima.getCantidad())  
        {  
            pila.apilar(cima);  
            return;  
        }  
        PilaContenidoNodo temp = pila.extraer();  
        insertarOrdenadoMayorAMenor(pila, cima);   
        pila.apilar(temp);  
    }  
    
    public void ordenarPilaMayorAMenor(PilaContenido pila)  
    {  
        if (pila.esVacia()) {return;}  
        PilaContenidoNodo temp = pila.extraer();   
        ordenarPilaMayorAMenor(pila);  
        insertarOrdenadoMayorAMenor(pila, temp);  
    }  
    
    public PilaContenidoNodo extraer(){
        PilaContenidoNodo x=cima;
        cima=cima.getSiguiente();
        return x;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Podria usarse despues">

//    
//    public void apilar(int n){
//        Documento d= new Documento();
//        //pendiente: recibir los datos del documento
//        PilaContenidoNodo nuevo = new PilaContenidoNodo();
//        nuevo.setDocumento(d);
//        if (esVacia()) {cima=nuevo;}
//        else {
//            nuevo.setSiguiente(cima);
//            cima = nuevo;
//        }
//    }
//    
//    public void apilar(Documento d){
//        PilaContenidoNodo nuevo = new PilaContenidoNodo();
//        nuevo.setDocumento(d);
//        if (esVacia()) {cima=nuevo;}
//        else {
//            nuevo.setSiguiente(cima);
//            cima = nuevo;
//        }
//    }
//    

//    
//    public List<String[]> imprimirPilaContenido(){
//        List<String[]> respuesta=new ArrayList<>();
//        PilaContenidoNodo temp = cima;
//        while (temp!=null){
//            String contenidoDePilaContenidoNodo=temp.toString();
//            String[] tostring=contenidoDePilaContenidoNodo.split(",");
//            respuesta.add(tostring);
//            temp=temp.getSiguiente();
//        }
//        return respuesta;
//    }
//    
//    public PilaContenido encontrarTodoDocumentoQueCalce(String buscador){
//        PilaContenido resultado = new PilaContenido();
//        PilaContenidoNodo aux=cima;
//        while(aux!=null){
//            if((aux.getDocumento().getNombre().toLowerCase()).contains(buscador.toLowerCase())){
//                resultado.apilar(aux.getDocumento());
//            }
//            aux=aux.getSiguiente();
//        }
//        resultado.ordenarPilaMayorAMenor(resultado);
//        return resultado;
//    }
//    
//    public void incrementarNumeroDeBusquedas(int id){
//        PilaContenidoNodo temp=cima;
//        while (temp!=null){
//            if(temp.getDocumento().getNumeroDeDocumento()!=id){temp=temp.getSiguiente();}
//            else{
//                temp.getDocumento().setNumeroDeBusquedas(temp.getDocumento().getNumeroDeBusquedas()+1);
//                break;
//            }
//        }
//    }
    
//    public boolean encontrarNumero(int numero){
//        if(esVacia()){return false;}
//        PilaContenidoNodo aux = cima;
//        while (aux !=null){
//            if (numero==aux.getDocumento().getNumero()) {return true;}
//            aux=aux.getSiguiente();
//        }
//        return false;
//    }
//    
//    public void extraerNumero(int x){
//        if(esVacia()){return;}
//        PilaContenidoNodo aux = cima;
//        PilaContenidoNodo anterior = aux;
//        boolean cambios=false;
//        if (aux.getDocumento().getNumero()==x){
//            cima=aux.getSiguiente();
//            aux=cima;
//            anterior=aux;
//        }
//        while (aux !=null){
//            if (anterior!=aux){
//                if (x==aux.getDocumento().getNumero()){
//                    anterior.setSiguiente(aux.getSiguiente());
//                    cambios=true;
//                    System.out.println("\nSi hubieron cambios, esta es la pila resultante:");
//                }
//                anterior=aux;
//                aux=aux.getSiguiente();
//            }else{
//                anterior=aux;
//                aux=aux.getSiguiente();}
//        }
//        if (cambios){imprimirPila();}
//        else {System.out.println("\nNo hubieron cambios");}       
//    }
//    
//

//    

//    
//    public void insertarOrdenadoMenorAMayor(Pila pila, int cima)  
//    {  
//        if (pila.esVacia() || cima < pila.cima.getDocumento().getNumero())  
//        {  
//            pila.apilar(cima);  
//            return;  
//        }  
//        int temp = pila.extraer();  
//        insertarOrdenadoMenorAMayor(pila, cima);   
//        pila.apilar(temp);  
//    }  
//    
//    public void ordenarPilaMenorAMayor(Pila pila)  
//    {  
//        if (pila.esVacia()) {return;}  
//        int temp = pila.extraer();   
//        ordenarPilaMenorAMayor(pila);  
//        insertarOrdenadoMenorAMayor(pila, temp);  
//    }  
//    
//    public void testextraer(Documento dato){
//        System.out.println("\nTest2: "+dato.getNumero());
//        dato.setNumero(dato.getNumero()+1);
//        System.out.println("\nTest3: "+dato.getNumero());
//    }
    //</editor-fold>
}
