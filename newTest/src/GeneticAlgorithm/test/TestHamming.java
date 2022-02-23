package GeneticAlgorithm.test;

import java.util.ArrayList;
import java.util.List;

import GeneticAlgorithm.GA.BranchTarget;
import GeneticAlgorithm.GA.fitness.HammingPath;

public class TestHamming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<BranchTarget> branches = new ArrayList<BranchTarget>();
		for (int i = 1; i <= 5; i++) {
			branches.add(new BranchTarget(Integer.valueOf(i)));
		}
		HammingPath hammingPath = new HammingPath(branches);
		System.out.println(hammingPath.makeListofNTuples(1));
		System.out.println(hammingPath.makeListofNTuples(2));
		System.out.println(hammingPath.makeListofNTuples(3));
		System.out.println(hammingPath.makeListofNTuples(4));
		System.out.println(hammingPath.makeListofNTuples(5));
	}

}
