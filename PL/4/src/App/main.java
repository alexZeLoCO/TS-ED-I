package app;

import java.util.Iterator;

import estDatos.MultiDicImp;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiDicImp m = new MultiDicImp ();
		m.addDic("British");
		m.addWords("British","door","puerta");
		m.addWords("British","house","casa");
		m.addWords("British","chair","silla");
		m.addWords("French","porte","puerta");
		m.addWords("French","maison","casa");
		m.addWords("French","chaise","silla");		
		System.out.println("M:\n"+m);
		
		m.removeWord("British", "kk");
		m.removeWord("British", "house");			
		Iterator<String> itr=m.IdiomIterator("British");
		while (itr.hasNext())
			System.out.print(itr.next()+" ");
		System.out.println();
		
		System.out.println("chair->"+m.getTranslation("British", "chair"));
		System.out.println("cloud->"+m.getTranslation("British", "cloud"));
				
		MultiDicImp m2 = new MultiDicImp (m);
		MultiDicImp m3 = new MultiDicImp (m);
		m.removeDic("British");
		System.out.println("M:\n"+m);
		System.out.println("M2:\n"+m2);
		
		System.out.println("m==m2: "+m.equals(m2));
		System.out.println("m2==m3: "+m2.equals(m3));
	}	

}

//M:
//[British (chair,silla)(door,puerta)(house,casa)]
//[French (chaise,silla)(maison,casa)(porte,puerta)]
//
//chair door 
//chair->silla
//cloud->null
//M:
//[French (chaise,silla)(maison,casa)(porte,puerta)]
//
//M2:
//[British (chair,silla)(door,puerta)]
//[French (chaise,silla)(maison,casa)(porte,puerta)]
//
//m==m2: false
//m2==m3: true
