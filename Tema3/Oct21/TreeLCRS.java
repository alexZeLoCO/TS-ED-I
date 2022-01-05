public class Tree<E> {
	private Node<E> theRoot;
	private class Node<E> {
		private E label;
		private Node<E> left;
		private Node<E> right;
		boolean isRightThread;

		public Node (E label, Node<E> left, Node<E> right) {
			this.label = label;
			this.left = left;
			this.right = right;
		}

	}

	/**
	 * Note: It is actually meant to return the Node<E> not the Tree<E>.
	 *
	 * @return Subtree, whose root is the parent of the root of this subtree.
	 *
	 * @throws NoSuchElementException if the root of this subtree has no parent.
	 */
	public Node<E> parent () {
		if (this.theRoot.right == null) {
			throw new NoSuchElementException();
		}
		Node<E> current = this.theRoot;
		while(!current.isRightThread) {
			current = current.right;
		}
		return current.right;
	}
}

