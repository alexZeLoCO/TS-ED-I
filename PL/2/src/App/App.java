package App;

import estDatos.RedBlackTreeMap;
import java.util.Comparator;

public class App {

	public static void main(String[] args) {
		Comparator<String> c = null;
		RedBlackTreeMap<String, Integer> d1 = new RedBlackTreeMap<String, Integer> (c);
		d1.put("Ana", 24);
		d1.put("Luis", 15);
		d1.put("Rosa", 36);
		d1.put("Angel", 45);
		d1.put("Pepe", 19);
		d1.put("Carmen", 25);
		
		RedBlackTreeMap<String, Integer> d2 =
				new RedBlackTreeMap<String, Integer> (d1, (a, b) -> (a.compareTo(b) * (-1)));
		
		System.out.printf("Diccionario 1:\n%s\nDiccionario 2:\n%s\n", d1.toString(), d2.toString());	

	}

}
