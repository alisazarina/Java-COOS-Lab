package LabWk3;

//Java API --library
import java.util.*;
import java.util.ArrayList;

/**
   COOSLO2-B03-TestSkill-AlisaZarina
   This program will sort user's input numbers and store it into an unsorted array.
   Then, it will sort the array via the selection sort process, printing each round until the array is in ascending order.
   Finally, it will print the execution time for sorting.
*/

public class selectionSort {  //Declare a class
	
    public static void main (String[]args) {  // main method

      // Create a Scanner object for keyboard input.    	
    	Scanner in = new Scanner (System.in);

      // Variables.    	
        int number;
        char loop;
        
      // Array variable.
        ArrayList<Integer> data = new ArrayList<Integer>();
        

      // Input number and calculate average.        
        do {
            System.out.println("Please input a number.");
            number = in.nextInt();
            	
            data.add(number);
            		
            System.out.println("Anymore input? If yes, type 'y'.");
            System.out.println("If no, type 'n'.");
            loop = in.next().charAt(0);     	
        	
        } while (loop == 'Y' || loop == 'y' );

      // Print unsorted array list.
        System.out.println("The unsorted array is " + data);

      // Obtain current system time in nanoseconds before bubble sort.        
        long start = System.currentTimeMillis();

      // Print sorted array list.        
        selectionSort(data);
        long end = System.currentTimeMillis(); 
        System.out.println("The execution time for sorting is "+ (end-start) + " milliseconds.");   
        	
    }

   // Sort existing array via Selection Sort.    
    public static void selectionSort(ArrayList<Integer> data) {
        
        ArrayList<Integer> oridata = new ArrayList<Integer>();
        
        oridata.addAll(data);
        
        if (data == null)
            return;
        
        if (data.size() == 0 || data.size() == 1)
            return;
        
        int smallestIndex;
        int smallest;
        int x=1;
        
        for (int curIndex = 0; curIndex < data.size(); curIndex++) {
            
            smallest = data.get(curIndex);
            smallestIndex = curIndex;
            
            for (int i = curIndex + 1; i < data.size(); i++) {
                if (smallest > data.get(i)) {
                    smallest = data.get(i);
                    smallestIndex = i;
                    
                    int temp = data.get(curIndex);
                    data.set(curIndex, data.get(smallestIndex));
                    data.set(smallestIndex, temp);
                    
                    temp = oridata.get(curIndex);
                    oridata.set(curIndex, oridata.get(smallestIndex));
                    oridata.set(smallestIndex, temp);
                    
                    if (oridata != data) {
                        System.out.println("Round " + x + " :" +data);
                    }
                }   x++;
            }
        }
  
   }  
		   	     
}
