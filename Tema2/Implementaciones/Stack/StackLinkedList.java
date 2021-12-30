/**
 * Stack. Represented using an LinkedList.
 * 	UNTESTED
 */
public class StackLinkedList<E> {
	private static final int DEFAULT_CAPACITY = 100;

	private LinkedList<E> data;
	private int nElements;

	public StackLinkedList () {
		this(DEFAULT_CAPACITY);
	}

	public StackLinkedList (int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException();
		}
		this.nElements = 0;
		this.data = new LinkedList<E> (capacity);
	}

	/**
	 * Returns the size of this Stack.
	 * 
	 * @return Size of the stack.
	 */
	public int size () {
		return this.data.size();
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
		return this.data.contains(e);
	}

	/**
	 * Adds a given element to this Stack.
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
		this.data.addLast(e);
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
		return this.data.remove(--this.nElements);
	}

	/**
	 * Returns an iterator starting on 0.
	 * Based on indexes.
	 * Goes from lower to higher index.
	 *
	 * @return New iterator staring on 0.
	 */
	public Iterator<E> iterator () {
		return iterator(0);
	}

	/**
	 * Returns an iterator staring on a specific position.
	 * Based on indexes.
	 * Goes from lower to higher index.
	 *
	 * @param idx Starting position of the iterator.
	 *
	 * @return New iterator stargin on idx.
	 */
	public Iterator<E> iterator (int idx) {
		return new SAITR(idx);
	}

	/**
	 * Stack Array Iterator.
	 * A non-modification Iterator based on an index.
	 * Goes from lower to higher index.
	 */
	private final class SAITR implements Iterator<E> {
		private int idx;

		public SAITR (int idx) {
			if (idx < 0 || idx > StackLinkedList.this.size()) {
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
			return this.idx <= StackLinkedList.this.nElements;
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
			return StackLinkedList.this.data.get(idx++);
		}
	}

	/**
	 * Returns a Stack Iterator starting on 0.
	 * Based on an Internal Iterator.
	 * Goes from lower to higher index.
	 *
	 * @return New Stack Iterator
	 */
	public Iterator<E> iterator2 () {
		return iterator2(0);
	}

	/**
	 * Returns a Stack Iterator starting on an index.
	 * Based on an Internal Ierator.
	 * Goes from lower to higher index.
	 *
	 * @return New Stack Iterator
	 */
	public Iterator<E> iterator2 (int idx) {
		return new SALITR2 (idx);
	}

	/**
	 * Stack Iterator.
	 * Based on an Internal Iterator.
	 * Goes from lower to higher index.
	 */
	private final class SALITR2 implements Iteartor<E> {
		private Iterator<E> itr;

		public SALITR2 (int idx) {
			if (idx < 0 || idx > StackLinkedList.this.size()-1) {
				throw new IndexOutOfBoundsException();
			}
			this.itr = StackLinkedList.this.data.iterator(idx);
		}

		/**
		 * Checks if there are more elements in the Stack.
		 *
		 * @return True if there are more elements to iterate.
		 */
		public boolean hasNext() {
			return this.itr.hasNext();
		}

		/**
		 * Returns the next element in the Stack.
		 *
		 * @return next element in the stack.
		 * @throws IndexOutOfBoundsException if the index has gone too far.
		 */
		public E next() {
			if (!this.hasNext()) {
				throw new IndexOutOfBoundsException();
			}
			return this.itr.next();
		}
	}

	/**
	 * Returns a Stack Iterator starting on the last element.
	 * Based on indexes.
	 * Goes from higher to lower.
	 *
	 * @return New Stack Iterator
	 */
	public Iterator<E> iterator3 () {
		reutrn iterator3(this.size()-1);
	}

	/**
	 * Returns a Stack Iterator starting on a given index.
	 * Based on indexes.
	 * Goes from higher to lower.
	 *
	 * @return New Stack Iterator
	 */
	public Iterator<E> iterator3 (int idx) {
		return new SALITR3(idx);
	}

	/**
	 * Stack Iterator.
	 * Based on indexes.
	 * Goes from higher to lower.
	 */
	private final class SALITR3 implments Iterator<E> {
		private int idx;

		public SALITR3 (int idx) {
			if (idx < 0 || idx > StackLinkedList.this.size()-1) {
				throw new IndexOutOfBoundsException();
			}
			this.idx = idx;
		}

		/**
		 * Checks if there are more elements in the Stack.
		 *
		 * @return True if there are more elements to iterate.
		 */
		public boolean hasPrevious() {
			return this.idx < 0;
		}

		/**
		 * Returns the next element in the Stack.
		 *
		 * @return previous element in the stack.
		 * @throws IndexOutOfBoundsException if the index has gone too far
		 */
		public E previous() {
			if(!this.hasPrevious()) {
				throw new IndexOutOfBoundsException();
			}
			return this.data.get(idx--);
		}	
	}

	/**
	 * Returns a Stack Iterator starting on the last element.
	 * Based on an Internal Iterator.
	 * Goes from higher to lower.
	 *
	 * @return New Stack Iterator
	 */
	public Iterator<E> iterator4 () {
		return iterator4 (this.size()-1);
	}

	/**
	 * Returns a Stack Iterator starting on a given index.
	 * Based on an Internarl Iterator.
	 * Goes from higher to lower.
	 *
	 * @return New Stack Iterator
	 */
	public Iterator<E> iterator4 (int idx) {
		return new SALITR4 (idx);
	}

	/**
	 * Stack Iterator.
	 * Based on an Internal Iterator.
	 * Goes from higher to lower.
	 */
	private final class SALITR4 implements Iterator<E> {
		private Iterator<E> itr;
	
		public SALITR4 (int idx) {
			if (idx < 0 || idx > StackLinkedList.this.size()-1) {
				throw new IndexOutOfBoundsException();
			}
			this.itr = StackLinkedList.data.listIterator(idx);
		}

		/**
		 * Checks if there are more elements in the Stack.
		 *
		 * @return True if there are more elements to iterate.
		 */
		public boolean hasPrevious() {
			return this.itr.hasPrevious();
		}

		/**
		 * Returns the previous element in the Stack.
		 *
		 * @return previous element in the stack.
		 * @throws IndexOutOfBoundsException if the index has gone too far
		 */
		public E previous() {
			if (!this.hasPrevious()) {
				throw new IndexOutOfBoundsException();
			}
			return this.itr.previous();
		}
	}
}
