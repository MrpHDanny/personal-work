public class Main {

    public static void main(String[] args) {

        Printer printer = new Printer(50,0,true);

        System.out.println("Initial toner lever: " + printer.getTonerLevel());
        System.out.println("Initial page count: " + printer.getPagesPrinted());

        int pagesPrinted = printer.printPage(4);
        System.out.println("Pages printed was: " + pagesPrinted + " new total print count for printer = " + printer.getPagesPrinted());

        pagesPrinted = printer.printPage(2);
        System.out.println("Pages printed was: " + pagesPrinted + " new total print count for printer = " + printer.getPagesPrinted());


    }
}
