import java.util.ArrayList;
import java.util.List;

public class SandwichBuild {
	public static void main(String[] args) {
		/*
		 * We create an object of this class to access the ingredient objects,
		 * then we fill the lists of ingredients, and print them out.
		 */
		SandwichBuild c = new SandwichBuild();
		c.fill();
		c.printIngredients(c.breads, c.toppings, c.fillings);

	}

	// Lists of ingredients
	private ArrayList<Bread> breads = new ArrayList<>();
	private ArrayList<Filling> fillings = new ArrayList<Filling>();
	private ArrayList<Topping> toppings = new ArrayList<>();
	/* 
	 * Methods that return an ingredient from the list and the size of the list
	 * Used in the SandwichChoice class
	 */
	public Bread returnBread(int i){
		return breads.get(i);
	}
	public int breadSize(){
		return breads.size();
	}
	public Filling returnFilling(int i){
		return fillings.get(i);
	}
	public int fillingSize(){
		return fillings.size();
	}
	public Topping returnTopping(int i){
		return toppings.get(i);
	}
	public int toppingSize(){
		return toppings.size();
	}

	/*
	 * Create ingredient objects
	 * Constructors take the objects below take these values: name, cost, isVegetarian, is NutFree
	 */

	// breads
	private Bread italian = new Bread("Italian", 1, true, true); // Vegetarian & nut free					
	private Bread flatBread = new Bread("Flat Bread", 0.5, true, true); // Vegetarian & nut free																		
	private Bread honeyOat = new Bread("Banana Nut", 0.6, true, false); // Vegetarian & NOT nut free

	// fillings
	private Filling cheese = new Filling("Gorgonzola", 0.3, false, true); // Not vegetarian & nut free				
	private Filling ham = new Filling("Ham", 0.3, false, true); // Not vegetarian & nut free
	private Filling sausage = new Filling("Sausage", 0.4, false, true); // Not vegetarian & nut free
	private Filling bacon = new Filling("Bacon", 0.4, false, true); // Not vegetarian & nut free
	
	// toppings
	private Topping lettuce = new Topping("Lettuce", 0.2, true, true); // Vegetarian & nut free
	private Topping tomatoes = new Topping("Tomatoes", 0.2, true, true); // Vegetarian & nut free
	private Topping onions = new Topping("Onions", 0.2, true, true); // Vegetarian & nut free
	private Topping pickles = new Topping("Pickles", 0.2, true, true); // Vegetarian & nut free

	private void printIngredients(ArrayList<Bread> list1, List<Topping> list2, List<Filling> list3) {
		// Prints out all of the ingredients
		System.out.println("Breads");
		for (Bread breads : list1) {
			System.out.println(breads.toString());
		}
		System.out.println("Toppings");
		for (Topping toppings : list2) {
			System.out.println(toppings.toString());
		}
		System.out.println("Fillings");
		for (Filling fillings : list3) {
			System.out.println(fillings.toString());
		}
	}

	public void fill() {
		// Fills the lists of ingredients with objects
		// We create an object of the class to access the lists and objects
		SandwichBuild a = new SandwichBuild();
		this.breads.add(a.italian);
		this.breads.add(a.flatBread);
		this.breads.add(a.honeyOat);
		this.fillings.add(a.cheese);
		this.fillings.add(a.ham);
		this.fillings.add(a.sausage);
		this.fillings.add(a.bacon);
		this.toppings.add(a.lettuce);
		this.toppings.add(a.tomatoes);
		this.toppings.add(a.onions);
		this.toppings.add(a.pickles);
	}

}
