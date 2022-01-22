package estDatos;

/**
 * TDA para árboles ordenados cuyos nodos están etiquetados.
 *
 * @param <E> el tipo de dato de la 
 */
public interface Tree<E> {
	
	/**
	 * Retorna cierto si la raíz de este árbol es el nodo nulo.
	 * @return {@code true} si este árbol es nulo
	 */
	boolean isNull();

	/**
	 * Retorna cierto si la raíz de este árbol es una hoja
	 * @return {@code true} si la raíz de este árbol es una hoja
	 */
	boolean isLeaf();
	
	/**
	 * Retorna la etiqueta de la raíz de este árbol.
	 * @return la etiqueta de la raíz del árbol
	 */
	E labelRoot();
	
	/**
	 * Retorna el nodo raíz de este árbol
	 * @return el nodo raíz del árbol
	 */
	Node<E> root();
	
	/**
	 * El primer hijo de la raíz de este árbol. Si la raíz no
	 * tiene hijos retorna un nodo nulo.
	 * @return el primer hijo de la raí. Retorna el árbol nulo
	 * si no tiene hijos
	 */
	Tree<E> firstChild();
	
	/**
	 * El hermano inmediantamente a la derecha de este árbol.
	 * Si no tiene hermano a la derecha retorna un nodo nulo.
	 * @return el hermano inmediatamente a la derecha,
	 * el árbol nulo si no lo tiene
	 */
	Tree<E> rightSibling();
	
	/**
	 * Cambia la etiqueta de la raíz de este árbol por la
	 * etiqueta especificada (opcional).
	 * @param item la nueva etiqueta de la raíz
	 * @throws UnsupportedOperationException si la operación
	 * no está soportada para este árbol
	 */
	default void setLabelRoot(E item) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Cambia el nodo raíz de este árbol por el nodo
	 * especificado (opcional).
	 * @param node la nueva raíz
	 * @throws UnsupportedOperationException si la operación
	 * no está soportada para este árbol
	 */
	default void setRoot(Node<E> node) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Cambia el primer hijo de la raíz de este árbol por el
	 * árbol especificado (opcional).
	 * @param t el nuevo primer hijo
	 * @throws UnsupportedOperationException si la operación
	 * no está soportada para este árbol
	 */
	default void setFirstChild(Tree<E> t) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Cambia el hermano inmediatamente a la derecha de este
	 * árbol por el árbol especificado.
	 * @param t el nuevo hermano a la derecha
	 * @throws UnsupportedOperationException si la operación
	 * no está soportada para este árbol
	 */
	default void setRightSibling(Tree<E> t) {
		throw new UnsupportedOperationException();
	}
}
