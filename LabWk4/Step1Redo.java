package LabWk4;

/**
 * COOS-LO2-B03 Lab3 Assignment Submission AlisaZarina
 *
 */

//Java API --library
import java.util.*;

public class Step1Redo {                                                // declare a class

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
        System.out.println("Process\t\tArrival(Time)\tBurst");

        for (int i = 0; i < n; i++) {
            System.out.println(" " + pid[i] + "\t\t\t\t" + at[i] + "\t\t\t " + burst[i]);

        }

//        for (int i = 0; i < burst.length; i++) {
//            int min = burst[i];
//            int minP = pid[i];
//            int minAT = at[i];
//            int minId = i;
//
//            for (int j = i + 1; j < burst.length; j++) {
//                if (burst[j] < min) {
//                    min = burst[j];
//                    minP = pid[j];
//                    minAT = at[j];
//                    minId = j;
//                }
//            }
//
//            // swapping
//            int temp = burst[i];
//            int tempP = pid[i];
//            int tempAT = at[i];
//            burst[i] = min;
//            pid[i] = minP;
//            at[i] = minAT;
//            burst[minId] = temp;
//            pid[minId] = tempP;
//            at[minId] = tempAT;
//
//        }
//
//        System.out.println("\nSorted user inputs: \n---------------------------------");
//        System.out.println("Process\tArrival (Time)\tBurst");

    }

}