package estDatos;

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
	}
	
	/**
	 * Crea un árbol ordenado copia del especificado.
	 * @param t el árbol a copiar
	 */
	public TreeNode(Tree<E> t) {
		theRoot = new Node<>(t.root());
	}
	
	@Override
	public boolean isNull() {
	}
	
	@Override
	public boolean isLeaf() {
	}

	@Override
	public E labelRoot() {
	}
	
	@Override
	public Node<E> root() {
	}

	@Override
	public Tree<E> firstChild() {
	}

	@Override
	public Tree<E> rightSibling() {
	}

	@Override
	public void setLabelRoot(E item) {
	}
	
	@Override
	public void setRoot(Node<E> node) {
	}
	
	@Override
	public void setFirstChild(Tree<E> t) {
	}

	@Override
	public void setRightSibling(Tree<E> t) {
	}

}
