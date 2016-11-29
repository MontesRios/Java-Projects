package arbolbinario;

/*
 * Copyright (c) 2016 Jorge Montes
 * Email: jorge.montes.1094@gmail.com
 * Website: https:\\www.monteslive.blogspot.mx
 *
 * Proyecto Arboles Binarios is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.util.Scanner;

public class TestABB {
	private static Scanner lectura;
	private static boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	public static void main (String[]args){
	ABB A = new ABB();
	lectura  = new Scanner(System.in);
	int op;
	int dato = 0;
	int numNodos = 0;
	String strint;
	System.out.println("\t\t  = PROYECTO FINAL = ");
	System.out.println("\t\t  Estructura de Datos");
	System.out.println("\t\tOtono 2016 - 201321617");
	System.out.println("\t   *** Jorge Eduardo Montes Rios ***");	
	System.out.println("\n******************************************************************************");
	System.out.println("Caracteristicas del programa: ");
	System.out.println("1. Al iniciar el programa, se pide al usuario ingresar una cantidad de nodos.");
	System.out.println("Teclear 1 para agregar nodos al arbol binario uno por uno.");   
    System.out.println("2. Los nodos duplicados no se agregan al arbol.");
    System.out.println("3. Los recorridos son por recursividad");
    System.out.println("*******************************************************************************");    
    System.out.println("\nINICIANDO PROGRAMA ... ");      
    System.out.println("\nCantidad de nodos:");
    
    do{
    	strint = lectura.next();  
	    if (isNumeric(strint)==true)
	    	numNodos = Integer.parseInt(strint);
	    else
	    	System.out.println("Entrada no valida, intente de nuevo");
    }while(isNumeric(strint)!=true);
	
		do{				
			 System.out.println("\n\t\t| Menu |");
			 System.out.println("\t1. Agregar nodos al Arbol"); 
			 System.out.println("\t2. Recorrido Preorden"); 
			 System.out.println("\t3. Recorrido Inorden"); 
			 System.out.println("\t4. Recorrido Postorden");
			 System.out.println("\t5. Altura del Arbol");
			 System.out.println("\t6. Cantidad de Nodos");
			 System.out.println("\t7. Buscar nodo");
			 System.out.println("\t8. Eliminar Nodo");
			 System.out.println("\t9. Salir");
			 op = lectura.nextInt();
			 
			 switch(op){
			 	case 1 :
			 		System.out.println("Agregar "+ numNodos + " nodos:"); 
			 		for(int i = 0; i<numNodos;i++){
			 			System.out.print("Nodo #"+i+" : ");			 			 			 		
			 			do{
			 		    	strint = lectura.next();  
			 			    if (isNumeric(strint)==true)
			 			    	dato = Integer.parseInt(strint);
			 			    else
			 			    	System.out.print("Entrada no valida, intente de nuevo: ");
			 		    }while(isNumeric(strint)!=true);
			 			A.insertar(dato);		 			
			 		}
			 		break;
			 	case 2 :
			 		System.out.print("El recorrido en Preorden es: ");
			 		A.preorden (A.raiz);
			 		System.out.println();
			 		break;
			 	case 3 :
			 		System.out.print("El recorrido en Inorden es: ");
			 		A.inOrden (A.raiz);
			 		System.out.println();
			 		break;
			 	case 4 :
			 		System.out.print("El recorrido en Postorden es: ");
			 		A.postOrden (A.raiz);
			 		System.out.println();
			 		break;
			 	case 5 :
			 		System.out.println("La altura del arbol es: " + A.altura (A.raiz));
			 		break;
			 	case 6 : 
			 		System.out.println("La cantidad de nodos que posee el arbol es: " + A.tamano(A.raiz));
			 		break;
			 	case 7 :
			 		System.out.print("Nodo a buscar en el arbol: ");
			 		 			 		
		 			do{
		 		    	strint = lectura.next();  
		 			    if (isNumeric(strint)==true)
		 			    	dato = Integer.parseInt(strint);
		 			    else
		 			    	System.out.println("Entrada no valida, intente de nuevo");
		 		    }while(isNumeric(strint)!=true);
			 		A.buscar(dato, A.raiz);
			 		break;
			 	case 8 :
			 		System.out.print("Nodo a eliminar del arbol: ");			 			 		
		 			do{
		 		    	strint = lectura.next();  
		 			    if (isNumeric(strint)==true)
		 			    	dato = Integer.parseInt(strint);
		 			    else
		 			    	System.out.println("Entrada no valida, intente de nuevo");
		 		    }while(isNumeric(strint)!=true);
			 		A.borrar(dato);
			 		break;
			 	case 9 :
			 		System.out.println("Programa Finalizado");
			 		System.exit(0);
			 		break;		 	
			 	default:
			 		System.out.println("Respuesta Incorrecta");
			 		break;
			 
			 }
			 
		}while(op != 9);
				
	}
}


