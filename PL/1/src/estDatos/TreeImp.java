package estDatos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TreeImp<E> extends AbstractTree<E> {
	// área de datos
	private E labelRoot;					// etiqueta de la raíz del árbol
	private LinkedList<Tree<E>> children;	// lista de subárboles de la raíz
	
	/**
	 * Crea un árbol ordenado que sólo tiene nodo raíz
	 * con la etiqueta especificada.
	 * @param e etiqueta de la raíz del árbol
	 */
	public TreeImp(E e) {

	}
	
	/**
	 * Crea un árbol ordenado cuyo nodo raíz está etiquetado como
	 * se especifica y que tiene como nodos hijo las raíces de los
	 * árboles especificados en el orden proporcionado.
	 * @param e la etiqueta de la raíz
	 * @param trees los árboles cuyas raíces son los nodos hijo
	 * del nodo raíz del árbol creado
	 */
	@SafeVarargs
	public TreeImp(E e, Tree<E> ... trees) {
		// trees es un número variable de argumentos, recuerda que
		// se puede tratar como si fuera un array

	}
	
	/**
	 * Crea un árbol ordenado copia del especificado.
	 * @param t el árbol a copiar
	 */
	public TreeImp(Tree<E> t) {

	}

	// Añade todas las operaciones que se requieran para que el
	// tipo de dato TreeImp<E> sea modificable y, recuerda, antes de
	// implementar cualquier operación lee con detalle su especificación.
	// En caso contrario, cometerás errores fácilmente evitables.
	
	
}
