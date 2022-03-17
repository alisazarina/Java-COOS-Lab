package LabWk4;

/**
 * COOS-LO2-B03 Lab3 Assignment Submission AlisaZarina
 *
 */

//Java API --library
import java.util.*;

public class Step1 {                                                // declare a class

    public static void main(String[] args) {                        // main method

        Scanner sc = new Scanner(System.in);                        // create a scanner object for keyboard input

        System.out.println("Please enter the number of processes: ");

        // variables
        int n = sc.nextInt();
        int pid[] = new int[n];
        int at[] = new int[n];                                  // at = arrival time
        int burst[] = new int[n];                               // burst = burst time

        
        for (int i = 0; i < n; i++) {

            System.out.println("\nPlease enter arrival of process " + (i + 1) + ": ");
            at[i] = sc.nextInt();

            System.out.println("Please enter burst of process " + (i + 1) + ": ");

            burst[i] = sc.nextInt();

            pid[i] = i + 1;

        }

        System.out.println("\nUser inputs: \n---------------------------------");
        System.out.println("Process\t\t\tArrival(Time)\t\t\tBurst");

        for (int i = 0; i < n; i++) {
            System.out.println(" " + pid[i] + "\t\t\t\t" + at[i] + "\t\t\t " + burst[i]);

        }

    }

}

