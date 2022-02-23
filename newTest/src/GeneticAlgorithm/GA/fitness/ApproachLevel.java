package GeneticAlgorithm.GA.fitness;

import java.util.HashSet;
import java.util.Set;

import GeneticAlgorithm.GA.BranchTarget;
import GeneticAlgorithm.GA.Chromosome;
import GeneticAlgorithm.GA.Population;

public class ApproachLevel extends FitnessFeature {

	@Override
	public void calculateFitnessValue(Chromosome ind) {
		setTargetPath(ind.getTargetPath());
		setCoveredPath(ind.getCoveredPath());
		Set<BranchTarget> unionSet = new HashSet<BranchTarget>();
		unionSet.addAll(targetPath.getBranches());
		unionSet.addAll(coveredPath.getBranches());
		
		int intersection = targetPath.size() + coveredPath.size() - unionSet.size();
		
		double fitness = (double)intersection/targetPath.size();
		System.out.println("Approach Level: " + fitness);
		ind.updateFitness(fitness);
	}

}
