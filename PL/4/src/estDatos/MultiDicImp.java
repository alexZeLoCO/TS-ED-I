package estDatos;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class MultiDicImp implements MultiDic{
	
	private Map<String, TreeMap<String, String>> maps;

	public MultiDicImp () {
		this.maps = new TreeMap<String, TreeMap<String, String>> ();
	}

	public MultiDicImp (MultiDicImp mdi) {
		this();
		for (Map.Entry<String, TreeMap<String, String>> e : mdi.maps.entrySet()) {
			for (Map.Entry<String, String> ee : e.getValue().entrySet()) {
				this.addWords(e.getKey(), ee.getKey(), ee.getValue());
			}
		}
	}

	@Override
	public boolean addDic(String idiom) {
		if (idiom == null) {
			throw new NullPointerException();
		}
		if (this.maps.containsKey(idiom)) {
			return false;
		}
		return this.maps.put(idiom, new TreeMap<String, String> ()) == null;
	}

	@Override
	public boolean removeDic(String idiom) {
		if (idiom == null) {
			throw new NullPointerException();
		}
		if (!this.maps.containsKey(idiom)) {
			return false;
		}
		return this.maps.remove(idiom) != null;
	}

	@Override
	public boolean addWords(String idiom, String word, String translation) {
		if (idiom == null || word == null) {
			throw new NullPointerException();
		}
		if (!this.maps.containsKey(idiom)) {
			this.addDic(idiom);
		}
		this.maps.get(idiom).put(word, translation);
		return this.maps.get(idiom).containsKey(word) && this.maps.get(idiom).get(word).equals(translation);
	}

	@Override
	public boolean removeWord(String idiom, String word) {
		if (idiom == null || word == null) {
			throw new NullPointerException();
		}
		if (!this.maps.containsKey(idiom)) {
			return false;
		}
		return this.maps.get(idiom).remove(word) != null;
	}

	@Override
	public String getTranslation(String idiom, String word) {
		if (idiom == null || word == null) {
			throw new NullPointerException();
		}
		if (!this.maps.containsKey(idiom) || !this.maps.get(idiom).containsKey(word)) {
			throw new NoSuchElementException(); 
		}
		return this.maps.get(idiom).get(word);
	}

	@Override
	public Iterator<String> IdiomIterator(String idiom) {
		if (idiom == null) {
			throw new NullPointerException();
		}
		if (!this.maps.containsKey(idiom)) {
			throw new NoSuchElementException();
		}
		return new IITR (idiom);
	}

	private final class IITR implements Iterator<String> {
		private final Iterator<String> itr;
		
		public IITR (String idiom) {
			this.itr = MultiDicImp.this.maps.get(idiom).keySet().iterator();
		}
		
		public boolean hasNext() {
			return this.itr.hasNext();
		}
		
		public String next () {
			return this.itr.next();
		}
	}

	@Override
	public boolean equals (Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof MultiDicImp)) {
			return false;
		}
		if (this.maps.size() != ((MultiDicImp)o).maps.size()) {
			return false;
		}
		String idiom;
		Iterator<Map.Entry<String, TreeMap<String, String>>> itra = this.maps.entrySet().iterator();
		Iterator<Map.Entry<String, TreeMap<String, String>>> itrb = ((MultiDicImp)o).maps.entrySet().iterator();
		while(itra.hasNext() && itrb.hasNext()) {
			idiom = itra.next().getKey();		// Idioma A
			if (idiom != itrb.next().getKey()) {	//Idioma B
				return false;
			}
			Iterator<Map.Entry<String, String>> itr1 = this.maps.get(idiom).entrySet().iterator();
			Iterator<Map.Entry<String, String>> itr2 = ((MultiDicImp) o).maps.get(idiom).entrySet().iterator();
			while (itr1.hasNext() && itr2.hasNext()) {
				Map.Entry<String, String> e1 = itr1.next();	// Traduccion A
				Map.Entry<String, String> e2 = itr2.next();	// Traduccion B
				//			Key										Value
				if (!e1.getKey().equals(e2.getKey()) || !e1.getValue().equals(e2.getValue())) {
					return false;
				}
			}
			if (itr1.hasNext() || itr2.hasNext()) {
				return false;
			}
		}
		return !itra.hasNext() && !itrb.hasNext();
		/*
		for (String idiom : this.maps.keySet()) {
			Iterator<String> itr1 = this.IdiomIterator(idiom);
			Iterator<String> itr2 = ((MultiDicImp) o).IdiomIterator(idiom);
			while (itr1.hasNext() && itr2.hasNext()) {
				if (!itr1.next().equals(itr2.next())) {
					return false;
				}
			}
			if (itr1.hasNext() || itr2.hasNext()) {
				return false;
			}
		}
		*/
	}
	@Override
	public String toString() {
		String res="";
		Iterator<Map.Entry<String,TreeMap<String, String>>> itr=maps.entrySet().iterator();
		while (itr.hasNext()){
			Map.Entry<String,TreeMap<String, String>> par=itr.next();
			res+='['+par.getKey()+" ";
			Iterator<Map.Entry<String,String>> itr2=(par.getValue()).entrySet().iterator();
			while (itr2.hasNext()) {
				Map.Entry<String, String> par2=itr2.next();
				res+='('+par2.getKey() +','+par2.getValue() +')';	
			}
			res+="]\n";
		}
		return res;
	}
		
}

