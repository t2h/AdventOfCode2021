import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner s = new Scanner(new File("Input.txt"));
        ArrayList<String> input = new ArrayList<>();

        while (s.hasNextLine()){
            input.add(s.nextLine());
        }
        s.close();

        int noOfLines = input.size();

        int[][] startPoints = new int[noOfLines][2];
        int[][] endPoints = new int[noOfLines][2];

        for (int i = 0; i < noOfLines; i++) {
            String[] a = input.get(i).split(" -> ");
            String[] b = a[0].split(",");
            startPoints[i][0] = Integer.parseInt(b[0]);
            startPoints[i][1] = Integer.parseInt(b[1]);
            String[] c = a[1].split(",");
            endPoints[i][0] = Integer.parseInt(c[0]);
            endPoints[i][1] = Integer.parseInt(c[1]);
        }

        int maximumX = 0;
        int maximumY = 0;

        for (int i = 0; i < noOfLines; i++) {
            if (startPoints[i][0] > maximumX) {
                maximumX = startPoints[i][0];
            }
            if (startPoints[i][1] > maximumY) {
                maximumY = startPoints[i][1];
            }
            if (endPoints[i][0] > maximumX) {
                maximumX = endPoints[i][0];
            }
            if (endPoints[i][1] > maximumY) {
                maximumY = endPoints[i][1];
            }
        }

        int[][] diagram = new int[maximumX][maximumY];
        for (int row = 0; row < maximumX; row++) {
            for (int col = 0; col < maximumY; col++) {
                diagram[row][col] = 0;
            }
        }

        int start;
        int end;

        int x1;
        int y1;
        int x2;
        int y2;

        for (int i = 0; i < noOfLines; i++) {

            x1 = startPoints[i][0];
            y1 = startPoints[i][1];
            x2 = endPoints[i][0];
            y2 = endPoints[i][1];

            //Check if horizontal line
            if (x1 == x2) {
                start = Math.min(y1,y2);
                end = Math.max(y1,y2);
                for (int j = start; j <= end; j++) {
                    diagram[x1][j]++;
                }

            //Check if vertical line
            } else if (y1 == y2) {
                start = Math.min(x1,x2);
                end = Math.max(x1,x2);
                for (int k = start; k <= end; k++) {
                    diagram[k][y1]++;
                }
            }
        }

        //Iterate over the 2D diagram, counting how many lines overlap at least twice
        int count = 0;
        for (int row = 0; row < maximumX; row++) {
            for (int col = 0; col < maximumY; col++) {
                if (diagram[row][col] >= 2) {
                    count++;
                }
            }
        }

        System.out.println("Points with at least two lines overlapping: " + count);

    }
}
