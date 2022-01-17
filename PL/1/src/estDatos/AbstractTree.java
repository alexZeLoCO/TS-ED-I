package estDatos;

import java.util.Iterator;

public abstract class AbstractTree<E> implements Tree<E> {
	
	/*
	 * Compara la igualdad de los dos árboles dados.
	 */
	private static <E> boolean equalsTree(Tree<E> t1, Tree<E> t2) {
		// Define esta función
		if (t1 == null || t2 == null) {
			throw new NullPointerException();
		}
		if (!t1.label().equals(t2.label())) {
			return false;
		}
		Iterator<Tree<E>> itr1 = t1.listIteratorToChildren();
		Iterator<Tree<E>> itr2 = t2.listIteratorToChildren();
		while (itr1.hasNext() && itr2.hasNext()) {
			if (!AbstractTree.equalsTree(itr1.next(), itr2.next())) {
				return false;
			}
		}
		return !itr1.hasNext() && !itr2.hasNext();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		
		if (!(o instanceof Tree<?>)) {
			return false;
		}
		
		Tree<E> t = (Tree<E>) o;
		
		return equalsTree(this, t);
	}
	
	/**
	 * Retorna una cadena de caracteres que representa a 
	 * este árbol ordenado.
	 * @return la cadena [a s(t1) s(t2) ... s(tk)], donde a es
	 * la etiqueta de la raíz de este árbol y s(ti) es la cadena
	 * de caracteres que representa al árbol ordenado cuya raíz es
	 * el i-ésimo hijo de la raíz de este árbol (con 1<=i<=k y donde
	 * k es el número de hijos de este nodo raíz)
	 */
	@Override
	public String toString() {
		String out = "[";
		
		out += label().toString();  		// etiqueta de la raíz
		Iterator<Tree<E>> itr = iteratorToChildren();
		while (itr.hasNext()) {
			out += " " + itr.next().toString();	// cadena del subárbol hijo
		}
		out += "]";
			
		return out;
	}
}
