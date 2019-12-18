import java.util.ArrayList;
import java.util.Scanner;

public class SandwichMenu {
	// This class uses the Sandwich class to build sandwiches
	private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		SandwichMenu menu = new SandwichMenu(); // creates an object of the
												// class to access methods
		// Create a blt sandwich
		// Constructor takes these values: name, price, isVegetarian, isNutFree
		Sandwich blt = new Sandwich("Classic BLT", 1.30, false, true);
		blt.setBread("flat bread");
		blt.addFillings("bacon");
		blt.addToppings("lettuce");
		blt.addToppings("tomatoes");
		menu.sandwiches.add(blt);

		// create a veggie sandwich
		Sandwich veg1 = new Sandwich("Veggie Sandwich", 1.80, true, true);
		veg1.setBread("italian");
		veg1.addToppings("Lettuce");
		veg1.addToppings("Onions");
		veg1.addToppings("Pickles");
		veg1.addToppings("Tomatoes");
		menu.sandwiches.add(veg1);

		// create a bigger veggie sandwich
		Sandwich veg2 = new Sandwich("Double Veggie Sandwich", 2.60, true, true);
		veg2.setBread("italian");
		veg2.addToppings("Lettuce");
		veg2.addToppings("Lettuce");
		veg2.addToppings("Onions");
		veg2.addToppings("Onions");
		veg2.addToppings("Pickles");
		veg2.addToppings("Pickles");
		veg2.addToppings("Tomatoes");
		veg2.addToppings("Tomatoes");
		menu.sandwiches.add(veg2);

		// create a meat lover sandwich
		Sandwich meatLover = new Sandwich("Meat Lover", 2.80, false, false);
		meatLover.setBread("Banana Nut");
		meatLover.addFillings("Sausage");
		meatLover.addFillings("Cheese");
		meatLover.addFillings("Bacon");
		meatLover.addFillings("Ham");
		meatLover.addToppings("Pickles");
		meatLover.addToppings("Onions");
		menu.sandwiches.add(meatLover);

		menu.chooseSandwich();

	}

	private final double VAT_VALUE = 1.2; // used to calculate cost with tax
	private int searchOption = 0; // used to choose search options
	private int sandwichChosen; // used to choose a sandwich
	private int choiceNumber = 0; // used to print choice number [choiceNumber]
	private ArrayList<Sandwich> sandwiches = new ArrayList<>(); // stores predefined sandwiches
	private ArrayList<Sandwich> narrowedSandwiches = new ArrayList<>(); // stores only those sandwiches that
																		// have the desired attributes

	private void chooseSandwich() {
		// prints out the search options
		System.out.println("Choose your prefered search options: [Or just select 'Next' to skip]");
		System.out.format("%-30s %5s", "Vegetarian option", "[1] \n");
		System.out.format("%-30s %5s", "Nut free options ", "[2] \n");
		System.out.format("%-30s %5s", "Nut free options & vegetarian", "[3] \n");
		System.out.format("%-30s %5s", "Next", "[4] \n");

		searchOption = scan.nextInt();
		if (searchOption <= 0 || searchOption > 4) {
			// if input is out of range, keep asking to re-enter an input
			while (searchOption <= 0 || searchOption > 4) {
				System.out.println("Wrong input. Please try again");
				searchOption = scan.nextInt();
			}
		}
		/*
		 * This series of if and else if statements checks which search option
		 * was chosen and prints out the sandwiches which have the desired
		 * attributes. Then it passes on the sandwich to a list of
		 * narrowedSandwiches because if we print the narrowed down list of
		 * sandwiches their choice number [number] will be different to their
		 * actual index in the sandwich list. By passing it to a new list we
		 * make sure the index corresponds to the right choice number [number]
		 */
		if (searchOption == 1) {
			// prints vegetarian sandwiches
			for (int i = 0; i < sandwiches.size(); i++) {
				if (this.sandwiches.get(i).isVegetarian()) {
					printSandwich(sandwiches.get(i));
					narrowedSandwiches.add(sandwiches.get(i));
				}
			}
		} else if (searchOption == 2) {
			// prints nut free sandwiches
			for (int i = 0; i < sandwiches.size(); i++) {
				if (this.sandwiches.get(i).isNutFree()) {
					printSandwich(sandwiches.get(i));
					narrowedSandwiches.add(sandwiches.get(i));
				}
			}
		} else if (searchOption == 3) {
			// prints vegetarian and nut free sandwiches
			for (int i = 0; i < this.sandwiches.size(); i++) {
				if (sandwiches.get(i).isNutFree() && sandwiches.get(i).isVegetarian()) {
					printSandwich(sandwiches.get(i));
					narrowedSandwiches.add(sandwiches.get(i));
				}
			}
		} else {
			// prints all sandwiches
			for (int i = 0; i < sandwiches.size(); i++) {
				printSandwich(sandwiches.get(i));
				narrowedSandwiches.add(sandwiches.get(i));
			}
		}
		// chooses a sandwich from a narrowed list
		sandwichChosen = scan.nextInt();
		if (sandwichChosen <= 0 || sandwichChosen > choiceNumber) {
			while (sandwichChosen <= 0 || sandwichChosen > choiceNumber) {
				// if choice is out or range, keep asking for another input
				System.out.println("Invalid input. Please try again");
				sandwichChosen = scan.nextInt();
			}
		}
		// Prints out the chosen sandwich
		System.out.println("Sandwich chosen:");
		System.out.println(narrowedSandwiches.get(sandwichChosen - 1).getName());
		System.out.println("Price before tax: " + narrowedSandwiches.get(sandwichChosen - 1).getCost());
		System.out.println("Price with tax: " + narrowedSandwiches.get(sandwichChosen - 1).getCost() * VAT_VALUE);

	}

	private void printSandwich(Sandwich sandwich) {
		// prints the sandwich with its ingredients
		this.choiceNumber++;
		System.out.print(sandwich + " [" + choiceNumber + "]");
		printAttributes(sandwich);
		System.out.println(sandwich.getBread());
		sandwich.listFillings();
		sandwich.listToppings();
	}

	private void printAttributes(Sandwich sandwich) {
		// adds "[Vegetarian]", "[Nut Free]" or [Not Vegetarian], [Not Nut Free]
		// to the sandwich printout
		if (sandwich.isNutFree() == true) {
			System.out.print(" [NutFree]");
		} else
			System.out.print(" [Not Nut Free]");
		if (sandwich.isVegetarian() == true) {
			System.out.print(" [Vegetarian]");
		} else
			System.out.print(" [Not Vegetarian] ");
		System.out.println();

	}

}
