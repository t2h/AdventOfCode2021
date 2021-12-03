import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner s = new Scanner(new File("Input.txt"));
        ArrayList<String> array = new ArrayList<>();

        while (s.hasNextLine()){
            array.add(s.nextLine());
        }
        s.close();

        String gammaBinary = "";
        String epsilonBinary = "";
        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 0; i < array.get(0).length(); i++) {

            for (String line : array) {
                if (line.charAt(i) == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }

            if (zeroCount > oneCount) {
                gammaBinary = gammaBinary.concat("0");
            } else {
                gammaBinary = gammaBinary.concat("1");
            }

            zeroCount = 0;
            oneCount = 0;

        }

        for (char c : gammaBinary.toCharArray()) {
            if (c == '0') {
                epsilonBinary = epsilonBinary.concat("1");
            } else {
                epsilonBinary = epsilonBinary.concat("0");
            }
        }

        int gammaDecimal = Integer.parseInt(gammaBinary,2);
        int epsilonDecimal = Integer.parseInt(epsilonBinary,2);

        System.out.println("Gamma Rate in Binary:      " + gammaBinary);
        System.out.println("Gamma Rate in Decimal:     " + gammaDecimal);
        System.out.println("Epsilon Rate in Binary:    " + epsilonBinary);
        System.out.println("Epsilon Rate in Decimal:   " + epsilonDecimal);
        System.out.println("Gamma Rate * Epsilon Rate: " + gammaDecimal*epsilonDecimal);

    }
}
