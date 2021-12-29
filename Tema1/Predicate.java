/**
 * Tipo test, elegir aquella funcion que -entre otras cosas-, imprima aquellos objetos Punto cuyos atributos Abscisa y Ordenada sean mayores o iguales que 0, esto es, se encuentran en el primer cuadrante.
 *
 */

public static void f(Iterable<T> e, Predicate<T> tester, Consumer<T> block) {
	if (e == null || tester == null || block == null) {
		throw new NullPointerException();
	}	
	for (T item : e) {
		if (tester.test(item)) {
			block.accept(item);
		}
	}
}

public static void main (String[] args) {
	Predicate <Punto> p = e -> e.getAbscisa() >= 0 && e.getOrdenada() >= 0;
	Consumer <Punto> c = e -> System.out::println(e.toString()); 

	f(l, p, c);	
}
