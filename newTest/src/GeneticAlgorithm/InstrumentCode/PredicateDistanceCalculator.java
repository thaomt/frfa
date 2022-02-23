package GeneticAlgorithm.InstrumentCode;

import openjava.ptree.BinaryExpression;
import openjava.ptree.Expression;
import openjava.ptree.MethodCall;

public class PredicateDistanceCalculator {
	
	public static final int K = 1;
	
	private int distance = PredicateDistanceCalculator.K;
	
	public int getDistance() {
		return distance;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public String toString() {
		return "distance: " + this.getDistance();
	}
	
	public void cumulativeDistance (int _distance) {
		this.setDistance(this.getDistance() + _distance);
	}
	
	public void calculateTrueClause(MethodCall method) {
		//do nothi
	}
	
	public void calculateNegativeClause(MethodCall method) {
		this.cumulativeDistance(PredicateDistanceCalculator.K);
	}
	
	public void calculateTrueClause(BinaryExpression binaryExpression) {
		int operator = binaryExpression.getOperator();
		if (operator == BinaryExpression.EQUAL) {
			
		}
	}

}
