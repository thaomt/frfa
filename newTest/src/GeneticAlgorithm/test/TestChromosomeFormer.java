package GeneticAlgorithm.test;

import GeneticAlgorithm.GA.ChromosomeFormer;
import GeneticAlgorithm.GA.CommonParameter;
import GeneticAlgorithm.GA.Population;

public class TestChromosomeFormer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String classUnderTest = "Example";
		String signFile = CommonParameter.relativePath + classUnderTest + ".sign";
		ChromosomeFormer chromosomeFormer = Population.setChromosomeFormer(signFile);
		
		//System.out.println(chromosomeFormer.getChromosome().toString());
		System.out.println(chromosomeFormer.getMethods().values());
		System.out.println(chromosomeFormer.getConstructors().values());
		
		
	}
	
	

}
