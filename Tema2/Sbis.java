public class Sbis<E> {
	private LinkedList<E> data;
	
	public Iterator<E> iterator () {
		return new SITR ();
	}

	public int size() {
		return this.data.size();
	}

	private final class SITR implements Iterator<E> {
		private Iterator<E> itr;

		public SITR () {
			this.itr = new Sbis.this.data.iterator();	
		}

		public boolean hasNext() {
			return this.itr.hasNext();	
		}

		public E next() {
			return this.itr.next();	
		}

	}

}
