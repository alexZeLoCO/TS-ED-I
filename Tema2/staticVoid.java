public class App {
	/**
 	 * Nota: La funcion utiliza listas de tipo ArrayList<E> y LinkedList<E>
 	 * Se busca complejidad lineal.
 	 *
	 * @param index posicion de insercion.
	 * @param l lista a la que se insertan los elementos.
	 * @param c la coleccion con los elementos a insertar.
	 * @throws IndexOutOfBoundsException si el indice esta fuera de rango (index < 0 V index > l.size())
	 */
	public static <E> void add (int index, List<E> l, Collection <? extends E> c) {
		if (index < 0 || index > l.size()) {
			throw new IndexOutOfBoundsException();
		}
		if (l == null || c == null) {
			throw new NullPointerException();
		}
		if (c.isEmpty()) {
			throw new NoSuchElementException();
		}
		//Stack<E> aux = new Stack<E> ();
		LinkedList<E> aux = new LinkedList<E> ();

		ListIterator<E> itr = l.listIterator(l.size()-1);
		while(itr.hasPrevious()) {
			itr.remove();
			aux.add(0, itr.remove());	//Add head (Stack-like)
			aux.add(itr.remove());		//Stack only
		}
		l.addAll(c);
		l.addAll(aux);
	}	
}	
