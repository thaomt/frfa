package GeneticAlgorithm.GA.fitness;

import GeneticAlgorithm.GA.Chromosome;
import GeneticAlgorithm.GA.Path;
import GeneticAlgorithm.GA.Population;

//created by btmanh
public abstract class FitnessFeature {
	
	protected Path targetPath;
	protected Path coveredPath;
	
	public Path getTargetPath() {
		return targetPath;
	}
	public void setTargetPath(Path targetPath) {
		this.targetPath = targetPath;
	}
	public Path getCoveredPath() {
		return coveredPath;
	}
	public void setCoveredPath(Path coveredPath) {
		this.coveredPath = coveredPath;
	}
	
	public abstract void calculateFitnessValue(Chromosome individual);	
	
}
