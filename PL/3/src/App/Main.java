package App;

import java.util.function.Consumer;

import estDatos.Tree;
import estDatos.TreeNode;

public class Main {

	public static <E> void inorder(Tree<E> t, Consumer<? super E> c) {
		if (!t.firstChild().isNull()) {
			inorder (t.firstChild(), c);
		}
		c.accept(t.root().label());
		if (!t.rightSibling().isNull()) {
			inorder (t.rightSibling(), c);
		}
	}

public static void main(String[] args) {
	Character[] preorder = {'a', 'b', 'd', 'g', 'e', 'h', 'i', 'k', 'n', 'c', 'f', 'j', 'l', 'm'};
	Character[] inorder= {'d', 'g', 'b', 'h', 'e', 'i', 'n', 'k', 'a', 'f', 'l', 'j', 'm', 'c'};

	Tree<Character> t = TreeNode.createTree(preorder, inorder);

	System.out.println(t.toString());			// (a [(b [(d [])(g [])])(e [(h [])])(i [])(k [(n [])])])
	System.out.print("Secuencia en inorden: ");
	inorder(t, System.out::print);				// dbgaheink
	System.out.println("\n");

	Tree<Character> t1 = new TreeNode<>(t);
	System.out.println(t1.toString());
	System.out.print("Secuencia en inorden: ");
	inorder(t1, System.out::print);				// dbgaheink

	System.out.println();
	System.out.printf("\nt1.equals(t)? %b\n", t1.equals(t));	// true
}

}
