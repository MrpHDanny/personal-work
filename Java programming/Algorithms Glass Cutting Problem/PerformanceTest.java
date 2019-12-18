import java.util.List;

public class PerformanceTest {

	public static void main(String[] args) {

		System.out.println("***********************************************");
		System.out.println("*********** Performance analysis **************");
		System.out.println("**********************************************");

		System.out.println();
		/*
		 * You must complete the Generator class in order to generate a random
		 * test values. You must complete the Algorithms class in order to call
		 * the two algorithms.
		 * 
		 * You can use any additional method you created in this class
		 */

		

		/**
		 * Remember: You need to calculate the time and number of sheets used
		 * for each run of each algorithm.
		 * 
		 * You are expected to run several tests (e.g. noOfTests=5) of your
		 * programs for, 10000, 20000, 30000, 40000, 50000 shapes
		 * (noOfShapes=10000, increment=10000) so that one can see how the
		 * algorithms perform for large datasets.
		 * 
		 * You are expected to run the same test a number of times to ensure
		 * accurate result (noOfRep=4). In this case, you need to calculate the
		 * average time and sheets needed for each run
		 **/

		// total number of tests - you need to CHANGE this value
		int noOfTests = 5;

		// number of repetitions for each test - you need to CHANGE this value
		int noOfRep = 1;

		// number of shapes needed for the first run - you need to CHANGE this
		// value
		int noOfShapes = 10000;

		// the increment in the number of shapes - you need to CHANGE this value
		int increment = 10000;


		Algorithms a = new Algorithms();
		Generator g = new Generator();
		List<Shape> shapes;
		List<Sheet> result;

		Integer totalSheetsNF;
		Integer totalSheetsFF;
		Integer currentSheets;
		Integer averageSheetsNF;
		Integer averageSheetsFF;
		Long startTime;
		Long totalTimeNF;
		Long totalTimeFF;
		Long averageTimeNF;
		Long averageTimeFF;


		System.out.println("Number of repetitions: " + noOfRep);

		System.out.println("\nNumber of Sheets Used\n");
		System.out.format("%-16s | %-15s | %-15s\n","Number of Shapes", "NextFit", "FirstFit");

		for(int i = 0; i < noOfTests; i++){
			totalSheetsNF = 0;
			totalSheetsFF = 0;
			for(int j = 0; j < noOfRep; j++){
				shapes = g.generateShapeList(noOfShapes + (increment * i));
				result = a.nextFit(shapes);
				currentSheets = result.size();
				totalSheetsNF += currentSheets;

				result = a.firstFit(shapes);
				currentSheets = result.size();
				totalSheetsFF += currentSheets;
			}
			averageSheetsNF = totalSheetsNF / noOfRep;
			averageSheetsFF = totalSheetsFF / noOfRep;

			System.out.format("%-16d | %-15d | %-15d\n", noOfShapes + (i*increment), averageSheetsNF, averageSheetsFF);

		}

		System.out.println("\nNumber of time taken (ms)\n");
		System.out.format("%-16s | %-15s | %-15s\n","Number of Shapes", "NextFit", "FirstFit");

		for (int i = 0; i < noOfTests; i++){
			totalTimeNF = (long) 0;
			totalTimeFF = (long) 0;
			for(int j = 0; j < noOfRep; j++){
				shapes = g.generateShapeList(noOfShapes + (increment * i));

				startTime = System.nanoTime();
				result = a.nextFit(shapes);
				totalTimeNF = totalTimeNF + (System.nanoTime() - startTime);

				startTime = System.nanoTime();
				result = a.firstFit(shapes);
				totalTimeFF = totalTimeFF + (System.nanoTime() - startTime);
			}
			averageTimeNF = totalTimeNF / noOfRep;
			averageTimeFF = totalTimeFF / noOfRep;

			System.out.format("%-16d | %-15d | %-15d\n", noOfShapes + (i*increment), averageTimeNF/1000000, averageTimeFF/1000000);

		}
	}
}
