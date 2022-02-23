package GeneticAlgorithm.GA;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 
 * @author anhbtm
 * To represent a program path including both execution/covered path and target path
 *
 */
public class Path {
	protected List<BranchTarget> branches;
	
	String executingMethod;
	
	public Path() {
		// TODO Auto-generated constructor stub
		branches = new LinkedList<BranchTarget>();
	}
	
	public Path(String method) {
		executingMethod = method;
		branches = new LinkedList<BranchTarget>();
	}
	
	public Path(List<BranchTarget> branchSet) {
		this.branches = branchSet;
	}
	
	public String getExecutingMethod() {
		return this.executingMethod;
	}
	
	public void setExecutingMethod(String method) {
		this.executingMethod = method;
	}
	
	public List<BranchTarget> getBranches() {
		return this.branches;
	}
	
	public void addBranch(BranchTarget branch) {
		this.getBranches().add(branch);
	}
	
	public void addBranch(int n) {
		this.getBranches().add(new BranchTarget(n));
	}
	
	public void removeBranch(BranchTarget branch) {
		this.getBranches().remove(branch);
	}
	
	public void removeBranch(int n) {
		this.getBranches().remove(new BranchTarget(n));
	}
	
	public boolean equals(Path p) {
		return (p.branches.equals(this.branches));
	}
	
	public boolean covers(Path p) {
		return (this.branches.containsAll(p.branches));
	}
	
	public int size() {
		return this.getBranches().size();
	}
	
	public String toString() {
//		String resultString = "[";
//		Iterator<Integer> iterator = nodes.iterator();
//		while (iterator.hasNext()) {
//			resultString += iterator.next().toString() + ",";
//		}
//		return resultString.substring(0, resultString.lastIndexOf(",")) + "]";
		return branches.toString();
	}
}
