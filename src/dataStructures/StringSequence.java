package dataStructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//sequence object for strings of text 
public class StringSequence implements Sequence<String> {
	public List<String> str;
	
	//parses the string into an ArrayList of strings where
	//each character from the original string is an entry in the list. 
	public StringSequence(String string){
		this.str = new ArrayList<String>(string.length());
		for(int x =0;x<string.length();x++){
			str.add(Character.toString(string.charAt(x)));
		}
	}
	
	//uses the List iterator
	@Override
	public Iterator<String> iterator() {
		return str.iterator();
	}
	
	@Override
	public String get(int i) {
		return str.get(i);
	}

}
