import java.util.ArrayList;
import java.util.List;

public class CorrectnessTest {
	public static void main(String[] args) {
		System.out.println("*********************************************");
		System.out.println("*********** Correctness testing *************");
		System.out.println("*********************************************");
		System.out.println();


		CorrectnessTest test = new CorrectnessTest();

//		test.testRuleA();
//		test.testRuleB();
//		test.testRuleC();
//		test.testRuleD();
//		test.testRuleE();
//		test.testRuleF();
//		test.testEmptyList();
//		test.testNormalRun();


	}

	/* Test rule A from specification */
	private void testRuleA(){
		Algorithms a = new Algorithms();
		List<Shape> shapes = new ArrayList<>();
		List<Sheet> result;

		Shape s1 = new Shape(200,100);
		Shape s2 = new Shape(50,90);

		shapes.add(s1);

		System.out.printf("Input: %s\n", s1);
		/* Rule A (part 1): A shape is placed at the bottom left corner
		* of a sheet if there is sufficient space */
		result = a.nextFit(shapes);
		System.out.println("\nNextFit results for rule A (part 1):");
		printResult(result);

		result = a.firstFit(shapes);
		System.out.println("\nFirstFit results for rule A (part 1):");
		printResult(result);

		System.out.printf("\nInput: %s %s\n", s1, s2);
		/* Rule A (part 2): A shape is placed to the right of another
		* shape if there is sufficient space */
		shapes.add(s2);

		result = a.nextFit(shapes);
		System.out.println("\nNextFit results for rule A (part 2):");
		printResult(result);

		result = a.firstFit(shapes);
		System.out.println("\nFirstFit results for rule A (part 2):");
		printResult(result);
	}

	/* Test rule B from specification */
	private void testRuleB(){
		Algorithms a = new Algorithms();
		List<Shape> shapes = new ArrayList<>();
		List<Sheet> result;

		Shape s1 = new Shape(100,100);
		Shape s2 = new Shape(90,110);
		shapes.add(s1);
		shapes.add(s2);

		System.out.printf("\nInput: %s %s\n", s1, s2);
		/* Rule B: If a shape does not fit a shelf, one rotates the shape
		* and tries to fit it in the shelf */
		result = a.nextFit(shapes);
		System.out.println("\nNextFit results for rule B:");
		printResult(result);

		result = a.firstFit(shapes);
		System.out.println("\nFirstfit results for rule B:");
		printResult(result);
	}

	/* Test rule C from specification */
	private void testRuleC(){
		Algorithms a = new Algorithms();
		List<Shape> shapes = new ArrayList<>();
		List<Sheet> result;

		Shape s1 = new Shape(300, 100);
		Shape s2 = new Shape(50,100);
		Shape s3 = new Shape(50,200);
		shapes.add(s1);
		shapes.add(s2);

		System.out.printf("\nInput: %s %s\n", s1, s2);
		/* Rule C (part 1): If a shape does not fit in a shelf, one can
		* start a new shelf directly on top of the current shelf if
		* there is enough shelf */
		result = a.nextFit(shapes);
		System.out.println("\nNextFit results for rule C (part 1):");
		printResult(result);

		result = a.firstFit(shapes);
		System.out.println("\nFirstfit results for rule C (part 1):");
		printResult(result);

		shapes = new ArrayList<>();
		shapes.add(s1);
		shapes.add(s3);

		System.out.printf("\nInput: %s %s\n", s1, s3);
		/* Rule C (part 2): If shape does not fit new shelf, one can
		 * rotate the shape and try to create the new shelf */

		result = a.nextFit(shapes);
		System.out.println("\nNextFit results for rule C (part 2):");
		printResult(result);

		result = a.firstFit(shapes);
		System.out.println("\nFirstfit results for rule C (part 2):");
		printResult(result);
	}

	/* Test rule D from specification */
	private void testRuleD(){
		Algorithms a = new Algorithms();
		List<Shape> shapes = new ArrayList<>();
		List<Sheet> result;

		Shape s1 = new Shape(100, 150);
		Shape s2 = new Shape(100,50);
		Shape s3 = new Shape(50,50);

		shapes.add(s1);
		shapes.add(s2);
		shapes.add(s2);
		shapes.add(s3);

		System.out.printf("\nInput: %s %s %s %s\n", s1, s2, s2, s3);
		/* Rule D: At most one shape is placed directly to the right
		* of any other shape */
		result = a.nextFit(shapes);
		System.out.println("\nNextFit results for rule D:");
		printResult(result);

		result = a.firstFit(shapes);
		System.out.println("\nFirstfit results for rule D:");
		printResult(result);

		System.out.println("\nClarification: Since shape 2 and 3 are not stacked on top one another\n" +
				"shape 4 does not have enough width left on the same shelf and has to go onto the next one.");
	}

	/* Test rule E from specification */
	private void testRuleE(){
		Algorithms a = new Algorithms();
		List<Shape> shapes = new ArrayList<>();
		List<Sheet> result;

		Shape s1 = new Shape(300, 125);
		shapes.add(s1);
		shapes.add(s1);
		shapes.add(s1);

		System.out.printf("\nInput: %s %s %s\n", s1, s1, s1);
		/* Rule E: The total height of all shelves in a sheet
		 * does not exceed H */
		result = a.nextFit(shapes);
		System.out.println("\nNextFit results for rule E:");
		printResult(result);

		result = a.firstFit(shapes);
		System.out.println("\nFirstfit results for rule E:");
		printResult(result);
	}

	/* Test rule F from specification */
	private void testRuleF(){
		Algorithms a = new Algorithms();
		List<Shape> shapes = new ArrayList<>();
		List<Sheet> result;

		Shape s1 = new Shape(1,1);
		for(int i = 0; i < 21; i++)
			shapes.add(s1);

		System.out.printf("\nInput: 21 x %s \n", s1);
		/* Rule F: The number of shapes placed on a sheet cannot
		 * exceed L (where L is given) */
		result = a.nextFit(shapes);
		System.out.println("\nNextFit results for rule F:");
		printResult(result);

		result = a.firstFit(shapes);
		System.out.println("\nFirstfit results for rule F:");
		printResult(result);
	}

	/* Test an empty shapes list */
	private void testEmptyList(){
		Algorithms a = new Algorithms();
		List<Shape> shapes = new ArrayList<>();
		List<Sheet> result;

		System.out.printf("\nInput: empty arraylist");
		/* When not given any shapes return an empty sheets list */
		result = a.nextFit(shapes);
		System.out.println("\nNextFit results for empty shape list:");
		printResult(result);

		result = a.firstFit(shapes);
		System.out.println("\nFirstfit results for empty shape list:");
		printResult(result);
	}

	/* Test normal runs to compare difference between algorithms */
	private void testNormalRun(){
		Algorithms a = new Algorithms();
		List<Shape> shapes = new ArrayList<>();
		List<Sheet> result;

		Shape s1 = new Shape(250,250);
		Shape s2 = new Shape(50,250);

		shapes.add(s1);
		shapes.add(s1);
		shapes.add(s2);

		System.out.printf("\nInput: %s %s %s\n", s1, s1, s2);
		/* Test the difference between how firstFit and nextFit work.
		* In this case, for firstFit, shape 3 will go into sheet 1 and
		* for nextFit it will go into sheet 2*/
		result = a.nextFit(shapes);
		System.out.println("\nNextFit results for normal run:");
		printResult(result);

		result = a.firstFit(shapes);
		System.out.println("\nFirstfit results for normal run:");
		printResult(result);

	}

	/**
	 * This method is used to print results
	 *
	 * @param res: list of used Sheets
	 **/
	private void printResult(List<Sheet> res){
		for (Sheet s: res){
			s.printInfo();
		}
	}
}
