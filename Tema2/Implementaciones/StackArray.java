public class StackArray<E> {
	private static final int DEFAULT_CAPACITY = 100;
	
	private E[] data;
	private int size;
	private int nElements;

	public StackArray () {
		this(DEFAULT_CAPACITY);
	}

	public StackArray (int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException(),
		}
		this.size = capacity;
		this.data = (E[]) new Object [capacity];
		this.nElements = 0;
	}

	public int size() {
		return this.size;
	}

	public int getnElements () {
		return this.nElements;
	}

	public boolean isEmpty () {
		return this.getnElements() == 0;
	}

	public boolean isFull () {
		return this.getnElements() == this.size();
	}

	public boolean contains (E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		for (E elem : this.data) {
			if (e.equals(elem)) {
				return true;
			}
		}
		return false;
	}

	private boolean resize (int m) {
		if (m < 1) {
			throw new IllegalArgumentException();
		}
		E[] neu = (E[]) Object [m*this.size()];
		int idx = 0;
		for (E e : this.data) {
			neu[idx++] = e;
		}
		this.size = m*this.size();
		return true;
	}

	public boolean add (E e) {
		if (e == null) {
			throw new NullPointerException ();
		}
		if (this.getnElements() == this.size()-1) {
			this.resize(2);
		}
		this.data[this.nElements++] = e;
		return true;
	}
