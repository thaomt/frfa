package GeneticAlgorithm.test;

import java.util.Iterator;
import java.util.List;

import GeneticAlgorithm.GA.CommonParameter;
import GeneticAlgorithm.GA.MethodTarget;
import GeneticAlgorithm.GA.Path;
import GeneticAlgorithm.GA.TestGenerator;

public class TestTestGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String classUnderTest = "Example";
		TestGenerator testGenerator = new TestGenerator();
		testGenerator.setPathsFile(CommonParameter.relativePath + classUnderTest + ".path");
		testGenerator.setTargetFile(CommonParameter.relativePath + classUnderTest + ".tgt");
		
		testReadTarget(testGenerator);
		testReadPaths(testGenerator);
		testGetBranchSetFromPaths(testGenerator);
		testGetTargetPaths(testGenerator);
		testGetBranchWithMethod(testGenerator);
		testGetBranchForMethod(testGenerator);
		
		
	}
	
	public static void testReadTarget(TestGenerator testGenerator) {
		testGenerator.readTarget();
		List<MethodTarget> targetToCoverList = testGenerator.getAllTargets();
		Iterator<MethodTarget> iterator = targetToCoverList.iterator();
		while (iterator.hasNext()) {
			MethodTarget branchTargets = iterator.next();
			System.out.println(branchTargets.getMethod() + ": " + branchTargets.toString());
		}
	}
	
	public static void testReadPaths(TestGenerator testGenerator) {
		testGenerator.readPaths();
		System.out.println(testGenerator.getAllPaths());
	}
	
	public static void testGetBranchSetFromPaths(TestGenerator testGenerator) {
		List branchesList = testGenerator.getBranchSetFromPaths();
		System.out.println(branchesList.toString());
	}
	
	public static void testGetBranchWithMethod(TestGenerator testGenerator) {
		System.out.println(testGenerator.getBranchWithMethod());
	}
	
	public static void testGetTargetPaths(TestGenerator testGenerator) {
		System.out.println(testGenerator.getTargetPaths());
		for (Path path : testGenerator.getTargetPaths()) {
			System.out.println(path.getExecutingMethod());
		}
	}
	
	public static void testGetBranchForMethod(TestGenerator testGenerator) {
		String[] branchWithMethod = testGenerator.getBranchForMethod(testGenerator.getBranchWithMethod(), testGenerator.getBranchSetFromPaths());
		for (int i = 0; i < branchWithMethod.length; i++) {
			System.out.println(branchWithMethod[i]);
		}
	}

}
