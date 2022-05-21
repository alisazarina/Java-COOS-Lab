/*
 * MS: [01:19:00] -- [02:30:00]

 */
package LabWk12;

/**
 *
 * @author AlisaZarina
 */

import java.util.*;
import java.util.ArrayList;

public class LRU {

    public static void main(String[] args) {
        int frames = 4;
        int lruIncomingStream[] = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 3};

        // Array list to represent set of current pages/frames
        ArrayList<Integer> s = new ArrayList<>(frames);
        int count = 0;
        int lruPageFaults = 0;
        
        // Display page reference and number of frames
        System.out.println("Page reference: " + Arrays.toString(lruIncomingStream)+ "\n");
        System.out.println("Number of frames: " + Integer.toString(frames) + "\n");
        
        // Display incoming pages and frames
        System.out.println("Incoming Pages\t\tFrames");

        for (int i : lruIncomingStream) {
            // Insert it into set if not present
            if (!s.contains(i)) {

                // Check if set can hold equal frames
                if (s.size() == frames) {
                    s.remove(0);
                    s.add(frames - 1, i);
                                        
                } else
                    s.add(count, i);
                        // Increment page faults
                        lruPageFaults++;
                        ++count; 
                                
            } else {
                // Remove index pages
                s.remove((Integer) i);
                
                // Insert current page
                s.add(s.size(), i);
            }
        }

        System.out.println("\n\nPage Faults: " + lruPageFaults);
        int lruHits = frames;
        System.out.println("Hit: " + lruHits);

        

        /* To display:
        Page reference = [7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2]
        
        Number of frames = 4

        //System.out.print("\n" + lruIncomingStream[i] + "\t\t\t");      
        Incoming page           Frames
        7                       [7]
        0                       [7, 0]
        1                       [7, 0, 1]
        ....
        2                       [4, 0, 3, 2]
        
        Page faults = 6
        Hits = 8
         */
    }

}
