package dataStructures;

import java.awt.Point;

public class TraceBack {
	//follows the list of sources starting at the bottom corner
	public Point[] trace(ScoreMatrix scoreMatrix){
		Point origen = new Point(0,0);
		Point currentPoint = new Point(scoreMatrix.rowSize()-1,scoreMatrix.columnSize()-1);
		Point[] index = new Point[scoreMatrix.columnSize()+scoreMatrix.rowSize()];
		int count = 0;
		//goes until we get back to the origen
		while(!currentPoint.equals(origen)){
			//System.out.println(currentPoint.getX() + " " +currentPoint.getY());
			index[count] = currentPoint;
			count++;
			currentPoint = scoreMatrix.getSource(currentPoint);
		}
		return index;
	}
	
}
