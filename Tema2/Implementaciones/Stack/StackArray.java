/**
 * Stack. Represented using a stardard array.
 * 	UNTESTED
 */
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
			throw new IllegalArgumentException();
		}
		this.size = capacity;
		this.nElements = 0;
		this.data = (E[]) new Object[capacity];
	}

	/**
	 * Returns the size of this Stack.
	 * 
	 * @return Size of the stack.
	 */
	public int size () {
		return this.size;
	}

	/**
	 * Checks if this Stack is empty.
	 *
	 * @return True if the stack is empty.
	 */
	public boolean isEmpty() {
		return this.nElements == 0;
	}

	/**
	 * Checks if this Stack is full.
	 *
	 * @return True if the stack is full.
	 */
	public boolean isFull () {
		return this.nElements == this.size()-1;
	}

	/**
	 * Checks if a given element is present in this Stack.
	 *
	 * @param e Element to be searched.
	 *
	 * @return True if the element is present in the stack.
	 * @throws NullPointerException if the element is null.
	 */
	public boolean contains (E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		for (E elem : this.data) {
			if (elem.equals(e)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Resizes this Stack by a given multiplier.
	 *
	 * @param m Multiplier for the total size.
	 *
	 * @return True if the modification was completed.
	 * @throws IllegalArgumentException if the multiplier is less than 1.
	 */
	private boolean resize (int m) {
		if (m < 1) {
			throw new IllegalArgumentException ();
		}
		E[] neu = (E[]) new Object [this.size()*m];
		this.size = this.size() * m;
		this.data = neu;
		return true;
	}

	/**
	 * Adds a given element to this Stack.
	 * It will also check if a resize is needed.
	 *
	 * @param e Element to be added.
	 *
	 * @return True if the element was added.
	 * @throws NullPointerException if the element is null
	 */
	public boolean add (E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		if (this.nElements == this.size()-1) {
			this.resize(2);
		}
		this.data[nElements++] = e;
		return true;
	}

	/**
	 * Returns and removes the last element that was inserted.
	 *
	 * @return Last element that was inserted in the stack.
	 * @throws NoSuchElementException if there are no elements in the stack.
	 */
	public E remove () {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		return this.data[--nElements];
	}

	/**
	 * Returns an iterator starting on 0.
	 *
	 * @return New iterator staring on 0.
	 */
	public Iterator<E> iterator1 () {
		return iterator(0);
	}

	/**
	 * Returns an iterator staring on a specific position.
	 *
	 * @param idx Starting position of the iterator.
	 *
	 * @return New iterator stargin on idx.
	 */
	public Iterator<E> iterator1 (int idx) {
		return new SAITR1(idx);
	}

	/**
	 * Stack Array Iterator.
	 * A non-modification Iterator based on an index.
	 */
	private final class SAITR1 implements Iterator<E> {
		private int idx;

		public SAITR1 (int idx) {
			if (idx < 0 || idx > StackArray.this.size()) {
				throw new IndexOutOfBoundException();
			}
			this.idx = idx;
		}

		/**
		 * Checks if there is another element to iterate
		 *
		 * @return True if there is another element.
		 */
		public boolean hasNext() {
			return this.idx <= StackArray.this.nElements;
		}

		/**
		 * Returns the next element in the Stack.
		 *
		 * @return next element in the stack.
		 * @throws IndexOutOfBoundsException if the idx has gone too far.
		 */
		public E next() {
			if (!hasNext()) {
				throw new IndexOutOfBoundsException();
			}
			return StackArray.this.data[idx++];
		}
	}

	/**
	 * Returns an iterator starting on the last element.
	 * Based on Indexes
	 * Goes from higher to lower.
	 *
	 * @return New Stack Iterator
	 */
	public Iterator<E> iterator2 () {
		return iterator2(this.nElements-1);
	}

	/**
	 * Returns an iterator starting on a given index.
	 * Based on Indexes.
	 * Goes from higher to lower.
	 *
	 * @return New Stack Iterator
	 */
	public Iterator<E> iterator2 (int idx) {
		return new SAITR12 (idx);
	}

	/**
	 * Stack Array Iterator.
	 * Based on Indexes.
	 * Goes from higher to lower.
	 */
	private final class SAITR12 implements Iterator<E> {
		private int idx;

		public SAITR12 (int idx) {
			if (idx < 0 || idx > StackArray.this.size()) {
				throw new IndexOutOfBoundsException();
			}
			this.idx = idx;
		}

		/**
		 * Checks if there are more elements in the  Stack.
		 *
		 * @return True if there are more elements to iterate
		 */
		public boolean hasPrevious() {
			return this.idx >= 0;
		}

		/**
		 * Returns the previous element in the stack.
		 *
		 * @return previous element in the stack.
		 * @throws IndexOutOfBoundsException if the index has gone too far
		 */
		public E previous() {
			if (!this.hasPrevious()) {
				throw new IndexOutOfBoundsException();
			}
			return StackArray.this.data[idx--];
		}
	}
}
