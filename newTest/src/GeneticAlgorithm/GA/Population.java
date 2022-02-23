
package GeneticAlgorithm.GA;

import java.io.IOException;
import java.util.*;

public class Population {
	/**
	 * Used to randomly select individuals for new population.
	 */
	static Random randomGenerator = new Random();
	/**
	 * Target hiện tại đang xét của population
	 */
	static Path currentTargetPath;

	private Chromosome indCoversCurrentTarget;
	

	/**
	 * các branch mở rộng ( khi gọi đến method khác)
	 */
	static List<Set> extendTarget = new LinkedList<Set>();;

	/**
	 * @return the extendTarget
	 */
	public static List<Set> getExtendTarget() {
		return extendTarget;
	}

	/**
	 * @param extendTarget
	 *            the extendTarget to set
	 */
	public static void setExtendTarget(List<Set> extendTarget) {
		Population.extendTarget = extendTarget;
	}

	/**
	 * Target hiện tại đang xét của population
	 */
	static Set preTarget;

	/**
	 * list các cá thể
	 *
	 * List<Chromosome>
	 */
	private List<Chromosome> individuals;

	/**
	 * ChromosomeFormer chịu trách nhiệm tạo ra từng cá thể đơn lẻ và sự tiến hóa /
	 * tái hợp của nó.
	 */
	static ChromosomeFormer chromosomeFormer;

	/**
	 * Thông số chính của thuật toán di truyền: số lượng cá thể (nhiễm sắc thể)
	 * trong quần thể
	 */
	public static int populationSize = CommonParameter.populationSize;

	/**
	 * khởi tạo population
	 */
	public Population(List id) {
		individuals = id;
	}
	
	public List<Chromosome> getIndividuals() {
		return this.individuals;
	}

	/**
	 * tạo mới ChromosomeFormer.
	 *
	 * @param signFile
	 *            Tập tin có chữ ký phương thức. từ đó tạo ra chromosome
	 */
	public static ChromosomeFormer setChromosomeFormer(String signFile) {
		chromosomeFormer = new ChromosomeFormer();
		chromosomeFormer.addDefaultConstructor();
		chromosomeFormer.readSignaturesFromClassUnderTest(signFile);
		return chromosomeFormer;
	}

	/**
	 * @param chromosomeFormer
	 *            the chromosomeFormer sẽ set
	 */
	public static void setChromosomeFormer(ChromosomeFormer chromosomeFormer) {
		Population.chromosomeFormer = chromosomeFormer;
	}

	/**
	 * Static method to generate a new population with given target method.
	 * 
	 * @return population including initial individuals
	 * @throws IOException
	 */
	public static Population generateRandomPopulation() throws IOException {
		List individuals = new LinkedList();
		for (int j = 0; j < Population.populationSize; j++) {
			chromosomeFormer.buildNewChromosome();
			individuals.add(chromosomeFormer.getChromosome());
		}
		return new Population(individuals);
	}
	
	public boolean checkTargetPathIsCovered() {
		Iterator<Chromosome> iterator = individuals.iterator();
		while (iterator.hasNext()) {
			Chromosome individual = iterator.next();
			if (individual.coversTarget(currentTargetPath)) { 
				indCoversCurrentTarget = individual;
				return true;
			}
		}
		return false;
	}
	
	public Chromosome getIndCoversCurrentTarget() {
		return this.indCoversCurrentTarget;
	}

	/**
	 * lựa chọn quần thể con
	 * 
	 * @return quần thể
	 */
	public Population selection() {
		int numberSelection = (int) (populationSize * CommonParameter.crossoverRate);
		List newIndividuals = new LinkedList();
		for (int i = 0; i < numberSelection; i++) {
			Chromosome id = (Chromosome) (individuals.get(i));
			newIndividuals.add(id);
		}
		return new Population(newIndividuals);

	}
	
	public int size() {
		return individuals.size();
	}
	
	/**
	 * Select individuals from the current population
	 * with the highest fitness to create new generation by elitism
	 * @return
	 */
	public Population elitismSelection() {
		int numberOfIndividuals = (int) (populationSize * CommonParameter.elitismRate);
		List<Chromosome> selectedIndividuals = new ArrayList<Chromosome>();
		for (int i = 0; i < numberOfIndividuals; i++) {
			selectedIndividuals.add((Chromosome)individuals.get(i).clone());
		}
		return new Population(selectedIndividuals);
	}
	
	private double calculateOverallFitness() {
		double overallFitness = 0.0;
		for (Chromosome ind : individuals) {
			overallFitness += ind.getFitness();
		}
		return overallFitness;
	}
	
	public Population rouletteWheelSelection() {
		List<Chromosome> parentIndividuals = new ArrayList<Chromosome>();
		double overallFitness = calculateOverallFitness();
		int nbSelectedParents = (int) (populationSize * CommonParameter.selectionRate);
		for (int i = 0; i < nbSelectedParents; i++) {
			Chromosome parent = null;
			if (overallFitness == 0.0) {
				System.out.println("Overall Fitness is 0");
				int j = randomGenerator.nextInt(populationSize);
				parent = individuals.get(j);
			} else {
				double r = randomGenerator.nextDouble();
				double cumFitness = 0.0;
				double prevFitness = 0.0;
				Iterator<Chromosome> iterator = individuals.iterator();
				while (iterator.hasNext()) {
					parent = (Chromosome) iterator.next();
					prevFitness = cumFitness;
					cumFitness += parent.getFitness();
					double prob = r * overallFitness;
					if (prob >= prevFitness && prob < cumFitness)
						break;
				}
//				for (int j = 0; j <= i; j++) {
//					cumFitness += individuals.get(j).getFitness();
//				}
//				if (r < cumFitness/overallFitness)
//					parent = individuals.get(i);
			}
			if (parent != null) {
				parent = (Chromosome) parent.clone();
				parentIndividuals.add(parent);
			}
		}
		Population newPopulation = new Population(parentIndividuals);
		return newPopulation;
	}
	
	public Population generateNewPopulation() throws IOException {
		List<Chromosome> newIndividuals = new ArrayList<Chromosome>();
		//select the best to the next generation
		//newIndividuals.addAll(elitismSelection().getIndividuals());
		//select parents for generating offsprings
		Population newPopulation = rouletteWheelSelection();
		//generating new offsprings from parents
		newPopulation.evolve();
		newIndividuals.addAll(newPopulation.getIndividuals());
		return new Population(newIndividuals);
	}
	
	public void evolve()throws IOException {
		List<Chromosome> newIndividuals = new ArrayList<Chromosome>();
		for (int i = 0; i < individuals.size(); i++) {
			int j = ChromosomeFormer.randomGenerator.nextInt(individuals.size());
			Chromosome parent1 = (Chromosome) individuals.get(i).clone();
			Chromosome parent2 = (Chromosome) individuals.get(j).clone();
			chromosomeFormer.setCurrentChromosome(parent1);
			chromosomeFormer.evolveChromosome(parent2);
			newIndividuals.add(chromosomeFormer.getChromosome());
		}
		individuals.addAll(newIndividuals);
		System.out.println("Debug: new generation size: " + individuals.size());
	}
	
	

//	/**
//	 * lai ghép
//	 * 
//	 * @throws IOException
//	 */
//	public void crossover() throws IOException {
//		int x = (int) (populationSize * CommonParameter.cumulativeProbability / 2);
//		for (int k = 0; k < x; k = k + 2) {
//			Chromosome id1 = (Chromosome) (individuals.get(k));
//			System.out.println("chromosome---------------------");
//			System.out.println(id1.toString());
//			Chromosome id2 = (Chromosome) (individuals.get(k + 1));
//			System.out.println(id2.toString());
//			if (id1.getArrayOfActualValues() == null || id2.getArrayOfActualValues() == null) {
//				return;
//			} else {
//				String[] chromValue1 = id1.getArrayOfActualValues();
//				System.out.println(Arrays.toString(chromValue1));
//				System.out.println(chromValue1.length);
//				String[] chromValue2 = id2.getArrayOfActualValues();
//				System.out.println(Arrays.toString(chromValue2));
//				System.out.println(chromValue2.length);
//
//				if (chromValue1.length == 1 || chromValue2.length == 1 || chromValue1.length != chromValue2.length) {
//					mutationOneChromosome();
//					break;
//				} else {
//					int indexValue = 1 + randomGenerator.nextInt(chromValue1.length - 1);
//					for (int i = indexValue; i < chromValue1.length; i++) {
//						String temp = chromValue1[i];
//						chromValue1[i] = chromValue2[i];
//						chromValue2[i] = temp;
//					}
////					Chromosome offspring1 = (Chromosome) (individuals.get(populationSize - 1 - k));
//					System.out.println(chromosomeFormer.getChromosome().toString());
//					Chromosome offspring1 = id1;
//					System.out.println(offspring1.toString());
//					offspring1.setInputValue(new ArrayList<String>(Arrays.asList(chromValue1)));
//					System.out.println("pk+ "+chromosomeFormer.getChromosome().toString());
//					chromosomeFormer.setCurrentChromosome(offspring1);
////					try {
////						chromosomeFormer.fitness = 0;
////						chromosomeFormer.caculateApproachLevel(currentTargetPath);
////					}catch (Exception e){
////						e.printStackTrace();
////					}
//
////					Chromosome offspring2 = (Chromosome) (individuals.get(populationSize - 1 - k - 1));
//					Chromosome offspring2 = id2;
//					offspring2.setInputValue(new ArrayList<String>(Arrays.asList(chromValue2)));
//					chromosomeFormer.setCurrentChromosome(offspring2);
////					try {
////						chromosomeFormer.fitness = 0;
////						chromosomeFormer.caculateApproachLevel(currentTargetPath);
////					}catch (Exception e){
////						e.printStackTrace();
////					}
//				}
//			}
//		}
//
//	}

	/**
	 * đột biến cá thể bất kì trong quần thể được chọn
	 * 
	 * @throws IOException
	 */
	public void mutation() throws IOException {
		int x = (int) (populationSize * CommonParameter.mutationInputValueRate);
		for (int i = 0; i < x; i++) {
			int rd = randomGenerator.nextInt(populationSize);
			Chromosome id = (Chromosome) (individuals.get(rd));

			System.out.println(id.toString());
			id.mutationByChangingInputValue();
			System.out.println(id.toString());
//			chromosomeFormer.setCurrentChromosome(id);
//			chromosomeFormer.fitness = 0;
//			chromosomeFormer.caculateApproachLevel(currentTargetPath);
		}

	}

	/**
	 * đột biến 1 cá thể
	 * 
	 * @throws IOException
	 */
	public void mutationOneChromosome() throws IOException {
		int rd = randomGenerator.nextInt(populationSize);
		Chromosome id = (Chromosome) (individuals.get(rd));
		id.mutationByChangingInputValue();
		//chromosomeFormer.setCurrentChromosome(id);
		//chromosomeFormer.fitness = 0;
		//chromosomeFormer.caculateApproachLevel(currentTargetPath);
	}

	/**
	 * Lấy fitness cao nhất của chromosome
	 * 
	 * @return
	 */
	public double getFittest() {
		Chromosome id1 = (Chromosome) (individuals.get(0));
		chromosomeFormer.setCurrentChromosome(id1);
		return chromosomeFormer.fitness;
	}

	/**
	 * Tạo population chứa các chromosome sẽ mang đi tạo testcase
	 * 
	 * @return population chứa các cá thể
	 * @throws IOException
	 */
	public Population generateDestinationPopulation() throws IOException {
		List newIndividuals = new LinkedList();
		Chromosome id = (Chromosome) (individuals.get(0));
		chromosomeFormer.setCurrentChromosome(id);
		newIndividuals.add(chromosomeFormer.getChromosome());
		return new Population(newIndividuals);
	}

	/**
	 * Add thêm chromosome cho Destination Population
	 * 
	 * @param pop
	 *            Destination Population đã có
	 * @return
	 * @throws IOException
	 */
	public Population addDestinationPopulation(Population pop) throws IOException {
		Population newPopulation = new Population(pop.individuals);
		Chromosome id = (Chromosome) (individuals.get(0));
		chromosomeFormer.setCurrentChromosome(id);

		newPopulation.individuals.add(id);

		return newPopulation;
	}

	/**
	 * 
	 */
	public String toString() {
		String s = "";
		Iterator i = individuals.iterator();
		while (i.hasNext()) {
			Chromosome id = (Chromosome) i.next();
			s += id.toString() + "\n";
		}
		return s;
	}

}
