package estDatos;

import java.util.Iterator;

public class TreeCount<E> extends TreeImp<E> {
	private int count;
	
	public TreeCount (E e) {
		super(e);
		this.count = 1;
	}
	
	public TreeCount (E e, Tree<E> ...trees) {
		super(e, trees);
		this.count = 1;
	}
	
	public TreeCount (Tree<E> t) {
		super(t);
		this.count = 1;
	}
	
	/**
	 * Calculates the number of nodes in the tree.
	 * 
	 * @param <E> Elements of the tree.
	 * @param t Tree
	 * @return number of nodes in the tree.
	 * 
	 * @throws NullPointerException if the tree is null;
	 */
	public static <E> int numNodes (Tree<E> t) {
		if (t == null) {
			throw new NullPointerException();
		}
		
		int c = 0;
		Iterator<Tree<E>> itr = t.iteratorToChildren();
		while (itr.hasNext()) {
			c+=TreeCount.numNodes(itr.next());
		}
		return c;
	}
	
	@Override
	public void setSubTree (int index, Tree<E> t) {
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (t == null) {
			if (index >= this.children.size()) {
				throw new IndexOutOfBoundsException();
			}
			this.count-=TreeCount.numNodes(this.children.remove(index));
		} else {
			int removed = 0;
			if (index < this.children.size()) {
				removed = TreeCount.numNodes(this.children.get(index));
				this.children.set(index, t);
			} else {
				this.children.add(t);
			}
			this.count+=(TreeCount.numNodes(t) - removed);
		}
	}
}
