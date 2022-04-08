package LabWk7;

/**
 *
 * COOS-LO2-B03 Week 7 Submission -- Alisa Zarina
 * Step 1. Print the table
 * Step 2. Arrange arrival
 * Step 3. Find the completion of 1st process + Arrange according to burst.
 * Step 4. Find the ranking and arrange according to the rank --??? :\
 * Step 5. Find waiting and turnaround time
 *
 */
// Java API --library
import java.util.*;
import java.util.ArrayList;

public class Aging {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Varibles
        char loop;
        ArrayList<Integer> arrival = new ArrayList<>();
        ArrayList<Integer> burst = new ArrayList<>();
        ArrayList<Integer> waitingTime = new ArrayList<>();
        ArrayList<Integer> turnAround = new ArrayList<>();
        ArrayList<Integer> process = new ArrayList<>();
        ArrayList<Integer> completion = new ArrayList<>();
        ArrayList<Integer> rank = new ArrayList<>();

        // Arrival
        do {
            System.out.println("\nPlease enter the arrival time of the process:");
            int number = in.nextInt();

            arrival.add(number);

            System.out.println("\nAnymore input? If yes, type 'y'.");
            System.out.println("If no, type 'n'.");
            loop = in.next().charAt(0);

        } while (loop == 'Y' || loop == 'y');

        // Burst
        for (int i = 0; i < arrival.size(); i++) {
            System.out.println("\nPlease enter the burst time of the process: ");
            int burstNumber = in.nextInt();
            burst.add(burstNumber);
        }

        // Process   
        for (int i = 0; i < arrival.size(); i++) {
            process.add(i + 1);
        }

        // WaitingTime value = 0
        for (int i = 0; i < arrival.size(); i++) {
            int total = 0;
            waitingTime.add(total);
        }

        // TurnAround value = 0
        for (int i = 0; i < arrival.size(); i++) {
            int total = 0;
            turnAround.add(total);
        }

        // Completion value = 0
        for (int i = 0; i < arrival.size(); i++) {
            int total = 0;
            completion.add(total);
        }

        // Rank value = 0
        for (int i = 0; i < arrival.size(); i++) {
            int total = 0;
            rank.add(total);
        }

        // Print Original Table
        System.out.println();
        System.out.println("----------------------Original Output-------------------------------");
        System.out.println();
        System.out.println(" |  Process  |   Arrival   |   Burst  |   Waiting Time   |   Turn Around Time  |    Completion   |");
        for (int i = 0; i < arrival.size(); i++) {
            System.out.println(" |     " + process.get(i) + "     |     " + arrival.get(i) + "       |    " + burst.get(i) + "     |         " + waitingTime.get(i) + "          |         " + turnAround.get(i) + "          |    " + completion.get(i) + "          |");
        }

        System.out.println();
        System.out.println("----------------------SJF Schedule----------------------------");
        System.out.println();

        // SortingArrival
        System.out.println(" |  Process  |   Arrival   |   Burst  |   Waiting Time   |   Turn Around Time  |    Completion  |");
        int smallIndex;
        int small;
        for (int i = 0; i < arrival.size(); i++) {
            small = arrival.get(i);
            smallIndex = i;

            for (int j = i + 1; j < arrival.size(); j++) {
                if (small > arrival.get(j)) {
                    small = arrival.get(j);
                    smallIndex = j;
                }
            }

            if (smallIndex == i) {

            } else {

                int temp = arrival.get(i);
                arrival.set(i, arrival.get(smallIndex));
                arrival.get(smallIndex);
                arrival.set(smallIndex, temp);

                int b = process.get(i);
                process.set(i, process.get(smallIndex));
                process.get(smallIndex);
                process.set(smallIndex, b);

                temp = burst.get(i);
                burst.set(i, burst.get(smallIndex));
                burst.get(smallIndex);
                burst.set(smallIndex, temp);

            }

            System.out.println(" |     " + process.get(i) + "     |     " + arrival.get(i) + "       |    " + burst.get(i) + "     |         " + waitingTime.get(i) + "          |         " + turnAround.get(i) + "          |    " + completion.get(i) + "          |");

        }

        System.out.println();
        System.out.println("---------------------------Calculate Completion and Waiting Time----------------------------------------------");
        System.out.println();

        //SortingBurst
        waitingTime.set(0, 0);
        completion.add(0, arrival.get(0) + burst.get(0));
        int value = 0;

        for (int i = 1; i < arrival.size(); i++) {
            int store = completion.get(i - 1);
            int mini = burst.get(i);

            for (int j = i; j < arrival.size(); j++) {
                if (store >= arrival.get(j) & mini >= burst.get(j)) {
                    mini = burst.get(j);
                    value = j;
                }
            }

            waitingTime.add(value, completion.get(value - 1) - arrival.get(value));
            if (waitingTime.get(value) < 0) {
                waitingTime.set(value, 0);
            }

            completion.add(value, arrival.get(value) + burst.get(value) + waitingTime.get(value));

            int temp = arrival.get(i);
            arrival.set(i, arrival.get(value));
            arrival.get(value);
            arrival.set(value, temp);

            int b = process.get(i);
            process.set(i, process.get(value));
            process.get(value);
            process.set(value, b);

            temp = burst.get(i);
            burst.set(i, burst.get(value));
            burst.get(value);
            burst.set(value, temp);

            temp = waitingTime.get(i);
            waitingTime.set(i, waitingTime.get(value));
            waitingTime.get(value);
            waitingTime.set(value, temp);

            temp = completion.get(i);
            completion.set(i, completion.get(value));
            completion.get(value);
            completion.set(value, temp);

        }
        // Output
        System.out.println(" |  Process  |   Arrival   |   Burst  |   Waiting Time   |   Turn Around Time  |    Completion  |");
        for (int i = 0; i < arrival.size(); i++) {
            System.out.println(" |     " + process.get(i) + "     |     " + arrival.get(i) + "       |    " + burst.get(i) + "     |         " + waitingTime.get(i) + "          |         " + turnAround.get(i) + "          |    " + completion.get(i) + "          |");
        }

        System.out.println();
        System.out.println("------------------------Calculate Turnaround Time--------------------------------------------");
        System.out.println();

        int totalTA = 0;

        // Calculate Turnaround Time
        for (int i = 0; i < arrival.size(); i++) {
            totalTA = completion.get(i) - arrival.get(i);
            turnAround.add(i, totalTA);
        }

        //Output Turnaround time
        System.out.println(" |  Process  |   Arrival   |   Burst  |   Waiting Time   |   Turn Around Time  |    Completion  |");
        for (int i = 0; i < arrival.size(); i++) {
            System.out.println(" |     " + process.get(i) + "     |     " + arrival.get(i) + "       |    " + burst.get(i) + "     |         " + waitingTime.get(i) + "          |         " + turnAround.get(i) + "          |    " + completion.get(i) + "          |");
        }

        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println();
        
    }

}
