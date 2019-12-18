public class Shape {

	private int sWidth; // width of the shape
	private int sHeight; // height of the shape

	/**
	 * A Shape constructor to set the width and height of a shape.
	 * 
	 * @param width  of a shape
	 * @param height of a shape
	 **/
	public Shape(int width, int height) {

		// Shape width and height should not be greater than the sheet width and height
		if (width > Sheet.SHEET_WIDTH || height > Sheet.SHEET_HEIGHT) {
			throw new IllegalArgumentException("Shape width or height is not valid");
		}

		this.sWidth = width;
		this.sHeight = height;
	}

	/**
	 * @return height of a shape
	 **/
	public int getHeight() {
		return sHeight;
	}

	/**
	 * @return width of a shape
	 */
	public int getWidth() {
		return sWidth;
	}

	@Override
	public String toString() {
		return String.format("\n     SHAPE [WIDTH: %d, HEIGHT: %d]", getWidth(), getHeight());
	}

	/* Rotate shape by swapping height and width values */
	public void rotateShape(){
		Integer temp = this.sHeight;
		this.sHeight = this.sWidth;
		this.sWidth = temp;
	}
}
