/**
 * Cola. Representada por un ArrayList.
 */
public class FIFOArray<E> {
	private static final int DEFAULT_CAPACITY;

	private ArrayList<E> data;
	private int start;
	private int end;
	private int nElements;
	
	public FIFOArray () {
		this(DEFAULT_CAPACITY);
	}

	public FIFOArray (int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException();
		}
		this.data = new ArrayList<E> (capacity);
		this.start = 0;
		this.end = 0;
		this.nElements = 0;
	}

	public boolean isEmpty() {
		return this.nElements == 0;
	}
	
	public boolean contains (E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		if (this.isEmpty()) {
			return false;
		}
		for (E elem: this.data) {
			if (e.equals(elem)) {
				return true;
			}
		}
		return false;
	}

	public boolean add (E e) {
		if (e == null) {
			throw new NullPointerException();
		}

		if (this.isFull) {
			throw new IndexOutOfBounds();
		}

		if (this.data.add(e)) { 
			this.nElements++;
			this.last = ++this.last%this.data.size();
			return true;
		}
		return false;
	}	

	public E remove () {
		if (this.data == null) {
			throw new NoSuchElementException();
		}
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		int out = this.first;
		this.first = ++this.first%this.data.size();
		this.nElements--;
		return this.data.get(out);
	}	
}
