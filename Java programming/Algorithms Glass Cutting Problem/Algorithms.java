import java.util.ArrayList;
import java.util.List;

public class Algorithms {

	/**
	 * This method is used to implement the next fit algorithm
	 *
	 * @param shapes:a list of shapes representing customer requests(shapes to be
	 *            cut/placed)
	 * @return a list of the sheets used to fulfil all customer requests (i.e.
	 *         place all the shapes). e.g. if you pass a "shapes" list that has
	 *         two shapes {(w=200,h=200),(w=50,h=100)}, then the returned list
	 *         of sheets should show us all the information needed (e.g. that
	 *         one sheet is used, this sheet has one shelf and this shelf has
	 *         two shapes in it). In the test program, you can use the returned
	 *         list to retrieve the total number of sheets used.
	 **/

	public List<Sheet> nextFit(List<Shape> shapes) {

		List<Sheet> usedSheets = new ArrayList<>();

		/* If no shapes are given */
		if(shapes.size() == 0)
			return usedSheets;

		Sheet sheet = new Sheet();
		Shelf shelf = new Shelf();
		Integer maxShapes = Sheet.SHAPE_LIMIT;
		Integer totalShapes = 0; /* Number of shapes on a sheet */

		/* Insert first shape which we know must fit */
		shelf.place(shapes.get(0));

		for(int i = 1; i < shapes.size(); i++){
			Shape shape = shapes.get(i);

			/* Does shape fit the shelf and will not exceed shape limit ? */
			if(fitsShelf(shape, shelf) && (shelf.getShapes().size() < maxShapes)){
				/* Does shape needs to be rotated ?*/
				if(shape.getHeight() > shelf.getHeight() || shape.getWidth() > (Sheet.SHEET_WIDTH - shelf.getWidth()))
					shape.rotateShape();
				shelf.place(shape);
				continue; /* Continue to next shape */
			}

			/* Does shelf fit the sheet and will not exceed shape limit ? */
			if(fitsSheet(shelf,sheet) && (totalShapes + shelf.getShapes().size() <= maxShapes)){
				sheet.addShelf(shelf);
				totalShapes += shelf.getShapes().size();
			}
			else {
				usedSheets.add(sheet);
				sheet = new Sheet();
				sheet.addShelf(shelf);
				totalShapes = shelf.getShapes().size();
			}

			/* Grab new shelf and insert next shape which we know must fit */
			shelf = new Shelf();
			shelf.place(shape);

			/* Does shelf fit the sheet and will not exceed shape limit ? */
			if(fitsSheet(shelf,sheet) && (totalShapes + shelf.getShapes().size() <= maxShapes)){
				/*Do we need to rotate the first shape? */
				if(shelf.getHeight() > Sheet.SHEET_HEIGHT - sheet.allShelvesHeight()){
					shelf.getShapes().get(0).rotateShape();
				}
			}
		}

		/* Add the remaining sheet and shelf to the usedSheets list */

		/* Does shelf fit the sheet and will not exceed shape limit ? */
		if(fitsSheet(shelf,sheet) && (totalShapes + shelf.getShapes().size() <= maxShapes)){
			/*Do we need to rotate the first shape? */
			if(shelf.getHeight() > Sheet.SHEET_HEIGHT - sheet.allShelvesHeight()){
				shelf.getShapes().get(0).rotateShape();
			}
		} else {
			usedSheets.add(sheet);
			sheet = new Sheet();
		}

		sheet.addShelf(shelf);
		usedSheets.add(sheet);

		return usedSheets;
	}

	/*
	 * This method tells you whether you can fit a shelf onto a sheet
	 *
	 * @param shape: a shelf
	 * @param shelf: a sheet
	 *
	 * @return true if it can fit and false otherwise
	 * */
	private boolean fitsSheet(Shelf shelf, Sheet sheet){
		Integer shelfH = shelf.getHeight();
		Integer heightLeft = Sheet.SHEET_HEIGHT - sheet.allShelvesHeight();

		/* If enough height left ?  */
		if (shelfH <= heightLeft){
			return true;
		}

		/* Enough height if we rotated the first shape? */
		if(shelf.getWidth() <= heightLeft){
			return true;
		}

		return false;
	}

	/*
	* This method tells you whether you can fit a shape into a shelf
	*
	* @param shape: a shape
	* @param shelf: a shelf
	*
	* @return true if it can fit and false otherwise
	* */
	private boolean fitsShelf(Shape shape, Shelf shelf){
		Integer shapeH = shape.getHeight();
		Integer shapeW = shape.getWidth();
		Integer shelfW = shelf.getWidth();
		Integer shelfH = shelf.getHeight();
		Integer widthLeft = Sheet.SHEET_WIDTH - shelfW;

		/* Enough width and height left ? */
		if(shapeW <= widthLeft && shapeH <= shelfH)
			return true;

		/* Can we rotate shape ?*/
		if(shapeW > Sheet.SHEET_HEIGHT){
			return false;
		}

		/* Enough width and height after rotation ? */
		if(shapeH <= widthLeft && shapeW <= shelfH)
			return true;

		return false;
	}

	/**
	 * This method is used to implement the first fit algorithm
	 * 
	 * @param shapes:a list of shapes representing customer requests (shapes to be
	 *            cut/placed)
	 * @return a list of the sheets used to fulfil all customer requests (i.e. place
	 *         all the shapes). e.g. if you pass a "shapes" list that has two
	 *         shapes {(w=200,h=200),(w=50,h=100)}, then the returned list of
	 *         sheets should show us all the information needed (e.g. that one
	 *         sheet is used, this sheet has one shelf and this shelf has two
	 *         shapes in it). In the test program, you can use the returned list
	 *         to retrieve the total number of sheets used
	 **/
	public List<Sheet> firstFit(List<Shape> shapes) {

		List<Sheet> usedSheets = new ArrayList<Sheet>();

		/* If no shapes are given */
		if(shapes.size() == 0)
			return usedSheets;

		Sheet sheet = new Sheet();
		Shelf shelf = new Shelf();
		Integer maxShapes = Sheet.SHAPE_LIMIT;
		Integer totalShapes; /* Number of shapes on a sheet */

		/* Insert first shape which we know must fit */
		shelf.place(shapes.get(0));
		sheet.addShelf(shelf);
		usedSheets.add(sheet);

		/* For each shape */
		nextShape: for (int i = 1; i < shapes.size(); i++){
			Shape shape = shapes.get(i);

			/* For each sheet */
			for (int j = 0; j < usedSheets.size(); j++){
				sheet = usedSheets.get(j);
				totalShapes = 0;

				/* Count shapes present in current sheet */
				for(Shelf s : usedSheets.get(j).getShelves()){
					totalShapes += s.getShapes().size();
				}

				/* For each shelf */
				for(int k = 0; k < sheet.getShelves().size(); k++){
					shelf = sheet.getShelves().get(k);

					/* Does shape fit the shelf and will not exceed shape limit ? */
					if(fitsShelf(shape,shelf) && (totalShapes < maxShapes)){
						/* Does shape need to be rotated ? */
						if(shape.getHeight() > shelf.getHeight() || shape.getWidth() > (Sheet.SHEET_WIDTH - shelf.getWidth()))
							shape.rotateShape();
						shelf.place(shape);
						continue nextShape; /* Continue to next shape */
					}
				}

				/* Does shape fit the sheet and will not exceed shape limit ? */
				if((shape.getHeight() <= (Sheet.SHEET_HEIGHT - sheet.allShelvesHeight())) && (totalShapes < maxShapes)){
					shelf = new Shelf();
					shelf.place(shape);
					sheet.addShelf(shelf);
					continue nextShape; /* Continue to next shape */
				}
				/* Does shape fit the sheet when rotated and will not exceed shape limit ? */
				else if (shape.getWidth() <= (Sheet.SHEET_HEIGHT - sheet.allShelvesHeight()) && (totalShapes < maxShapes)){
					shelf = new Shelf();
					shape.rotateShape();
					shelf.place(shape);
					sheet.addShelf(shelf);
					continue nextShape; /* Continue to next shape */
				}
			}

			/* No place found */

			/* Add another sheet with new shelf and shape which we know must fit */
			sheet = new Sheet();
			shelf = new Shelf();
			shelf.place(shape);
			sheet.addShelf(shelf);
			usedSheets.add(sheet);

			continue nextShape; /* Continue to next shape */
		}

		return usedSheets;
	}

}
