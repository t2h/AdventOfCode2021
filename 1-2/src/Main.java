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

        int windowLargerThanPrevious = 0;

        for (int i = 2; i < (list.size() - 1); i++) {
            if ((list.get(i-1) + list.get(i) + list.get(i+1)) > (list.get(i) + list.get(i-1) + list.get(i-2))) {
                windowLargerThanPrevious++;
            }
        }

        System.out.println("Number of three-measurement windows larger than previous: " + windowLargerThanPrevious);


    }
}
