import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner s = new Scanner(new File("Input.txt"));
        ArrayList<String> arrayGenerator = new ArrayList<>();

        while (s.hasNextLine()){
            arrayGenerator.add(s.nextLine());
        }
        s.close();

        int zeroCount = 0;
        int oneCount = 0;
        ArrayList<String> toRemove = new ArrayList<>();
        ArrayList<String> arrayScrubber = new ArrayList<>(arrayGenerator);

        for (int i = 0; i < arrayGenerator.get(0).length(); i++) {
            for (String number : arrayGenerator) {
                if (number.charAt(i) == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
            if (zeroCount > oneCount) {
                for (String number : arrayGenerator) {
                    if (number.charAt(i) == '1') {
                        toRemove.add(number);
                    }
                }
            } else {
                for (String number : arrayGenerator) {
                    if (number.charAt(i) == '0') {
                        toRemove.add(number);
                    }
                }
            }
            zeroCount = 0;
            oneCount = 0;
            if (arrayGenerator.size() == 1) {
                break;
            }
            arrayGenerator.removeAll(toRemove);
            toRemove.clear();
        }

        for (int j = 0; j < arrayScrubber.get(0).length(); j++) {
            for (String number : arrayScrubber) {
                if (number.charAt(j) == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
            if (zeroCount <= oneCount) {
                for (String number : arrayScrubber) {
                    if (number.charAt(j) == '1') {
                        toRemove.add(number);
                    }
                }
            } else {
                for (String number : arrayScrubber) {
                    if (number.charAt(j) == '0') {
                        toRemove.add(number);
                    }
                }
            }
            zeroCount = 0;
            oneCount = 0;
            if (arrayScrubber.size() == 1) {
                break;
            }
            arrayScrubber.removeAll(toRemove);
            toRemove.clear();
        }

        String generatorRatingBinary;
        generatorRatingBinary = arrayGenerator.get(0);
        int generatorRatingDecimal = Integer.parseInt(generatorRatingBinary,2);
        String scrubberRatingBinary;
        scrubberRatingBinary = arrayScrubber.get(0);
        int scrubberRatingDecimal = Integer.parseInt(scrubberRatingBinary, 2);
        System.out.println("Oxygen Generator Rating in Binary:  " + generatorRatingBinary);
        System.out.println("CO2 Scrubber Rating in Binary:      " + scrubberRatingBinary);
        System.out.println("Oxygen Generator Rating in Decimal: " + generatorRatingDecimal);
        System.out.println("CO2 Scrubber Rating in Decimal:     " + scrubberRatingDecimal);
        System.out.println("Oxygen Rate * CO2 Rate:             " + generatorRatingDecimal*scrubberRatingDecimal);

    }
}
