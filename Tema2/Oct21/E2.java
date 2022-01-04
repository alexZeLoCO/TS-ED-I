public class MyList<E> extends AbstractSequentialList<E> {
	private Node<E> head;
	private Node<E> tail;

	/**
	 * Default Constructor.
	 */
	public MyList () {
		this.head = null;
		this.tail = null;
	}

	private static class Node<E> {
		private E elem;
		private Node<E> next;

		public Node (E e) {
			this(e, null);
		}

		public Node (E e, Node<E> next) {
			this.elem = e;
			this.next = next;
		}
	}

	/**
	 * Returns the size of this list.
	 *
	 * @return Size of this list.
	 */
	public int size () {
		int c = 0;
		Node<E> current = this.head;
		do {
			c++;
			current = current.next;
		} while (current.next != null);
		return c;
	}

	/**
	 * Adds the element to the end of the list.
	 * 
	 * @param e Element to be added.
	 *
	 * @return Last node.
	 * @throws NullPointerException if the element is null.
	 */
	private Node<E> linkLast (E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		if (this.head == null) {
			this.tail = new Node<E> (e);
			this.head = this.tail;
		}
		this.tail.next = new Node<E> (e, null);
		this.tail = this.tail.next;
		return this.tail;
	}

	/**
	 * Adds the element to the front of the list.
	 *
	 * @param e Element to be added.
	 *
	 * @return First node.
	 * @throws NullPointerException if the element is null.
	 */
	private Node<E> linkFirst (E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		this.head = new Node<E> (e, this.head);
		return this.head;
	}

	/**
	 * Adds the element to the index of the list.
	 *
	 * @param index Position of the new element.
	 * @param e Element to be added.
	 *
	 * @return True if added.
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public boolean add (int index, E e) {
		if (index < 0 || index > this.size()) {
			throw new IndexOutOfBoundsException();
		}
		if (this.head == null || index == this.size()) {	//Add last or on empty list
			this.linkLast(e);
			return true;
		}
		if (index == 0) {	//Add first
			this.linkFirst(e);
			return true;
		}
			//Any other situation
		Node<E> current = this.head;
		while (index-- > 1) {
			current = current.next;	
		}
		current.next = new Node<E> (e, current.next);
		return true;
	}	
}
