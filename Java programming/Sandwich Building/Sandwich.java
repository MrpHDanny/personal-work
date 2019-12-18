import java.util.ArrayList;

public class Sandwich {
	// This class lets us create pre-built sandwiches to sell in SandwichMenu

	Sandwich(String name, double cost, boolean isVegetarian, boolean isNutFree) {
		setName(name);
		setCost(cost);
		setIsVegetarian(isVegetarian);
		setIsNutFree(isNutFree);
	}
	// Sandwich attributes
	private String name;
	private String bread;
	private double cost;
	private boolean isVegetarian;
	private boolean isNutFree;
	// lists of ingredients in the sandwich
	private ArrayList<String> toppings = new ArrayList<>();
	private ArrayList<String> fillings = new ArrayList<>();

	public void setBread(String bread) {
		this.bread = bread;
	}

	public String getBread() {
		return this.bread;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getCost() {
		return cost;
	}

	public void addToppings(String ingredient) {
		//adds a topping
		this.toppings.add(ingredient);
	}

	public void addFillings(String ingredient) {
		//adds a filling
		this.fillings.add(ingredient);
	}

	public void listToppings() {
		// prints out all toppings
		for (int i = 0; i < this.toppings.size(); i++) {
			System.out.println(this.toppings.get(i));
		}
	}

	public void listFillings() {
		// prints out all fillings
		for (int i = 0; i < this.fillings.size(); i++) {
			System.out.println(this.fillings.get(i));
		}
	}
	
	public boolean isVegetarian(){
		return this.isVegetarian;
	}
	public boolean isNutFree(){
		return this.isNutFree;
	}
	
	public void setIsVegetarian(boolean Vegetarian){
		this.isVegetarian = Vegetarian;
	}
	
	public void setIsNutFree(boolean NutFree){
		this.isNutFree = NutFree;
	}
	public String toString() {
		return String.format("%-9s %-15s %1s %4s", "Sandwich:", this.name, "£", this.cost);
	}

}