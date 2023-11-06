import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int total = 0;
        double avg = 0.0;
        int userInt = 0;
        int userInt2 = 0;
        int count = 0;
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);
        int[] dataPoints = new int[100];
        int min = 0;
        int max = 0;
        for (int i = 0; i < dataPoints.length; i++) {
            int val = rnd.nextInt(100) + 1;
            dataPoints[i] = val;
        }
        for (int i = 0; i < dataPoints.length; i++) {
            System.out.print(dataPoints[i] + " | ");
            if (i % 20 == 0 && i != 0) {
                System.out.println("");
            }
        }
        min = dataPoints[0];
        max = dataPoints[0];
        for (int i = 0; i < dataPoints.length; i++) {
            total = total + dataPoints[i];
            if (i == 99) {
                avg = total / dataPoints.length;
                System.out.println("\nThe total is " + total + ", and the average is " + avg);
            }
        }
        userInt = SafeInput.getRangedInt(in, "Enter the number you would like to locate [1-100]", 1, 100);
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userInt) {
                count++;
            }
        }
        System.out.println(userInt + " was found " + count + " times");
        userInt2 = SafeInput.getRangedInt(in, "Enter the number you would like to locate [1-100]", 1, 100);
        for (int i = 0; i < dataPoints.length; i++) {
            if (userInt2 == dataPoints[i]) {
                System.out.println("User input, " + userInt2 + ", was found at index " + i);
                break;
            }
            if (i == 99 && userInt2 != dataPoints[99]) {
                System.out.println("User input, " + userInt2 + ", was not found");
            }

        }
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] > max) {
                max = dataPoints[i];
            }
            if (dataPoints[i] < min) {
                min = dataPoints[i];
            }
        }
        System.out.println("The minimum value is " + min + " and the maximum value is " + max);
        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));
        System.out.println("The minimun value is: " + getMin(dataPoints));
        System.out.println("The maximum value is: " + getMax(dataPoints));
        System.out.println("Your target was found " + occuranceScan(dataPoints, 67) + " times");
        System.out.println("The sum of dataPoints is: " + getSum(dataPoints));
        System.out.println(contains(dataPoints, 78));
    }

    public static double getAverage(int values[]) {
        int sum = 0;
        double avg = 0;
        for (int i = 0; i < values.length; i++) {
            sum = sum + values[i];
        }
        avg = sum / values.length;
        return avg;
    }

    public static int getMin(int values[]) {
        int min = 100;
        for (int i = 0; i < values.length; i++) {
            if (values[i] < min) {
                min = values[i];
            }
        }
        return min;
    }

    public static int getMax(int values[]) {
        int max = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }

    public static int occuranceScan(int values[], int target) {
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == target) {
                count++;
            }
        }
        return count;
    }

    public static int getSum(int values[]) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum = sum + values[i];
        }
        return sum;
    }

    public static boolean contains(int values[], int target) {
        boolean contains = false;
        for (int i = 0; i < values.length; i++) {
            if (target == values[i]) {
                contains = true;
                break;
            }
        }
        return contains;
    }
}
