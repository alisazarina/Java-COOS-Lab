package LabWk2;

//Java API --library
import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.time.Duration;
import java.time.Instant;

/**
   COOSLO2-B03-TestSkill-AlisaZarina
   This program will sort user's input numbers and store it into an unsorted array.
   Then, it will sort the array via the bubble sort process, printing each round until the array is in ascending order.
   Finally, it will print the execution time for sorting.
*/

public class bubbleSort {  //Declare a class
	
	  public static void main (String[]args) {  // main method

      // Create a Scanner object for keyboard input.    	
    	Scanner in = new Scanner (System.in);

      // Variables.    	
        int number;
        char loop;
        
      // Array variable.
        ArrayList<Integer> data = new ArrayList<Integer>();
        
        int x=0;

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
        bubbleSort(data);
        long end = System.currentTimeMillis(); 
        System.out.println("The execution time for sorting is "+ (end-start) + " milliseconds.");   
        	
    }

   // Sort existing array via Bubble Sort.    
    public static void bubbleSort(ArrayList<Integer> data) {
   	  int x=0;
   	  
   	  for (int j = 0; j < data.size()-1; j++){
   	  	for (int i = 0; i < data.size()-1-j; i++) {
   	   	 if (data.get(i).compareTo(data.get(i+1)) > 0) {
  	 
   	   	 	int tmp = data.get(i);
   	   	 	data.set(i, data.get(i+1));
   	   	 	data.set(i+1, tmp);
   	   	 	System.out.println("Round " + x + " :" +data);
   	   	 
   	   	 	x++;
   	   	 }
   	  }
   	   
    }
  
   }  
		   	     
}
