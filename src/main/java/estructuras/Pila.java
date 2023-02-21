package estructuras;
import javax.swing.JOptionPane;
public class Pila {
    private Nodo cima;
    
    public Pila(){
        this.cima=null;
    }
    
    public boolean esVacia(){
        if (cima==null) {return true;}
        return false;
    }
    
    public void apilar(){
        Documento d= new Documento();
        //pendiente: recibir los datos del documento
        Nodo nuevo = new Nodo();
        nuevo.setDocumento(d);
        if (esVacia()) {cima=nuevo;}
        else {
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
    }
    
    public void apilar(int n){
        Documento d= new Documento();
        //pendiente: recibir los datos del documento
        Nodo nuevo = new Nodo();
        nuevo.setDocumento(d);
        if (esVacia()) {cima=nuevo;}
        else {
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
    }
    
    public void imprimirPila(){
        String respuesta= "";
        if(!esVacia()){
            Nodo aux = cima;
            while (aux !=null){
                respuesta = respuesta + "\n" + aux.getDocumento();
                aux=aux.getSiguiente();
            }
        }
        respuesta = respuesta + "\n-null-"; 
        System.out.println(respuesta);
    }

    public boolean encontrarNumero(int numero){
        if(esVacia()){return false;}
        Nodo aux = cima;
        while (aux !=null){
            if (numero==aux.getDocumento().getNumero()) {return true;}
            aux=aux.getSiguiente();
        }
        return false;
    }
    
    public void extraerNumero(int x){
        if(esVacia()){return;}
        Nodo aux = cima;
        Nodo anterior = aux;
        boolean cambios=false;
        if (aux.getDocumento().getNumero()==x){
            cima=aux.getSiguiente();
            aux=cima;
            anterior=aux;
        }
        while (aux !=null){
            if (anterior!=aux){
                if (x==aux.getDocumento().getNumero()){
                    anterior.setSiguiente(aux.getSiguiente());
                    cambios=true;
                    System.out.println("\nSi hubieron cambios, esta es la pila resultante:");
                }
                anterior=aux;
                aux=aux.getSiguiente();
            }else{
                anterior=aux;
                aux=aux.getSiguiente();}
        }
        if (cambios){imprimirPila();}
        else {System.out.println("\nNo hubieron cambios");}       
    }
    

    public void insertarOrdenadoMayorAMenor(Pila pila, int cima)  
    {  
        if (pila.esVacia() || cima > pila.cima.getDocumento().getNumero())  
        {  
            pila.apilar(cima);  
            return;  
        }  
        int temp = pila.extraer();  
        insertarOrdenadoMayorAMenor(pila, cima);   
        pila.apilar(temp);  
    }  
    
    public void ordenarPilaMayorAMenor(Pila pila)  
    {  
        if (pila.esVacia()) {return;}  
        int temp = pila.extraer();   
        ordenarPilaMayorAMenor(pila);  
        insertarOrdenadoMayorAMenor(pila, temp);  
    }  
    
    int extraer(){
        int x=cima.getDocumento().getNumero();
        cima=cima.getSiguiente();
        return x;
    }
    
    public void insertarOrdenadoMenorAMayor(Pila pila, int cima)  
    {  
        if (pila.esVacia() || cima < pila.cima.getDocumento().getNumero())  
        {  
            pila.apilar(cima);  
            return;  
        }  
        int temp = pila.extraer();  
        insertarOrdenadoMenorAMayor(pila, cima);   
        pila.apilar(temp);  
    }  
    
    public void ordenarPilaMenorAMayor(Pila pila)  
    {  
        if (pila.esVacia()) {return;}  
        int temp = pila.extraer();   
        ordenarPilaMenorAMayor(pila);  
        insertarOrdenadoMenorAMayor(pila, temp);  
    }  
    
    public void testextraer(Documento dato){
        System.out.println("\nTest2: "+dato.getNumero());
        dato.setNumero(dato.getNumero()+1);
        System.out.println("\nTest3: "+dato.getNumero());
    }
}
