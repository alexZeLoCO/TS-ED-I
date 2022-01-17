package estDatos;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * TDA para árboles ordenados.
 *
 * @param <E> tipo de las etiquetas de los nodos del árbol
 */
public interface Tree<E> {
	
	/**
	 * Cierto si la raíz de este árbol es una hoja.
	 * @return true si la raíz de este árbol es una hoja
	 */
	boolean isLeaf();
	
	/**
	 * La etiqueta de la raíz de este árbol.
	 * @return la etiqueta de la raíz del árbol
	 */
	E label();
	
	/**
	 * El subárbol cuya raíz es el nodo hijo index-ésimo de la
	 * raíz de este árbol
	 * @param index la posición del hijo de la raíz
	 * @return el subárbol cuya raíz es el nodo hijo en la posición
	 * dada
	 * @throws IndexOutOfBoundsException si el índice está fuera de
	 * rango.
	 */
	default Tree<E> subTree(int index) {
		ListIterator<Tree<E>> itr = listIteratorToChildren(index);
		if (!itr.hasNext()) {
			throw new IndexOutOfBoundsException();
		}
		
		return itr.next();
	}
	
	/**
	 * Un iterador sobre los subárboles cuyas raíces son los nodos
	 * hijos del nodo raíz de este árbol.
	 * @return un iterador sobre los subárboles de la raíz
	 */
	Iterator<Tree<E>> iteratorToChildren();

	/**
	 * Un iterador sobre los subárboles cuyas raíces son los nodos
	 * hijos del nodo raíz de este árbol.
	 * @return un iterador sobre los subárboles de la raíz
	 */
	ListIterator<Tree<E>> listIteratorToChildren();
	
	/**
	 * Un iterador sobre los subárboles cuyas raíces son los nodos
	 * hijos del nodo raíz de este árbol, comenzando en el subárbol
	 * que ocupa la posición especificada.
	 * @param index la posición del subárbol
	 * @return un iterador sobre los subárboles de la raíz comenzando
	 * en el subárbol indicado.
	 * @throws IndexOutOfBoundsException si el índice está fuera de
	 * rango.
	 */
	default ListIterator<Tree<E>> listIteratorToChildren(int index) {
		ListIterator<Tree<E>> itr = listIteratorToChildren();
		int n = 0;
		
		while (itr.hasNext() && n != index) {
			n = n + 1;
			itr.next();
		}
		
		if (n != index) {
			throw new IndexOutOfBoundsException();
		}
		
		return itr;
	}
	
	/**
	 * Modifica la etiqueta de la raíz de este árbol. Operación
	 * opcional.
	 * @param e la nueva etiqueta de la raíz de este árbol
	 * @throws UnsupportedOperationException si esta operación no
	 * está soportada por este árbol
	 */
	default void setLabel(E e) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Modifica el subárbol hijo de la raíz que ocupa la posición
	 * indicada. Si el índice especificado es el número de hijos
	 * de la raíz, se añade un nuevo hijo al final. Si el árbol
	 * especificado es null, no hay reemplazamiento(se borra el
	 * subárbol correspondiente). Operación opcional.
	 * @param index la posición del hijo que se reemplaza. Si index
	 * es el número de hijos de la raíz, se añade al final un nuevo
	 * hijo
	 * @param t el árbol que reemplazará el subárbol indicado
	 * @throws IndexOutOfBoundsException si no se cumple
	 * 0<=index<=número de hijos de la raíz
	 * @throws UnsupportedOperationException si esta operación no
	 * está soportada por este árbol
	 */
	default void setSubTree(int index, Tree<E> t) {
		throw new UnsupportedOperationException();
	}
	
}
