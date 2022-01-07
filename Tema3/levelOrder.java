public class IterableTree<E> implements Iterable<E> {
	private Tree<E> tree;
		
	public IterableTree (Tree<E> t) {
		this.tree = t;
	}

	@Override
	public Iterator<E> iterator () {
		return new TreeIterator ();
	}

	//TODO: Iterator
	private final class TreeIterator implements Iterator<E> {
		private LinkedList<E> queue;

		public TreeIterator () {
			this.queue = new LinkedList<E>();
			this.queue.add(tree.root);
		}

		public boolean hasNext () {
			return this.queue.isEmpty();
		}	
		
		public E next () {
			if (!this.hasNext()) {
				throw new IndexOutOfBoundsException();
			}
			Iterator<Node<E>> itr = this.queue.get(0).iteratorChildren();
			while(itr.hasNext()) {
				this.queue.add(itr.next());
			}
			return this.queue.removeHead();
		}
	}

	public static <E> void levelOrder (Tree<E> t, Consumer<E> a) {
		if (t == null || a == null) {
			throw new NullPointerException ();
		}
		if (! t instanceof IterableTree<E>) {
			throw new ClassCastException();
		}
		(((IterableTree<E>) t).forEach(a);
	}	
}
