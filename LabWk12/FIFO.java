package LabWk12;

/**
 *
 * @author AlisaZarina
 */

import java.util.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FIFO {
    public static void main(String[] args) 
    {
        int incomingStream[] = {1, 3, 0, 3, 5, 6, 3};
        int pageFaults = 0;
        int frames = 3;
        int i, j = 0, k, pages;
        
        pages = incomingStream.length;
        
        System.out.println("Incoming\t\tPages");
        
        int temp[] = new int[frames];
        
        for (i = 0; i < frames; i++)
        {
            temp[i] = -1;
        }
        
        for (i = 0; i < pages; i++)
        {
            k = 0;
            
            for (j = 0; j < frames; j++) 
            {
                if (incomingStream[i] == temp[j])
                {
                    k++;
                    pageFaults--;
                }
            }
            pageFaults++;
            
            if ((pageFaults <= frames) && (k == 0))
            {
                temp[i] = incomingStream[i];
            }
            else if (k == 0)
            {
                temp[(pageFaults - 1) % frames] = incomingStream[i];
            }
            
            System.out.print("\n" + incomingStream[i] + "\t\t\t");
            
            for(j = 0; j < frames; j++)
            {
                if (temp[j] != -1)
                    System.out.print(temp[j] + "\t\t\t");
                else
                    System.out.print("Null" + "\t\t\t");
            }
        }
        
        System.out.println("\n\nPage Faults: " + pageFaults);
        int hits = pages - pageFaults;
        System.out.println("Hit: " + hits);
    }
}
