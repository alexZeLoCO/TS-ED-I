/**
 * Standard Stack. Represented by an array.
 */

public StackVector<E> {
	private static final int DEFAULT_CAPACITY = 100;

	private E[] data;
	private int last; // siguiente posicion en la que se include un nuevo elemento

	public StackVector () {
		this.last = 0;
		this.data = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public StackVector (int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException () {
		}	
		this.last = 0;
		this.data = (E[]) new Object[capacity];
	}

	public int size () {
		return this.last;
	}

	public boolean contains (E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		for (E elem : this.data) {
			if (elem.equals(e) {
				return true;
			}
		}
		return false;
	}

	public boolean isEmpty () {
		return this.size() == 0;
	}

	public boolean add (E e) {
		if (e == null) {
			throw new NullPointerException ();
		}
		this.data[size++] = e;
		return true;
	}

	public E pop () {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		return this.data[--last];
	}
}
