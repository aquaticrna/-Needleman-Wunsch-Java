import processes.StringScoreFunction;
import dataStructures.ScoreMatrix;
import dataStructures.ScoringFunction;
import dataStructures.Sequence;
import dataStructures.StringSequence;
import dataStructures.TraceBack;


public class NeidelmanWunsch {
	//main function for testing
	public static void main(String[] args) {
		Sequence<String> seq1 = new StringSequence("This is good code");
		Sequence<String> seq2 = new StringSequence("This ss goid cde");
		int[] trace = align(seq1,seq2,new StringScoreFunction(),null);
	}
	
	public static <S, T> int[] align(Sequence<S> seq1,Sequence<T> seq2,ScoringFunction<S,T> scorer, TraceBack tracer){
		ScoreMatrix scoreMatrix = scorer.score(seq1,seq2); //produces the score matrix
		int[] trace = tracer.trace(scoreMatrix); //traces back along the score matrix to find a likely 
		return trace;
	}

}
