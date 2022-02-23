package GeneticAlgorithm.test;

import java.util.ArrayList;
import java.util.List;

import GeneticAlgorithm.GA.BranchTarget;
import GeneticAlgorithm.GA.Chromosome;
import GeneticAlgorithm.GA.fitness.HammingDistance;
import GeneticAlgorithm.GA.fitness.HammingPath;

public class TestHammingDistance {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<BranchTarget> coveredPath = new ArrayList<BranchTarget>();
		for (int i = 1; i <= 5; i++) {
			coveredPath.add(new BranchTarget(Integer.valueOf(i)));
		}
		List<BranchTarget> targetPath = new ArrayList<BranchTarget>();
		for (int i = 1; i <= 6; i++) {
			targetPath.add(new BranchTarget(Integer.valueOf(i)));
		}
		targetPath.add(3, new BranchTarget(Integer.valueOf(3)));
		targetPath.add(3, new BranchTarget(Integer.valueOf(3)));

//		System.out.println(coveredPath);
//		System.out.println(targetPath);
//		System.out.println("===================================");
		HammingPath coverPath1 = new HammingPath(coveredPath);
		HammingPath targetPath1 = new HammingPath(targetPath);

		System.out.println(coverPath1.makeDistinctListOfNTuples(1));
		System.out.println(targetPath1.makeDistinctListOfNTuples(1));
		System.out.println("===================================");
		System.out.println(coverPath1.makeDistinctListOfNTuples(2));
		System.out.println(targetPath1.makeDistinctListOfNTuples(2));
		System.out.println("===================================");
		System.out.println(coverPath1.makeDistinctListOfNTuples(3));
		System.out.println(targetPath1.makeDistinctListOfNTuples(3));
		System.out.println("===================================");
		System.out.println(coverPath1.makeDistinctListOfNTuples(4));
		System.out.println(targetPath1.makeDistinctListOfNTuples(4));
		System.out.println("===================================");
		System.out.println(coverPath1.makeDistinctListOfNTuples(5));
		System.out.println(targetPath1.makeDistinctListOfNTuples(5));
		System.out.println("===================================");

		HammingDistance hammingDistance = new HammingDistance();
		Chromosome ind = new Chromosome();
		ind.setCoveredPath(coverPath1);
		ind.setTargetPath(targetPath1);
		hammingDistance.calculateFitnessValue(ind);
		
//		System.out.println("Hamming Distance: " + ind.getFitness());

	}

}
