/**
 * Representar los atributos de las siguientes estructuras.
 * Opcion 1. { {Map, Mapa}, {Game, Juego}, {Tree, Arbol}, ... }
 * Opcion 2. { {Map, Mapa} ---> {Game, Juego} ---> {Tree, Arbol} ---> ... }
 * Opcion 3: { (Tree) }
 */
public class Nov14 {
	//Opcion1
	private Map.Entry<K, V> [] data;
	private int size;

	//Opcion2
	private LinkedList<Map.Entry<K, V>> ();

	//Opcion3 - Sin utilizar TreeSet ni TreeMap
	private Node<K, V> theRoot;
	private int size;

	private final class Node<K, V> {
		private Node<K, V> right;
		private Node<K, V> left;
	}
}
