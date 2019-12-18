import java.io.FileNotFoundException;

/**
 * 
 * @author Daniel
 * Last-modified: April 13, 2019
 */
public class PerformanceTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws FileNotFoundException {
		Entry front = new Entry("AAA", "A.A.", "12345"); // Front element |  Position 0
		Entry fill1 = new Entry("BBB", "B.B.", "12333"); // Elements between the first one and the middle
		Entry middle = new Entry("MMM", "M.M.", "54321"); // The middle element | Position 4999
		Entry fill2 = new Entry("NNN", "N.N", "51421"); // Elements between the middle one and the end
		Entry end = new Entry("ZZZ", "Z.Z.", "12321"); // The end element | Position 9999				
		ListDirectory list = new ListDirectory();
		HashDirectory hash = new HashDirectory();
		ArrayDirectory array = new ArrayDirectory();
		StopWatch timer = new StopWatch();
		long time;
		/**
		 * Choose any implementation to test by changing "testImplementation" to
		 * be equal to either array/list/hash
		 */
		Directory testImplementation = hash;
		// Filling up the entry lists
		
		// Add the front, middle and end entries
		testImplementation.newEntry(front);
		testImplementation.newEntry(middle);
		testImplementation.newEntry(end);

		// Fill in the gaps with other entries
		for (int i = 0; i < 4998; i++) {
			testImplementation.newEntry(fill1);
		}
		for (int i = 0; i < 4999; i++) {
			testImplementation.newEntry(fill2);
		}
		
		// Performance tests
		String format = "%-6d %-2s %-20s\n";
		System.out.println("Lookup method average times:");
		// Front
		timer.reset();
		timer.start();
		for (int i = 0; i < 10000; i++)
			testImplementation.findEntry("AAA");
		timer.stop();
		time = timer.getElapsedTime();
		timer.reset();
		System.out.printf(format, time / 10000, " ns", "| Looking at the front");
		// Middle
		timer.start();
		for (int i = 0; i < 10000; i++)
			testImplementation.findEntry("MMM");
		timer.stop();
		time = timer.getElapsedTime();
		timer.reset();
		System.out.printf(format, time / 10000, " ns", "| Looking in the middle");
		timer.start();
		for (int i = 0; i < 10000; i++)
			testImplementation.findEntry("ZZZ");
		timer.stop();
		time = timer.getElapsedTime();
		timer.reset();
		System.out.printf(format, time / 10000, " ns", "| Looking at the end");
		
		System.out.println("\nInsertion and deletion method average times:");
		// Front
		timer.start();
		for (int i = 0; i < 10000; i++)
			testImplementation.newEntry(front);
		timer.stop();
		time = timer.getElapsedTime();
		timer.reset();
		System.out.printf(format, time / 10000, " ns", "| Adding at the front");		
		// Deleting
		timer.start();
		for (int i = 0; i < 10000; i++)
			testImplementation.delEntry("AAA");
		timer.stop();
		time = timer.getElapsedTime();
		timer.reset();
		System.out.printf(format, time / 10000, " ns", "| Deleting at the front");
		System.out.println();
		// Middle
		timer.start();
		for (int i = 0; i < 10000; i++)
			testImplementation.newEntry(middle);
		timer.stop();
		time = timer.getElapsedTime();
		timer.reset();
		System.out.printf(format, time / 10000, " ns", "| Adding in the middle");		
		// Deleting
		timer.start();
		for (int i = 0; i < 10000; i++)
			testImplementation.delEntry("MMM");
		timer.stop();
		time = timer.getElapsedTime();
		timer.reset();
		System.out.printf(format, time / 10000, " ns", "| Deleting in the middle");		
		System.out.println();
		// End
		timer.start();
		for (int i = 0; i < 10000; i++)
			testImplementation.newEntry(end);
		timer.stop();
		time = timer.getElapsedTime();
		timer.reset();
		System.out.printf(format, time / 10000, " ns", "| Adding at the end");		
		// Deleting
		timer.start();
		for (int i = 0; i < 10000; i++)
			testImplementation.delEntry("ZZZ");
		timer.stop();
		time = timer.getElapsedTime();
		timer.reset();
		System.out.printf(format, time / 10000, " ns", "| Deleting at the end");	
		
		
	}
	
}
