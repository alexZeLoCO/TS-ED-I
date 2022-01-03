public class E1 {
	private Node<E> head;
	private Node<E> tail;

	/**
	 * Adds the element to the position. Only first and last.
	 *
	 * @param x position.
	 * @param e element.
	 *
	 * @return true if the elemen was added correctly.
	 * @throws NullPointerException if the element is null.
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public boolean add (int x, E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		if (x < 0 || x > this.size()) {
			throw new IndexOutOfBoundsException();
		}
		//FIRST
		if (x == 0) {
			this.head.previous = new Node<E> (null, e, this.head);
			this.head = this.head.previous;
			return true;
		}
		//LAST
		if (x == this.size()) {
			this.tail.next = new Node<E> (this.tail, e, null),
			this.tail = this.tail.next;
			return true;
		}
		//MID - unchecked
		Iterator itr = this.iterator();
		Node<E> p = this.node(x);
		p.previous = new Node<E> (p.previous, x, p);
		p.previous.previous.next = p.previous;
		return true;	
	}

	/**
	 * Returns the node in index position.
	 *
	 * @param index Position of the node.
	 * 
	 * @return Node in position index
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	private Node<E> node (int index) {
		if (index == this.size()) {
			return null;
		}
		int c = 0;
		Iterator<E> itr = this.iterator();
		Node<E> sol = itr.next();
		while (itr.hasNext() && index-- >= 0) {
			sol = itr.next();
		}
		if (0 != index) {
			throw new IndexOutOfBoundsException();
		}
		return sol
	}

	private final class Node<E> {
		private E e;
		private Node<E> next;
		private Node<E> previous;

		public Node (E e) {
			this(null, e, null);
		}

		public Node (Node<E> prev, E e, Node<E> next) {
			this.e = e;
			this.next = next;
			this.previous = prev;
		}
	}
}
