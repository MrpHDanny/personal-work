import java.util.Comparator;

/**
 * @Purpose: The SortByArea comparator class is used to compare shapes
 * by their area.
 */
class SortByArea implements Comparator<Shape> {
    @Override
    public int compare(Shape a, Shape b){
        return (a.getWidth()*a.getHeight()) - (b.getWidth() * b.getHeight());
    }
}