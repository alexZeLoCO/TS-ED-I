/**
 * Linked List. Modifiable.
 */
public class SimpleLL<E> {
	private Node<E> firstNode;
	private Node<E> sentinel;

	public SimpleLL () {
		this.firstNode = new Node<E> ();
		this.sentinel = this.firstNode;	
	}

	public boolean isEmpty() {
		return this.firstNode.equals(this.sentinel);
	}

	public boolean add (E e) { 
		if (e == null) {
			throw new NullPointerException();
		}
		this.sentinel = new Node<E> (e, new Node<E>());
		this.sentinel = this.sentinel.next;
		return true;	
	}

	private final class Node<E> {
		E elem;
		Node<E> next;
	
		public Node () {
		}

		public Node (E elem, Node<E> next) {
			if (elem == null || next == null) {
				throw new NullPointerException();
			}	
			this.elem = elem;
			this.next = new Node<E> (next);
		}
	}	
}
