import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.StringTokenizer;

//import sortStrategy.sortStrategy;

public class WorldPopulation {
	int i= 0;

	sortStrategy sortStrategy;
	long[] population = new long[13484]; // Cheating because we know number of records!!
	// Lab Exercise:  After creating some strategy classes -- set the default strategy here.
	public WorldPopulation(){
		sortStrategy = new InsertionSort(); // Set the default strategy here.	
	}
	
	public void readInputFile(){
		population = readPopulationFile("src\\WorldPopulation.csv");
	}
	
	public void setStrategy(sortStrategy strategy){
		sortStrategy = strategy;
		sortStrategy.sort(population);
	}
	
	// Lab Exercise:  Read in the WorldPopulation.csv
	// Extract ONLY the numbers and store them into population[]
	public long[] readPopulationFile(String fileName){
		try {
			FileReader inputFile = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(inputFile);
			String line;
			while((line = reader.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(line, ",");
				String Name = tokenizer.nextToken();
				String year = tokenizer.nextToken();
				 population[i] = Integer.parseInt(tokenizer.nextToken());
				 i++;

			System.out.println(line);
			}
			reader.close();
			} catch (Exception e) {
			e.printStackTrace();
			}
	  
		return population;
	}
	
	// Lab Exercise.  Complete this method.
	// Delegate sorting to the strategy object
	public void sortPopulation(){	
		String y = sortStrategy.strategyName();
		System.out.println("The sort_technique used "+ y);
		long time = sortStrategy.getSorttime();
		System.out.println("Time for  sort_technique used "+ time);
		
		
	}
	
	public void computeTotalPopulation(){
		System.out.println("dd");
	}
	
	// Experiment with various strategies.
	// Create 3 strategies -- Bubble, insertion, and selection sort.
	public static void main(String[] args) {
		WorldPopulation worldPopulation = new WorldPopulation();
		InsertionSort InsertionSort = new InsertionSort();
		SelectionSort selectionSort = new SelectionSort();
		BubbleSort bubbleSort = new BubbleSort();
		worldPopulation.readInputFile();
		worldPopulation.setStrategy(bubbleSort);
		worldPopulation.sortPopulation();
		worldPopulation.setStrategy(selectionSort);
		worldPopulation.sortPopulation();
		worldPopulation.setStrategy(InsertionSort); //  Currently no strategies.
		worldPopulation.sortPopulation();	
	}

}
