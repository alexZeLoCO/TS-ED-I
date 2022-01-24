package estDatos;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class MultiDicImp implements MultiDic{
	

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

