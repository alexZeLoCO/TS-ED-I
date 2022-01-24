package estDatos;

import java.util.Iterator;
import java.util.Map;

public interface MultiDic {

		/**
		 * Añade un diccionario vacío para el idioma dado a los diccionarios
		 * @param idiom el idioma del diccionario a añadir
		 * @throws NullPointerException() si idiom es null
		 * @return un booleano indicando si se ha introducido el nuevo diccionario
		 */
		public boolean addDic(String idiom);  
		
		/**
		 * Elimina el diccionario del idioma dado de los diccionarios
		 * @param idiom el idioma del diccionario a borrar
		 * @return un booleano indicando si se ha borrado el diccionario
		 */
		public boolean removeDic(String idiom); 
		
		/**
		 * Añade un par (word, translation) al diccionario del idioma dado 
		 * Si el diccinario del idioma no exite, hay que añadirlo previamente
		 * @param idiom el idioma del diccionario donde añadir el par
		 * @param word la palabra clave en el idioma indicado
		 * @param translation la traducción al español de word
		 * @throws NullPointerException() si idiom o word son null
		 * @return un booleano indicando si se ha introducido el par
		 */
		public boolean addWords(String idiom, String word, String translation); 

		/**
		 * Elimina el par de clave word en el diccionario del idioma dado 
		 * @param idiom el idioma del diccionario donde borrar el par
		 * @param word la palabra clave del par para borrar
		 * @return un booleano indicando si se ha borrado el par
		 */
		public boolean removeWord(String idiom, String word); 
		
		/**
		 * Obtiene el valor asociado a la clave word en el diccionario del idioma dado 
		 * @param idiom el idioma del diccionario donde buscar
		 * @param word la palabra clave del par 
		 * @return un string con el valor asociado a word
		 */	
		public String getTranslation(String idiom, String word); 

		/**
		 * Devuelve un iterador sobre las claves del diccionario del idioma dado
		 * @param idiom el idioma del diccionario donde iterar
		 * @return un iterador sobre las claves del diccionario
		 */	
		public Iterator<String> IdiomIterator(String idiom);

}
