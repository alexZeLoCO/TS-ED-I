/**
 * Queue. Represented by a standard ArrayList.
 * 	UNTESTED
 */
public class QueueArrayList<E> {
	private static final int DEFAULT_CAPACITY = 100;

	private ArrayList<E> data;
	private int nElements;

	public QueueArrayList () {
		this(DEFAULT_CAPACITY);
	}

	public QueueArrayList (int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException();
		}
		this.nElements = 0;
		this.data = new ArrayList<E> (capacity);
	}

	/**
	 * Returns the size of this Queue.
	 *
	 * @return Size of the queue.
	 */
	public int size () {
		return this.data.size();
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
		return this.nElements == this.size()-1;
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
		return this.data.contains(e);
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
		ArrayList<E> neu = new  ArrayList<E> (m*this.size());
		neu.addAll(this.data);
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
		this.data.add(e);
		return true;
	}

	/**
	 * Shifts all elements to the left.
	 * Used when extracting an element.
	 *
	 * @return True if the shift was completed
	 */
	private boolean shl () {
		for (int i = 0; i < this.nElements-1; i++) {
			this.data.set(i, this.data.get(i+1));	//Assuming data.set(index, element);
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
		E e = new E (this.data.get(0));
		this.shl();
		return e;
	}

	/**
	 * Returns a Queue Iterator starting on 0.
	 * Based on indexes.
	 *
	 * @return New Queue Iterator.
	 */
	public Iterator<E> iterator1 () {
		return new QALITR1 (0);
	}

	/**
	 * Returns a Queue Iterator starting on a given index.
	 * Based on indexes.
	 *
	 * @return New Queue Iterator
	 */
	public Iterator<E> iterator1 (int idx) {
		return new QALITR1 (idx);
	}

	/**
	 * Queue Iterator.
	 * Based on indexes.
	 * Goes from lower to higher.
	 */
	private final class QALITR1 implments Iterator<E> {
		private int idx;

		public QALITR1 (int idx) {
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
			return this.idx <= QueueArrayList.this.nElements;
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
			return this.data.get(idx++);
		}
	}

	/**
 	 * Returns a Queue Iterator starting on 0.
	 * Based on an Internal Iterator.
	 *
	 * @return New Queue Iterator.
	 */
	public Iterator<E> iterator2 () {
		return iterator2(0);
	}

	/**
	 * Returns a Queue Iterator starting on a given index.
	 * Based on an Internal Iterator.
	 *
	 * @return New Queue Iterator.
	 */
	public Iterator<E> iterator2 (int idx) {
		return new QALITR2(idx);
	}

	/**
	 * Queue Iterator.
	 * Based on an Internal Iterator.
	 * Goes from lower to higher.
	 */
	private final class QALITR2 implements Iterator<E> {
		private Iterator<E> itr;

		public QALITR2 (int idx) {
			if (idx < 0 || idx > QueueArrayList.this.nElements) {
				throw new IllegalArgumentException();
			}
			this.itr = QueueArrayList.this.data.iterator(idx);
		}

		/**
		 * Checks if there are more elements in the Queue.
		 *
		 * @return True if there are more elements to iterate.
		 */
		public boolean hasNext () {
			return this.itr.hasNext(),
		}

		/**
		 * Returns the next element in the Queue.
		 *
		 * @return Next element in the queue.
		 */
		public E next () {
			return this.itr.next();
		}
	}
}
