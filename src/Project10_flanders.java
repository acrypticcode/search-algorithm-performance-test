/*
This program tests the efficiency of two array search methods, binary and sequential, by
  creating two identical integer arrays containing random numbers from 0 to 999, sorting the
  second array, and searching for any number of integers chosen by the user using sequential
  search on the first array and binary search on the second.
 The results of the searches are printed to the screen.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Project10_flanders extends P10Search {

    //prints the results of a search
    public static void printResults(String searchType, int key, int foundIndex, int tries){

        String format, foundStr, locationStr;

        format = "%s search %s %d%s after scanning %d items.%n";

        if (foundIndex == -1){
            foundStr = "couldn't find";
            locationStr = "";
        }
        else{
            foundStr = "found";
            locationStr = " at index " + foundIndex;
        }

        System.out.printf(format, searchType, foundStr, key, locationStr, tries);
    }

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int[] ary1 = new int[1000], ary2 = new int[1000];
        int randInt, i, key, seqReturn, binReturn;

        //fills both arrays with the same random integers ranging in value from 0 to 999
        for (i = 0; i < 1000; i++) {
            randInt = (int)(Math.random() * 1000);
            ary1[i] = randInt;
            ary2[i] = randInt;
        }
        //sorts the contents of array 2, to prepare it for binary searches
        Arrays.sort(ary2);

        /*Gets numbers to search the array for from the user.
        Each number is searched for using sequential search in the first array and binary
          search in the second array.
         The results of the searches are outputted to the user.
         Loop ends when user enters an end of file command.
         */
        System.out.print("\nEnter the integer to search for (CTRL-D to quit): ");
        while (kb.hasNext()) {
            key = kb.nextInt();
            seqReturn = seq_search(ary1,key);
            binReturn = bin_search(ary2, key);
            printResults("sequential",key,seqReturn,SEQ_NUM);
            printResults("binary",key,binReturn,BIN_NUM);
            System.out.print("\nEnter the integer to search for (CTRL-D to quit): ");
        }
    }
}