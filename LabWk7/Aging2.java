package LabWk7;

/**
 *
 * COOS-LO2-B03 Week 7
 * Step 1. Print the table
 * Step 2. Arrange arrival
 * Step 3. Find the completion of 1st process + Arrange according to burst.
 * Step 4. Find the ranking and arrange according to the rank
 * Step 5. Find waiting and turnaround time
 * 
 */

import java.util.*;

public class Aging2 {
public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of process: ");
        int n = sc.nextInt();
        int pid[] = new int[n];
        double at[] = new double[n]; // at = arrival time
        double bt[] = new double[n]; // bt = burst time
        double tp[] = new double [n]; // tp = time process
        double et[] = new double [n]; // et = end time
        double st[] = new double [n]; // st = start time
        double wt[] = new double [n]; // wt = waiting time
        double sl[] = new double [n]; // sl = system length
        double rk[] = new double [n]; // rk = rank
        double avgWt = 0.0;
        double total = 0.0;
        final int w1 = 1;
        final int w2 = 2;
        
        
        for(int i=0;i<n;i++) {
            
        System.out.print("\nEnter arrival of process " + (i+1) + ": ");
        at[i] = sc.nextInt();
        
        System.out.print("Enter burst of process " + (i+1) + ": ");
        bt[i] = sc.nextInt();
        pid[i] = i+1;
    
        }
        
        System.out.println("\nUser inputs: \n---------------------------------");
        System.out.println("Process\t\tArrival(Time)\tBurst");
        for(int i=0;i<n;i++) {
        System.out.println("  "+pid[i]+"\t\t\t\t"+at[i]+"\t\t\t  "+bt[i]);          //End of STEP 1
        
        }
        
        int tempP;
        double temp;
        double tempAT;
        double tempTP;
        double tempET;
        double tempST;
        double tempWT;
        double tempSL;
        double tempRK;
        
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i - 1; j++) {   //Sorting based on arrival time
                if (at[j] > at[j + 1]) {
                    //swapping arrival time
                    tempAT = at[j];
                    at[j] = at[j + 1];
                    at[j + 1] = tempAT;
                    
                    //swapping process identity
                    tempP = pid[j];
                    pid[j] = pid[j + 1];
                    pid[j + 1] = tempP;
                    
                    //swapping burst time
                    temp = bt[j];
                    bt[j] = bt[j + 1];
                    bt[j + 1] = temp;

                    //swapping time process
                    tempTP = tp[j];
                    tp[j] = tp[j + 1];
                    tp[j + 1] = tempTP;

                    //swapping end time
                    tempET = et[j];
                    et[j] = et[j + 1];
                    et[j + 1] = tempET;
                    
                    //swapping start time
                    tempST = st[j];
                    st[j] = st[j + 1];
                    st[j + 1] = tempST;
                    
                    //swapping waiting time
                    tempWT = wt[j];
                    wt[j] = wt[j + 1];
                    wt[j + 1] = tempWT;
                    
                    //swapping system length
                    tempSL = sl[j];
                    sl[j] = sl[j + 1];
                    sl[j + 1] = tempSL;
                    
                    //swapping rank
                    tempRK = rk[j];
                    rk[j] = rk[j + 1];
                    rk[j + 1] = tempRK;

                }
                //sorting according to burst time when arrival time are same
                if (at[j] == at[j + 1]) {
                    if (bt[j] > bt[j + 1]) {
                        
                        //swapping arrival time
                        tempAT = at[j];
                        at[j] = at[j + 1];
                        at[j + 1] = tempAT;
                        
                        //swapping process identity
                        tempP = pid[j];
                        pid[j] = pid[j + 1];
                        pid[j + 1] = tempP;
                        
                        //swapping burst time
                        temp = bt[j];
                        bt[j] = bt[j + 1];
                        bt[j + 1] = temp;

                        //swapping time process
                        tempTP = tp[j];
                        tp[j] = tp[j + 1];
                        tp[j + 1] = tempTP;

                        //swapping end time
                        tempET = et[j];
                        et[j] = et[j + 1];
                        et[j + 1] = tempET;
                        
                        //swapping start time
                        tempST = st[j];
                        st[j] = st[j + 1];
                        st[j + 1] = tempST;
                    
                        //swapping waiting time
                        tempWT = wt[j];
                        wt[j] = wt[j + 1];
                        wt[j + 1] = tempWT;
                        
                        //swapping system length
                        tempSL = sl[j];
                        sl[j] = sl[j + 1];
                        sl[j + 1] = tempSL;
                        
                        //swapping rank
                        tempRK = rk[j];
                        rk[j] = rk[j + 1];
                        rk[j + 1] = tempRK;

                    }
                }
            }

        }
        
 
        for (int i = 0; i < 1; i++) {
            tp[0] = bt[0] / 10;
            et[0] = tp[0];
            st[0] = at[0];
            sl[0] = at[0];
            rk[0] = (w1 * sl[0]) + (w2 * tp[0]);
            wt[0] = st[0] - at[0];
            
          }
        
        
        System.out.println("\nSorted user inputs: \n-----------------------------------------------");
        System.out.println("Process\t\tArrival(Time)\t Start\t\tBurst\t  Time(Process)\t  Length\t Rank\t  End(Time)\t\tWaiting");
        System.out.println("  "+pid[0]+"\t\t\t\t"+at[0]+"\t\t\t  "+st[0]+"\t\t "+bt[0]+"\t\t\t"+tp[0]+"\t\t\t"+String.format("%.2f",sl[0])+"\t "+rk[0]+"\t\t"+String.format("%.2f",et[0])+"\t\t"+wt[0]);   
        
        
        for (int i = 1; i < n; i++) {

            for (int j = 1; j < n - i - 1; j++) {
                if (bt[j] > bt[j + 1]) {            //sorting by burst time 
                    //swapping arrival time
                    tempAT = at[j];
                    at[j] = at[j + 1];
                    at[j + 1] = tempAT;
                    
                    //swapping process identity
                    tempP = pid[j];
                    pid[j] = pid[j + 1];
                    pid[j + 1] = tempP;
                    
                    //swapping burst time
                    temp = bt[j];
                    bt[j] = bt[j + 1];
                    bt[j + 1] = temp;

                    //swapping time process
                    tempTP = tp[j];
                    tp[j] = tp[j + 1];
                    tp[j + 1] = tempTP;
                    
                    //swapping start time
                    tempST = st[j];
                    st[j] = st[j + 1];
                    st[j + 1] = tempST;
                    
                    //swapping waiting time
                    tempWT = wt[j];
                    wt[j] = wt[j + 1];
                    wt[j + 1] = tempWT;

                    //swapping end time
                    tempET = et[j];
                    et[j] = et[j + 1];
                    et[j + 1] = tempET;
                    
                    //swapping system length
                    tempSL = sl[j];
                    sl[j] = sl[j + 1];
                    sl[j + 1] = tempSL;
                        
                    //swapping rank
                    tempRK = rk[j];
                    rk[j] = rk[j + 1];
                    rk[j + 1] = tempRK;

                }
            }

            tp[i] = bt[i] / 10;
            et[i] = tp[i] + et[i-1];
            //st[i] = et[i - 1];
            sl[i] = et[i-1] - at[i];
            rk[i] = (w1 * sl[i]) + (w2 * tp[i]);
            //wt[i] = st[i] - at[i];
            //total = total + wt[i];
            
            //avgWt = total / bt.length;
        }
        
        
        
        for(int j=1;j<n;j++) {
        System.out.println("  "+pid[j]+"\t\t\t\t"+at[j]+"\t\t\t  "+st[j]+"\t\t "+bt[j]+"\t\t\t"+tp[j]+"\t\t\t"+String.format("%.2f",sl[j])+"\t "+rk[j]+"\t\t"+String.format("%.2f",et[j])+"\t\t"+String.format("%.2f",wt[j]));   //End of STEP 3
        
        }
        System.out.format("\nAverage waiting time: %.2f" , avgWt);      //End of STEP 4     //String.format("%.2f", input) = to round inputs to 2 decimal places
        
        for (int j = 0; j < n; j++) {

            for (int k = 0; k < n - j - 1; k++) {   //Sorting based on arrival time
                if (rk[k] > rk[k + 1]) {
                    
                    //swapping arrival time
                    tempAT = at[k];
                    at[k] = at[k + 1];
                    at[k + 1] = tempAT;
                    
                    //swapping process identity
                    tempP = pid[k];
                    pid[k] = pid[k + 1];
                    pid[k + 1] = tempP;
                    
                    //swapping burst time
                    temp = bt[k];
                    bt[k] = bt[k + 1];
                    bt[k + 1] = temp;

                    //swapping time process
                    tempTP = tp[k];
                    tp[k] = tp[k + 1];
                    tp[k + 1] = tempTP;

                    //swapping end time
                    tempET = et[k];
                    et[k] = et[k + 1];
                    et[k + 1] = tempET;
                    
                    //swapping start time
                    tempST = st[k];
                    st[k] = st[k + 1];
                    st[k + 1] = tempST;
                    
                    //swapping waiting time
                    tempWT = wt[k];
                    wt[k] = wt[k + 1];
                    wt[k + 1] = tempWT;
                    
                    //swapping system length
                    tempSL = sl[k];
                    sl[k] = sl[k + 1];
                    sl[k + 1] = tempSL;
                    
                    //swapping rank
                    tempRK = rk[k];
                    rk[k] = rk[k + 1];
                    rk[k + 1] = tempRK;

                }
            }
        }
        
        for (int j = 1; j < n; j++) {

            for (int k = 1; k < n - j - 1; k++) {   //Sorting based on arrival time
                if (rk[k] > rk[k + 1]) {
                    
                    //swapping arrival time
                    tempAT = at[k];
                    at[k] = at[k + 1];
                    at[k + 1] = tempAT;
                    
                    //swapping process identity
                    tempP = pid[k];
                    pid[k] = pid[k + 1];
                    pid[k + 1] = tempP;
                    
                    //swapping burst time
                    temp = bt[k];
                    bt[k] = bt[k + 1];
                    bt[k + 1] = temp;

                    //swapping time process
                    tempTP = tp[k];
                    tp[k] = tp[k + 1];
                    tp[k + 1] = tempTP;

                    //swapping end time
                    tempET = et[k];
                    et[k] = et[k + 1];
                    et[k + 1] = tempET;
                    
                    //swapping start time
                    tempST = st[k];
                    st[k] = st[k + 1];
                    st[k + 1] = tempST;
                    
                    //swapping waiting time
                    tempWT = wt[k];
                    wt[k] = wt[k + 1];
                    wt[k + 1] = tempWT;
                    
                    //swapping system length
                    tempSL = sl[k];
                    sl[k] = sl[k + 1];
                    sl[k + 1] = tempSL;
                    
                    //swapping rank
                    tempRK = rk[k];
                    rk[k] = rk[k + 1];
                    rk[k + 1] = tempRK;

                }
            }
            
            st[j] = et[j - 1];
            wt[j] = st[j] - at[j];
            total = total + wt[j];
            
            avgWt = total / pid.length;
            
        }
        
        System.out.println("\nSorted user inputs: \n-----------------------------------------------");
        System.out.println("Process\t\tArrival(Time)\t Start\t\tBurst\t  Time(Process)\t  Length\t Rank\t  End(Time)\t\tWaiting");
        for(int k = 0; k < n; k++) {
        System.out.println("  "+pid[k]+"\t\t\t\t"+at[k]+"\t\t\t  "+String.format("%.2f",st[k])+"\t\t "+bt[k]+"\t\t\t"+tp[k]+"\t\t\t"+String.format("%.2f",sl[k])+"\t "+String.format("%.2f",rk[k])+"\t\t"+String.format("%.2f",et[k])+"\t\t"+String.format("%.2f",wt[k]));   //End of STEP 3
        
        }
        
        System.out.format("\nAverage waiting time: %.2f" , avgWt);
    }
}