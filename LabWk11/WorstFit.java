package LabWk11;

/**
   COOSLO2-B03 -- Worst Fit + Internal Fragmentation
   Alisa Zarina
*/

import java.util.*;
import java.time.Duration;

public class WorstFit {
    public static void main(String[] args) {
        
        /* Initialize the values:
           Process Size, Block Size, Allocation
        */
        
        int[] processSize = {100, 199, 201, 297};
        int[] blockSize = {200, 300, 100};
        int[] allocation = {-1, -1, -1, -1};
        int n = processSize.length;
        int m = blockSize.length;
        int diff = 0;
        int internalFrag = 0;
        
        // calc time for internal frag
        long start = System.currentTimeMillis();
        
        for (int i = 0; i < n; i++)
        {
            // index for worst fit
            int worstIdx = -1;
            for (int j = 0; j < m; j++)
            {
                if (blockSize[j] >= processSize[i])
                {
                    if (worstIdx == -1)
                    {
                        worstIdx = j;
                    }
                    else if (blockSize[worstIdx] < blockSize[j])
                    {
                        worstIdx = j;
                    }
                }
            }
            if (worstIdx != -1)
            {
                allocation[i] = worstIdx;
                blockSize[worstIdx] -= processSize[i];
                
                internalFrag += blockSize[worstIdx];
            }
        }
        System.out.println("Process\t\tProcess Size\t\tBlock");
        System.out.println("-----------------------------------------------------");
        
        for (int i = 0; i < n; i++)
        {
            System.out.print(i+1 + "\t\t" + processSize[i] + "\t\t\t");
            if (allocation[i] != -1)
            {
                allocation[i] += 1;
                System.out.println(allocation[i]);
            }
            else
            {
                System.out.println("Not Allocated");
            }
        }
        
        long end = System.currentTimeMillis();
        
        System.out.println("Final Result:");
        System.out.println("\nMethod\t\tInternal Fragmentation\t\tTime (milliseconds)");
        System.out.println("\nWorst Fit\t\t" + internalFrag + "\t\t\t\t" + (end-start));
    }
}
