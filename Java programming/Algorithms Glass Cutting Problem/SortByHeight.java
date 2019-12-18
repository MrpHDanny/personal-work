import java.util.Comparator;

/**
 * @Purpose: The SortByHeight comparator class is used to compare shapes
 * by their height.
 */
class SortByHeight implements Comparator<Shape> {
    @Override
    public int compare(Shape a, Shape b){
        return a.getHeight() - b.getHeight();
    }
}