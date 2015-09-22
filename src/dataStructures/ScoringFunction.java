package dataStructures;

public interface ScoringFunction<S,T> {
	
	public ScoreMatrix score(Sequence<S> seq1, Sequence<T> seq2);
}
