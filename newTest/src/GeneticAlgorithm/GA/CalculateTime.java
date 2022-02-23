package GeneticAlgorithm.GA;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CalculateTime {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		MainGA mainGA=new MainGA();
		List<Double> time = new ArrayList<Double>();
		List<Double> cover = new ArrayList<Double>();
		double totalGenTime=(double)0;
		double totalCover=(double)0;
		for(int i=0;i<100;i++) {
			time.add(i, mainGA.getValueForTest("Triangle").get(1));
			totalGenTime+=time.get(i);
			cover.add(i, mainGA.getValueForTest("Triangle").get(0));
			totalCover+=cover.get(i);
			
		}
		TestGenerator testGenerator=new TestGenerator();
		testGenerator.printParameters();
		System.out.println("Kết quả với 100 lần chạy thực nghiệm: \n");
		System.out.println("class under test: "+ "Triangle\n");
		totalGenTime=(double)(totalGenTime/100);
		System.out.println("thời gian chạy trung bình: " +totalGenTime + "ms");
		totalCover=(double)(totalCover/100);
		System.out.println("--------------");
		System.out.println("tỷ lệ cover trung bình: " +totalCover + "%");
		double maxCover=cover.get(0);
		double minCover=cover.get(0);
		for(int i=1;i<100;i++) {
			maxCover = Math.max(maxCover, cover.get(i));
			minCover= Math.min(minCover, cover.get(i));
		}
		System.out.println("tỷ lệ cover max " + maxCover+" %");
		System.out.println("tỷ lệ cover min " + minCover+ " %");
		for(int i=0;i<100;i++) {
			System.out.println("cover lần " + (i+1) +" là "+ cover.get(i)+ " %");
		}
		
		
		

	}

}
