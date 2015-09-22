package dataStructures;

import java.util.Iterator;

public interface Sequence<T> extends Iterable<T>{
	
	@Override
	public Iterator<T> iterator();
	
	public T get(int i);
	
}
