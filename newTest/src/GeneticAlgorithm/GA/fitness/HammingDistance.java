package GeneticAlgorithm.GA.fitness;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import GeneticAlgorithm.GA.Chromosome;
import GeneticAlgorithm.GA.Path;

public class HammingDistance extends FitnessFeature {
	
	public static final int FIRST_ORDER_WEIGHT = 1;
	
	private int maximumOrder;
	
	private int[] weights;
	
	private double[] similarities;
	
	private double[] symetricDifferencies;

	public HammingDistance() {
		this.coveredPath = new HammingPath();
		this.targetPath = new HammingPath();
	}

	public HammingDistance(HammingPath coveredPath, HammingPath targetPath) {
		this.coveredPath = coveredPath;
		this.targetPath = targetPath;
		this.maximumOrder = targetPath.size();
	}
	
	public void setTargetPath(Path targetPath) {
		this.targetPath = new HammingPath(targetPath.getBranches());
	}
	
	public void setCoveredPath(Path coveredPath) {
		this.coveredPath = new HammingPath(coveredPath.getBranches());
	}
	
	public void nOrderHammingDistance(int nOrder) {
		List<List> coveredNOrders = ((HammingPath)coveredPath).makeDistinctListOfNTuples(nOrder);
		List<List> targetNOrders = ((HammingPath)targetPath).makeDistinctListOfNTuples(nOrder);
		
		Set<List> unionSet = new HashSet<List>();
		unionSet.addAll(coveredNOrders);
		unionSet.addAll(targetNOrders);
		
		int union = unionSet.size();
		int intersection = coveredNOrders.size() + targetNOrders.size() - unionSet.size();
		int symetricDifference = unionSet.size() - intersection;
		
		symetricDifferencies[nOrder] = symetricDifference;
		weights[nOrder] = (nOrder == 0) ? FIRST_ORDER_WEIGHT : (weights[nOrder-1]*targetNOrders.size());
		similarities[nOrder] = 1 - (((double) symetricDifference)/union);
		
	}

	@Override
	public void calculateFitnessValue(Chromosome ind) {
		// TODO Initialize all parameters before calculating Hamming Distance
		setTargetPath(ind.getTargetPath());
		setCoveredPath(ind.getCoveredPath());
		
		this.maximumOrder = this.targetPath.size();
		this.weights = new int[this.maximumOrder];
		this.similarities = new double[this.maximumOrder];
		this.symetricDifferencies = new double[this.maximumOrder];
	
		double fitness = 0;

		for(int i = 0; i < this.maximumOrder; i++) {
			nOrderHammingDistance(i);
			fitness += weights[i]*similarities[i];
		}
		
		System.out.println("Hamming Distance: " + fitness);
		ind.updateFitness(fitness);
	}

}
