public class Tree<E> {
	private Node<E> theRoot;
	private int size;

	private class Node<E> {
		private E label;
		private Node<E> left;
		private Node<E> right;
		boolean isRightThread;

		public Node (E label, Node<E> left, Node<E> right) {
			this.label = label;
			this.left = left;
			this.right = right;
		}

	}

	/**
 	 * Checks if a given element is in the tree.
 	 *
 	 * @param e Element to be searched.
 	 *
 	 * @return True if the element is in the tree.
 	 * @throws NullPointerException if e is null.
 	 */
	public boolean contains (E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		if (this.isEmpty()) {
			return false;
		}
		int x = 0; 
		Node<E> current = null;
		Node<E> child = this.theRoot;
		while (child != null) {
			current = child;
			x = compare(e, current.label);
			if (x == 0) {
				return true;
			}
			if (x > 0) {
				child = current.right;
			} else {
				child = current.left;
			}
		}
		return false;	
	}

	/**
 	 * Adds the element e to the Tree.
 	 *
 	 * @param e Element to be added.
 	 * 
 	 * @return True if the element was added.
 	 * @throws NullPointerException if e is null.
 	 */
	public boolean add (E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		if (this.isEmpty()) {
			this.theRoot = new Node<E> (e);
			this.size++;
			return true;
		}
		int x = 0;
		Node<E> current = null;
		Node<E> child = this.theRoot;
		while (child != null) {
			current = child;
			x = compare(e, current.label);
			if (x > 0) {
				child = current.right;
			} else {
				child = current.left;
			}
		}
		if (x > 0) {
			current.right = new Node<E> (e);
			this.size++;
			return true;
		}
		current.left = new Node<E> (e);
		this.size++;
		return true;
	}
		
	/**
	 * Note: It is actually meant to return the Node<E> not the Tree<E>.
	 *
	 * @return Subtree, whose root is the parent of the root of this subtree.
	 *
	 * @throws NoSuchElementException if the root of this subtree has no parent.
	 */
	public Node<E> parent () {
		if (this.theRoot.right == null) {
			throw new NoSuchElementException();
		}
		Node<E> current = this.theRoot;
		while(!current.isRightThread) {
			current = current.right;
		}
		return current.right;
	}
}

