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

        int days = 80;
        int fishCreated;

        System.out.println("Initial state: " + Arrays.toString(fish.toArray()));

        for (int i = 1; i <= days; i++) {
            fishCreated = 0;
            for (int j = 0; j < fish.size(); j++) {
                if (fish.get(j) == 0) {
                    fish.set(j,6);
                    fishCreated++;
                } else if (fish.get(j) > 0) {
                    fish.set(j, fish.get(j) - 1);
                }
            }
            for (int k = 0; k < fishCreated; k++) {
                fish.add(8);
            }
        }

        System.out.println("After " + days + " days there are a total of " + fish.size() + " fish" );

    }
}
