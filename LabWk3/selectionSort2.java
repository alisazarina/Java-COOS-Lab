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

public class selectionSort2 {  //Declare a class
	
    public static void main (String[]args) {  // main method

      // Create a Scanner object for keyboard input.    	
    	Scanner in = new Scanner (System.in);

      // Variables.    	
        int number;
        char loop;
        
      // Array variable.
        ArrayList<Integer> arr = new ArrayList<Integer>();
        

      // Input number and calculate average.        
        do {
            System.out.println("Please input a number.");
            number = in.nextInt();
            	
            arr.add(number);
            		
            System.out.println("Anymore input? If yes, type 'y'.");
            System.out.println("If no, type 'n'.");
            loop = in.next().charAt(0);     	
        	
        } while (loop == 'Y' || loop == 'y' );

      // Print unsorted array list.
        System.out.println("The unsorted array is " + arr);

      // Obtain current system time in nanoseconds before bubble sort.        
        long start = System.currentTimeMillis();

      // Print sorted array list.        
        selectionSort(arr);
        long end = System.currentTimeMillis(); 
        System.out.println("The execution time for sorting is "+ (end-start) + " milliseconds.");   
        	
    }

   // Sort existing array via Selection Sort.    
    public static void selectionSort(ArrayList<Integer> arr) {
        int length = arr.size();
        int x = 0;
        for(int i = 0; i < length; i++)
        {
            int min_i = i;
            for(int j = i + 1; j < length; j++)
            {
                if (arr.get(min_i) > arr.get(j))
                {
                    min_i = j;
                }
            }
            if (min_i == i)
            {
                break;
            }
            else
            {
                int temp = arr.get(i);
                arr.set(i, arr.get(min_i));
                arr.set(min_i, temp);
                x = x + 1;
                System.out.println("Round " + x + " :" +arr);
            }
                
        }
		   	     
    }
}