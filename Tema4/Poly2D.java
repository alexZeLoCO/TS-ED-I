/**
 * Coordenadas.
 * Almacenar P(2,1), la cadena "P" y las 2 coordenadas 2 y 1.
 *
 * Modificado para coordenadas N "PolyND"
 */
public class Poly2D {
	private TreeMap<String, List<Integer>> data;

	public Poly2D () {
		this(2);
	}
	
	public Poly2D (int size) {
		this.data = new TreeMap<String, List<Integer>> ();
		this.dimension = size;
	}

	/**
	 * Returns the number of coordinates held.
	 *
	 * @return number of coordinates.
	 */
	public int size () {
		return this.data.size;
	}

	/**
	 * Adds or modifies a coordinate.
	 *
	 * @param name Name of the coordinate
	 * @param i Coordinates
	 *
	 * @return True if added.
	 * @throws IndexOutOfBoundsException if the number of coordinates do not match
	 */
	public boolean add (String, Integer ... i) {
		if (this.size() != i.length-1) {
			throw new IndexOutOfBoundsException();
		}
		this.size++;
		return this.data.putAll(String, i);
	}
}	

/**
 * Original Poly2D.
 */
public class Poly2D {
	private TreeMap<String, Pair<Integer, Integer>> data;

	public Poly2D () {
		this.data = new TreeMap<String, Pair<Integer, Integer>> ();
	}

	public Poly2D (Poly2D p) {
		this();
		this.data.putAll(p.data);
	}

	public int numPoints () {
	      return this.data.size();
	}

	public Pair<Integer, Integer> getCoordsLastPoint () {
		if (this.data.isEmpty()) {
			return null;
		}
		String max = "";
		for (String s : this.data.keySet()) {
			if (s.compareTo(max) > 0) {
				max = s;
			}
		}
		return this.data.get(max);
	}
}
