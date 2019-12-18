import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

	public static final int MAX_SIZE_HEIGHT = 250;
	public static final int MAX_SIZE_WIDTH = 300;

	/**
	 * This method will generate a list of shapes of random width and height
	 * (integers). The random width is between 1 and MAX_SIZE_WIDTH inclusive.
	 * The random height is between 1 and MAX_SIZE_HEIGHT inclusive.
	 * 
	 * @param numberOfShapes: the number of shapes to generate
	 * @return a list of shapes of random sizes
	 */

	public List<Shape> generateShapeList(int numberOfShapes) {
		Random random = new Random();
		List<Shape> shapes = new ArrayList<Shape>();

		for (int i = 0; i < numberOfShapes; i++){
			int randomHeight = 1 + random.nextInt(MAX_SIZE_HEIGHT);
			int randomWidth = 1 + random.nextInt(MAX_SIZE_WIDTH);
			Shape s = new Shape(randomWidth, randomHeight);
			shapes.add(s);
		}

		return shapes;
	}

}