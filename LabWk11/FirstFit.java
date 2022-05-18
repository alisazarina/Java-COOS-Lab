package LabWk11;

/**
 *
 * @author Alisa Zarina // something wrong with the code -- won't run + TO ADD: internalFrag
 */

import java.util.*;
import java.time.Duration;

public class FirstFit {
    public static void main(String[] args) {
        /*
        Initialize the values
        process size, block size, allocation
        */
        int[] processSize = {100, 199, 201, 297};
        int[] blockSize = {200, 300, 100};
        int[] allocation = {-1, -1, -1, -1};
        int n = processSize.length;
        int m = blockSize.length;
        int internalFrag = 0;
        
        // First Fit algorithm //
        for (int i = 0; 1 < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if ((blockSize[j] >= processSize[i]) && (allocation[i] == -1))
                {
                    allocation[i] = j;
                    blockSize[j] -= processSize[i];
                    break;
                }
            }
        }
        System.out.println("Process\t\tProcess Start\t\tBlock");
        System.out.println("--------------------------------------------------");
        
        for(int i = 0; i < n; i++)
        {
            System.out.println(i+1 + "\t\t\t" + processSize[i] + "\t\t\t\t\t");
            
            if (allocation[i] != -1)
            {
                allocation[i] += 1;
                System.out.println(allocation[i]);
            } 
            else
            {
                System.out.println("Not allocated");
            }
        }
    }
}
