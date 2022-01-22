package estDatos;

public abstract class AbstractTree<E> implements Tree<E> {

	/**
	 * @see estDatos.Tree#isNull()
	 */
	abstract public boolean isNull();
	
	/**
	 * @see estDatos.Tree#isLeaf()
	 */
	abstract public boolean isLeaf();
	
	/**
	 * @see estDatos.Tree#labelRoot()
	 */
	abstract public E labelRoot();
	
	/**
	 * @see estDatos.Tree#root()
	 */
	abstract public Node<E> root();
	
	/**
	 * @see estDatos.Tree#firstChild()
	 */
	abstract public Tree<E> firstChild();
	
	/**
	 * @see estDatos.Tree#rightSibling()
	 */
	abstract public Tree<E> rightSibling();
	
	/**
	 * @see estDatos.Tree#setLabelRoot(java.lang.Object)
	 */
	abstract public void setLabelRoot(E item);
	
	/**
	 * @see estDatos.Tree#setRoot(estDatos.Node)
	 */
	abstract public void setRoot(Node<E> node);
	
	/**
	 * @see estDatos.Tree#setFirstChild(estDatos.Tree)
	 */
	abstract public void setFirstChild(Tree<E> t);
	
	/**
	 * @see estDatos.Tree#setRightSibling(estDatos.Tree)
	 */
	abstract public void setRightSibling(Tree<E> t);

	/**
	 * Compara la igualdad de los dos árboles ordenados que se
	 * especifican.
	 * @param t1 el primer árbol ordenado
	 * @param t2 el segundo árbol ordenado
	 * @return {@code true} si los árboles son iguales y {@code false}
	 * en caso contrario
	 */
	private static <E> boolean equality(Tree<E> t1, Tree<E> t2) {
		if (!t1.root().equals(t2.root())) {
			return false;
		}
		return ((t1.rightSibling().isNull() && t2.rightSibling().isNull()) ||
				(t1.firstChild().isNull() && t2.firstChild().isNull()) || 
			     equality (t1.rightSibling(), t2.rightSibling()) && equality (t1.firstChild(), t2.firstChild()));
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o == null)
			return false;
		if (! (o instanceof Tree<?>))
			return false;
		
		return equality(this, (Tree<E>) o);
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String out = "(" + labelRoot() + " [";
		Tree<E> current = firstChild();
		while (!current.isNull()) {
			out += current.toString();
			current = current.rightSibling();
		}
		
		return  out + "])";
	}
}
