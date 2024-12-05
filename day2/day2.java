package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day2 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(safeReports());
        System.out.println(safeTolerance());
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

    public static int safeTolerance() throws FileNotFoundException {
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

            boolean isValid = checkSequence(intNumbers);

            if(isValid) {
                total++;
            }

            if (!isValid) {
                for (int i = 0; i < intNumbers.length; i++) {
                    // Create a new list excluding the current number
                    List<Integer> modifiedList = new ArrayList<>();
                    for (int j = 0; j < intNumbers.length; j++) {
                        if (i != j) {
                            modifiedList.add(intNumbers[j]);
                        }
                    }

                    // Convert the list back to an array
                    int[] modifiedArray = modifiedList.stream().mapToInt(Integer::intValue).toArray();

                    if (checkSequence(modifiedArray)) {
                        isValid = true;
                        total++;
                        break;
                    }
                }
            }
        }

        s.close();

        return total;
    }

    public static boolean checkSequence(int[] intNumbers) {
        int direction = 0;
            for(int i = 1; i < intNumbers.length; i++) {
                int diff = intNumbers[i] - intNumbers[i-1];
                if(Math.abs(diff) < 1 || Math.abs(diff) > 3) {
                   return false;
                }

                if (diff > 0) {
                    if (direction == -1) {
                        return false;
                    }
                    direction = 1;
                } else if (diff < 0) {
                    if (direction == 1) {
                        return false;
                    }
                    direction = -1;
                }
            }
        return true;
    }
}
