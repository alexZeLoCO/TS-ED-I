package estDatos;

import java.util.TreeSet;

/**
 * Tipo de dato modificable para árboles ordenados con nodos etiquetados.
 *
 * @param <E> el tipo de dato de las etiquetas de los nodos
 */
public class TreeNode<E> extends AbstractTree<E> {
	private Node<E> theRoot;

	/**
	 * Crea un árbol ordenado cuyas secuencias en preorden y postorden
	 * son las especificadas.
	 * @param preorder un array que contiene la secuencia en preorden
	 * @param postorder un array que contien la secuencia en postorden
	 * @return el árbol ordenado cuyas secuencias en preorden y postorden
	 * son las especificadas
	 * @throws IllegalArgumentException si las secuencias especificadas no
	 * tienen el mismo tamaño o contienen elementos repetidos
	 */
	public static <E> Tree<E> createTree(E[] preorder, E[] postorder) {
		return new TreeNode<>(Node.createNode(preorder, postorder));
	}

	/**
	 * Crea un árbol ordenado que sólo tiene nodo raíz
	 * etiquetado como se especifica.
	 * @param e la etiqueta del nodo raíz
	 */
	public TreeNode(E e) {
		theRoot = new Node<>(e);
	}

	/**
	 * Crea el árbol ordenado cuya raíz es el nodo especificado.
	 * @param node la raíz del nuevo árbol
	 */
	private TreeNode(Node<E> node) {
		theRoot = node;
	}

	/**
	 * Crea el árbol ordenado cuya raíz está etiquetada como se
	 * especifica y que tiene como hijos la raíces de los árboles
	 * ordenados dados.
	 * @param labelRoot la etiqueta de la raíz
	 * @param trees los árboles cuyas raíces son hijos de la raíz
	 * del nuevo árbol ordenado
	 */
	@SafeVarargs
	public TreeNode (E labelRoot, Tree<E>... trees) {
		this(labelRoot);
		this.setFirstChild(trees[0]);
		Node<E> current = this.firstChild().root();
		for (int i = 1 ; i < trees.length ; i++) {
			current.setRight(trees[i].root());
			current = current.right();
		}
	}

	/**
	 * Crea un árbol ordenado copia del especificado.
	 * @param t el árbol a copiar
	 */
	public TreeNode(Tree<E> t) {
		this.setRoot(t.root());
		Tree<E> current = t.firstChild();
		Tree<E> setter = this;
		while (!current.root().isNull()) {
			setter.setFirstChild(current);
			setter = setter.firstChild();
			if (!current.rightSibling().isNull()) {
				setter.setRightSibling(current.rightSibling());
			}
			current = current.firstChild();
		}
		//this(t.root().label(), new TreeNode<E> (t.root().left()), new TreeNode<E> (t.root().right()));
	}

	@Override
	public boolean isNull() {
		return this.theRoot.isNull();
	}

	@Override
	public boolean isLeaf() {
		return this.firstChild().isNull();
	}

	@Override
	public E labelRoot() {
		return this.theRoot.label();
	}

	@Override
	public Node<E> root() {
		return this.theRoot;
	}

	@Override
	public Tree<E> firstChild() {
		return new TreeNode<E> (this.theRoot.left());
	}

	@Override
	public Tree<E> rightSibling() {
		return new TreeNode<E> (this.theRoot.right());
	}

	@Override
	public void setLabelRoot(E item) {
		this.theRoot.setLabel(item);
	}

	@Override
	public void setRoot(Node<E> node) {
		this.theRoot = node;
	}

	@Override
	public void setFirstChild(Tree<E> t) {
		this.theRoot.setLeft(t.root());
	}

	@Override
	public void setRightSibling(Tree<E> t) {
		this.theRoot.setRight(t.root());
	}

}
