package dataStructures;

public class ScoreMatrix {
	private Double[][] scores;
	private int[][] source;
	private int rows;
	private int columns;
	private int size;
	
	//score matrices are defined by an array of score values and a corresponding 
	//array of pointers to where values originated from this binds the two and organzies them
	public ScoreMatrix(Double[][] scores,int[][] source){
		this.scores = scores;
		this.source = source;
		this.rows = scores.length;
		this.columns = scores[0].length;
		this.size = rows*columns;
	}
	
	//each spot on the matrix can be numbered and referenced that way, if it's too obnoxious later
	//i'll come back and change it, currently i assume they are numbered row wise starting at 0
	public void add(double value, int location, int origen){
		if(location>size){
			return;
		}
		scores[(int) Math.floor(location/columns)][location%columns] = value;
		source[(int) Math.floor(location/columns)][location%columns] = origen;
	}
	
	public double getScore(int location){
		if(location>size){
			return Double.NaN;
		}
		return scores[(int) Math.floor(location/columns)][location%columns];
	}
	
	public Integer getSource(int location){
		if(location>size){
			return null;
		}
		return source[(int) Math.floor(location/columns)][location%columns];
	}
}
