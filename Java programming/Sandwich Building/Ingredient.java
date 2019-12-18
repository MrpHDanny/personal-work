
interface Ingredient {
	// Interface that Bread, Filling, and Topping classes implement

	// Getters and Setters
	public String getName();

	public double getCost();

	public void setCost(double cost);

	public void setName(String name);

	public boolean isVegetarian();

	public boolean isNutFree();

	public String toString();
}
