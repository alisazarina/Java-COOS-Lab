package LabWk1;

//Java API --library
import java.util.*;

/**
   COOSLO2-B03-TestSkill-AlisaZarina
   This program reads infinitely and calculates the average.
   //Then, it will display the user input into an array.
*/

public class calcAvgInfinite //Declare a class
{
   public static void main(String[] args) // main method
   {
      // Create a Scanner object for keyboard input.
      Scanner scanner = new Scanner(System.in);
      
      // Variables.
      int total = 0;
      int count = 0;
      double average;
      String input = "y";
      
      
      // Input number and calculate average.
      while (input.equals("y")){
          System.out.println("Please input number: ");
          int n = scanner.nextInt();
          total = total + n;
          count++;
          
          System.out.println("Anymore input? If yes, type 'y'.");
          System.out.println("If no, type 'n'.");
          input = scanner.next();
      }
      
      average = total / count;
      System.out.println("The total is " + total);
      System.out.println("The average is " + average);
      
   }
}
