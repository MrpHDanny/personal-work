import java.util.ArrayList;


public class TestSort
{
	public static void main(String[] args)
    {
        ArrayList<String> tests50 = new ArrayList<>();
        ArrayList<String> tests1000 = new ArrayList<>();
        tests50.add("test1.txt");
        tests50.add("test2.txt");
        tests50.add("test3.txt");
        tests1000.add("test4.txt");
        tests1000.add("test5.txt");
        tests1000.add("test6.txt");
        Sort sortTest = new Sort(50);
        Sort compTest50 = new Sort(50);
        Sort compTest1000 = new Sort(1000);

        System.out.println("--------------------------------------------");
        System.out.println("-------------Testing Correctness------------");
        System.out.println("--------------------------------------------");
        /* Insertion sort */
        sortTest.readIn(tests50.get(0));
        sortTest.display(10,"Unsorted array from test1.txt\n");
        sortTest.insertion();
        sortTest.display(10,"\nInsertion sort on test1.txt\n");
        /* Quicksort */
        sortTest.readIn(tests50.get(0));
        sortTest.display(10,"\nUnsorted array from test1.txt\n");
        sortTest.quicksort(0,49);
        sortTest.display(10,"\nQuicksort on test1.txt\n");
        /* Newsort */
        sortTest.readIn(tests50.get(0));
        sortTest.display(10,"\nUnsorted array from test1.txt\n");
        sortTest.newSort();
        sortTest.display(10,"\nNewsort on test1.txt\n");

        System.out.println("\n\n--------------------------------------------");
        System.out.println("-------------Testing Comparisons------------");
        System.out.println("--------------------------------------------\n\n");
        /* first three files */
        System.out.printf("%-9s | %-15s | %-15s | %-15s\n", "File", "Insertion sort", "Quicksort", "Newsort");
        for(int i = 0; i < tests50.size(); i++){
            compTest50.compIS = 0;
            compTest50.compQS = 0;
            compTest50.compNS = 0;
            compTest50.readIn(tests50.get(i));
            compTest50.insertion();
            compTest50.readIn(tests50.get(i));
            compTest50.quicksort(0,compTest50.getSize()-1);
            compTest50.readIn(tests50.get(i));
            compTest50.newSort();
            System.out.printf("%-9s | %-15d | %-15d | %-15d \n", "file" + (i+1) + ".txt", compTest50.compIS, compTest50.compQS, compTest50.compNS );
        }
        /* last three files */
        for(int i = 0; i < tests1000.size(); i++){
            compTest1000.compIS = 0;
            compTest1000.compQS = 0;
            compTest1000.compNS = 0;
            compTest1000.readIn(tests1000.get(i));
            compTest1000.insertion();
            compTest1000.readIn(tests1000.get(i));
            compTest1000.quicksort(0,compTest1000.getSize()-1);
            compTest1000.readIn(tests1000.get(i));
            compTest1000.newSort();
            System.out.printf("%-9s | %-15d | %-15d | %-15d \n", "file" + (i+4) + ".txt", compTest1000.compIS, compTest1000.compQS, compTest1000.compNS );
        }
    }
} /** End of TestSort class **/
