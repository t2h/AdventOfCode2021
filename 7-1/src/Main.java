import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner s = new Scanner(new File("Input.txt"));

        String[] input = s.nextLine().split(",");

        s.close();

        int[] crabs = new int[input.length];

        for (int i = 0; i < crabs.length; i++) {
            crabs[i] = Integer.parseInt(input[i]);
        }

        int bestFuel = Integer.MAX_VALUE;
        int position = 0;
        int fuel = 0;

        for (int i = 0; i < crabs.length; i++) {
            for (int j = 0; j < crabs.length; j++) {
                fuel += Math.abs(i - crabs[j]);
            }
            if (fuel < bestFuel) {
                bestFuel = fuel;
                position = i;
            }
            fuel = 0;
        }

        System.out.println("Best position is " + position + " using " + bestFuel + " fuel");

    }
}
