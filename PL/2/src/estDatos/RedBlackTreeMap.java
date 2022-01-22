package estDatos;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class RedBlackTreeMap<K, V> extends AbstractMap<K, V> implements Map<K, V> {
	// área de datos
	private RedBlackTree<Map.Entry<K, V>> data;
	
	/**
	 * Crea un diccionario vacío. Las claves estarán ordenadas
	 * según el orden natural.
	 * @trhows ClassCastException si el tipo K no es Comparable
	 */
	public RedBlackTreeMap() {
		this.data = new RedBlackTree<Map.Entry<K, V>> ();
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
	@SuppressWarnings("unchecked")
	public RedBlackTreeMap(Comparator<? super K> cmp) {
		if (cmp == null) {
			this.data = new RedBlackTree<Map.Entry<K, V>>
	    		((Map.Entry<K, V> e1, Map.Entry<K, V> e2) ->	    		
	    		((Comparable<K>)e1.getKey()).compareTo(e2.getKey())); 
		}
	    this.data = new RedBlackTree<Map.Entry<K, V>>
	    		((Map.Entry<K, V> e1, Map.Entry<K, V> e2) ->
			   	 cmp.compare(e1.getKey(), e2.getKey()));
	}

	/**
	 * Crea un diccionario copia del especificado con claves
	 * ordenadas según el orden natural.
	 * @trhows ClassCastException si el tipo K no es Comparable
	 */
	public RedBlackTreeMap(Map<K, V> m) {
		this();
		this.data.addAll(m.entrySet());
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
		this(cmp);
		this.data.addAll(m.entrySet());
	}
	
	/**
	 * Crea un diccionario copia del especificado con claves 
	 * ordenadas según el orden que establece el comparador de
	 * este último.
	 * @param m diccionario a copiar
	 */
	public RedBlackTreeMap(SortedMap<K, V> m) {
		this(m, m.comparator());
	}
	
	/**
	 * Retorna el comparador de las claves del diccionario, si es
	 * {@code null} los elementos se ordenan según el orden natural
	 * del tipo de éstas.
	 * @return el comparador de las claves del diccionario
	 */
	public Comparator <? super Map.Entry<K, V>> comparator() {
		return this.data.comparator();
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		return new TreeSet<Map.Entry<K, V>> (this.data);
	}
	
	// . . .  (resto de operaciones)
	// Operaciones para que sea modificable.
	
	@Override
	public V put (K key, V value) {
		for (Map.Entry<K, V> e : this.data) {
			if (e.getKey().equals(key)) {
				return  e.setValue(value);
			}
		}
		TreeMap<K, V> aux = new TreeMap<K, V> ();
		aux.put(key, value);
		this.data.add(aux.firstEntry());
		return null;
	}
	
}
