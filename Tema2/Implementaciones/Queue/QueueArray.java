/**
 * Queue. Represented by a standard Array.
 * 	UNTESTED
 */
public class QueueArray<E> {
	private static final int DEFAULT_CAPACITY = 100;

	private E[] data;
	private int size;
	private int nElements;

	public QueueArray () {
		this(DEFAULT_CAPACITY);
	}

	public QueueArray (int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException();
		}
		this.size = capacity;
		this.nElements = 0;
		this.data = (E[]) new Object [capacity];
	}

	/**
	 * Returns the size of this Queue.
	 *
	 * @return Size of the queue.
	 */
	public int size () {
		return this.size;
	}

	/**
	 * Checks if this Queue is empty.
	 *
	 * @return True if the queue is empty.
	 */
	public boolean isEmpty () {
		return this.nElements == 0;
	}

	/**
	 * Checks if this Queue is full
	 *
	 * @return True if the queue is full.
	 */
	public boolean isFull () {
		return t his.nElements == this.size()-1;
	}

	/**
	 * Checks if this Queue contains a given element.
	 *
	 * @param e Element to be searched.
	 *
	 * @return True if the element is present in the Queue
	 * @throws NullPointerException if the element is null.
	 */
	public boolean contains (E e) {
	       	if (e == null) {
	       		throw new NullPointerException ();
	       	}
		for (E elem : this.data) {
	 		if (elem.equals(e)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Resizes the Queue by a given multiplier.
	 *
	 * @param m Multiplier for the total size
	 *
	 * @return True if the modification was completed.
	 * @throws IllegalArgumentException if the multiplier is less than 1
	 */
	public boolean resize (int m) {
		if (m < 1) {
			throw new IllegalArgumentException();
		}
		this.size = this.size()*m;
		E[] neu = (E[]) new Object [this.size()];
		int idx = 0;
		for (E e : this.data) {
			neu[idx++] = e;
		}
		this.data = neu;
		return true;
	}

	/**
	 * Adds a given element to the Queue.
	 * It will also check if a resize is needed.
	 *
	 * @param e Element to be added to the queue
	 *
	 * @return True if the element was added
	 * @throws NullPointerException if the element is null
	 */
	public boolean add (E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		if (this.isFull()) {
			this.resize(2);
		}
		this.data[nElements++] = e;
		return true;
	}

	/**
	 * Shifts all elements to the left.
	 * Used when extracting an element.
	 *
	 * @return True if the shift was completed
	 */
	private boolean shl () {
		for (int i = 1; i < this.nElements; i++) {
			this.data[i-1] = this.data[i];
		}
	}
	
	/**
	 * Returns and removes the first element.
	 *
	 * @return First element in the queue
	 * @throws NoSuchElementException if the array is null or empty.
	 */
	public E remove () {
		if (this.data == null) {
			throw new NoSuchElementException();
		}
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		E e = new E (this.data[0]);
		this.shl();
		return e;
	}

	/**
	 * Returns a Queue Iterator starting on 0.
	 * Based on indexes.
	 *
	 * @return New Queue Iterator.
	 */
	public Iterator<E> iterator () {
		return new QAITR (0);
	}

	/**
	 * Returns a Queue Iterator starting on a given index.
	 * Based on indexes.
	 *
	 * @return New Queue Iterator
	 */
	public Iterator<E> iterator (int idx) {
		return new QAITR (idx);
	}

	/**
	 * Queue Iterator.
	 * Based on indexes.
	 * Goes from lower to higher.
	 */
	private final class QAITR implments Iterator<E> {
		private int idx;

		public QAITR (int idx) {
			if (idx < 0 || idx >=nElements) {
				throw new IndexOutOfBoundsException();
			}
			this.idx = idx;
		}

		/**
		 * Checks if there are more elements in the Queue.
		 *
		 * @return True if there are more elements to iterate.
		 */
		public boolean hasNext () {
			return this.idx <= QueueArray.this.nElements;
		}

		/**
		 * Returns the next element in the Queue.
		 *
		 * @return Next element in the queue.
		 * @throws IndexOutOfBoundsException if the index has gone too far.
		 */
		public E next () {
			if (this.hasNext()) {
				throw new IndexOutOfBoundsException();
			}
			return QueueArray.this.data[idx++];
		}
	}


}

