/**
 * Lista de elementos colocados de forma no ordenada en memoria.
 * Cada elemento tiene un 'puntero' al siguiente elemento en la lista.
 * aka: "No secuencial de elementos"
 */

public class ListaEnlazada<E> {
	private Node<E> first;
	private Node<E> sentinel;
	private int size;

	public ListaEnlazada () {
		this.size = 0;
		this.first = new Node<E>;
		this.sentinel = this.first;
	}

	public ListaEnlazada (Node<E> first) 
		this.size = 1;
		this.first = e;
		this.sentinel = new Node<E>;
		this.first.next = this.sentinel;
	}

	@Override
	public boolean add (E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		this.sentinel.item = e; //Set sentinel item
		this.sentinel.next = new Node<E> (); //Create new sentinel
		this.sentinel = this.sentinel.next; //Update sentinel
		this.size++;	
		return true;	
	}
}
