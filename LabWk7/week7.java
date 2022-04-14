import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;

public class week7 {
    public static void main(String args[]) {
      Scanner input = new Scanner(System.in);
      
      ArrayList<Integer> burst = new ArrayList<Integer>();
      ArrayList<Integer> arrival = new ArrayList<Integer>();
      ArrayList<Integer> process = new ArrayList<Integer>();
      ArrayList<Integer> wait = new ArrayList<Integer>();
      ArrayList<Integer> compute = new ArrayList<Integer>();
      ArrayList<Integer> turnaround = new ArrayList<Integer>();
      
      System.out.println("input number! \nenter any key besides number to stop.");
      
      int index = 0;
      int counter = 0;
      boolean fixed = false;

      while (input.hasNextInt()) {
          burst.add(input.nextInt());
      }
      
      
      for(int i=0; i<burst.size(); i++){
          int total = 0;
          arrival.add(total);
      }
      
      for(int i=0; i<arrival.size(); i++){
          process.add(i+1);
      }
      
      for(int i=0; i<arrival.size(); i++){
          int total = 0;
          wait.add(total);
      }
      
      for(int i=0; i<arrival.size(); i++){
          int total = 0;
          compute.add(total);
      }
      
      for(int i=0; i<arrival.size(); i++){
          int total = 0;
          turnaround.add(total);
      }
      
      System.out.println();
      System.out.println("--------------------------------------------------------------------------------------");
      System.out.println();
      System.out.println("|   Process  |   Arrival   |   Burst   |   Waiting Time   |   Turn Around Time  |");
      
      for (int i = 0; i < arrival.size(); i++) {
          System.out.println( "|\t\t" + process.get(i) + "\t\t\t" + arrival.get(i)  + "\t\t\t" + burst.get(i)  + "\t\t\t\t" + wait.get(i)  + "\t\t\t" +turnaround.get(i)  + "\t\t|" );
      }
      
      System.out.println("----------------------Burst arrangement----------------------------");
      
      System.out.println("|   Process  |   Arrival   |   Burst   |   Waiting Time   |   Turn Around Time  |");
      
      //array selection sort
      while(fixed == false){
          
          for(int i=0; i<burst.size() ; i++){
              
              //find position of smallest num
              int smol = i;
              
              for (int j = i+1; j<burst.size(); j++) {
                  
                  if (burst.get(j) < burst.get(smol)){
                      smol = j;
                  } else {
                      fixed = true;
                  }
                  
                  //swapping min
                  int min = burst.get(smol);
                  burst.set(smol, burst.get(i));
                  burst.set(i, min);
                  
                  int a = process.get(smol);
                  process.set(smol, process.get(i));
                  process.set(i, a);
                  
                  int b = arrival.get(smol);
                  arrival.set(smol, arrival.get(i));
                  arrival.set(i, b);
              }
              
              System.out.println( "|\t\t" + process.get(i) + "\t\t\t" + arrival.get(i)  + "\t\t\t" + burst.get(i)  + "\t\t\t" + wait.get(i)  + "\t\t\t\t" +turnaround.get(i)  + "\t\t|" );
           }
      }
      
      System.out.println("----------------------Waiting time------------------------------");
      System.out.println("|   Process  |   Arrival   |   Burst   |   Waiting Time   |   Turn Around Time  |");
      
      int totalWT = 0;
      
      for (int i=0; i<arrival.size(); i++){
          totalWT += burst.get(i);
          wait.add(i+1, totalWT);
      }
      
      for (int i=0; i<arrival.size(); i++){
          System.out.println( "|\t\t" + process.get(i) + "\t\t\t" + arrival.get(i)  + "\t\t\t" + burst.get(i)  + "\t\t\t" + wait.get(i)  + "\t\t\t\t" +turnaround.get(i)  + "\t\t|" );
      }
      
      System.out.println("----------------------Turnaround time------------------------------");
      System.out.println("|   Process  |   Arrival   |   Burst   |   Waiting Time   |   Turn Around Time  |");
      
      int totalTA = 0;
      
      for (int i=0; i<arrival.size(); i++){
          totalTA += burst.get(i) + wait.get(i);
          turnaround.add(i, totalTA);
      }
      
      for (int i=0; i<arrival.size(); i++){
          System.out.println( "|\t\t" + process.get(i) + "\t\t\t" + arrival.get(i)  + "\t\t\t" + burst.get(i)  + "\t\t\t" + wait.get(i)  + "\t\t\t\t" +turnaround.get(i)  + "\t\t|" );
      }
      
      double sumWT = 0.0;
      double sumTA = 0.0;
      
      for (int i=0; i<arrival.size(); i++){
          sumWT += wait.get(i);
      }
      
      for (int i=0; i<arrival.size(); i++){
          sumTA += turnaround.get(i);
      }
      
      double avgWT = 0.0;
      double avgTA = 0.0;
      
      avgWT = sumWT/arrival.size();
      avgTA = sumTA/arrival.size();
      
      System.out.println("Average waiting time: " + avgWT);
      System.out.println("Average turn around time: " + avgTA);
      
    }
}