package com.estructuras;

public class Cola {
    //<editor-fold defaultstate="collapsed" desc="Declaracion de variables">
    private Nodo frente;
    private Nodo ultimo;
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters">
    public Nodo getFrente() {return frente;}
    public Nodo getUltimo() {return ultimo;}
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Setters">
    public void setFrente(Nodo frente) {this.frente = frente;}
    public void setUltimo(Nodo ultimo) {this.ultimo = ultimo;}
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public void queue(Nodo elemento){
        if (frente== null) {
            frente=elemento;
            ultimo=elemento;
        }
    }
    //</editor-fold>
    
    public Nodo atender(){
        Nodo temp = frente;
        if (frente!=null) {
            frente=frente.getSiguiente();
            temp.setSiguiente(null);
        }
        return temp;
    }
    
    public void encolarSinOrden(Nodo elemento){
        if(frente==null){
            frente = elemento;
            ultimo = elemento;
        }else{
            ultimo.setSiguiente(elemento);
            ultimo=elemento;
        }
    }
    
    
//    public String imprimirCola(){
//        String respuesta="";
//        Nodo temp = frente;
//        while (temp!=null){
//            respuesta += temp.toString()+",";
//            temp=temp.getSiguiente();
//        }
//        return respuesta;
//    }
//    
//    public boolean encuentra(int x){
//        boolean found = false;
//        Nodo temp = frente;
//        while (temp!=null){
//            if(x==temp.getDocumento()){return true;}
//            temp=temp.getSiguiente();
//        }
//        return false;
//    }    
//    
//    public void extraer(int x){
//        if(frente==null){return;}
//        boolean cambios=false;
//        Nodo temp=frente.getSiguiente();
//        Nodo anterior=frente;
//        if (anterior.getDocumento()==x){
//            anterior=temp;
//            frente=temp;
//            temp=temp.getSiguiente();            
//            cambios=true;
//        }
//        while (temp !=null){
//            if(temp.getDocumento()==x){
//                anterior.setSiguiente(temp.getSiguiente());
//                cambios=true;
//            }
//            anterior=temp;
//            temp=temp.getSiguiente();
//        }
//        if (cambios){System.out.println(imprimirCola());}
//        else {System.out.println(imprimirCola());
//        System.out.println("\nNo hubieron cambios"); }
//    }
//    
//    public boolean esVacia(){
//        if (frente==null){return true;}
//        return false;
//    }
//    
//    /*
//    *Se encarga de empujar los nodos actuales hacia atras, poniendo el nuevo
//    *nodo en la primera posicion.
//    */
//    public void ponerAlFrente(Nodo nuevoFrente){
//        nuevoFrente.setSiguiente(frente);
//        frente=nuevoFrente;
//    }
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
