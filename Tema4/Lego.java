public class Lego<E> {
	protected E dato;
	protected Lego<E> uno;
	protected Lego<E> otro;

	public Lego () {
		this(null, null, null);
	}

	public Lego (E d, Lego<E> a, Lego<E> b) {
		this.dato = d;
		this.uno = a;
		this.otro = b;
	}

}

public class OpenHashLego<E> {
	private static final int DEFAULT_CAPACITY = 5;
	private static final double DEFAULT_FACTOR_LIMIT = 0.75;

	private ArrayList <Integer> estado;
	private ArrayList <Lego<E>> data;

	private int factorLimit;
	private int nElements;

	public OpenHashLego () {
		this(DEFAULT_CAPACITY, DEFAUTL_FACTOR_LIMIT);
	}

	public OpenHashLego (int capacity, int factorLimit) {
		this.estado = new ArrayList<E> (capacity);
		this.data = new ArrayList<Lego<E>> (capacity);
		this.loadFactor = factorLimit;
		this.nElements = 0;
	}

	
}
