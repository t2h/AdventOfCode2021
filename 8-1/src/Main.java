import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner s = new Scanner(new File("Input.txt"));

        ArrayList<String> outputValues = new ArrayList<>();

        while (s.hasNextLine()) {
            String[] inputSplit = s.nextLine().split("\\Q | \\E");
            outputValues.add(inputSplit[1]);
        }
        s.close();

        int count = 0;
        int length;

        for (String string : outputValues) {
            String[] values = string.split(" ");
            for (String value : values) {
                length = value.length();
                if (length == 2 || length == 4 || length == 3 || length == 7) {
                    count++;
                }
            }
        }

        System.out.println("In the output values, the digits 1, 4, 7 or 8 appear " + count + " times");

    }
}
