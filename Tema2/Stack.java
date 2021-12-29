/**
 * Standard-stack. Only the TOS is accessible.
 */
public class Stack<E> {
	private Node<E> first;	
	private int size;

	public Stack<E> () {
		this.first = new Node<E> ();
		this.size = 0;
	}

	public Stack<E> (Node<E> first) {
		this.first = new Node<E> (first);
		this.size = 1;
	}

	public boolean add (E e) {
		if (e == null) {
			throw new NullPointerException();
		}	
		Node<E> aux = new Node <E> (e);
		aux.next = this.head;
		this.head = aux;
		this.size++;
		return true;
	}

	public Node<E> remove () {
		if (this.first == null) {
			throw new NullPointerException();
		}
		Node<E> out = new Node<E> (this.first);
		this.first = this.first.next;
		this.size--;
		return out;	
	}
}
