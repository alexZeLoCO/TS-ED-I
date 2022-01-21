package estDatos;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Las instancias del tipo RedBlackTree<E> son árboles binarios
 * de búsqueda rojo-negro.
 * 
 * @param <E> tipo de las etiquetas de los nodos del árbol
 */
public class RedBlackTree<E> extends AbstractCollection<E> {
	
	/**
	 * Nodo raíz del árbol rojo-nego
	 */
	private Node theRoot;
	
	/**
	 * Comparador para las etiquetas del árbol. Si el comparador
	 * es {@code null} el orden será el orden natural del tipo E
	 * (el tipo E tiene que implementar la interfaz Comparable<E>).
	 */
	private Comparator<? super E> cmp;
	
	/**
	 * Número de nodos del árbol rojo-negro
	 */
	private int size;

	// color de los nodos
	public static final boolean RED   = false;
	public static final boolean BLACK = true;

	/**
	 * Clase interna de los nodos del árbol
	 */
	private class Node {
		private E label;			// etiqueta
		private Node left;			// nodo izquierdo
		private Node right; 		// nodo derecho
		private Node parent;		// nodo padre
		private boolean color;		// color del nodo
				
		private Node(E e) { // nodo raíz
			this.label = e;
			this.left = null;
			this.right = null;
			this.parent = null;
			this.color = BLACK;
		}
		
		private Node(E e, Node parent) {
			this.label = e;
			this.left = null;
			this.right = null;
			this.parent = parent;
			this.color = RED;
		}
		
	} // fin class Node
	
	/**
	 * Crea un árbol rojo-negro vacío que ordenará los
	 * elementos según el orden natural del tipo de éstos.
	 */
	public RedBlackTree() {
		this.theRoot = null;
		this.cmp = null;
		this.size = 0;
	}

	/**
	 * Crea un árbol rojo-negro vacío que ordenará los
	 * elementos según el orden que establece el comparador
	 * especificado.
	 * @param cmp el comparador
	 */
	public RedBlackTree(Comparator<E> cmp) {
		this();
		this.cmp = cmp;
	}
	
	/**
	 * Crea un árbol rojo-negro vacío y añade los elementos de
	 * a colección especificada en el mismo orden en que se
	 * obtiene al iterar sobre ésta. Los elementos en el árbol
	 * se ordenan según el orden natural del tipo de éstos.
	 * @param c la colección
	 */
	public RedBlackTree(Collection<? extends E> c) {
		this();
		this.addAll(c);
	}

	/**
	 * Crea un árbol rojo-negro vacío y añade los elementos de
	 * a colección especificada en el mismo orden en que se
	 * obtiene al iterar sobre ésta. Los elementos en el árbol
	 * se ordenan según el orden que establece el comparador
	 * especificado.
	 * @param c la colección
	 * @param cmp el comparador
	 */
	public RedBlackTree(Collection<? extends E> c,
			Comparator<E> cmp) {
		this(cmp);
		this.addAll(c);
	}

	
	/**
	 * Permite comparar los dos elementos especificados, retornando
	 * un entero positivo, cero o negativo, si {@code a>b}, {@code a=b}
	 * o {@code a<b}, respectivamente.
	 * @param a el primero elemento a comparar
	 * @param b el segundo elemento a comparar
	 * @throws ClassCastException si el comparador de este árbol es
	 * nulo y el tipo E de las etiquetas no es Comparable.
	 */
	@SuppressWarnings("unchecked")
	public int compare(E a, E b) {
		if (cmp == null && !(a instanceof Comparable<?>)) {
			throw new ClassCastException("El tipo " + a.getClass().getName() +
					" no es comparable.");
		}
		return cmp == null
				      ? ((Comparable<E>) a).compareTo((E) b)
			          : cmp.compare(a, b);
	}
	
	/**
	 * Retorna el comparador de este árbol rojo-negro, si es
	 * {@code null} los elementos se ordenan según el orden natural
	 * del tipo de éstos.
	 * @return el comparador de éste árbol
	 */
	public Comparator<? super E> comparator() {
		return this.cmp;
	}

	@Override
	public Iterator<E> iterator() {
		return new InorderIterator(theRoot);
	}

	@Override
	public int size() {
		return size;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object o) {
		Node current = theRoot;
		while (current != null) {
			int x = compare((E)o, current.label);
			if (x == 0) {
				return true;
			} else {
				if (x > 0) {
					current = current.right;
				} else {
					current = current.left;
				}
			}
		}
		
		return false;
	}
	
	private void rotateLeft(Node node) {
		if (node != null) {
			Node r = node.right;
			node.right = r.left;
			if (r.left != null)
				r.left.parent = node;
			r.parent = node.parent;
			if (node.parent == null)
				theRoot = r;
			else if (node.parent.left == node)
				node.parent.left = r;
			else
				node.parent.right = r;
			r.left = node;
			node.parent = r;
		}
	}
			
	private void rotateRight(Node node) {
		if (node != null) {
			Node l = node.left;
			node.left = l.right;
			if (l.right != null)
				l.right.parent = node;
			l.parent = node.parent;
			if (node.parent == null)
				theRoot = l;
			else if (node.parent.right == node)
				node.parent.right = l;
			else
				node.parent.left = l;
			l.right = node;
			node.parent = l;
		}
	}
			
	// Restablece el equilibrio las condiciones
	// de un árbol rojo-negro
	private void fixAdd(Node x) {
		while (x != null && x != theRoot && color(parent(x))== RED) {
			Node y = parent(x);
			Node z = parent(y);
			if (y == left(z)) {	// inserción por la izquierda
				Node t = right(z);	// tio de x
				// caso 1: tio de x rojo
				if (color(t) == RED) {
					setColor(y, BLACK);
					setColor(z, RED);
					setColor(t, BLACK);
					x = z;
				} else { // tio de x negro
					// caso 2: tio negro nodo x a la derecha
					if (x == right(y)) {	// caso 2: nodo x a la derecha
						rotateLeft(y);
						x = y;
					}
					// caso 3: tio negro nodo x a la izquierda
					rotateRight(z);
					setColor(z, RED);
					setColor(y, BLACK);
				}
			} else {				// inserción por la derecha (simétrico)
				Node t = left(z);	// tio de x
				// caso 1: tio de x rojo
				if (color(t) == RED) {
					setColor(y, BLACK);
					setColor(z, RED);
					setColor(t, BLACK);
					x = z;
				} else { // tio de x negro
					// caso 2: tio negro nodo x a la derecha
					if (x == left(y)) {	// caso 2: nodo x a la izquierda
						rotateRight(y);
						x = y;
					}
					// caso 3: tio negro nodo x a la derecha
					rotateLeft(z);
					setColor(z, RED);
					setColor(y, BLACK);
				}
			}
		}
		
		// poner la raíz a negro
		setColor(theRoot, BLACK);
	}

	// Alex code
	
	/**
	 * Returns the right node of a given node.
	 * 
	 * @param x Node.
	 * @return right child of the node.
	 */
	private Node right (RedBlackTree<E>.Node x) {
		return x.right;
	}

	/**
	 * Returns the left node of a given node.
	 * 
	 * @param x Node.
	 * @return left child of the node.
	 */
	private Node left (RedBlackTree<E>.Node x) {
		return x.left;
	}

	/**
	 * Returns the parent of a given node.
	 * 
	 * @param x Node.
	 * @return parent of the node.
	 */
	private Node parent(RedBlackTree<E>.Node x) {
		return x.parent;
	}

	/**
	 * Sets the given color to a given node.
	 * 
	 * @param x Node.
	 * @param color Color for the node.
	 */
	public void setColor (RedBlackTree<E>.Node x, boolean color) {
		x.color = color;
	}

	/**
	 * Returns the color of a given node.
	 * 
	 * @param x Node.
	 * @return color of the node.
	 */
	public boolean color (RedBlackTree<E>.Node x) {
		return x.color;
	}

	// End of Alex code
	
	@Override
	public boolean add(E e) {
		if (isEmpty()) {
			theRoot = new Node(e);
			size++;
			return true;
		}

		// búsqueda de la posición de inserción
		int x = 0;
		Node current = null;
		Node child = theRoot;
		while (child != null) {
			current = child;
			x = compare(e, current.label);
			if (x == 0) {	// elemento existente
				return false;
			}
			if (x > 0) {	// añadir  al subárbol derecho
				child = current.right;
			} else {  		// añadir al subárbol izquierdo
				child = current.left;
			}
		}

		if (current == theRoot) {
			setColor(current, BLACK);
		}

		if (x > 0) { 	// insertar e a la derecha
			current.right = new Node(e, current);
			current = current.right;
		} else {		// insertar e la izquierda 
			current.left = new Node(e, current);
			current = current.left;
		}
		
		size++;			// contabilizar e
		
		// restablecer el equilibrio, si es necesario
		fixAdd(current);
			
		return true;
	}
	
	// operación interna que cambia la raíz de este subárbol
	// (contiene la etiqueta a quitar) por el nodo cuya
	// etiqueta es la mayor del subárbol root.left
	private Node removeTop(Node root) {
		Node left = root.left;
		Node right = root.right;
		
		if (left == null) { // caso 1
			return right;
		}

		if (right == null) { // caso 2
			return left;
		}
		
		if (left.right == null) { // caso 3
			left.right = right;
			right.parent = left;
			return left;
		}
		
		// caso general
		Node parent = root;
		Node current = left;
		while (current.right != null) {
			parent = current;
			current = current.right;
		}
		
		parent.right = current.left;
		if (current.left != null) {
			current.left.parent = parent;
		}
		left.parent = current;
		current.left = left;
		right.parent = current;
		current.right = right;
		
		return current;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object o) {
		if (this.isEmpty()) {
			return false;
		}
		
		// comprobar si el elemento a borrar está en la raíz 
		if (compare((E)o, theRoot.label) == 0) {
			// el elemento a borrar está en la raíz
			theRoot = removeTop(theRoot);
			if (theRoot != null) {
				theRoot.parent = null;
			}
			size--;
			return true;
		}
		
		// si el elemento a borrar no está en la raíz, buscar
		// el nodo que lo contiene y el nodo padre de éste
		Node parent = null;
		Node child = theRoot;
		while (child != null) {
			parent = child;
			int x = compare((E) o, child.label);
			if (x > 0) { // buscar en el subárbol derecho
				child = child.right;
				if (child != null
						&& compare((E) o,  child.label) == 0) {
					// encontrado
					parent.right = removeTop(child);
					if (parent.right != null) {
						parent.right.parent = parent;
					}
					size--;
					return true;
				}
			}
			else { // buscar en el subárbol izquierdo
				child = child.left;
				if (child != null
						&& compare((E) o, child.label) == 0) {
					// encontrado
					parent.left = removeTop(child);
					if (parent.left != null) {
						parent.left.parent = parent;
					}
					size--;
					return true;
				}
			}
		}
		
		return false;
	}
	
	// Iterador que proporciona, una a una, las etiquetas de
	// los nodos del árbol rojo-negro. Los nodos del árbol se
	// visitan en inorden.
	private final class InorderIterator implements Iterator<E> {
		private LinkedList<Node> stack;	// pila auxiliar
		private Node next;				// elemento que retornará next()
		private Node previous;			// último elemento retornado por next()

		
		/**
		 * Obtiene el nodo situado más a la izquierda del ABB. Además,
		 * añade a la pila todos los nodos en el camino de la raíz del 
		 * árbol hasta él (para poder recuperarlos posteriormente)
		 */
		private void slideLeft(Node root) {
			while (root != null) {
				stack.addFirst(root);
				root = root.left;
			}
		}
		
		private InorderIterator(Node root) {
			stack = new LinkedList<>();
			// primer nodo de la secuencia en inorden
			slideLeft(root);
			next = stack.isEmpty() ? null : stack.remove();
			previous = null;
		}
				
		public boolean hasNext() {
			return next != null;
		}
		
		public E next() {
			if (! hasNext()) {
				throw new NoSuchElementException();
			}
			
			previous = next;
			
			if (next.right != null) {
				slideLeft(next.right);
			}

			next = stack.isEmpty() ? null : stack.remove();
			return previous.label;
		}
		
		public void remove() {
			if (previous == null) {
				throw new IllegalStateException();
			}
			
			if (theRoot == previous) { // borrar la raíz
				theRoot = removeTop(theRoot);
			}
			else { // el elemento a borrar no está en la raíz
				Node parent = null;
				Node child = theRoot;
				while (child != previous) {
					parent = child;
					if (compare(previous.label, child.label) > 0) {
						// buscar en el subárbol derecho
						child = child.right;
					}
					else { // buscar en el subárbol izquierdo
						child = child.left;
					}
				}
				
				if (parent.left == previous) {
					parent.left = removeTop(previous);
				}
				else {
					parent.right = removeTop(previous);
				}
			}
			
			size--;
			previous = null;
		}
		
	} // fin class InorderIterator
	
} // fin class RedBlackTree
