package dataStructures;

import java.awt.Point;

public class ScoreMatrix {
	private Double[][] scores;
	private Point[][] source;
	private int rows;
	private int columns;
	private int size;
	
	//score matrices are defined by an array of score values and a corresponding 
	//array of pointers to where values originated from this binds the two and organzies them
	public ScoreMatrix(int size1, int size2){
		size1++;
		size2++;
		scores = new Double[size1][size2];
		source = new Point[size1][size2];
		rows = size1;
		columns = size2;
		size = size1*size2;
	}
	
	public ScoreMatrix(Double[][] scores,Point[][] source){
		this.scores = scores;
		this.source = source;
		this.rows = scores.length;
		this.columns = scores[0].length;
		this.size = rows*columns;
	}
	
	public void add(double value, int x,int y, Point origen){
		if(x>rows|y>columns){
			return;
		}
		scores[x][y] = value;
		source[x][y] = origen;
	}
	
	public double getScore(int x,int y){
		if(x>rows|y>columns){
			return Double.NaN;
		}
		return scores[x][y];
	}
	
	public Point getSource(int x,int y){
		if(x>rows|y>columns){
			return null;
		}
		return source[x][y];
	}

}
