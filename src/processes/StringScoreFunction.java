package processes;

import dataStructures.ScoreMatrix;
import dataStructures.ScoringFunction;
import dataStructures.Sequence;

public class StringScoreFunction implements ScoringFunction<String,String> {
	public int[] stepPenalties; //step, skip, skip again, hold, 
	
	public StringScoreFunction() {
		stepPenalties = new int[]{0,3,1,1};
	}
	
	public StringScoreFunction(int[] penalties){
		stepPenalties = penalties;
	}

	@Override
	public ScoreMatrix score(Sequence<String> seq1, Sequence<String> seq2) {
		// TODO Auto-generated method stub
		return null;
	}

}
