package estDatos;

import java.util.Set;
import java.util.TreeSet;

/**
 * Tipo de dato modificable Node<E>. Representa nodos etiquetados
 * de un árbol cualquiera.
 *
 * @param <E> el tipo de las etiquetas de los nodos
 */
public class Node<E> {
	private E label;		// etiqueta del nodo
	private Node<E> left;	// hijo izquierdo
	private Node<E> right;	// hijo derecho

	/**
	 * El nodo nulo.
	 */
	private static final NullNode<?> NULL_NODE = new NullNode<>();
	
	/**
	 * Retorna el nodo nulo.
	 * @return el nodo nulo
	 */
	@SuppressWarnings("unchecked")
	public static <E> Node<E> NullNode() {
		return (Node<E>)NULL_NODE;
	}

	private static <E> Node<E> createBinTree(E[] preorder, int inf_p,
			int sup_p, E[] inorder, int inf_i, int sup_i) {
		if (inf_p > sup_p) {
			return NullNode();
		}
		
		// búsqueda de la etiqueta de la raíz del árbol (preorder[inf_p])
		// en la secuencia en inorden (inorder[inf_i..sup_i])
		int k = inf_i;
		while (inorder[k] != preorder[inf_p] && k < sup_i) {
			k++;
		}

		if (inorder[k] != preorder[inf_p]) { // la búsqueda ha fallado
			throw new IllegalStateException("Las secuencias proporcionadas son incorrectas.");
		}

		return new Node<E>(preorder[inf_p],
				createBinTree(preorder, inf_p + 1, k + inf_p - inf_i, inorder, inf_i, k - 1),
				createBinTree(preorder, k + inf_p - inf_i + 1, sup_p, inorder, k + 1, sup_i));
	}
	
	private static <E> void check(String msg, E[] arr) {
		Set<E> s = new TreeSet<>();
		
		for (E e: arr) {
			s.add(e);
		}
		
		if (arr.length != s.size()) {
			throw new IllegalArgumentException(String.format(
					"La secuencia en %s tiene elementos repetidos", msg));
		}
	}
	
	/**
	 * Retorna el nodo raíz del árbol binario cuyos recorridos en preorden
	 * e inorden son los especificados.
	 * @param preorder el array que contiene la secuencia en preorden
	 * @param inorder el array que contiene la secuencia en inorden
	 * @return el nodo raíz del árbol binario cuyos recorridos en preorden
	 * e inorden son los indicados
	 * @throws IllegalArgumentException si las secuencias especificadas no
	 * tienen el mismo tamaño o contienen elementos repetidos
	 */
	public static <E> Node<E> createNode(E[] preorder, E[] inorder) {
		if (preorder.length != inorder.length) {
			throw new IllegalArgumentException("Las secuencias no tienen la misma longitud.");
		}
		
		check("preorden", preorder);
		check("inorden", inorder);
		
		return createBinTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}
		
	/**
	 * Clase específica para el nodo nulo ({@code Node.NULL_NODE}).
	 *
	 * @param <E>
	 */
	private static class NullNode<E> extends Node<E> {
		
		private NullNode() {}
		
		private NullNode(Node<E> node) { 
			super(node);
		}

		/**
		 * Retorna {@code true}.
		 * @return {@code true}
		 */
		public boolean isNull() {
			return true;
		}
		
		/**
		 * @throws IllegalStateException
		 */
		public E label() {
			throw new IllegalStateException();
		}
		
		/**
		 * @throws IllegalStateException
		 */
		public Node<E> left() {
			throw new IllegalStateException();
		}
		
		/**
		 * @throws IllegalStateException
		 */
		public Node<E> right() {
			throw new IllegalStateException();
		}
		
		/**
		 * @throws IllegalStateException
		 */
		public void setLabel(E e) {
			throw new IllegalStateException();
		}
		
		/**
		 * @throws IllegalStateException
		 */
		public void setLeft(Node<E> node) {
			throw new IllegalStateException();
		}
		
		/**
		 * @throws IllegalStateException
		 */
		public void setRight(Node<E> node) {
			throw new IllegalStateException();
		}
	}
	
	private Node() {}

	/**
	 * Crea un nodo sin hijos y con la etiqueta especificada. 
	 * @param e la etiqueta del nodo
	 */
	Node(E e) {
		label = e;
		left = NullNode();
		right = NullNode();
	}
	
	/**
	 * Crea un nodo con la etiqueta especificada y los hijos
	 * izquierdo y derecho que se especifican
	 * @param e la etiqueta de la raíz
	 * @param left el hijo izquierdo
	 * @param right el hijo derecho
	 */
	public Node(E e, Node<E> left, Node<E> right) {
		label = e;
		this.left = left;
		this.right = right;
	}
	
	/**
	 * Crea un nuevo nodo copia del especificado.
	 * @param node el nodo a copiar
	 * @throws NullPointerException si el nodo dado es
	 * {@code null}
	 */
	public Node(Node<E> node) {
		if (node == null) {
			throw new NullPointerException();
		}
		
		if (!node.isNull()) {
			label = node.label;
			left = node.left.isNull() ? node.left : new Node<E>(node.left);
			right = node.right.isNull() ? node.right : new Node<E>(node.right);
		}
	}
	
	/**
	 * Retorna {@code false}
	 * @return {@code false}
	 */
	public boolean isNull() {
		return false;
	}
	

	/**
	 * La etiqueta de este nodo
	 * @return la etiqueta del nodo
	 */
	public E label() {
		return this.label;
	}
	
	/**
	 * El hijo izquierdo de este nodo
	 * @return el hijo izquierdo del nodo
	 */
	public Node<E> left() {
		return this.left;
	}
	
	/**
	 * El hijo derecho de este nodo
	 * @return el hijo derecho del nodo
	 */
	public Node<E> right() {
		return this.right;
	}
	
	/**
	 * Cambia la etiqueta de este nodo por la especificada
	 * @param e la etiqueta de reemplazo
	 */
	public void setLabel(E e) {
		label = e;
	}
	
	/**
	 * Cambia el hijo izquierdo de este nodo por el especificado
	 * @param node el nodo de reemplazo
	 * @throws NullPointerException si {@code node} es {@code null}
	 */
	public void setLeft(Node<E> node) {
		if (node == null) {
			throw new NullPointerException();
		}
		
		if (node.isNull()) {
			left = node;
		} else {
			left = new Node<E>(node);
		}
	}
	
	/**
	 * Cambia el hijo derecho de este nodo por el especificado
	 * @param node el nodo de reemplazo
	 * @throws NullPointerException si {@code node} es {@code null}
	 */
	public void setRight(Node<E> node) {
		if (node == null) {
			throw new NullPointerException();
		}
		
		if (node.isNull()) {
			right = node;
		} else {
			right= new Node<E>(node);
		}
	}
}
