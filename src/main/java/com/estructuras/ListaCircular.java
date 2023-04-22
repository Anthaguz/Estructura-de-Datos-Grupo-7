package com.estructuras;

public class ListaCircular {
    
    private NodoListaCircular cabeza;
    
    private NodoListaCircular ultimo;

    /**
     * Get the value of ultimo
     *
     * @return the value of ultimo
     */
    public NodoListaCircular getUltimo() {
        return ultimo;
    }
    
    /**
     * Set the value of ultimo
     *
     * @param ultimo new value of ultimo
     */
    public void setUltimo(NodoListaCircular ultimo) {
        this.ultimo = ultimo;
    }


    /**
     * Get the value of cabeza
     *
     * @return the value of cabeza
     */
    public NodoListaCircular getCabeza() {
        return cabeza;
    }

    /**
     * Set the value of cabeza
     *
     * @param cabeza new value of cabeza
     */
    public void setCabeza(NodoListaCircular cabeza) {
        this.cabeza = cabeza;
    }
    
    public void insertaPalabrasDeDocumento(String p)
    {
        //Aquí verificamos si la cabeza es nula, lo cual significa que la lista está vacía
        if(cabeza == null)
        {
            cabeza = new NodoListaCircular(p);
            ultimo = cabeza;
            ultimo.setSiguiente(cabeza);
        }
        else
        {
            cabeza.setSiguiente(new NodoListaCircular(p));
            ultimo=cabeza.getSiguiente();
            ultimo.setSiguiente(cabeza);
        }
    }

    @Override
    public String toString() {
        String respuesta = "Lista circular: \n";
        
        //Aquí vamos a recorrer el contenido de la lista
        
        NodoListaCircular aux = cabeza;
        
        if(aux != null)
        {
            respuesta += aux.toString() + "\n";
            aux = aux.getSiguiente();
            //La lista tiene elementos
            while(aux != cabeza)
            {
                respuesta += aux.toString() + "\n";
                aux = aux.getSiguiente();
            }
        }
        else
        {
            //La lista no tiene elementos
            respuesta += "Vacía";
        }
        
        return respuesta; 
    }
    
    


    
    
    
    
    
//    public boolean existe(int id){
//        boolean resultado=false;
//        NodoListaCircular aux=cabeza;
//        while (aux!=cabeza){
//            if(aux.getDato().getId()==id){resultado=true;}
//            aux=aux.getSiguiente();
//        }
//        return resultado;
//    }
//    
//    public Persona encuentra(int id){
//        Persona resultado=null;
//        NodoListaCircular aux=cabeza;
//        while (aux!=cabeza){
//            if(aux.getDato().getId()==id){resultado=aux.getDato();break;}
//            aux=aux.getSiguiente();
//        }
//        return resultado;
//    }
//    
//    public void modifica (Persona p){
//        if(cabeza.getDato().getId()==p.getId()){cabeza.getDato().setNombre(p.getNombre());}
//        NodoListaCircular aux=cabeza.getSiguiente();
//        while (aux!=cabeza){
//            if(aux.getDato().getId()==p.getId()){aux.getDato().setNombre(p.getNombre());break;}
//            aux=aux.getSiguiente();
//        }
//    }
//    
//    public void elimina (int id){
//        if(cabeza.getDato().getId()==id){
//            cabeza=cabeza.getSiguiente();
//            ultimo.setSiguiente(cabeza);
//        }
//        NodoListaCircular aux=cabeza;
//        while (aux!=cabeza||cabeza.getDato().getId()!=id){
//            if(aux.getSiguiente().getDato().getId()==id){
//                NodoListaCircular aux2=aux.getSiguiente();
//                aux.setSiguiente(aux.getSiguiente().getSiguiente());
//                aux2=null;
//                break;
//            }
//            aux=aux.getSiguiente();
//            if(aux.getSiguiente()==cabeza)break;
//        }
//    }
//    
//    public Persona extrae(int id){
//        Persona resultado=null;
//        if(cabeza==null){return resultado;}
//        if(cabeza.getDato().getId()==id){
//            resultado=cabeza.getDato();
//            cabeza.setSiguiente(cabeza.getSiguiente());
//            ultimo.setSiguiente(cabeza);
//        }
//        NodoListaCircular aux=cabeza.getSiguiente();
//        while (aux!=cabeza){
//            if(aux.getSiguiente().getDato().getId()==id){
//                resultado=aux.getSiguiente().getDato();
//                aux.setSiguiente(aux.getSiguiente().getSiguiente());
//                break;
//            }
//            aux=aux.getSiguiente();
//        }
//        
//        return resultado;
//    }
}
