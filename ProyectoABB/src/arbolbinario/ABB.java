package arbolbinario;

public class ABB{
	NodoABB padre;
	NodoABB raiz;
	NodoABB actual;
 
	//Constructor
	public ABB(){
		raiz = null;
	}
 
	//Insercion de un elemento en el arbol
	public void insertar(int dato){
        padre = null;
        actual = raiz;
        NodoABB nuevo = new NodoABB(dato);
        
        if(actual == null){
            raiz = nuevo;
            System.out.println("Nodo "+dato+" insertado como raiz.");
        }
        else{
            while(actual != null){
                if(nuevo.dato == actual.dato){
                    System.out.println("Nodo duplicado");
                    break;
                }
                if(nuevo.dato < actual.dato){
                    padre = actual;
                    actual = actual.hijoIzquierdo;
                }
                else{
                    padre = actual;
                    actual = actual.hijoDerecho;
                }
            }
            if(actual == null){
                if(nuevo.dato < padre.dato){
                    padre.hijoIzquierdo = nuevo;
                    System.out.println("Nodo "+dato+" insertado a la izquierda.");
                }
                else{
                    padre.hijoDerecho = nuevo;
                    System.out.println("Nodo "+dato+" insertado a la derecha.");
                }
            }
        }
    }
 
	//Preorden Recursivo del arbol
	public void preorden (NodoABB Nodo){
		if(Nodo == null)
			return;
		else{
			System.out.print (Nodo.dato + " ");
			preorden (Nodo.hijoIzquierdo);
			preorden (Nodo.hijoDerecho);
		}
	}
 
	//PostOrden recursivo del arbol
	public void postOrden (NodoABB Nodo){
		if(Nodo == null)
			return;
		else{
			postOrden (Nodo.hijoIzquierdo);
			postOrden (Nodo.hijoDerecho);
			System.out.print (Nodo.dato + " ");
		}
	}
 
	//Inorden Recursivo del arbol
	public void inOrden (NodoABB Nodo){	
		if(Nodo == null)
			return;
		else{
			inOrden (Nodo.hijoIzquierdo);
			System.out.print(Nodo.dato + " ");
			inOrden (Nodo.hijoDerecho);
		}
	}
 
	//Cantidad de niveles q	ue posee el arbol
	   public int altura(NodoABB Nodo){ 
		if (Nodo==null)
	         return -1;
	    else
	         return 1+Math.max(altura(Nodo.hijoIzquierdo),altura(Nodo.hijoDerecho));
		}
	//Cantidad de elementos que posee el arbol	
	public int tamano(NodoABB Nodo){
	    if (Nodo==null)
	       return 0;
	    else
	      return 1+tamano(Nodo.hijoIzquierdo)+tamano(Nodo.hijoDerecho);
	}
	
	//Busca un elemento en el arbol
	public void buscar(int dato, NodoABB A){
			if(A == null || A.dato == dato){
				System.out.print("Elemento " +A.dato +" encontrado ");				
			} 
			else{
			if(dato>A.dato)
					buscar(dato, A.hijoDerecho);
			else
					buscar( dato, A.hijoIzquierdo);
			}			
	} 


	
	//Elimina un elemento en el arbol
	 public void borrar (int elemento)
	    {
	        raiz = borrar(this.raiz, elemento);
	    }
	   
	    private NodoABB borrar(NodoABB raiz, int elemento)
	    {
	        if (raiz.dato == elemento)
	        {
	            if(raiz.hijoDerecho == null && raiz.hijoIzquierdo == null)
	            {
	                raiz = null;
	                return raiz;
	            }
	            if(raiz.hijoDerecho == null)// caso en el que raiz solo tiene hijo izquierdo
	            {
	                raiz = raiz.hijoIzquierdo;
	                return raiz;    //aqui el hijo ocupa el lugar del padre
	            }
	            if(raiz.hijoIzquierdo ==null)
	            {
	                raiz = raiz.hijoDerecho;
	                return raiz;
	            }	            
	            //este es el caso en el que el nodo tiene dos hijos
	            raiz.dato = encontrarMaximo(raiz.hijoIzquierdo); //sera igual que el nodo de mayor valor
	            raiz = ajuste(raiz, raiz.hijoIzquierdo, raiz);
	            return raiz;//el nodo igualado de mayor valor se debe eliminar
	        }
	   
	        if(elemento > raiz.dato)//si el elemento buscado es mayor al del nodo actual
	        {
	            raiz.hijoDerecho = borrar(raiz.hijoDerecho, elemento);
	            return raiz;
	        }
	   
	        raiz.hijoIzquierdo = borrar(raiz.hijoIzquierdo, elemento);
	        return raiz;
	    }
	    
	    private NodoABB ajuste(NodoABB padre, NodoABB hijo, NodoABB ances)
	    {
	        if(hijo.hijoDerecho == null)
	        {
	            if(padre.equals(ances))
	            {
	                padre.hijoIzquierdo = hijo.hijoIzquierdo;
	                return padre;
	            }
	            padre.hijoDerecho = hijo.hijoIzquierdo;
	            return padre;
	        }
	        return padre;
	    }
	    
	    private int encontrarMaximo(NodoABB raiz)
	    {
	        if(raiz.hijoDerecho == null)//si no hay un nodo mayor retorna el valor del nodo
	            return raiz.dato;
	        return encontrarMaximo(raiz.hijoDerecho);
	    }
	   
	}  
	    

