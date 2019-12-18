import java.io.*;
import java.text.*;
import java.util.*;

public class Sort {

/** Size of array **/
private int size;

/** Number of used elements in array **/
private int usedSize;

/** Array of integers **/
private int[] A;

/** Global variables for counting sort comparisons **/
public int compIS; /** Global comparison count for Insertion Sort **/
public int compQS; /** Global comparison count for Quicksort **/
public int compNS; /** Global comparison count for newsort **/

/*****************/
/** Constructor **/
/*****************/
Sort(int max)
{
    /** Initialiase global sort count variables **/
    compIS = 0;
    compQS = 0;
    compNS = 0;
    
    /** Initialise size variables **/
    usedSize = 0;
    size = max;
    
    /** Create Array of Integers **/
    A = new int[size];
}

/*********************************************/
/*** Read a file of integers into an array ***/
/*********************************************/
public void readIn(String file)
{
   try
   {
       /** Initialise loop variable **/
       usedSize = 0;
       
       /** Set up file for reading **/
       FileReader reader = new FileReader(file);
       Scanner in = new Scanner(reader);
       
       /** Loop round reading in data while array not full **/
       while(in.hasNextInt() && (usedSize < size))
       {
           A[usedSize] = in.nextInt();
           usedSize++;
       }
       
    }
    catch (IOException e)
    {
       System.out.println("Error processing file " + file);
    }
   
}

/**********************/
/*** Display array  ***/
/**********************/
public void display(int line, String header)
{
    /*** Integer Formatter - three digits ***/
    NumberFormat FI = NumberFormat.getInstance();
    FI.setMinimumIntegerDigits(3);

    /** Print header string **/
    System.out.print("\n"+header);

    /** Display array data **/
    for (int i=0;i<usedSize;i++)
    {
        /** Check if new line is needed **/
        if (i%line == 0) 
        { 
            System.out.println(); 
        }
        
        /** Display an array element **/
        System.out.print(FI.format(A[i])+" ");
    }
}

/* Sort array using insertion sort */
public void insertion(){
    int key; // value to insert
    int j; // current index to try
    for (int i = 1; i < usedSize; i++){
        key = A[i];
        j = i;
        while (j>0 && key < A[j-1]){
            compIS++;
            A[j]=A[j-1];
            j--;
        }
        compIS++;
        A[j] = key;
    }
}

/* Sort array using quicksort */
public void quicksort(int L, int R){

    if (L < R){
    int p; // index of partition
    p = partition(L,R);
    quicksort(L,p-1); // Sort left half
    quicksort(p+1,R); // Sort right half
    }
}

/* partition an array */
public int partition(int L, int R){
    int v = A[R]; // pivot value
    int pL = L;
    int pR = R;
    while(pL < pR){
        while(A[pL] < v){
            compQS++;
            pL++;
        }
        compQS++;
        while((A[pR] >= v) && (pR > L)){
            compQS++;
            pR--;
        }
        compQS++;
        if (pL < pR){
            swap(pL, pR);
        }
    }

    swap(pL, R);
    return  pL;
}

/* swap two elements in array */
private void swap(int x, int y){
    int temp = A[x];
    A[x] = A[y];
    A[y] = temp;
}

/* sort array using newSort */
public void newSort(){
    int pos = 0;
    while(pos < usedSize){
        int min = findMinFrom(pos);
        for(int i = pos; i < (usedSize); i++){
            if(A[i] == min){
                swap(i,pos);
                pos++;
            }
            compNS++;
        }
    }
}
/* finds a min value in an array from given starting position */
private int findMinFrom(int pos){
    int min = A[pos];
    for(int i = (pos + 1); i < (usedSize); i++){
        if(A[i] < min){
            min = A[i];
        }
        compNS++;
    }
    return min;
}
/* returns size of array */
public int getSize(){
    return usedSize;
}



}  /** End of Sort Class **/
