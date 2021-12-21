import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner s = new Scanner(new File("Input.txt"));

        ArrayList<String> signalPatterns = new ArrayList<>();
        ArrayList<String> outputValues = new ArrayList<>();

        while (s.hasNextLine()) {
            String[] inputSplit = s.nextLine().split("\\Q | \\E");
            signalPatterns.add(inputSplit[0]);
            outputValues.add(inputSplit[1]);
        }
        s.close();

        int length;
        int total = 0;
        Map<Integer, String> patternMap = new HashMap<>();
        ArrayList<String> twoThreeFive = new ArrayList<>();
        ArrayList<String> zeroSixNine = new ArrayList<>();

        for (int i = 0; i < signalPatterns.size(); i++) {

            System.out.println(signalPatterns.get(i) + " | " + outputValues.get(i));

            String[] pattern = signalPatterns.get(i).split(" ");
            for (String string : pattern) {
                length = string.length();
                if (length == 2) {
                    patternMap.put(1, string);
                    System.out.println("Digit 1 is shown by " + patternMap.get(1));
                } else if (length == 4) {
                    patternMap.put(4, string);
                    System.out.println("Digit 4 is shown by " + patternMap.get(4));
                } else if (length == 3) {
                    patternMap.put(7, string);
                    System.out.println("Digit 7 is shown by " + patternMap.get(7));
                } else if (length == 7) {
                    patternMap.put(8, string);
                    System.out.println("Digit 8 is shown by " + patternMap.get(8));
                } else if (length == 5) {
                    twoThreeFive.add(string);
                } else if (length == 6) {
                    zeroSixNine.add(string);
                }
             }

            for (String string : zeroSixNine) {
                if (string.contains(String.valueOf(patternMap.get(4).charAt(0))) &&
                        string.contains(String.valueOf(patternMap.get(4).charAt(1))) &&
                        string.contains(String.valueOf(patternMap.get(4).charAt(2))) &&
                        string.contains(String.valueOf(patternMap.get(4).charAt(3)))) {
                    patternMap.put(9, string);
                    System.out.println("Digit 9 is shown by " + patternMap.get(9));
                } else if (string.contains(String.valueOf(patternMap.get(7).charAt(0))) &&
                        string.contains(String.valueOf(patternMap.get(7).charAt(1))) &&
                        string.contains(String.valueOf(patternMap.get(7).charAt(2)))) {
                    patternMap.put(0, string);
                    System.out.println("Digit 0 is shown by " + patternMap.get(0));
                } else {
                    patternMap.put(6, string);
                    System.out.println("Digit 6 is shown by " + patternMap.get(6));
                }
            }

            for (String string : twoThreeFive) {
                if (string.contains(String.valueOf(patternMap.get(7).charAt(0))) &&
                        string.contains(String.valueOf(patternMap.get(7).charAt(1))) &&
                        string.contains(String.valueOf(patternMap.get(7).charAt(2)))) {
                    patternMap.put(3, string);
                    System.out.println("Digit 3 is shown by " + patternMap.get(3));
                } else if ((string.contains(String.valueOf(patternMap.get(4).charAt(0))) &&
                        string.contains(String.valueOf(patternMap.get(4).charAt(1))) &&
                        string.contains(String.valueOf(patternMap.get(4).charAt(2)))) ||
                        (string.contains(String.valueOf(patternMap.get(4).charAt(1))) &&
                                string.contains(String.valueOf(patternMap.get(4).charAt(2))) &&
                                string.contains(String.valueOf(patternMap.get(4).charAt(3)))) ||
                        (string.contains(String.valueOf(patternMap.get(4).charAt(0))) &&
                                string.contains(String.valueOf(patternMap.get(4).charAt(1))) &&
                                string.contains(String.valueOf(patternMap.get(4).charAt(3)))) ||
                        (string.contains(String.valueOf(patternMap.get(4).charAt(0))) &&
                                string.contains(String.valueOf(patternMap.get(4).charAt(2))) &&
                                string.contains(String.valueOf(patternMap.get(4).charAt(3))))) {
                    patternMap.put(5, string);
                    System.out.println("Digit 5 is shown by " + patternMap.get(5));
                } else {
                    patternMap.put(2, string);
                    System.out.println("Digit 2 is shown by " + patternMap.get(2));
                }
            }

            String[] values = outputValues.get(i).split(" ");

            StringBuilder subTotal = new StringBuilder();

            for (String value : values) {
                for (int m = 0; m <= 9; m++) {
                    if (sameChars(value, patternMap.get(m))) {
                        subTotal.append(m);
                    }
                }
            }

            System.out.println("Adding " + subTotal + " to total");
            System.out.println();

            total = total + Integer.parseInt(subTotal.toString());

            patternMap.clear();
            zeroSixNine.clear();
            twoThreeFive.clear();

        }

        System.out.print("Sum of all output values: " + total);

    }

    static boolean sameChars(String firstStr, String secondStr) {
        char[] first = firstStr.toCharArray();
        char[] second = secondStr.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return Arrays.equals(first, second);
    }

}
