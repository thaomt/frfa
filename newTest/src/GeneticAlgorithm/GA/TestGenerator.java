package GeneticAlgorithm.GA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import GeneticAlgorithm.GA.fitness.ApproachLevel;
import GeneticAlgorithm.GA.fitness.BranchDistance;
import GeneticAlgorithm.GA.fitness.FitnessFeature;
import GeneticAlgorithm.GA.fitness.HammingDistance;

public class TestGenerator {
	/**
	 * Junit file
	 *
	 */
	private String junitFile = null;

	/**
	 * Branch sẽ được cover( method và các statement). Thuộc tính bao gồm các đối
	 * tượng Target
	 */
	List<MethodTarget> targets = new ArrayList<MethodTarget>();

	/**
	 * List các testcase final
	 */
	List testCases = null;

	/**
	 * Control dependences associated to each target.
	 * 
	 *
	 * target: BranchTarget -> Set<nodes: BranchTarget>
	 */
	Map paths = new HashMap();

	/**
	 * File list target
	 */
	private String targetFile;

	/**
	 * File list path
	 */
	private String pathsFile;
	
	private String classUnderTest;
	
	private List<FitnessFeature> fitnessFeatures = new ArrayList<FitnessFeature>();

	private Map<Path, Chromosome> targetsCoveredByIndividual = new HashMap<Path, Chromosome>();
	
	private List<Path> notCoveredTargets = new ArrayList<Path>();
	
	private List<Path> completePaths = new ArrayList<Path>();
	
	public TestGenerator() {
		configureFitnessFeatures();
	}
	
	public String getClassUnderTest() {
		return this.classUnderTest;
	}
	
	public void setClassUnderTest(String cut) {
		this.classUnderTest = cut;
	}
	
	public List<Path> getNotCoveredTargets() {
		return this.notCoveredTargets;
	}
	
	public void addNotCoveredTarget(Path p) {
		this.notCoveredTargets.add(p);
	}

	/**
	 * Print current configuration before running algorithm
	 */
	public static void printParameters() {
		System.out.println("populationSize: " + CommonParameter.populationSize);
		System.out.println("maxAttemptsPerTarget: " + CommonParameter.maxAttemptsPerTarget);
		if (CommonParameter.approachLevelFitness) 
			System.out.println("Use Approach Level Fitness");
		if (CommonParameter.branchDistanceFitness) 
			System.out.println("Use Branch Distance Fitness");
		if (CommonParameter.hammingDistanceFitness) 
			System.out.println("Use Hamming Distance Fitness");
		if(CommonParameter.useSA) {
			System.out.println("----------------------");
			System.out.println("Combine genetic and simulated annealing algorithms\nGA-SA");  
			System.out.println("----------------------");
    	}else {
    		System.out.println("----------------------");
    		System.out.println("Only genetic algorithms\nGA");
    		System.out.println("----------------------");
    	}
	}
	
	public void configureFitnessFeatures() {
		if (CommonParameter.approachLevelFitness) 
			fitnessFeatures.add(new ApproachLevel());
		if (CommonParameter.branchDistanceFitness) 
			fitnessFeatures.add(new BranchDistance());
		if (CommonParameter.hammingDistanceFitness) 
			fitnessFeatures.add(new HammingDistance());
	}
	
	public void evaluatePopulation(Population pop) throws IOException{
		TestCaseExecutor executor = new TestCaseExecutor();
		for (Chromosome individual : pop.getIndividuals()) {
			individual.setTargetPath(pop.currentTargetPath);
			individual.setFitness(0.0);
			executor.execute(classUnderTest, individual.toString());
			Path coveredPath = executor.getExecutionTrace(classUnderTest);
			individual.setCoveredPath(coveredPath);
			System.out.println("Chromosome "+ individual);
			System.out.println("Covered: " + coveredPath);
			System.out.println("Target: " + pop.currentTargetPath);
			for (FitnessFeature fitnessFeature : fitnessFeatures) {
				fitnessFeature.calculateFitnessValue(individual);
			}
		}
		//sorting individuals in the population by fitness
		Collections.sort(pop.getIndividuals());
	}

	/**
	 * Read all branch targets from target file (.tgt)
	 *
	 * <pre>
	 * BinaryTree.search(Comparable): 5, 6, 7, 8, 9
	 * </pre>
	 */
	public void readTarget() {
		try {
			String s;
			Pattern p = Pattern.compile("([^\\s]+)\\s*:\\s*(.*)");
			BufferedReader in = new BufferedReader(new FileReader(targetFile));
			while ((s = in.readLine()) != null) {
				Matcher m = p.matcher(s);
				if (!m.find())
					continue;
				String method = m.group(1);
				MethodTarget tgt = new MethodTarget(method);
				String[] branches = m.group(2).split(",");
				for (int i = 0; i < branches.length; i++) {
					int n = Integer.parseInt(branches[i].trim());
					tgt.addBranch(n);
				}
				targets.add(tgt);

			}
		} catch (NumberFormatException e) {
			System.err.println("Wrong format file: " + targetFile);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("IO error: " + targetFile);
			System.exit(1);
		}
	}

	/**
	   * Reads control dependences (paths.txt).
	   * 
	   * Format of paths.txt:
	   *
	   * <pre>
	   * 10: 4 5 6
	   * 11: 4 5 6 10
	   * 12: 4 5 6 10 
	   * </pre>
	   */
	public void readPaths() {
		try {
			String s;
			BufferedReader in = new BufferedReader(new FileReader(pathsFile));
			while ((s = in.readLine()) != null) {
				String r = s.substring(0, s.indexOf(":"));
				int tgt = Integer.parseInt(r);
				r = s.substring(s.indexOf(":") + 1);
				StringTokenizer tok = new StringTokenizer(r);
				List<BranchTarget> pathPoints = new LinkedList<BranchTarget>();
				while (tok.hasMoreTokens()) {
					int n = Integer.parseInt(tok.nextToken());
					pathPoints.add(new BranchTarget(n));
				}
				Collections.sort(pathPoints);
				paths.put(new BranchTarget(tgt), pathPoints);
			}
			minimizeBranchesToCover();
			buildCompleteTargetPaths();
		} catch (NumberFormatException e) {
			System.err.println("Wrong format file: " + pathsFile);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("IO error: " + pathsFile);
			System.exit(1);
		}
	}
	
	//minimizing the list of branches to be covered
	//if a branch appears in a reachable path of another branch which appears after
	//then remove the former because cover the later then cover the former
	private void minimizeBranchesToCover() {
		Map initialPaths = new HashMap();
		initialPaths.putAll(paths);
		List<BranchTarget> branches = new LinkedList<BranchTarget>();
		branches.addAll(initialPaths.keySet());
		Collections.sort(branches);
		for (int i = 0; i < branches.size() - 1; i++) {
			BranchTarget branch = branches.get(i);
			for (int j = i+1; j < branches.size(); j++) {
				List<BranchTarget> reachingPath = (LinkedList<BranchTarget>)initialPaths.get(branches.get(j));
				if (reachingPath.contains(branch)) {
					paths.remove(branch);
					break;
				}
			}
		}
	}

	/**
	 * Get all branch targets from the target file
	 */
	public List<MethodTarget> getAllTargets() {
		return targets;
	}
	
	public Map getAllPaths() {
		return paths;
	}
	
	public List<Path> getTargetPathsForMethod(String methodName){
		List<Path> targetPathsForMethod = new ArrayList<Path>();
		for (Path path : completePaths) {
			if (path.getExecutingMethod() != null && path.getExecutingMethod().equals(methodName))
				targetPathsForMethod.add(path);
		}
		return targetPathsForMethod;
	}
	
	public void buildCompleteTargetPaths() {
		List<BranchTarget> branchTargets = new ArrayList<BranchTarget>();
		branchTargets.addAll(paths.keySet());
		Iterator<BranchTarget> iterator = branchTargets.iterator();
		while (iterator.hasNext()) {
			BranchTarget branch = iterator.next();
			Path targetPath = new Path((List)paths.get(branch));
			targetPath.addBranch(branch);
			completePaths.add(targetPath);
		}
		mapTargetPathsToMethod();
	}
	
	private void mapTargetPathsToMethod() {
		Iterator<MethodTarget> iterator = targets.iterator();
		while (iterator.hasNext()) {
			MethodTarget target = iterator.next();
			for (Path path : completePaths) {
				if (target.getSubTargets().containsAll(path.getBranches())) {
					path.setExecutingMethod(target.getMethod());
				}
			}
		}
	}
	
	
	public List<Path> getTargetPaths() {
//		List<Path> targetPaths = new ArrayList<Path>();
//		List<BranchTarget> branchTargets = new ArrayList<BranchTarget>();
//		branchTargets.addAll(paths.keySet());
//		Iterator<BranchTarget> iterator = branchTargets.iterator();
//		while (iterator.hasNext()) {
//			BranchTarget branch = iterator.next();
//			Path targetPath = new Path((List)paths.get(branch));
//			targetPath.addBranch(branch);
//			targetPaths.add(targetPath);
//		}
//		mapTargetPathsToMethod(targetPaths);
		return completePaths;
	}
	
//	private void mapTargetPathsToMethod(List<Path> targetPaths) {
//		Iterator<MethodTarget> iterator = targets.iterator();
//		while (iterator.hasNext()) {
//			MethodTarget target = iterator.next();
//			for (Path path : targetPaths) {
//				if (target.getSubTargets().containsAll(path.getBranches())) {
//					path.setExecutingMethod(target.getMethod());
//				}
//			}
//		}
//	}
	
	public String[] getBranchForMethod(List listTarget, List<Set> listBranchTarget) {
		String[] branchWithMethod = new String[listTarget.size()];

        for (int i = 0; i < listTarget.size(); i++) {
            branchWithMethod[i] = "";
            for (int j = 0; j < listBranchTarget.size(); j++) {
                Pattern pattern = Pattern.compile("[0-9]+");
                String temp = "";
                for (int k = 0; k < listBranchTarget.get(j).toString().length(); k++) {
                    Matcher matcher = pattern.matcher(listBranchTarget.get(j).toString().charAt(k) + "");
                    if (matcher.matches()) {
                        temp += listBranchTarget.get(j).toString().charAt(k) + "";
                    } else {
                        if (temp.equals("") == true) {
                            continue;
                        } else
                            break;
                    }
                }
                if (!temp.equals("")) {
                    if (listTarget.get(i).toString().equals("[" + temp + "]")) {
                        branchWithMethod[i] += Integer.toString(j) + ",";
                        break;
                    } else if (listTarget.get(i).toString().contains("[" + temp + ",")) {
                        branchWithMethod[i] += Integer.toString(j) + ",";
                    }
                }

            }
        }
        return branchWithMethod;
	}

	/**
	 * Lấy ra các branch chuẩn từ tập các path
	 * 
	 * @return List<Set> tập hợp các branch có
	 */
	public List<Set> getBranchSetFromPaths() {
		List valuePaths = new LinkedList();
		valuePaths.addAll(paths.values());
		List keyPaths = new LinkedList();
		keyPaths.addAll(paths.keySet());

		List<Set> newSet = new LinkedList<>();
		for (int i = 0; i < valuePaths.size(); i++) {
			Set<String> temp = new HashSet<>();
			if (valuePaths.get(i).toString().equals("[]")) {
				temp.add(keyPaths.get(i) + "");
			} else {
				temp.add((valuePaths.get(i) + ", " + keyPaths.get(i)).replace("[", "").replaceAll("]", ""));
			}
			newSet.add(temp);
		}
		return newSet;
	}

	/**
	 * Lấy ra các target
	 */
	public List<String> getBranchWithMethod() {
		List targetsToCover = new LinkedList();
		Iterator i = targets.iterator();
		while (i.hasNext()) {
			MethodTarget tgt = (MethodTarget) i.next();
			targetsToCover.add(tgt.toString());
		}
		return targetsToCover;
	}
	
	public String getTargetFile() {
		return this.targetFile;
	}
	
	public void setTargetFile(String targetFile) {
		this.targetFile = targetFile;
	}
	
	public String getPathsFile() {
		return this.pathsFile;
	}
	
	public void setPathsFile(String pathsFile) {
		this.pathsFile = pathsFile;
	}

//	/**
//	 * Minimize số lượng testcase
//	 * 
//	 * @param pop
//	 *            quần thể chứa các testcase
//	 * @return
//	 */
//	public Population minimizeTestCases(Population pop) {
//		String target = "";
//		for (String s : MainGA.inputs) {
//			TestGenerator testGenerator = new TestGenerator();
//			testGenerator.setPathsFile(CommonParameter.relativePath + s + ".path");
//			testGenerator.setTargetFile(CommonParameter.relativePath + s + ".tgt");
//			target += testGenerator.getAllTargets().toString();
//		}
//		int count = 0;
//		for (int j = 0; j < pop.getIndividuals().size(); j++) {
//			Pattern pattern = Pattern.compile("[0-9]+");
//			String temp = "";
//
//			int low = count;
//			Chromosome id = (Chromosome) pop.getIndividuals().get(j);
//			for (int i = 0; i < id.getTargetPath().toString().length(); i++) {
//				Matcher matcher = pattern.matcher(id.getTargetPath().toString().charAt(i) + "");
//				if (matcher.matches()) {
//					temp += id.getTargetPath().toString().charAt(i) + "";
//				} else {
//					if (temp.equals("") == true) {
//						continue;
//					} else {
//						if (temp.equals("") == false) {
//							int t = 0;
//							if (target.contains("[" + temp + ","))
//								t = 1;
//							if (target.contains(" " + temp + ","))
//								t = 2;
//							if (target.contains(" " + temp + "]"))
//								t = 3;
//							if (target.contains("[" + temp + "]"))
//								t = 4;
//							switch (t) {
//							case 1:
//							case 2:
//							case 3:
//							case 4:
//								count++;
//								String str = target.substring(0, target.indexOf(temp))
//										+ target.substring(target.indexOf(temp) + temp.length());
//								target = str;
//								break;
//							}
//						}
//					}
//					temp = "";
//				}
//			}
//			int up = count;
//			if (up == low)
//				pop.getIndividuals().remove(j);
//
//		}
//
//		return pop;
//	}
	

	/**
	 * Generates Junit test class.
	 */
	public void printJunitFile() {
		try {
			System.out.println(junitFile);
			if (junitFile == null)
				return;
			String junitClass = junitFile.substring(0, junitFile.indexOf("."));
			PrintStream out = new PrintStream(new FileOutputStream(CommonParameter.relativePath + junitFile));
			out.println("import junit.framework.*;");

			out.println();
			out.println("public class " + junitClass + " extends TestCase {");
			out.println();
			out.println("  public static void main (String[] args) {");
			out.println("    junit.textui.TestRunner.run(" + junitClass + ".class);");
			out.println("  }");
			out.println();
			int testCaseId = 0;
			List<Chromosome> testCases = new ArrayList<Chromosome>();
			testCases.addAll(targetsCoveredByIndividual.values());
			Iterator<Chromosome> iterator = testCases.iterator();
			while (iterator.hasNext()) {
				Chromosome tc = iterator.next();
				testCaseId++;
				out.println("  @org.junit.jupiter.api.Test");
				out.println("  public void testCase" + testCaseId + "() {");
				out.print(tc.toCode());
				out.println("  }");
				out.println();
			}
			out.println("  }");
			out.close();
		} catch (FileNotFoundException e) {
			System.err.println("cannot create file: " + junitFile);
			System.exit(1);
		}
	}
	
	public void printTestCases() {
		List<Chromosome> testCases = new ArrayList<Chromosome>();
		testCases.addAll(targetsCoveredByIndividual.values());
		Iterator<Chromosome> iterator = testCases.iterator();
		int tcID = 0;
		while (iterator.hasNext()) {
			Chromosome tc = iterator.next();
			tcID++;
			System.out.print("TC #" + tcID + ": ");
			System.out.print(tc.toString());
			//System.out.print(" # covers path: " + tc.getCoveredPath());
			System.out.println();
		}
	}
	
	public void printEvaluation(long totalTime) {
		//System.out.println("==========================================");
        //System.out.println("listBranchTarget");
        //System.out.println(completePaths);
        System.out.println("==========================================");
        System.out.println("listBranchTargetCovered");
        System.out.println(targetsCoveredByIndividual.keySet());
        System.out.println("==========================================");
        System.out.println("listBranchTargetNotCovered");
        System.out.println(notCoveredTargets);
		System.out.println("Total generation time of " + classUnderTest + ": " + totalTime+"(ms)");
		int nbCoveredTargets = targetsCoveredByIndividual.size();
		int nbNotCoveredTargets = notCoveredTargets.size();
		double coverage = 100.0 * nbCoveredTargets / (nbCoveredTargets + nbNotCoveredTargets);
		System.out.println("Coverage: " + coverage + "%");
		if (nbNotCoveredTargets > 0) 
			System.out.println("Targets not yet covered:");
		Iterator<Path> iterator = notCoveredTargets.iterator();
		while (iterator.hasNext()) {
			Path path = (Path) iterator.next();
			System.out.println(path.getExecutingMethod() + " path:" + path);
		}
	}
	
	/**
	 * update covered target and individual in map
	 * @param pop
	 */
	public void updateCoveredTargets(Population pop) {
		targetsCoveredByIndividual.put(Population.currentTargetPath, pop.getIndCoversCurrentTarget());
	}
	
	public void setJUnitFile(String jUnitFile) {
		this.junitFile = jUnitFile;
	}
	public String getJUnitFile() {
		return this.junitFile;
	}
	// add
		public double getCover(long totalTime) {
			int nbCoveredTargets = targetsCoveredByIndividual.size();
			int nbNotCoveredTargets = notCoveredTargets.size();
			double coverage =100.0 * nbCoveredTargets / (nbCoveredTargets + nbNotCoveredTargets);
			return  coverage ;
		}
}
