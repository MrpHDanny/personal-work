import java.util.*;
// if you're inheriting from another class,
// and you've got a method, and you override that method, that's what polymorphism
// is. It's giving unique functionality for the class that has inherited from a
// base class.
    class Movie {
        private String name;

        public Movie(String name) {
            this.name = name;
        }

        public String plot(){
            return "No plot here";
        }

        public String getName() {
            return name;
        }
    }


    class Jaws extends Movie{
        public Jaws(){
            super("Jaws");
        }

        public String plot(){
            return "A shark eats lots of people";
        }

    }

    class MazeRunner extends Movie {
        public MazeRunner() {
            super("Inferno");
        }

        @Override
        public String plot() {
            return "Kids try to escape a maze";
        }
    }

    class IndependenceDay extends Movie {
        public IndependenceDay() {
            super("Independence day");
        }

        @Override
        public String plot() {
            return "Aliens attempt to take over planet earth";
        }

    }


    class StarWars extends Movie {
        public StarWars() {
            super("Starwars");
        }

        @Override
        public String plot() {
            return "Imperial Forces try to take over the universe";
        }
    }

    class Forgetable extends Movie {
        public Forgetable(){
            super("Forgetable");


            // No plot method
            // If this movie is displayed then

        }

}
    public class Main {

        public static Movie randomMovie() {
            int randomNumber = (int) (Math.random() * 5 + 1);
            System.out.println("Random number generated was: " + randomNumber);
            switch (randomNumber) {
                case 1:
                    return new Jaws();

                case 2:
                    return new IndependenceDay();

                case 3:
                    return new MazeRunner();

                case 4:
                    return new StarWars();

                case 5:
                    return new Forgetable();

                default:
                    return null;
            }
        }

        public static void main(String[] args) {


            for (int i = 1; i < 11; i++) {
                Movie movie = randomMovie();
                System.out.println("Movie#" + i + " : " + movie.getName() + "\n" + "Plot: " + movie.plot() + "\n");
            }
                //Unrelated testing
                Scanner scan = new Scanner(System.in);
                double randomNumber = Math.random() * 10 + 1;
                int randomInt = (int) randomNumber;
                System.out.println(randomInt + " Random number");
                String line = scan.nextLine();
                if(line.startsWith("!quote")){
                    System.out.println(line.);
                }

            }
        }


