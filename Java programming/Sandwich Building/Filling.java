public class Filling implements Ingredient {
	// Attributes of Filling
	private String name;
	private double cost;
	private boolean isVegetarian;
	private boolean isNutFree;

	// Constructor which calls set methods for name and cost and determines
	// whether bread is Vegetarian and/or nut free
	public Filling(String name, double cost, boolean isVegetarian, boolean isNutFree) {
		setName(name);
		setCost(cost);
		setIsVegetarian(isVegetarian);
		setIsNutFree(isNutFree);
	}

	// Getters and Setters
	public String getName() {
		return this.name;
	}

	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIsVegetarian(boolean isItVegetarian) {
		this.isVegetarian = isItVegetarian;
	}

	public void setIsNutFree(boolean isItNutFree) {
		this.isNutFree = isItNutFree;
	}

	public boolean isVegetarian() {
		return isVegetarian;
	}

	public boolean isNutFree() {
		return isNutFree;
	}

	public String toString() {
		// Overrides the toString method for a better output
		return String.format("%-12s %1s %1s", name, "£", cost);
	}

}