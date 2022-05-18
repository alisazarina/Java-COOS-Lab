package LabWk11;

/**
 *
 * @author Alisa Zarina // TO BE EDITED: something wrong with internalFrag value
 */

import java.util.*;
import java.time.Duration;
        
public class BestFit {
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
            // index for your best fit
            int bestIdx = -1;
            for (int j = 0; j < m; j++)
            {
                if (blockSize[j] >= processSize[i])
                {
                    if (bestIdx == -1)
                    {
                        diff = blockSize[j] - processSize[i];
                        bestIdx = j;
                    }
                    else if (diff > (blockSize[j] - processSize[i]));
                    {
                        bestIdx = j;
                        diff = blockSize[bestIdx] - processSize[i];
                        
                        internalFrag += blockSize[bestIdx];
                    }
                }
            }
            if (bestIdx != -1)
            {
                allocation[i] = bestIdx;
                blockSize[bestIdx] -= processSize[i];
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
        System.out.println("\nBest Fit\t\t" + internalFrag + "\t\t\t\t" + (end-start));
    }
}
