import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner s = new Scanner(new File("Input.txt"));
        ArrayList<String> direction = new ArrayList<>();
        ArrayList<Integer> velocity = new ArrayList<>();

        while (s.hasNextLine()){
            String[] parts = s.nextLine().split(" ");
            direction.add(parts[0]);
            velocity.add(Integer.parseInt(parts[1]));
        }
        s.close();

        int position = 0;
        int depth = 0;

        for (int i = 0; i < direction.size(); i++) {
            switch (direction.get(i)) {
                case "forward" -> position = position + velocity.get(i);
                case "down" -> depth = depth + velocity.get(i);
                case "up" -> depth = depth - velocity.get(i);
            }
        }

        System.out.println("Final position: " + position);
        System.out.println("Final depth: " + depth);
        System.out.println("Multiplied: " + position*depth);

    }
}
