public class Poblaciones {
	private TreeMap<String, TreeSet<String>> data;

	/*
	 * Area de datos con descripcion.
	 * private TreeMap<String, TreeSet<Map.Entry<String, String>>> data;
	 */

	public Poblaciones () {
		this.data = new TreeMap<String, TreeSet<String>> ();
	}

	public Poblaciones (Poblaciones p) {
		this();
		this.data.putAll(p.data);
	}

	public int sitios () {
		int c = 0;
		for (Collection<TreeSet<Strin>> e : this.data.values()) {
			c+=e.size();
		}
		return c;
	}

	public void addSitioAPoblacion (String poblacion, string sitio) {
		if (poblacion == null || sitio == null) {
			throw new NullPointerException();
		}
		if (this.data.containsKey(poblacion)) {
			this.data.get(poblacion).add(sitio);
		} else {
			TreeSet<String> sitios = new TreeSet<String> ();
			sitios.add(sitio);
			this.data.put(poblacion, sitios); 
		}
	}

}
