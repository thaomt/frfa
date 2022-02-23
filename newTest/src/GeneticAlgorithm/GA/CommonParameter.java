package GeneticAlgorithm.GA;


public class CommonParameter {

	public static final String relativePath = "..\\newTest\\src\\";
	//GA parameters
	public static final int populationSize = 30;
	public static final int maxAttemptsPerTarget = 30;
	public static final int maxExecutionTime = 1000; //s
	//genetic operator parameters
	public static final float elitismRate = 0.1f;
	public static final float selectionRate = 0.5f;
	public static final float crossoverRate = 0.8f;
	public static final float mutationInputValueRate =  0.6f;
	public static final float mutationConstructorRate = 0.2f;
	public static final float mutationMethodInvocationRate = 0.4f;
	//fitness configuration
	public static final boolean approachLevelFitness = false;
	public static final boolean branchDistanceFitness = false;
	public static final boolean hammingDistanceFitness = true;
	//check algorithm
	public static final boolean useSA = true;

}

