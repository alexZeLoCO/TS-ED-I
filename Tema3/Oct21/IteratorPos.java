public class IteratorPos<E> implements Iterator<E> {
	private Iterator<E> itr;
	private int idx;
	private E prev;

	public IteratorPos (Iterable<E> iterable) {
		this.itr = iterable.iterator();	
		this.idx = 0;
		this.prev = null;
	}

	@Override
	public boolean hasNext() {
		return this.itr.hasNext();
	}

	@Override
	public E next () {
		//Excep. in itr.next();
		this.idx++;
		this.prev = itr.next();
		return this.prev;
	}

	@Override
	public void remove () {
		if (this.prev == null) {
			throw new IllegalStateException();	//unchecked
		}
		this.prev = null;
		this.itr.remove();
		this.itr--;		
	}

	/**
	 * @return position of the next element to be returned by next().
	 */
	public int nextPosition () {
		return this.idx;	
	}
}
