import java.awt.Point;

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
		Point[] trace = align(seq1,seq2,new StringScoreFunction(),new TraceBack());
		int counter = trace.length-1;
		String seq1align = "";
		String seq2align = "";
		int lastx = -1;
		int lasty = -1;
		//builds the two text sequences from the returned trace back path, still in progress
		while(counter>=0){
			Point pt = trace[counter];
			counter--;
			if(pt==null){
				continue;
			}
			if(pt.getX()!=0&&pt.getX()!=lastx){
				seq1align += seq1.get((int) pt.getX()-1);
			} else {
				seq1align += "-";
			}
			if(pt.getY()!=0&&pt.getY()!=lasty){
				seq2align += seq2.get((int) pt.getY()-1);
			} else {
				seq2align += "-";
			}
			lastx = (int) pt.getX();
			lasty = (int) pt.getY();
		}
		System.out.println(seq1align);
		System.out.println(seq2align);
	}
	
	public static <S, T> Point[] align(Sequence<S> seq1,Sequence<T> seq2,ScoringFunction<S,T> scorer, TraceBack tracer){
		ScoreMatrix scoreMatrix = scorer.score(seq1,seq2); //produces the score matrix
		Point[] trace = tracer.trace(scoreMatrix); //traces back along the score matrix to find a likely 
		return trace;
	}

}
