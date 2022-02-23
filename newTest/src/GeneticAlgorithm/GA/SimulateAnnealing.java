package GeneticAlgorithm.GA;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import GeneticAlgorithm.GA.fitness.FitnessFeature;

public class SimulateAnnealing {

	public SimulateAnnealing(Chromosome solid,Population curPopulation ) {
		// TODO Auto-generated constructor stub
		this.curPopulation = curPopulation;
		this.solid=solid;
	}

	//bổ sung phần simulate annealing SA
	// khởi tạo các giá trị cho  SA
	private  double coolingRate = 0.009;
	private double temperature = 10000;
	private  double endTemperature = 0.99;
	private Population curPopulation;
	private Chromosome solid;

	
	public void simulateAnnealing() throws IOException {
		
            // Best found solution is initially, randomly picked	
		    System.out.println("Simulated Annealing: ");
			Random randomGenerator = curPopulation.randomGenerator;
			int random1 = randomGenerator.nextInt(curPopulation.populationSize);
			int random2=randomGenerator.nextInt(curPopulation.populationSize);		 
			Chromosome bestSolution = (Chromosome) (curPopulation.getIndividuals().get(random1));
			double bestEnergy=bestSolution.getFitness();	   
			//  a current solution
			solid=(Chromosome)(curPopulation.getIndividuals().get(random2));
			Chromosome currentSolution=solid;	     
			// Energy of the current solution is its' value
			double currentEnergy = currentSolution.getFitness();	 
		    // Start annealing
		    while (temperature > endTemperature) {
		      // Get random position in our individual
		      int newSolutionPosition = this.getRandomIndex();
		      Chromosome newSolution = (Chromosome)(curPopulation.getIndividuals().get(newSolutionPosition));
		      // Retrieve new solution's value
		      int newSolutionEnergy = newSolutionPosition;
		      //int newSolutionEnergy = newSolution.getFitness();
		      // Check whether new solution should be accepted    
		      if (this.acceptanceProbability( currentEnergy, newSolutionEnergy, temperature) > this.ranDom(0.0, 1.0)) {
		        // Move on to the new solution
		        currentSolution = (Chromosome) curPopulation.getIndividuals().get(newSolutionPosition);
		      }
		      // Compare to the global optimal
		      if (newSolutionEnergy < bestEnergy) {
		        // Mark as global optimal (best found) if current global optimal is greater
		        bestSolution = currentSolution;
		      }
		      // Cool down
		      temperature *= 1 - coolingRate;
		    }
		    		
		    curPopulation.chromosomeFormer.setCurrentChromosome(bestSolution);

	  }
	//Shared random object
	static private Random rand;
	//Create a uniformly distributed random double between a and b inclusive
	static double ranDom(double a, double b) {
		if (rand == null) {
			rand = new Random();
			rand.setSeed(System.nanoTime());
		}
		return ((b - a) * rand.nextDouble() + a);
	}

	  private double acceptanceProbability(final double currentEnergy, 
			  final double newSolutionEnergy, final double temperature) {
	    if (newSolutionEnergy > currentEnergy) {
	      return 1;
	    }

	    return Math.exp((currentEnergy - newSolutionEnergy) / temperature);
	  }

	  private int getRandomIndex() {
	    final Random random = new Random();

	    return random.nextInt(this.curPopulation.getIndividuals().size());
	  }
	  

}
