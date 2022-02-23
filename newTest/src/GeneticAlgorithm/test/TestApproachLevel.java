package GeneticAlgorithm.test;

import GeneticAlgorithm.GA.Chromosome;
import GeneticAlgorithm.GA.Path;
import GeneticAlgorithm.GA.fitness.ApproachLevel;

public class TestApproachLevel {

	public static void main(String[] args) {
		
		Path coverPath = new Path();
		Path targetPath = new Path();
		
		coverPath.addBranch(Integer.valueOf(1));
		coverPath.addBranch(Integer.valueOf(3));
		coverPath.addBranch(Integer.valueOf(4));
		coverPath.addBranch(Integer.valueOf(5));
		coverPath.addBranch(Integer.valueOf(7));
		
		targetPath.addBranch(Integer.valueOf(1));
		targetPath.addBranch(Integer.valueOf(4));
		targetPath.addBranch(Integer.valueOf(6));
		targetPath.addBranch(Integer.valueOf(8));
		
//		Path path1 = new Path(targetPath.getBranches());
//		Path path2 = new Path(targetPath.getBranches());
//		
//		System.out.println(path1.equals(path2));
		
		ApproachLevel approachLevelFitness = new ApproachLevel();
		Chromosome ind = new Chromosome();
		ind.setCoveredPath(coverPath);
		ind.setTargetPath(targetPath);
		approachLevelFitness.calculateFitnessValue(ind);
		//System.out.println("Approach Level: " + ind.getFitness());
	}

}
