import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SandwichChoice {
	// This class builds a sandwich
	public static void main(String[] args) {

		SandwichChoice build = new SandwichChoice();
		build.buildSandwich();
	}

	private int choice; // user's input
	private boolean isSandwichVegetarian = true; // defines whether sandwich is vegetarian
	private boolean isSandwichNutFree = true; // defines whether sandwich is nut free
	private final double VAT_VALUE = 1.2; // used to calculate cost with tax
	private Scanner scan = new Scanner(System.in); // scanner used in methods
	private List<Object> sandwich = new ArrayList<>(); // list where user's chosen ingredients go into								
	private double totalCost = 0; // total cost of the sandwich
	SandwichBuild a = new SandwichBuild(); // instantiating this class to get access to its methods

	public void buildSandwich() {
		// fills the lists, chooses bread, fillings, toppings, prints the sandwich
		a.fill();
		chooseBread();
		chooseFillings();
		chooseToppings();
		printSandwich();

	}

	private void printSandwich() {
		// Prints out user's built sandwich
		
		System.out.println("Your Sandwich: ");
		// Lists ingredients
		for (int i = 0; i < sandwich.size(); i++) {
			System.out.println(sandwich.get(i));
		}
		// Prices
		System.out.format("%-12s %-1s %.2f ", "Your total:", "£", totalCost);
		System.out.println();
		System.out.format("%-12s %-1s %.2f ", "Your total with tax:", "£", totalCost * VAT_VALUE);
		// Checks if sandwich is nut free. Sandwich is nut free iff all ingredients were nut free.
		System.out.println();
		if (isSandwichNutFree) {
			System.out.println("Your sandwich is nut free");
		} else
			System.out.println("Your sandwich is not nut free");
		// Checks if sandwich is vegetarian. Sandwich is vegetarian iff all ingredients were vegetarian.
		if (isSandwichVegetarian) {
			System.out.println("Your sandwich is vegetarian");
		} else
			System.out.println("Your sandwich is not vegetarian");

	}

	private void chooseBread() {
		// This method lets the user choose one type of bread. It also
		// catches invalid inputs and
		// asks the user to re-enter an input

		System.out.println("Choose type of bread");
		for (int i = 0; i < a.breadSize(); i++) {
			System.out.println(a.returnBread(i) + " [" + (i + 1) + "]");
		}
		choice = scan.nextInt();
		if (choice <= 0 || choice > a.breadSize()) {
		// if choice was out of range, keep asking for input until it's correct
			while (choice <= 0 || choice > a.breadSize()) {
				System.out.println("Wrong input. Try again");
				choice = scan.nextInt();
			}
		}
		// Let the user know what they chose
		System.out.println("Chosen bread: " + a.returnBread(choice - 1));
		// Add the bread to the sandwich and add the cost to total cost
		sandwich.add(a.returnBread(choice - 1));
		totalCost = totalCost + a.returnBread(choice - 1).getCost();
		// Checks if ingredient is nut free
		if (a.returnBread(choice - 1).isNutFree() != true) {
			isSandwichNutFree = false;
		}
		// Checks if ingredient is vegetarian
		if (a.returnBread(choice - 1).isVegetarian() != true) {
			isSandwichVegetarian = false;
		}
		System.out.println();

	}

	private void chooseFillings() {
		// This method lets the user choose as many fillings as they want. It also
		// catches invalid inputs and
		// asks the user to re-enter an input
		int x = 0; // used to print option number [option x]
		System.out.println("Choose type of filling");
		for (int i = 0; i < a.fillingSize(); i++) {
			// prints out the fillings
			x++;
			System.out.println(a.returnFilling(i) + " [" + (i + 1) + "]");
		}
		// prints option 'next'
		System.out.format("%-16s %5s", "Next", "[" + (x + 1) + "]");
		System.out.println();
		choice = scan.nextInt();
		if (choice <= 0 || choice > (a.fillingSize() + 1)) {
			// if first choice is out of range, keep asking for input until it's correct
			while (choice <= 0 || choice > (a.fillingSize() + 1)) {
				System.out.println("Wrong input. Try again");
				choice = scan.nextInt();
			}
		}
		if (choice != (x+1)) {
			// if user hasn't decided to instantly skip fillings by pressing 'next' continue the code
			System.out.println("Chosen filling: " + a.returnFilling(choice - 1));
			sandwich.add(a.returnFilling(choice - 1)); // adds ingredient to the sandwich
			totalCost = totalCost + a.returnFilling(choice - 1).getCost();
			// Checks if ingredient is nut free
			if (a.returnFilling(choice - 1).isNutFree() != true) {
				isSandwichNutFree = false;
			}
			// Checks if ingredient is vegetarian
			if (a.returnFilling(choice - 1).isVegetarian() != true) {
				isSandwichVegetarian = false;
			}
		}
		while (choice != (x+1)) {
			// keep picking ingredients until user picks 'next'
			choice = scan.nextInt();
			if (choice <= 0 || choice > (a.fillingSize() + 1)) {
				// if choice is out of range, keep asking for input until it's correct
				while (choice <= 0 || choice > (a.fillingSize() + 1)) {
					System.out.println("Wrong input. Try again");
					choice = scan.nextInt();
				}
			}
			if (choice != (x+1)) {
				// if user hasn't decided to press 'next' pick another ingredient
				System.out.println("Chosen filling: " + a.returnFilling(choice - 1));
				sandwich.add(a.returnFilling(choice - 1)); // adds ingredient to the sandwich
				totalCost = totalCost + a.returnFilling(choice - 1).getCost();
				// Checks if ingredient is nut free
				if (a.returnFilling(choice - 1).isNutFree() != true) {
					isSandwichNutFree = false;
				}
				// Checks if ingredient is vegetarian
				if (a.returnFilling(choice - 1).isVegetarian() != true) {
					isSandwichVegetarian = false;
				}
			}
		}
		System.out.println();

	}

	private void chooseToppings() {
		// This method lets the user choose as many toppings as they want. It is
		// also fail-proof, as it catches invalid inputs and
		// asks the user to re-enter an input
		int x = 0; // used to print option number [option x]
		// prints out the toppings
		System.out.println("Choose type of topping");
		for (int i = 0; i < a.toppingSize(); i++) {
			x++;
			System.out.println(a.returnTopping(i) + " [" + (i + 1) + "]");
		}
		// prints 'next' option
		System.out.format("%-16s %5s", "Next", "[" + (x + 1) + "]");
		System.out.println();
		choice = scan.nextInt();
		if (choice <= 0 || choice > (a.toppingSize() + 1)) {
			// if first choice is out of range, keep asking for input until it's correct
			while (choice <= 0 || choice > (a.toppingSize() + 1)) {
				System.out.println("Wrong input. Try again");
				choice = scan.nextInt();
			}
		}
		if (choice != (x+1)) {
			// if user hasn't decided to instantly skip fillings by pressing 'next' continue the code
			System.out.println("Chosen filling: " + a.returnTopping(choice - 1));
			sandwich.add(a.returnTopping(choice - 1)); // adds ingredient to the sandwich
			totalCost = totalCost + a.returnTopping(choice - 1).getCost();
			// Checks if ingredient is nut free
			if (a.returnTopping(choice - 1).isNutFree() != true) {
				isSandwichNutFree = false;
			}
			// Checks if ingredient is vegetarian
			if (a.returnTopping(choice - 1).isVegetarian() != true) {
				isSandwichVegetarian = false;
			}
		}
		while (choice != (x+1)) {
			// keep picking ingredients until user picks 'next'
			choice = scan.nextInt();
			if (choice <= 0 || choice > (a.toppingSize() + 1)) {
				// if choice is out of range, keep asking for input until it's correct
				while (choice <= 0 || choice > (a.toppingSize() + 1)) {
					System.out.println("Wrong input. Try again");
					choice = scan.nextInt();
				}
			}
			if (choice != (x+1)) {
				// if user hasn't decided to press 'next' pick another ingredient
				System.out.println("Chosen filling: " + a.returnTopping(choice - 1));
				sandwich.add(a.returnTopping(choice - 1)); // adds ingredient to the sandwich
				totalCost = totalCost + a.returnTopping(choice - 1).getCost();
				// Checks if ingredient is nut free
				if (a.returnTopping(choice - 1).isNutFree() != true) {
					isSandwichNutFree = false;
				}
				// Checks if ingredient is vegetarian
				if (a.returnTopping(choice - 1).isVegetarian() != true) {
					isSandwichVegetarian = false;
				}
			}
		}

	}

}
