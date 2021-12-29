/**
 * Standard Queue. Represented by a circular array.
 */
 public class QueueVector<E> {
       	private final static int DEFAULT_CAPACITY = 100;

	private E[] data;
	private int first;
	private int last;
	private int size;

	public QueueVector () {
		this.first = 0;
		this.last = 0;
		this.size = 0;
		this.data = (E[]) new Object [DEFAULT_CAPACITY];
	}

	public QueueVector (int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException();
		}
		this.first = 0;
		this.last = 0;
		this.size = 0;
		this.data = (E[]) new Object [capacity];
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public E remove () {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		this.size--; //Update size
		int out = this.first; //Keep current index	
		first = ++first%this.data.length; //Update index
		return this.data[out]; //Output current	
	}
}
