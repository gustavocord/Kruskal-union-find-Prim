package logica;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class KruskalBK {

	static final int MAX = 1005;  //maximo numero de vértices

	///UNION-FIND
	static int padre[] = new int[ MAX ];  //Este arreglo contiene el padre del i-esimo nodo

	//Método de inicialización
	static void creacionConjuntos( int n ){
	    for( int i = 1 ; i <= n ; ++i ) 
	    	padre[ i ] = i;
	}

	//Método para encontrar la raiz del vértice actual X
	static int Find( int x ){
	    return ( x == padre[ x ] ) ? x : ( padre[ x ] = Find( padre[ x ] ) );
	}

	//Método para unir 2 componentes conexas
	static void Union( int x , int y ){
	    padre[ Find( x ) ] = Find( y );
	}

	//Método que me determina si 2 vértices estan o no en la misma componente conexa
	static boolean mismaComponenteConexa( int x , int y ){
	    if( Find( x ) == Find( y ) ) return true;
	    return false;
	}
	
	
	///FIN UNION-FIND
	

	

	static int V , E;      //numero de vertices y aristas
	//Estructura arista
	
	static class Arista implements Comparator<Arista>{
	   
		int origen;     //Vértice origen
	    int destino;    //Vértice destino
	    int peso;       //Peso entre el vértice origen y destino
	   
	    Arista(){}
	    //Comparador por peso, me servira al momento de ordenar lo realizara en orden ascendente
	    //Ordenar de forma descendente para obtener el arbol de expansion maxima
		@Override
		public int compare(Arista e1 , Arista e2 ) {
			return e1.peso - e2.peso;   //Arbol de expansion minima
		}
	}
	
	static Arista arista[] = new Arista[ MAX ];      //Arreglo de aristas para el uso en kruskal
	static Arista MST[] = new Arista[ MAX ];     //Arreglo de aristas del MST encontrado

	static void KruskalMST(){
	    int origen , destino , peso;
	    int total = 0;          //Peso total del MST
	    int numAristas = 0;     //Numero de Aristas del MST
	    
	    creacionConjuntos( V );           //Inicializamos cada componente
	    Arrays.sort( arista , 0 , E , new Arista() );    //Ordenamos las aristas por su comparador

	    for( int i = 0 ; i < E ; ++i ){     //Recorremos las aristas ya ordenadas por peso
	        origen = arista[ i ].origen;    //Vértice origen de la arista actual
	        destino = arista[ i ].destino;  //Vértice destino de la arista actual
	        peso = arista[ i ].peso;        //Peso de la arista actual

	        //Verificamos si estan o no en la misma componente conexa
	        if( !mismaComponenteConexa( origen , destino ) ){  //Evito ciclos
	            total += peso;              //Incremento el peso total del MST
	            MST[ numAristas++ ] = arista[ i ];  //Agrego al MST la arista actual
	            Union( origen , destino );  //Union de ambas componentes en una sola
	        }
	    }

	    //Si el MST encontrado no posee todos los vértices mostramos mensaje de error
	    //Para saber si contiene o no todos los vértices basta con que el numero
	    //de aristas sea igual al numero de vertices - 1
	    
	    
	    if( V - 1 != numAristas ){
	        System.out.println("No existe MST valido para el grafo ingresado, el grafo debe ser conexo.");
	        return;
	    }
	    System.out.println( "-----El MST encontrado contiene las siguientes aristas-----");
	    for( int i = 0 ; i < numAristas ; ++i )
	        System.out.printf("( %d , %d ) : %d\n" , MST[ i ].origen , MST[ i ].destino , MST[ i ].peso ); //( vertice u , vertice v ) : peso

	    System.out.printf( "El costo minimo de todas las aristas del MST es : %d\n" , total );
	}
	
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner( System.in );	   //para lectura de datos
		V = sc.nextInt(); E = sc.nextInt();
		
	    //Realizamos el ingreso del grafo, almacenando las aristas en un arreglo con los datos respectivos
	    for( int i = 0 ; i < E ; ++i ){
	        arista[ i ] = new Arista();
	    	arista[ i ].origen = sc.nextInt();
	        arista[ i ].destino = sc.nextInt();
	        arista[ i ].peso = sc.nextInt();
	        //arista[ i ] = new Arista( sc.nextInt() , );
	    }
	    KruskalMST();
	    System.out.printf( "El costo minimo de todas las aristas del MST es : %d\n" );
	}
}