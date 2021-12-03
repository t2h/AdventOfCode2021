import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner s = new Scanner(new File("Input.txt"));
        ArrayList<Integer> list = new ArrayList<>();

        while (s.hasNext()){
            list.add(Integer.parseInt(s.next()));
        }
        s.close();

        int largerThanPrevious = 0;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > list.get(i-1)) {
                largerThanPrevious++;
            }
        }

        System.out.println("Number of values larger than previous: " + largerThanPrevious);

    }
}
