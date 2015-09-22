package dataStructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StringSequence implements Sequence<String> {
	public List<String> str;
	
	public StringSequence(String string){
		this.str = new ArrayList<String>(string.length());
		for(int x =0;x<string.length();x++){
			str.add(Character.toString(string.charAt(x)));
		}
	}
	
	@Override
	public Iterator<String> iterator() {
		return str.iterator();
	}

	@Override
	public String get(int i) {
		return str.get(i);
	}

}
