public class Printer {

    private int tonerLevel = 100;
    private int pagesPrinted;
    private boolean isDuplexPrinter;

    public Printer(int tonerLevel, int pagesPrinted, boolean isDuplexPrinter) {
        if(this.tonerLevel >=0 && this.tonerLevel<=100){
            this.tonerLevel = tonerLevel;
        }
        this.pagesPrinted = pagesPrinted;
        this.isDuplexPrinter = isDuplexPrinter;
    }

    public int fillToner(int amount){
        if(amount >0 && amount<=100){
            if(this.tonerLevel + amount > 100){
                return -1;
            }
            this.tonerLevel +=amount;
            return this.tonerLevel;

        } else return -1;
    }

    public int printPage(int amount){
        int pagesToPrint = amount;
        if(this.isDuplexPrinter){
            pagesToPrint = (amount/2) + (amount % 2);
            System.out.println("Printing in duplex mode");
        }
        this.pagesPrinted += pagesToPrint;
        return pagesToPrint;

        }


    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }
}
