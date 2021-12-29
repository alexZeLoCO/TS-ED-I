public class StackArrayList<E> {
	private static final int DEFAULT_CAPACITY = 100;

	private ArrayList<E> data;
	private int size;

	public StackArrayList () {
		this(DEFAULT_CAPACITY);	
	}

	public StackArrayList (int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException();
		}
		this.size = 0;
		this.data = new ArrayList<E> (capacity);
	}

	public int size() {
		return this.size;	
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public boolean contains (E e) {
		if (e == null) {
			throw new NullPointerException();
		}	
		return this.data.contains(e);
	}

	public boolean add (E e) {
		(e == null ?) throw new NullPointerException()
		this.size++;	
		return this.data.add(e);
	}

	public E remove () {
		(this.isEmpty() ?) throw new NoSuchElementException();
		this.size--;	
		return this.data.remove(this.size()+1)
	}

	public Iterator<E> iterator1 () {
		return new SARITR1 ();
	}

	public Iterator<E> iterator2 () {
		return new SARITR2 ();
	}

	public Iterator<E> iterator3 () {
		return new SARITR3 ();
	}

	public Iterator<E> iterator4 () {
		return new SARITR4 ();
	}

	private final class SARITR1 implements Iterator<E> {
		private int idx;

		public SARTIR1() {
			this.idx = 0;
		}

		public boolean hasNext() {
			return this.idx == StackArrayList.this.size();
		}

		public E next() {
			if (!this.hasNext()) {
				throw new NoSuchElementException();
			}
			return StackArrayList.this.data.get(this.idx++);
		}
	}

	private final class SARITR2 implements Iterator<E> {
		private Iterator<E> itr;

		public SARITR2 () {
			this.itr = StackArrayList.this.data.iterator();
		}

		public boolean hasNext() {
			return this.itr.hasNext();
		}

		public E next() {		
			return this.itr.next();
		}
	}

	private final class SARITR3 implements Iterator<E> {
		private int idx;

		public SARITR3 () {
			this.idx = StackArrayList.this.size()-1;
		}

		public boolean hasNext() {
			return this.idx == 0;
		}

		public E next() {
			if (!this.hasNext()) {
				throw new NoSuchElementException();
			}
			return StackArrayList.this.data.get(idx--);
		}
	}

	private final class SARITR4 implements Iterator<E> {
		private ListIterator<E> itr;
		
		public SARITR4 () {
			this.itr = StackArrayList.this.iterator(this.size()-1);	
		}

		public boolean hasNext() {
			return this.itr.hasNext();
		}

		public boolean hasPrevious() {
			return this.itr.hasPrevious();
		}

		public E next () {
			return this.itr.next();
		}

		public E previous (){
			return this.itr.previous();
		}
	}
}
