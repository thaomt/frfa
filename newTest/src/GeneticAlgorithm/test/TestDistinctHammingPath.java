package GeneticAlgorithm.test;

import java.util.ArrayList;
import java.util.List;

import GeneticAlgorithm.GA.BranchTarget;
import GeneticAlgorithm.GA.fitness.HammingPath;

public class TestDistinctHammingPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<BranchTarget> branches = new ArrayList<BranchTarget>();
		for (int i = 1; i <= 5; i++) {
			branches.add(new BranchTarget(Integer.valueOf(i)));
		}
		branches.add(3, new BranchTarget(Integer.valueOf(3)));
		branches.add(3, new BranchTarget(Integer.valueOf(3)));
		
		System.out.println(branches);
		
		HammingPath hammingPath = new HammingPath(branches);
		System.out.println(hammingPath.makeDistinctListOfNTuples(1));
		System.out.println(hammingPath.makeDistinctListOfNTuples(2));
		System.out.println(hammingPath.makeDistinctListOfNTuples(3));
		System.out.println(hammingPath.makeDistinctListOfNTuples(4));
		System.out.println(hammingPath.makeDistinctListOfNTuples(5));
	}

}
