import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner s = new Scanner(new File("Input.txt"));
        ArrayList<String> command = new ArrayList<>();
        ArrayList<Integer> value = new ArrayList<>();

        while (s.hasNextLine()){
            String[] parts = s.nextLine().split(" ");
            command.add(parts[0]);
            value.add(Integer.parseInt(parts[1]));
        }
        s.close();

        int position = 0;
        int depth = 0;
        int aim = 0;

        for (int i = 0; i < command.size(); i++) {
            switch (command.get(i)) {
                case "forward" -> {
                    position = position + value.get(i);
                    depth = depth + (aim * value.get(i));
                }
                case "down" -> aim = aim + value.get(i);
                case "up" -> aim = aim - value.get(i);
            }
        }

        System.out.println("Final position: " + position);
        System.out.println("Final depth: " + depth);
        System.out.println("Multiplied: " + position*depth);

    }
}
