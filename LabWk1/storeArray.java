package LabWk1;

//Java API --library
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

/**
   COOSLO2-B03-TestSkill-AlisaZarina
   This program reads infinitely and calculates the average.
   Then, it will display the user input into an array.
*/

public class storeArray //Declare a class
{
   public static void main(String[] args) // main method
   {
      // Create a Scanner object for keyboard input.
      Scanner scanner = new Scanner(System.in);
      
      // Variables.
      int n = 0;
      int count = 0;
      double i = 0;
      double total = 0;
      double average;
      String answer = "y";
      
      // Array.
      ArrayList<Integer> array = new ArrayList<Integer>();
      
      
      // Input number and calculate average.
      do {
          System.out.println("Please input a number.");
          
          array.add(scanner.nextInt());
          total = total + n;
          count++;
          System.out.println("Anymore input? If yes, type 'y'.");
          System.out.println("If no, type 'n'.");
          answer = scanner.next();
          
      } while (answer.equals ("y"));
      
        // Array - for loop.
        for(int a = 0; a < array.size(); a++) {
        total += array.get(a);
        average = total / array.size();
      }
      
      average = total / count;
      System.out.println("The total is " + total);
      System.out.println("The average is " + average);
      
      System.out.println("The array is " + array);
   }
}
