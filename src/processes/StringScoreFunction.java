package processes;

import java.awt.Point;

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
		ScoreMatrix scoreMatrix = new ScoreMatrix(seq1.length(),seq2.length());
		scoreMatrix.add(0,0,0,new Point(0,0));
		for(int x = 1;x<Math.max(seq1.length(),seq2.length());x++){
			if(x<seq1.length()){
				scoreMatrix.add(scoreMatrix.getScore(0, x-1)+stepPenalties[3], x, 0, new Point(x-1,0));
			}
			if(x<seq2.length()){
				scoreMatrix.add(scoreMatrix.getScore(x-1, 0)+stepPenalties[3], 0, x, new Point(0,x-1));
			}
		}
		int row = 1;
		int column = 1;
		int counter = 0;
		CharPairScore charScore = new CharPairScore();
		while(counter<seq1.length()*seq2.length()){
			double score = charScore.getScore(seq1.get(row),seq2.get(column));
			double step = scoreMatrix.getScore(row-1, column-1)+stepPenalties[0]+score;
			if(step==Double.NaN){
				step = Double.MAX_VALUE;
			}
			double holdV = scoreMatrix.getScore(row,column-1)+stepPenalties[3]+score;
			if(holdV==Double.NaN){
				holdV = Double.MAX_VALUE;
			}
			double holdH = scoreMatrix.getScore(row-1, column)+stepPenalties[3]+score;
			if(holdH==Double.NaN){
				holdH = Double.MAX_VALUE;
			}
			double skip;
			int skipChoice;
			if(row-2>=0&&scoreMatrix.getScore(row-2, column-1)>scoreMatrix.getScore(row-1, column-2)){
				skip = scoreMatrix.getScore(row-1,column-2);
				skipChoice = 1;
				if(scoreMatrix.getSource(row-1, column-2)== new Point(row-2,column-4)|scoreMatrix.getSource(row-1, column-2)== new Point(row-4,column-2)){
					skip += stepPenalties[2];
				}else {
					skip += stepPenalties[1];
				}
			} else if(column-2>=0){
				skip = scoreMatrix.getScore(row-2,column-1);
				skipChoice = 2;
				if(scoreMatrix.getSource(row-2, column-1)== new Point(row-2,column-4)|scoreMatrix.getSource(row-2, column-1)== new Point(row-4,column-2)){
					skip += stepPenalties[2];
				}else {
					skip += stepPenalties[1];
				}
			}else {
				skip = Double.MAX_VALUE;
				skipChoice = 0;
			}
			if(skip==Double.NaN){
				skip = Double.MAX_VALUE;
			}
			if(step<holdV&step<holdH&step<skip){
				scoreMatrix.add(step, row, column, new Point(row-1,column-1));
			} else if(holdV<holdH&holdV<skip){
				scoreMatrix.add(holdV,row,column,new Point(row, column-1));
			} else if(holdH<skip){
				scoreMatrix.add(holdH,row,column,new Point(row-1,column));
			} else {
				Point skipSource;
				if(skipChoice == 1){
					skipSource = new Point(row-2,column-1);
				} else {
					skipSource = new Point(row-1,column-2);
				}
				scoreMatrix.add(skip,row,column,skipSource);
			}
			counter++;
		}
		return scoreMatrix;
	}

}
