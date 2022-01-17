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
		for (Tree<E> t : trees) {
			count = TreeCount.numNodes(t);
		}
	}
	
	public TreeCount (Tree<E> t) {
		super(t);
		count = TreeCount.numNodes(t);
	}
	
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
			if (index < this.children.size()) {
				this.children.set(index, t);
			} else {
				this.children.add(t);
			}
			this.count+=TreeCount.numNodes(t);
		}
	}
}
