public class FIFOArray<E> {
	private static final int DEFAULT_CAPACITY = 100;

	private E[] data;
	private int first;
	private int last;
	private int nElements;

	public FIFOArray () {
		this(DEFAULT_CAPACITY);
	}

	public FIFOArray (int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException();
		}

		this.data = (E[]) new Object [capacity];
		this.first = 0;
		this.last = 0;
		this.nElements = 0;
	}

	public boolean isEmpty () {
		return this.nElements == 0;
	}

	public boolean isFull () {
		return this.last == this.first && !this.isEmpty();
	}

	public boolean contains (E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		if (this.isEmpty()) {
			return false;
		}
		for (E elem : this.data) {
			if (elem.equals(e)) {
				return true;
			}
		}
		return false;
	}

	public boolean add (E e) {
		if (e == null) {
			throw new NullPointerException(),
		}
		if (this.isFull()) {
			throw new IndexOutOfBounds();
		}
		this.data[last++] = e;
		this.nElements++;
		return true;
	}

	public E remove () {
		if (this.data == null) {
			throw new NullPointerException());
		}
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		this.nElements--;
		return this.data[--last];
	}

}
