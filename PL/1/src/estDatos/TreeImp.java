package estDatos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TreeImp<E> extends AbstractTree<E> {
	// área de datos
	private E labelRoot;					// etiqueta de la raíz del árbol
	protected LinkedList<Tree<E>> children;	// lista de subárboles de la raíz
	
	/**
	 * Crea un árbol ordenado que sólo tiene nodo raíz
	 * con la etiqueta especificada.
	 * @param e etiqueta de la raíz del árbol
	 */
	public TreeImp(E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		this.setLabel(e);
		this.children = new LinkedList<Tree<E>> ();
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
		this(e);
		for (Tree<E> t : trees) {
		//	this.children.add(t);
			this.setSubTree(this.children.size(), t);
		}
	}
	
	/**
	 * Crea un árbol ordenado copia del especificado.
	 * @param t el árbol a copiar
	 */
	public TreeImp(Tree<E> t) {
		this(t.label());
		Iterator<Tree<E>> itr = t.iteratorToChildren();
		while (itr.hasNext()) {
		//	this.children.add(itr.next());
			this.setSubTree(this.children.size(), t);
		}
	}

	@Override
	public boolean isLeaf() {
		return this.children.isEmpty();
	}

	@Override
	public void setLabel (E e) {
		this.labelRoot = e;
	}
	
	@Override
	public void setSubTree (int index, Tree<E> t) {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (t == null) {
			if (index >= this.children.size()) {
				throw new IndexOutOfBoundsException();
			}
			this.children.remove(index);
		} else {
			if (index < this.children.size()) {
				this.children.set(index, t);
			} else {
				this.children.add(t);
			}
		}
	}

	@Override
	public E label() {
		return this.labelRoot;
	}

	@Override
	public Iterator<Tree<E>> iteratorToChildren() {
		return this.children.iterator(); 
	}

	@Override
	public ListIterator<Tree<E>> listIteratorToChildren() {
		return this.children.listIterator();
	}

	// Añade todas las operaciones que se requieran para que el
	// tipo de dato TreeImp<E> sea modificable y, recuerda, antes de
	// implementar cualquier operación lee con detalle su especificación.
	// En caso contrario, cometerás errores fácilmente evitables.
	
	
}
