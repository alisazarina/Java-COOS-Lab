/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LabWk4;

/**
 *
 * @author Lenovo
 */
import java.util.*;
public class All {
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
        double avgWt = 0.0;
        double total = 0.0;
        
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
        
        //for (int i = 0; i < bt.length; i++) {
        //double min = bt[i];
        //int minP = pid[i];
        //double minAT = at[i];
        //int minId = i;
        
        //for (int j = i+1; j < bt.length; j++) {
        //    if (bt[j] < min) {
        //        min = bt[j];
        //        minP = pid[j];
        //        minAT = at[j];
        //        minId = j;
        //    }
        //}
        
        // swapping
        //double temp = bt[i];
        //int tempP = pid[i];
        //double tempAT = at[i];
        //bt[i] = min;
        //pid[i] = minP;
        //at[i] = minAT;
        //bt[minId] = temp;
        //pid[minId] = tempP;
        //at[minId] = tempAT;
        
    //}
        
        //System.out.println("\nSorted user inputs: \n---------------------------------");
        //System.out.println("Process\t\tArrival(Time)\tBurst");
        //for(int j=0;j<n;j++) {
        //System.out.println("  "+pid[j]+"\t\t\t\t"+at[j]+"\t\t\t  "+bt[j]);   // End of STEP 2
        
        //}
        
        int tempP;
        double temp;
        double tempAT;
        double tempTP;
        double tempET;
        double tempST;
        double tempWT;
        
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i - 1; j++) {
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

                    }
                }
            }

        }
        
 
        for (int i = 0; i < 1; i++) {
            tp[0] = bt[0] / 10;
            et[0] = tp[0];
            st[0] = at[0];
            wt[0] = st[0] - at[0];
            
          }
        
        
        System.out.println("\nSorted user inputs: \n-----------------------------------------------");
        System.out.println("Process\t\tArrival(Time)\tStart\t\tBurst\t  Time(Process)\t  End(Time)\t\tWaiting");
        System.out.println("  "+pid[0]+"\t\t\t\t"+at[0]+"\t\t\t  "+st[0]+"\t\t "+bt[0]+"\t\t\t"+tp[0]+"\t\t\t "+et[0]+"\t\t "+wt[0]);   
        
        
        for (int i = 1; i < n; i++) {

            for (int j = 1; j < n - i - 1; j++) {
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

                }
            }

            tp[i] = bt[i] / 10;
            et[i] = tp[i] + et[i-1];
            st[i] = et[i - 1];
            wt[i] = st[i] - at[i];
            total = total + wt[i];
            
            avgWt = total / bt.length;
        }
        
        for(int j=1;j<n;j++) {
        System.out.println("  "+pid[j]+"\t\t\t\t"+at[j]+"\t\t\t  "+st[j]+"\t\t "+bt[j]+"\t\t\t"+tp[j]+"\t\t\t "+et[j]+"\t\t "+wt[j]);   //End of STEP 3
        
        }
        System.out.format("\nAverage waiting time: %.2f" , avgWt);      //End of STEP 4
        }
  
    }