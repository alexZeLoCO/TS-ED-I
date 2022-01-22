package app;

import java.util.function.Consumer;

import estDatos.Tree;
import estDatos.TreeNode;

public class Main {
	
	public static <E> void inorder(Tree<E> t, Consumer<? super E> c) {
	}
	
	public static void main(String[] args) {
		Character[] preorder = {'a', 'b', 'd', 'g', 'e', 'h', 'i', 'k', 'n', 'c', 'f', 'j', 'l', 'm'};
		Character[] postorder = {'d', 'g', 'b', 'h', 'e', 'i', 'n', 'k', 'a', 'f', 'l', 'j', 'm', 'c'};

		Tree<Character> t = TreeNode.createTree(preorder, postorder);
		
		System.out.println(t.toString());			// (a [(b [(d [])(g [])])(e [(h [])])(i [])(k [(n [])])])
		System.out.println();
		System.out.print("Secuencia en inorden: ");
		inorder(t, System.out::print);				// dbgaheink
		System.out.println();
		
		//Tree<Character> t1 = new TreeNode<>(t);
		
		//System.out.printf("\nt1.equals(t)? %b\n", t1.equals(t));	// true
	}

}
