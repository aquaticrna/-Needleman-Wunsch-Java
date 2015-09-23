package dataStructures;

import java.awt.Point;

public class ScoreMatrix {
	private Double[][] scores;
	private Point[][] source;
	private int rows;
	private int columns;
	
	//score matrices are defined by an array of score values and a corresponding 
	//array of pointers to where values originated from this binds the two and organzies them
	public ScoreMatrix(int size1, int size2){
		size1++;
		size2++;
		scores = new Double[size1][size2];
		source = new Point[size1][size2];
		rows = size1;
		columns = size2;
	}
	
	//adds value and origin to the appropriate x,y coordinate 
	public void add(double value, int x,int y, Point origen){
		if(x>rows|y>columns){
			return;
		}
		scores[x][y] = value;
		source[x][y] = origen;
	}
	
	//returns the score at x,y
	public double getScore(int x,int y){
		if(x>rows|y>columns){
			return Double.NaN;
		}
		return scores[x][y];
	}
	
	//returns the score a the x,y in the Point object
	public double getScore(Point pt){
		if(pt.getX()>rows|pt.getY()>columns){
			return Double.NaN;
		}
		return scores[(int) pt.getX()][(int) pt.getY()];
	}
	
	//returns the source of the score at x,y
	public Point getSource(int x,int y){
		if(x>rows|y>columns){
			return null;
		}
		return source[x][y];
	}
	
	//returns the source of the point at x,y in the Point object
	public Point getSource(Point pt){
		if(pt.getX()>rows|pt.getY()>columns){
			return null;
		}
		return source[(int) pt.getX()][(int) pt.getY()];
	}
	
	//returns the number of rows
	public int rowSize(){
		return rows;
	}
	
	//returns the number of columns
	public int columnSize(){
		return columns;
	}

}
