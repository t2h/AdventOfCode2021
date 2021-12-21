import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner s = new Scanner(new File("Input.txt"));

        ArrayList<String[]> input = new ArrayList<>();

        while (s.hasNextLine()) {
            input.add(s.nextLine().split(""));
        }
        s.close();

        int x = input.get(0).length;
        int y = input.size();
        int[][] heightmap = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                heightmap[i][j] = Integer.parseInt(input.get(i)[j]);
            }
        }

        int totalRiskLevel = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 && j == 0) {
                    if (heightmap[i][j] < heightmap[i+1][j] &&
                            heightmap[i][j] < heightmap[i][j+1]) {
                        totalRiskLevel = totalRiskLevel + 1 + heightmap[i][j];
                    }
                } else if (i == x-1 && j == y-1) {
                    if (heightmap[i][j] < heightmap[i-1][j] &&
                            heightmap[i][j] < heightmap[i][j-1]) {
                        totalRiskLevel = totalRiskLevel + 1 + heightmap[i][j];
                    }
                } else if (i == 0 && j == y-1) {
                    if (heightmap[i][j] < heightmap[i+1][j] &&
                            heightmap[i][j] < heightmap[i][j-1]) {
                        totalRiskLevel = totalRiskLevel + 1 + heightmap[i][j];
                    }
                } else if (i == x-1 && j == 0) {
                    if (heightmap[i][j] < heightmap[i-1][j] &&
                            heightmap[i][j] < heightmap[i][j+1]) {
                        totalRiskLevel = totalRiskLevel + 1 + heightmap[i][j];
                    }
                } else if (i == 0) {
                    if (heightmap[i][j] < heightmap[i+1][j] &&
                            heightmap[i][j] < heightmap[i][j+1] &&
                            heightmap[i][j] < heightmap[i][j-1]) {
                        totalRiskLevel = totalRiskLevel + 1 + heightmap[i][j];
                    }
                } else if (j == 0) {
                    if (heightmap[i][j] < heightmap[i+1][j] &&
                            heightmap[i][j] < heightmap[i-1][j] &&
                            heightmap[i][j] < heightmap[i][j+1]) {
                        totalRiskLevel = totalRiskLevel + 1 + heightmap[i][j];
                    }
                } else if (i == x-1) {
                    if (heightmap[i][j] < heightmap[i-1][j] &&
                            heightmap[i][j] < heightmap[i][j+1] &&
                            heightmap[i][j] < heightmap[i][j-1]) {
                        totalRiskLevel = totalRiskLevel + 1 + heightmap[i][j];
                    }
                } else if (j == y-1) {
                    if (heightmap[i][j] < heightmap[i+1][j] &&
                            heightmap[i][j] < heightmap[i-1][j] &&
                            heightmap[i][j] < heightmap[i][j-1]) {
                        totalRiskLevel = totalRiskLevel + 1 + heightmap[i][j];
                    }
                } else {
                    if (heightmap[i][j] < heightmap[i+1][j] &&
                            heightmap[i][j] < heightmap[i][j+1] &&
                            heightmap[i][j] < heightmap[i-1][j] &&
                            heightmap[i][j] < heightmap[i][j-1]) {
                        totalRiskLevel = totalRiskLevel + 1 + heightmap[i][j];
                    }
                }
            }
        }

        System.out.println("Sum of the risk levels of all low points: " + totalRiskLevel);

    }
}
