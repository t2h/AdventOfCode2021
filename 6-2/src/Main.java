import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner s = new Scanner(new File("Input.txt"));

        String[] input = s.nextLine().split(",");

        s.close();

        ArrayList<Integer> fish = new ArrayList<>();
        for (String string : input) {
            fish.add(Integer.valueOf(string));
        }

        int days = 256;
        long[] ages = new long[9];

        //Count the number of different aged fish in the input
        for (int age : fish) {
            ages[age]++;
        }

        for (int day = 0; day < days; day++) {
            //Save the number of fish who are about to reproduce
            long parents = ages[0];
            //Age the the population
            for (int i = 1; i < ages.length; i++) ages[i - 1] = ages[i];
            //Every fish aged 0 becomes a 6
            ages[6] += parents;
            //And for each of those, a new fish aged 8 is added
            ages[8] = parents;
        }

        long sumOfAgeCounts = Arrays.stream(ages).sum();

        System.out.println("After " + days + " days there are a total of " + sumOfAgeCounts + " fish" );

    }
}
