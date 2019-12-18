public class Walls {
    private final int numberOfWalls = 4;
    private String wallpaperColor;
    private Size size;

    public Walls(String wallpaperColor, Size size) {
        this.wallpaperColor = wallpaperColor;
        this.size = size;
    }

    public int getNumberOfWalls() {
        return numberOfWalls;
    }

    public String getWallpaperColor() {
        return wallpaperColor;
    }

    public Size getSize() {
        return size;
    }

    public String toString(){
        return "Number of walls: " + numberOfWalls + " Wallpaper color: " + wallpaperColor + " Wall size: " + size + "\n";
    }
}
