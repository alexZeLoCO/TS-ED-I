//	27.12.21

/**
 * 1.5 Noviembre 2019, parcial. Apartado 2.
 * Constructor si C<E> es un tipo modificable.
 *
 * Extra:
 * 	Iterador si C<E> es un tipo no modificable.
 *
 */
public class C<E> extends AbstractCollection<E> {
	private LinkedList<E> data;
	
	//Tipo modificable
	public C (Collection<? extends E> copy) {
		this();
		this.addAll(copy);
	}
	
	public boolean add (E e) {
		if (e == null) {
			throw new NullPointerException();
		}
		if (!this.contains(e)) {
			return this.data.add(e);	
		}
		return false;

	}

	public Iterator<E> iterator () {
		return new CITR();
	}
	
	//Itr No mod
	private final class CITR implements Iterator<E> {
		private Iterator<E> itr;

		public CITR () {
			this.itr = C.this.data.iterator();
		}

		public boolean hasNext () {
			return this.itr.hasNext();
		}

		public E next() {
			return this.itr.next();
		}
	}
}
