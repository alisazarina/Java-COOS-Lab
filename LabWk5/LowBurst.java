/**
 * COOS-LO2-B03 Week 5 Submission -- Alisa Zarina
 *
 */
// Java API --library
import java.util.*;
import java.util.ArrayList;

public class LowBurst {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        
        
        // Varibles
        char loop;
        ArrayList<Integer> arrival = new ArrayList<>();
        ArrayList<Integer> burst = new ArrayList<>();
        ArrayList<Integer> waitingTime = new ArrayList<>();
        ArrayList<Integer> turnAround = new ArrayList<>();
        ArrayList<Integer> process = new ArrayList<>();

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

        // WaitingTime's value = 0
        for (int i = 0; i < arrival.size(); i++) {
            int total = 0;
            waitingTime.add(total);
        }

        // TurnAround's value = 0
        for (int i = 0; i < arrival.size(); i++) {
            int total = 0;
            turnAround.add(total);
        }

        // Original Output
        System.out.println();
        System.out.println("----------------------Original Output-------------------------------");
        System.out.println();
        System.out.println(" |  Process  |   Arrival   |   Burst   |   Time (Process)   |     End (Time)    |");
        for (int i = 0; i < arrival.size(); i++) {
            System.out.println(" |     " + process.get(i) + "     |     " + arrival.get(i) + "       |    " + burst.get(i) + "     |         " + waitingTime.get(i) + "          |         " + turnAround.get(i) + "         |  ");
        }

        System.out.println();
        System.out.println("----------------------Arrival Arrangement----------------------------");
        System.out.println();

        // SortingBurst
        System.out.println(" |  Process  |   Arrival   |   Burst    |   Time (Process)   |     End (Time)    |");
        int smallIndex;
        int small;
        for (int i = 0; i < arrival.size(); i++) {
            small = burst.get(i);
            smallIndex = i;

            for (int j = i + 1; j < arrival.size(); j++) {
                if (small > burst.get(j)) {
                    small = burst.get(j);
                    smallIndex = j;
                }
            }

            if (smallIndex == i) {
                ;
            } else {

                int temp = burst.get(i);
                burst.set(i, burst.get(smallIndex));
                burst.get(smallIndex);
                burst.set(smallIndex, temp);

                int b = process.get(i);
                process.set(i, process.get(smallIndex));
                process.get(smallIndex);
                process.set(smallIndex, b);

                temp = arrival.get(i);
                arrival.set(i, arrival.get(smallIndex));
                arrival.get(smallIndex);
                arrival.set(smallIndex, temp);

            }

            System.out.println(" |     " + process.get(i) + "     |     " + arrival.get(i) + "       |    " + burst.get(i) + "      |         " + waitingTime.get(i) + "          |         " + turnAround.get(i) + "         |  ");

        }

        System.out.println();
        System.out.println("---------------------------Waiting Time / Time (Process)----------------------------------------------");
        System.out.println();

        int totalWT = 0;

        // Calculate Waiting Time
        for (int i = 0; i < arrival.size(); i++) {
            totalWT += burst.get(i);
            waitingTime.add(i + 1, totalWT);
        }

        // Output Waiting Time
        System.out.println(" |  Process  |   Arrival   |   Burst    |    Time (Process)   |     End (Time)    |");
        for (int i = 0; i < arrival.size(); i++) {
            System.out.println(" |     " + process.get(i) + "     |     " + arrival.get(i) + "       |    " + burst.get(i) + "      |         " + waitingTime.get(i) + "          |         " + turnAround.get(i) + "         |  ");
        }

        System.out.println();
        System.out.println("------------------------Turn Around Time / End (Time)--------------------------------------------");
        System.out.println();

        int totalTA = 0;

        // Calculate Turn Around Time
        for (int i = 0; i < arrival.size(); i++) {
            totalTA = burst.get(i) + waitingTime.get(i);
            turnAround.add(i, totalTA);
        }

        // Output Turn Around Time
        System.out.println(" |  Process  |   Arrival   |   Burst    |    Time (Process)   |     End (Time)     |");
        for (int i = 0; i < arrival.size(); i++) {
            System.out.println(" |     " + process.get(i) + "     |     " + arrival.get(i) + "       |    " + burst.get(i) + "      |         " + waitingTime.get(i) + "          |         " + turnAround.get(i) + "         |  ");
        }

    }
}