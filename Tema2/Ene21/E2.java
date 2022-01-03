public class FITR implements Iterator<Long> {
	private long current;
	private int last;
	private int idx;

	public FITR (int last) {
		this.idx = 0;
		this.current = 1;
		this.last = last;
	}

	public boolean hasNext() {
		return this.idx <= this.last;
	}

	public Long next () {
		if (this.idx++ == 0) {
			return 1;
		}
		this.hasNext() ? return this.current*=this.idx++ : throw new IndexOutOfBoundsException();
	}

}
