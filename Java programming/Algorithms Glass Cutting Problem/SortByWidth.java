import java.util.Comparator;

/**
 * @Purpose: The SortByWidthcomparator class is used to compare shapes
 * by their width.
 */
class SortByWidth implements Comparator<Shape> {
    @Override
    public int compare(Shape a, Shape b){
        return a.getWidth() - b.getWidth();
    }
}