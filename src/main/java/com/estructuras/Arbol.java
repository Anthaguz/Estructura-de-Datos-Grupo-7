package com.estructuras;

import javax.swing.JOptionPane;

public class Arbol {
    private NodoArbol raiz;
    
    public void inserta(Documento x){        
        if(raiz == null){
            raiz = new NodoArbol(x);
        }else{
            insertaRecursivo(raiz, x);
        }
    }
    
    public void insertaRecursivo(NodoArbol n, Documento x){
        if(x.getNumeroDeDocumento()==n.getDoc().getNumeroDeDocumento()){
            JOptionPane.showMessageDialog(null, "Error: El documento ya existe en favoritos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(x.getNumeroDeBusquedas() <= n.getDoc().getNumeroDeBusquedas()){
            if(x.getNumeroDeBusquedas() == n.getDoc().getNumeroDeBusquedas()){
                if(x.getNumeroDeDocumento()<=n.getDoc().getNumeroDeDocumento()){
                    if(n.getHijoIzq() == null){
                        n.setHijoIzq(new NodoArbol(x));
                    }else{
                        insertaRecursivo(n.getHijoIzq(), x);
                    }
                }else{
                    if(n.getHijoDer() == null){
                        n.setHijoDer(new NodoArbol(x));
                    }else{
                        insertaRecursivo(n.getHijoDer(), x);
                    }
                }
            }else{
                if(n.getHijoIzq() == null){
                    n.setHijoIzq(new NodoArbol(x));
                }else{
                    insertaRecursivo(n.getHijoIzq(), x);
                }
            }
        }else{
            if(n.getHijoDer() == null){
                n.setHijoDer(new NodoArbol(x));
            }else{
                insertaRecursivo(n.getHijoDer(), x);
            }
        }
    }
    
    public void inorden(){
        if(raiz != null){
            //Ejecutamos el recorrido
            inordenRecursivo(raiz);
        }{
            System.out.println("El árbol está vacío");
        }
    }
    
    public void inordenRecursivo(NodoArbol n){
        if(n != null){
            inordenRecursivo(n.getHijoIzq());
            System.out.println("Documento: "+n.getDoc().getNumeroDeDocumento() + ", Numero de busquedas: "+n.getDoc().getNumeroDeBusquedas()); //Aquí estamos imprimiendo la raiz (completa o de subarbol)
            inordenRecursivo(n.getHijoDer());
        }
    }
    
    public void preorden(){
        if(raiz != null){
            //Ejecutamos el recorrido
            preordenRecursivo(raiz);
        }{
            System.out.println("El árbol está vacío");
        }
    }
    
    public void preordenRecursivo(NodoArbol n){
        if(n != null){
            System.out.println("Documento: "+n.getDoc().getNumeroDeDocumento() + ", Numero de busquedas: "+n.getDoc().getNumeroDeBusquedas()); //Aquí estamos imprimiendo la raiz (completa o de subarbol)
            preordenRecursivo(n.getHijoIzq());
            preordenRecursivo(n.getHijoDer());
        }
    }
    
    public void postorden(){
        if(raiz != null){
            //Ejecutamos el recorrido
            postordenRecursivo(raiz);
        }{
            System.out.println("El árbol está vacío");
        }
    }
    
    public void postordenRecursivo(NodoArbol n){
        if(n != null){
            preordenRecursivo(n.getHijoIzq());
            preordenRecursivo(n.getHijoDer());
            System.out.println("Documento: "+n.getDoc().getNumeroDeDocumento() + ", Numero de busquedas: "+n.getDoc().getNumeroDeBusquedas()); //Aquí estamos imprimiendo la raiz (completa o de subarbol)
        }
    }
}
