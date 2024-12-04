package day1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class day1 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(calculateDifference());   
        System.out.println(calculateSimilarity()); 
    }

    public static int calculateDifference() throws FileNotFoundException {
        int total = 0;
        
        // Initialize two arrays and output file to array
        int[] a1 = new int[1000];
        int[] a2 = new int[1000]; 

        File day1Input = new File("day1\\day1.txt");
        Scanner s = new Scanner(day1Input);

        for(int i = 0; i < 1000; i++) {
            a1[i] = s.nextInt();
            a2[i] = s.nextInt();
        }

        Arrays.sort(a1);
        Arrays.sort(a2);

        for(int i = 0; i < 1000; i++) {
            if(a1[i] > a2[i]) {
                total += a1[i] - a2[i];
            } else if (a1[i] < a2[i]) {
                total +=  a2[i] - a1[i];
            }
        }

        //s.close();

        return total;
    }

    public static int calculateSimilarity() throws FileNotFoundException{
        HashMap <Integer, Integer> h1 = new HashMap<>();
        HashMap <Integer, Integer> h2 = new HashMap<>();

        int total = 0;
        
        File day1Input = new File("day1\\day1.txt");
        Scanner s = new Scanner(day1Input);

        while (s.hasNextInt()) {
            // Read a pair of integers
            int col1 = s.nextInt();
            int col2 = s.nextInt();

            // Update h1 for the first column
            h1.put(col1, h1.getOrDefault(col1, 0) + 1);

            // Update h2 for the second column
            h2.put(col2, h2.getOrDefault(col2, 0) + 1);
        }

        for(int keys : h1.keySet()) {
            if(h2.containsKey(keys)) {
                total += keys*(h1.get(keys) * h2.get(keys));
            }
        }

        return total;
    }

}