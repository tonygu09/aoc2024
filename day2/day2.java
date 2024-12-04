package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(safeReports());
    }

    public static int safeReports() throws FileNotFoundException {
        File day1Input = new File("day2\\day2.txt");
        Scanner s = new Scanner(day1Input);

        int total = 0;

        while(s.hasNextLine()) {
            String temp = s.nextLine();
            String[] numbers = temp.split(" ");
            int[] intNumbers = new int[numbers.length];

            for(int i = 0; i < numbers.length; i++) {
                intNumbers[i] = Integer.parseInt(numbers[i]);
            }

            boolean isValid = true;
            int direction = 0;
            for(int i = 1; i < intNumbers.length; i++) {
                int diff = intNumbers[i] - intNumbers[i-1];
                if(Math.abs(diff) < 1 || Math.abs(diff) > 3) {
                   isValid = false;
                   break;
                }

                if (diff > 0) {
                    if (direction == -1) {
                        isValid = false;
                        break;
                    }
                    direction = 1;
                } else if (diff < 0) {
                    if (direction == 1) {
                        isValid = false;
                        break;
                    }
                    direction = -1;
                }
            }

            if(isValid) {
                total++;
            }
        }

        s.close();

        return total;
    }
}
