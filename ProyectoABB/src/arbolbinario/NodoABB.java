package arbolbinario;

public class NodoABB{
	NodoABB hijoIzquierdo;
    NodoABB hijoDerecho;
    int dato;
    
    public NodoABB(int dato){
        this.hijoIzquierdo=null;
        this.hijoDerecho=null;
        this.dato= dato;
    }
}
