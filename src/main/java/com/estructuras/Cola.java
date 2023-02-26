package com.estructuras;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cola {
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    private Nodo frente;
    private Nodo ultimo;
    private int cantidadDeDocumentos;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters">
    public Nodo getFrente() {return frente;}
    public Nodo getUltimo() {return ultimo;}
    public int getCantidadDeDocumentos() {return cantidadDeDocumentos;}
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Setters">
    public void setFrente(Nodo frente) {this.frente = frente;}
    public void setUltimo(Nodo ultimo) {this.ultimo = ultimo;}
    public void setCantidadDeDocumentos(int cantidadDeDocumentos) {this.cantidadDeDocumentos = cantidadDeDocumentos;}
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructores">
                                   
    //</editor-fold>
    
    public Nodo atender(){
        Nodo temp = frente;
        if (frente!=null) {
            frente=frente.getSiguiente();
            temp.setSiguiente(null);
        }
        return temp;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Añadir nodos en diferentes posiciones">
    public void encolar(Documento documento){
        Nodo elemento=new Nodo(documento);
        if(frente==null){
            frente = elemento;
            ultimo = elemento;
        }else{
            ultimo.setSiguiente(elemento);
            ultimo=elemento;
        }
    }

    /*Se encarga de empujar los nodos actuales hacia atras, poniendo el nuevo
    *nodo en la primera posicion.
    */
    public void ponerAlFrente(Documento documento){
        Nodo nuevoFrente=new Nodo(documento);
        nuevoFrente.setSiguiente(frente);
        frente=nuevoFrente;
    }
    //</editor-fold>
    
    public Pila toPila(){
        Pila resultado=new Pila();
        Nodo aux=frente;
        while(aux!=null){
            resultado.apilar(aux.getDocumento());
            aux=aux.getSiguiente();
        }
        return resultado;
    }
    
    public void incrementarNumeroDeBusquedas(int id){
        Nodo temp=frente;
        while (temp!=null){
            if(temp.getDocumento().getNumeroDeDocumento()!=id){temp=temp.getSiguiente();}
            else{
                temp.getDocumento().setNumeroDeBusquedas(temp.getDocumento().getNumeroDeBusquedas()+1);
            }
        }
    }
    
    //<editor-fold defaultstate="collapsed" desc="Buscadores">
    
    //retorna el documento con el nombre buscado
    public Documento encontrarPorNombre(String buscador){
        Documento resultado = null;
        Nodo temp = frente;
        while (temp!=null){
            if(buscador.equals(temp.getDocumento().getNombre())){resultado=temp.getDocumento();}
            temp=temp.getSiguiente();
        }
        return resultado;
    }  
        
    //retorna el documento con el ID buscado
    public Documento encontrarPorNumeroDeDocumento(int numeroDeDocumento){
        Documento resultado = null;
        Nodo temp = frente;
        while (temp!=null){
            if(numeroDeDocumento==temp.getDocumento().getNumeroDeDocumento()){resultado=temp.getDocumento();}
            temp=temp.getSiguiente();
        }
        return resultado;
    }
    
    //retorna una lista de documentos que calcen con la fecha buscada
    public List<Documento> encontrarPorFechaDeIngreso(Date buscador){
        List<Documento> resultado=new ArrayList<Documento>();
        Nodo temp = frente;
        int diferenciaDeFechas=0;
        while (temp!=null){
            diferenciaDeFechas=buscador.compareTo(temp.getDocumento().getFechaAdicion());
            if (diferenciaDeFechas == 0) {
                resultado.add(temp.getDocumento());
            }
            temp=temp.getSiguiente();
        }
        return resultado;
    }
    //</editor-fold>
    
    public boolean esVacia(){
        if (frente==null){return true;}
        return false;
    }
    
    public Documento extraer(int numeroDeDocumento){
        if(esVacia()){return null;}
        Documento extraido=null;
        Nodo temp=frente.getSiguiente();
        Nodo anterior=frente;
        if (anterior.getDocumento().getNumeroDeDocumento()==numeroDeDocumento){
            extraido= anterior.getDocumento();
        }
        while (temp !=null){
            if(extraido!=null){break;}
            if(temp.getDocumento().getNumeroDeDocumento()==numeroDeDocumento){
                extraido= temp.getDocumento();
            }
            anterior=temp;
            temp=temp.getSiguiente();
        }
        return extraido;
    }
    
    public List<String[]> imprimirCola(){
        List<String[]> respuesta=new ArrayList<>();
        Nodo temp = frente;
        while (temp!=null){
            String contenidoDeNodo=temp.toString();
            String[] tostring=contenidoDeNodo.split(",");
            respuesta.add(tostring);
            temp=temp.getSiguiente();
        }
        return respuesta;
    }
//      
//    

//    

//    
//    /*

//    
//    
//    public int atenderPrimero(){
//        int x=frente.getDocumento();
//        frente=frente.getSiguiente();
//        return x;
//    }  
//    
//    /*
//    *Metodo auxiliar que se encarga de ordenar los nodos basado en el
//    *dato contenido por el nodo. Si el dato del nodo de referencia menor
//    *que el nodo actualmente al frente, entonces el metodo poner al frente
//    *empuja a los demas nodos un espacio atras. Si no, entonces temporalmente
//    *quita el nodo al frente y comprueba contra el segundo, tercero, etc.
//    *Una vez el nodo de referencia encuentra su posicion adecuada, el nodo
//    *frontal inicial se vuelve a poner en su posicion correcta.
//    *
//    *Para ver la funcionalidad, quitar el simbolo de comentario en
//    *imprimirCola()
//    */
//    public void insertarOrdenadoMenorAMayor(Cola cola, int nodoDeReferencia){  
//        if (cola.esVacia() || nodoDeReferencia < cola.frente.getDocumento())  
//        {  
//            cola.ponerAlFrente(new Nodo(nodoDeReferencia));
//            System.out.println("Procesando:"+nodoDeReferencia+" PonerAlFrente - Ultimo:"+getUltimo()+" Frente:"+getFrente()+" - "+imprimirCola());
//            return;  
//        }  
//        if (frente.getSiguiente()==null){
//            setUltimo(frente);
//        }
//        int x=getUltimo().getDocumento();
//        if (nodoDeReferencia>=x){
//            Nodo temp=new Nodo(nodoDeReferencia);
//            ultimo.setSiguiente(temp);
//            ultimo=temp;
//            System.out.println("Procesando:"+nodoDeReferencia+" AlFinal - Ultimo:"+getUltimo()+" Frente:"+getFrente()+" - "+imprimirCola());
//            return;
//        }
//        int temp = cola.atenderPrimero();  
//        System.out.println("Procesando:"+nodoDeReferencia+" QuitarDelFrente - Ultimo:"+getUltimo()+" Frente:"+getFrente()+" - "+imprimirCola());
//        insertarOrdenadoMenorAMayor(cola, nodoDeReferencia);   
//        cola.ponerAlFrente(new Nodo(temp));  
//        System.out.println("Procesando:"+nodoDeReferencia+" IFalse - Ultimo:"+getUltimo()+" Frente:"+getFrente()+" - "+imprimirCola());
//    }  
//    
//    
//    /*
//    *Metodo recursivo que desmantela la Cola en Nodos independientes y 
//    *construye una cola auxiliar que los ordena de menor a mayor con el
//    *metodo insertarOrdenarMenorAMayor.
//    *Para ver la funcionalidad, quitar el simbolo de comentario en
//    *imprimirCola()
//    */
//    public void ordenarPilaMenorAMayor(Cola cola)  
//    {  
//        System.out.println("O - Ultimo:"+getUltimo()+" Frente:"+getFrente()+" - "+imprimirCola());
//        if (cola.esVacia()) {return;}  
//        int nodoTemporal = cola.atenderPrimero();  
//        ordenarPilaMenorAMayor(cola);  
//        insertarOrdenadoMenorAMayor(cola, nodoTemporal);  
//    }      
}
