package app;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Consumer;
import estDatos.Tree;
import estDatos.TreeImp;
import estDatos.TreeCount;

public class Main<E> {
	
	/**
	 * Recorre en inorden el árbol ordenado t y con cada etiqueta
	 * realiza la operación indicada por el consumidor especificado.
	 * @param t el árbol a recorrer
	 * @param block el consumidor, interfaz funcional acción a realizar con
	 * las etiquetas
	 */
	public static <E> void inorder(Tree<E> t, Consumer<? super E> block) {
		// Define esta función
	}
	
	public static void main(String[] args) {
		Tree<Character> tb = new TreeImp<>('b',
										   new TreeImp<>('e'),
										   new TreeImp<>('f'));
		Tree<Character> tc = new TreeImp<>('c',
										   new TreeImp<>('g'));
		Tree<Character> th = new TreeImp<>('h',
										   new TreeImp<>('j'),
										   new TreeImp<>('k'),
										   new TreeImp<>('l'));
		Tree<Character> td = new TreeImp<>('d',
										   th,
										   new TreeImp<>('i'));
		Tree<Character> ta = new TreeImp<>('a', tb, tc, td);
		Tree<Character> t = new TreeImp<>(ta); // copia de ta
		
		System.out.println("ta: " + ta.toString());
		System.out.println("Subárboles de la raíz del árbol ta:");
		ListIterator<Tree<Character>> itr = ta.listIteratorToChildren();
		while (itr.hasNext()) {
			System.out.print("Subárbol " + itr.nextIndex() + ": ");
			System.out.println(itr.next().toString());
		}
		System.out.print("Inorder de ta: ");
		inorder(ta, System.out::print);
		System.out.println();
		System.out.println("tb: " + tb.toString());
		System.out.println("ta == tb? " + ta.equals(tb));
		System.out.println("t: " + t.toString());
		System.out.println("ta == t? " + ta.equals(t));
		System.out.println("t " + t.toString());
		System.out.print("Cambiando el tercer subárbol de t ... ");
		t.setSubTree(2, tb);
		System.out.println("hecho");
		System.out.println("t: " + t.toString());
		System.out.println("ta: " + ta.toString());
		System.out.print("Cambiando el tercer subárbol de ta ... ");
		ta.setSubTree(2, new TreeImp<>('0', new TreeImp<>('1')));
		System.out.println("hecho");
		System.out.println("ta: " + ta.toString());

		
		// Para la parte 3. Descomentar una vez finalizada ésta
/*
		System.out.println("\nParte 3");
		System.out.println("=======");
		TreeCount<Character> tcx = new TreeCount<>('X',
											       new TreeCount<>('Y'),
											       new TreeCount<>('Z'));
		TreeCount<Character> tcc = new TreeCount<>('C',
											       new TreeCount<>('G'));
		TreeCount<Character> tcp = new TreeCount<>('P',
									      	       new TreeCount<>('Q'),
									      	       new TreeCount<>('R'),
									      	       new TreeCount<>('S'));
		TreeCount<Character> tcr = new TreeCount<>('R',
											       tcp,
											       new TreeCount<>('U'));
		TreeCount<Character> tca = new TreeCount<>('A', tcx, tcc, tcr);		
		TreeCount<Character> tC = new TreeCount<>(tca); // copia de tca
		
		System.out.println("tca: " + tca.toString());
		System.out.println("Número de nodos de tca: " + tca.numNodos());
		System.out.println("Subárboles de la raíz del árbol tca:");
		ListIterator<Tree<Character>> itrC = tca.listIteratorToChildren();
		while (itrC.hasNext()) {
			System.out.print("Subárbol " + itrC.nextIndex() + ": ");
			TreeCount<Character> temp = (TreeCount<Character>) itrC.next();
			System.out.print(temp.toString());
			System.out.println("  (" + temp.numNodos() + " nodos)");
		}
		System.out.print("Inorder de tca: ");
		inorder(tca, System.out::print);
		System.out.println();
		System.out.println("tcx: " + tcx.toString());
		System.out.println("tca == tcx? " + tca.equals(tcx));
		System.out.println("tC: " + tC.toString());
		System.out.println("Número de nodos de tC: " + tC.numNodos());
		System.out.println("tca == tC? " + tca.equals(tC));
		System.out.print("Cambiando el tercer subárbol de tC ... ");
		tC.setSubTree(2, tcx);
		System.out.println("hecho");
		System.out.println("tC: " + tC.toString());
		System.out.println("Número de nodos de tC: " + tC.numNodos());
		System.out.println("tca: " + tca.toString());
		System.out.println("Número de nodos de tca: " + tca.numNodos());
		System.out.print("Cambiando el tercer subárbol tca ... ");
		tca.setSubTree(2, new TreeCount<>('0', new TreeCount<>('1')));
		System.out.println("hecho");
		System.out.println("tca: " + tca.toString());
		System.out.println("Número de nodos de tca: " + tca.numNodos());
		System.out.print("Borrando el último subárbol de tca ... ");
		tca.setSubTree(2, null);
		System.out.println("hecho");
		System.out.println("tca: " + tca.toString());
		System.out.println("Número de nodos de tca: " + tca.numNodos());
*/	
		
		// Salida Esperada
/*
		ta: [a [b [e] [f]] [c [g]] [d [h [j] [k] [l]] [i]]]
		Subárboles de la raíz del árbol ta:
		Subárbol 0: [b [e] [f]]
		Subárbol 1: [c [g]]
		Subárbol 2: [d [h [j] [k] [l]] [i]]
		Inorder de ta: ebfagcjhkldi
		tb: [b [e] [f]]
		ta == tb? false
		t: [a [b [e] [f]] [c [g]] [d [h [j] [k] [l]] [i]]]
		ta == t? true
		t [a [b [e] [f]] [c [g]] [d [h [j] [k] [l]] [i]]]
		Cambiando el tercer subárbol de t ... hecho
		t: [a [b [e] [f]] [c [g]] [b [e] [f]]]
		ta: [a [b [e] [f]] [c [g]] [d [h [j] [k] [l]] [i]]]
		Cambiando el tercer subárbol de ta ... hecho
		ta: [a [b [e] [f]] [c [g]] [0 [1]]]
		
		Parte 3
		=======
		tca: [A [X [Y] [Z]] [C [G]] [R [P [Q] [R] [S]] [U]]]
		Número de nodos de tca: 12
		Subárboles de la raíz del árbol tca:
		Subárbol 0: [X [Y] [Z]]  (3 nodos)
		Subárbol 1: [C [G]]  (2 nodos)
		Subárbol 2: [R [P [Q] [R] [S]] [U]]  (6 nodos)
		Inorder de tca: YXZAGCQPRSRU
		tcx: [X [Y] [Z]]
		tca == tcx? false
		tC: [A [X [Y] [Z]] [C [G]] [R [P [Q] [R] [S]] [U]]]
		Número de nodos de tC: 12
		tca == tC? true
		Cambiando el tercer subárbol de tC ... hecho
		tC: [A [X [Y] [Z]] [C [G]] [X [Y] [Z]]]
		Número de nodos de tC: 9
		tca: [A [X [Y] [Z]] [C [G]] [R [P [Q] [R] [S]] [U]]]
		Número de nodos de tca: 12
		Cambiando el tercer subárbol tca ... hecho
		tca: [A [X [Y] [Z]] [C [G]] [0 [1]]]
		Número de nodos de tca: 8
		Borrando el último subárbol de tca ... hecho
		tca: [A [X [Y] [Z]] [C [G]]]
		Número de nodos de tca: 6
*/
	}
	
}
