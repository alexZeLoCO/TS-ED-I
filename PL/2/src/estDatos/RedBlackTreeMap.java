package estDatos;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public class RedBlackTreeMap<K, V> extends AbstractMap<K, V> implements Map<K, V> {
	// área de datos
	
	/**
	 * Crea un diccionario vacío. Las claves estarán ordenadas
	 * según el orden natural.
	 * @trhows ClassCastException si el tipo K no es Comparable
	 */
	public RedBlackTreeMap() {
	}
		
	/**
	 * Crea un diccionario vacío. Las claves estarán ordenadas
	 * según el orden que establece el comparador especificado,
	 * si éste es {@code null} el orden será el orden natural.
	 * @param cmp el comparador
	 * @trhows ClassCastException si el tipo K no implementa la
	 * interfaz Comparator o si {@code cmp} es {@code null} y el tipo
	 * K no es Comparable
	 */
	public RedBlackTreeMap(Comparator<? super K> cmp) {
	}

	/**
	 * Crea un diccionario copia del especificado con claves
	 * ordenadas según el orden natural.
	 * @trhows ClassCastException si el tipo K no es Comparable
	 */
	public RedBlackTreeMap(Map<K, V> m) {
	}

	/**
	 * Crea un diccionario copia del especificado con claves 
	 * ordenadas según el orden que establece el comparador dado,
	 * si éste es {@code null} el orden será el orden natural.
	 * @param cmp el comparador
	 * @trhows ClassCastException si el tipo K no implementa la
	 * interfaz Comparator o si {@code cmp} es {@code null} y el tipo
	 * K no es Comparable
	 */
	public RedBlackTreeMap(Map<K, V> m, Comparator<? super K> cmp) {
	}
	
	/**
	 * Crea un diccionario copia del especificado con claves 
	 * ordenadas según el orden que establece el comparador de
	 * este último.
	 * @param m diccionario a copiar
	 */
	public RedBlackTreeMap(SortedMap<K, V> m) {
	}
	
	/**
	 * Retorna el comparador de las claves del diccionario, si es
	 * {@code null} los elementos se ordenan según el orden natural
	 * del tipo de éstas.
	 * @return el comparador de las claves del diccionario
	 */
	public Comparator<? super Map.Entry<K, V>> comparator() {
		return null;
	}
	
	// . . .  (resto de operaciones)
	
}
