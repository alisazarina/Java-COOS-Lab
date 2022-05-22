package LabWk12;

/**
 *
 * @author AlisaZarina
 */

import java.util.*;

public class FIFOLRU {
    public static void main(String[] args) 
    {      
        int fifoIncomingStream[] = {1, 3, 0, 3, 5, 6, 3};
        int fifoPageFaults = 0;
        int frames = 3;
        int i, j = 0, k, fifoPages;
        
        fifoPages = fifoIncomingStream.length;
        
        System.out.println("Method: FIFO");
        System.out.println("\nIncoming\tPages");
        
        int temp[] = new int[frames];
        
        for (i = 0; i < frames; i++)
        {
            temp[i] = -1;
        }
        
        for (i = 0; i < fifoPages; i++)
        {
            k = 0;
            
            for (j = 0; j < frames; j++) 
            {
                if (fifoIncomingStream[i] == temp[j])
                {
                    k++;
                    fifoPageFaults--;
                }
            }
            fifoPageFaults++;
            
            if ((fifoPageFaults <= frames) && (k == 0))
            {
                temp[i] = fifoIncomingStream[i];
            }
            else if (k == 0)
            {
                temp[(fifoPageFaults - 1) % frames] = fifoIncomingStream[i];
            }
            
            System.out.print("\n" + fifoIncomingStream[i] + "\t\t");
            
            for(j = 0; j < frames; j++)
            {
                if (temp[j] != -1)
                    System.out.print(temp[j] + "\t\t");
                else
                    System.out.print("\t\t");
            }
        }
        
        // Diplay FIFO page faults and hits
        int fifoHits = fifoPages - fifoPageFaults;
        System.out.println("\n\nPage Faults: " + fifoPageFaults);
        System.out.println("Hits: " + fifoHits);
        
        // LRU
        System.out.println("\n");
        System.out.println("-----------------------------------------------------------");
        System.out.println("\nMethod: LRU" + "\n");
        int lruFrames = 4;
        int lruIncomingStream[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 3};

        // Array list to represent set of current pages/frames
        ArrayList<Integer> s = new ArrayList<>(lruFrames);
        int count = 0;
        int lruPageFaults = 0;
        int lruHits = 0;
                
        // Display page reference and number of frames
        System.out.println("Page reference: " + Arrays.toString(lruIncomingStream)+ "\n");
        System.out.println("Number of frames: " + Integer.toString(lruFrames) + "\n");
        
        // Display incoming pages and frames
        System.out.println("Incoming Pages\t\tFrames");

        for (int m : lruIncomingStream) {
            // Insert it into set if not present
            if (!s.contains(m)) {
                // Check if set can hold equal frames -- is it full or not?
                if (s.size() == lruFrames) {
                    s.remove(0);
                    s.add(lruFrames - 1, m);
                    System.out.print("\n" + lruIncomingStream[m] + "\t\t\t" + s);
                                        
                } else 
                    s.add(count, m);
                        System.out.print("\n" + lruIncomingStream[m] + "\t\t\t" + s);
                        
                        // Increment page faults
                        lruPageFaults++;
                        ++count;
                        
            } else {
                // Remove index pages
                s.remove((Integer) m);
                
                // Insert current page
                s.add(s.size(), m);
                
                System.out.print("\n" + lruIncomingStream[m] + "\t\t\t" + s);
                
                lruHits++;
            }
        }

        // Display LRU page faults and hits
        System.out.println("\n\nPage Faults: " + lruPageFaults);
        System.out.println("Hits: " + lruHits);

        // Print table of comparison for FIFO and LRU (Page Faults and Hits)        
        System.out.println("\n");
        System.out.println("---------------------------------------------------------");
        System.out.println("Method\t\t\tPage Faults\t\tHits");   
        System.out.println("FIFO\t\t\t" + fifoPageFaults + "\t\t\t" + fifoHits);
        System.out.println("LRU\t\t\t" + lruPageFaults + "\t\t\t" + lruHits);
        System.out.println("---------------------------------------------------------");
        System.out.println("\n");
        
    }
     
}
