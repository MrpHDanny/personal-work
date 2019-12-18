import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Purpose: The SortedTest class is used to compare the implemented algorithms
 *           in term of the number of sheets used WHEN the list of
 *           shapes is SORTED
 */

public class SortedTest {
	public static void main(String[] args) {
		System.out.println("*********************************************");
		System.out.println("**************** Sorted Test ****************");
		System.out.println("*********************************************");
		System.out.println();

		/*
		 * Generate a random shape list and then check the number of sheets used
		 * when
		 ** this shape list is passed un-sorted
		 ** the list is sorted based on different criteria as set in the speciication document.
		 * 
		 * run several tests for different sizes of the "list of shapes" 
		 */

		/*
		 * HINT: you might want to implements the comparTo method in the Shape
		 * class or implement the Comparator Interface to do the sorting
		 */

		int noOfTests = 5;
		int noOfRep = 1;
		int noOfShapes = 10000;
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
        List<Integer> resultsNF = new ArrayList<>();
        List<Integer> resultsFF = new ArrayList<>();

        System.out.println("Number of repetitions: " + noOfRep);

		System.out.println("NextFit Performance\n");
        System.out.printf("%70s\n","Num of Sheets Used\n");
		System.out.format("%-16s | %-24s | %-24s | %-24s | %-24s |\n","Number of Shapes", "         Unsorted", "         Height", "         Width", "         Area");
        String asc = "Ascending";
        String desc = "Descending";
		System.out.printf("%-16s | %-24s | %-11s | %-11s| %-11s | %-11s| %-11s | %-11s|\n", "", "",asc,desc, asc,desc, asc,desc, asc,desc);

		for (int i = 0; i < noOfTests; i++){

		    totalSheetsNF = 0;
		    totalSheetsFF = 0;

			/* Unsorted list of shapes */
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
			totalSheetsNF = 0;
			totalSheetsFF = 0;

			resultsNF.add(averageSheetsNF);
			resultsFF.add(averageSheetsFF);

			/* Sorted in ascending order by height */
			for(int j = 0; j < noOfRep; j++){
				shapes = g.generateShapeList(noOfShapes + (increment * i));
				Collections.sort(shapes, new SortByHeight());

				result = a.nextFit(shapes);
				currentSheets = result.size();
				totalSheetsNF += currentSheets;

                result = a.firstFit(shapes);
                currentSheets = result.size();
                totalSheetsFF += currentSheets;
			}
			averageSheetsNF = totalSheetsNF / noOfRep;
			averageSheetsFF = totalSheetsFF / noOfRep;
			totalSheetsNF = 0;
			totalSheetsFF = 0;
			resultsNF.add(averageSheetsNF);
			resultsFF.add(averageSheetsFF);

            /* Sorted in descending order by height */
            for(int j = 0; j < noOfRep; j++){
                shapes = g.generateShapeList(noOfShapes + (increment * i));
                Collections.sort(shapes, new SortByHeight());
                Collections.reverse(shapes);

                result = a.nextFit(shapes);
                currentSheets = result.size();
                totalSheetsNF += currentSheets;

                result = a.firstFit(shapes);
                currentSheets = result.size();
                totalSheetsFF += currentSheets;

            }
            averageSheetsNF = totalSheetsNF / noOfRep;
            averageSheetsFF = totalSheetsFF / noOfRep;
            totalSheetsNF = 0;
            totalSheetsFF = 0;
            resultsNF.add(averageSheetsNF);
            resultsFF.add(averageSheetsFF);

            /* Sorted in ascending order by width */
            for(int j = 0; j < noOfRep; j++){
                shapes = g.generateShapeList(noOfShapes + (increment * i));
                Collections.sort(shapes, new SortByWidth());

                result = a.nextFit(shapes);
                currentSheets = result.size();
                totalSheetsNF += currentSheets;

                result = a.firstFit(shapes);
                currentSheets = result.size();
                totalSheetsFF += currentSheets;

            }
            averageSheetsNF = totalSheetsNF / noOfRep;
            averageSheetsFF = totalSheetsFF / noOfRep;
            totalSheetsNF = 0;
            totalSheetsFF = 0;
            resultsNF.add(averageSheetsNF);
            resultsFF.add(averageSheetsFF);

            /* Sorted in descending order by width */
            for(int j = 0; j < noOfRep; j++){
                shapes = g.generateShapeList(noOfShapes + (increment * i));
                Collections.sort(shapes, new SortByWidth());
                Collections.reverse(shapes);

                result = a.nextFit(shapes);
                currentSheets = result.size();
                totalSheetsNF += currentSheets;

                result = a.firstFit(shapes);
                currentSheets = result.size();
                totalSheetsFF += currentSheets;
            }
            averageSheetsNF = totalSheetsNF / noOfRep;
            averageSheetsFF = totalSheetsFF / noOfRep;
            totalSheetsNF = 0;
            totalSheetsFF = 0;
            resultsNF.add(averageSheetsNF);
            resultsFF.add(averageSheetsFF);

            /* Sorted in ascending order by area */
            for(int j = 0; j < noOfRep; j++){
                shapes = g.generateShapeList(noOfShapes + (increment * i));
                Collections.sort(shapes, new SortByArea());

                result = a.nextFit(shapes);
                currentSheets = result.size();
                totalSheetsNF += currentSheets;

                result = a.firstFit(shapes);
                currentSheets = result.size();
                totalSheetsFF += currentSheets;
            }
            averageSheetsNF = totalSheetsNF / noOfRep;
            averageSheetsFF = totalSheetsFF / noOfRep;
            totalSheetsNF = 0;
            totalSheetsFF = 0;
            resultsNF.add(averageSheetsNF);
            resultsFF.add(averageSheetsFF);

            /* Sorted in descending order by area */
            for(int j = 0; j < noOfRep; j++){
                shapes = g.generateShapeList(noOfShapes + (increment * i));
                Collections.sort(shapes, new SortByArea());
                Collections.reverse(shapes);

                result = a.nextFit(shapes);
                currentSheets = result.size();
                totalSheetsNF += currentSheets;

                result = a.firstFit(shapes);
                currentSheets = result.size();
                totalSheetsFF += currentSheets;
            }
            averageSheetsNF = totalSheetsNF / noOfRep;
            averageSheetsFF = totalSheetsFF / noOfRep;
            resultsNF.add(averageSheetsNF);
            resultsFF.add(averageSheetsFF);

            System.out.printf("%-16d | %-12s | %-9d | %-11d | %-11d| %-11d | %-11d| %-11d | %-11d|\n", noOfShapes + (increment * i),"NextFit", resultsNF.get(0),resultsNF.get(1),resultsNF.get(2), resultsNF.get(3),resultsNF.get(4), resultsNF.get(5),resultsNF.get(6));
            System.out.printf("%-16s | %-12s | %-9d | %-11d | %-11d| %-11d | %-11d| %-11d | %-11d|\n", "","FirstFit", resultsFF.get(0),resultsFF.get(1),resultsFF.get(2), resultsFF.get(3),resultsFF.get(4), resultsFF.get(5),resultsFF.get(6));
            resultsNF = new ArrayList<>();
            resultsFF = new ArrayList<>();
        }
	}
}
