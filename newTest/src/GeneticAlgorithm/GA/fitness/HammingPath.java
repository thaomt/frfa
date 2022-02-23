package GeneticAlgorithm.GA.fitness;

import java.util.List;

import GeneticAlgorithm.GA.Path;
import GeneticAlgorithm.GA.BranchTarget;

import java.util.ArrayList;

public class HammingPath extends Path{
	
	//private List<Integer> nodes;
	
	public HammingPath () {
		this.branches = new ArrayList<BranchTarget>();
	}
	
	public HammingPath(List<BranchTarget> branches) {
		this.branches = branches;
	}
	
	public List<List> makeListofNTuples (int nOrder) {
		List<List> result = new ArrayList<List> ();
		
		if (nOrder > branches.size())
			return result;
		
		for (int i = 0; i < branches.size(); i++) {
			List<BranchTarget> nTuple = new ArrayList<BranchTarget>();
			int elementIndexInNTuple = i;
			for (int j = 0; j < nOrder; j++) {
				nTuple.add(((List<BranchTarget>)branches).get(elementIndexInNTuple));
				elementIndexInNTuple++;
			}
			result.add(nTuple);
			if (elementIndexInNTuple >= branches.size())
				break;
		}
		return result;
	}
	
	public List<List> makeDistinctListOfNTuples (int nOrder) {
		List<List> result = new ArrayList<List>();
		List<List> listOfNTuples = this.makeListofNTuples(nOrder);
		for (int i = 0; i < listOfNTuples.size(); i++) {
			if (!result.contains(listOfNTuples.get(i))) 
				result.add(listOfNTuples.get(i));
		}
		return result;
	}

	
}
