import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner s = new Scanner(new File("Input.txt"));
        ArrayList<String> input = new ArrayList<>();

        while (s.hasNextLine()){
            input.add(s.nextLine());
        }
        s.close();

        //ArrayList<Integer> of the bingo numbers that are drawn
        ArrayList<Integer> drawnNumbers = new ArrayList<>();
        for (String string : input) {
            if (string.contains(",")) {
                for (String substring : string.split(",")) {
                    drawnNumbers.add(Integer.valueOf(substring));
                }
            }
        }

        //ArrayList<Integer> of the board numbers, going left to right, top to bottom
        ArrayList<Integer> boardNumbers = new ArrayList<>();
        for (String string : input) {
            if (string.contains(" ")) {
                for (String substring : string.split(" ")) {
                    if (!substring.strip().isBlank()) {
                        boardNumbers.add(Integer.valueOf(substring.strip()));
                    }
                }
            }
        }

        //ArrayList<Integer[]> of the board numbers, but each row is saved as an Integer[] array
        ArrayList<Integer[]> boardArrays = new ArrayList<>();
        for (int i = 0; i < boardNumbers.size(); i+=5) {
            boardArrays.add(new Integer[]{boardNumbers.get(i),
                    boardNumbers.get(i+1),
                    boardNumbers.get(i+2),
                    boardNumbers.get(i+3),
                    boardNumbers.get(i+4)});
        }

        //ArrayList<Integer[][]> of the boards, saved as an Integer[][] array
        ArrayList<Integer[][]> boards = new ArrayList<>();
        for (int i = 0; i < boardArrays.size(); i+=5) {
            boards.add(new Integer[][]{boardArrays.get(i),
                    boardArrays.get(i+1),
                    boardArrays.get(i+2),
                    boardArrays.get(i+3),
                    boardArrays.get(i+4)});
        }

        //ArrayList<String[][]> of the 'game state', to show marked numbers. Unmarked shown by "_", marked by "#"
        ArrayList<String[][]> gameState = new ArrayList<>();
        for (int i = 0; i < boards.size(); i++) {
            gameState.add(new String[5][5]);
        }
        for (String[][] board : gameState) {
            for (String[] strings : board) {
                Arrays.fill(strings, "_");
            }
        }

        int drawnNumber;
        int winningNumber = 0;
        int winningBoardIndex = 0;
        int noOfWonBoards = 0;
        ArrayList<Integer> wonBoards = new ArrayList<>();
        boolean finished = false;

        System.out.println("Drawing " + drawnNumbers.size() + " numbers against " + boards.size() + " boards..." + "\n");

        //Start drawing numbers in the bingo game
        for (Integer number : drawnNumbers) {
            if (finished) break;
            drawnNumber = number;
            System.out.println("Drawing a number... " + drawnNumber);
            for (Integer[][] board : boards) {
                for (int row = 0; row < board.length && !finished; row++) {
                    for (int col = 0; col < board[row].length; col++) {
                        if (board[row][col] == drawnNumber) {
                            System.out.println("Match with cell [" + row + "][" + col + "] on board " + boards.indexOf(board));
                            String[][] boardState = gameState.get(boards.indexOf(board));
                            boardState[row][col] = "#";
                            gameState.set(boards.indexOf(board), boardState);
                            String[][] newBoardState = gameState.get(boards.indexOf(board));
                            //Check row for winning line
                            if (newBoardState[row][0].equals("#") &&
                                    newBoardState[row][1].equals("#") &&
                                    newBoardState[row][2].equals("#") &&
                                    newBoardState[row][3].equals("#") &&
                                    newBoardState[row][4].equals("#")) {
                                //If that board hasn't won yet, add it to the list of won boards
                                if (!wonBoards.contains(boards.indexOf(board))) {
                                    noOfWonBoards++;
                                    wonBoards.add(boards.indexOf(board));
                                    System.out.println("Board " + boards.indexOf(board) + " has won! Won boards: " + noOfWonBoards);
                                }
                                //If the board is the last to win, end the game
                                if (wonBoards.size() == boards.size()) {
                                    finished = true;
                                    winningBoardIndex = boards.indexOf(board);
                                    winningNumber = drawnNumber;
                                }
                            }
                            //Check column for winning line
                            if (newBoardState[0][col].equals("#") &&
                                    newBoardState[1][col].equals("#") &&
                                    newBoardState[2][col].equals("#") &&
                                    newBoardState[3][col].equals("#") &&
                                    newBoardState[4][col].equals("#")) {
                                //If that board hasn't won yet, add it to the list of won boards
                                if (!wonBoards.contains(boards.indexOf(board))) {
                                    noOfWonBoards++;
                                    wonBoards.add(boards.indexOf(board));
                                    System.out.println("Board " + boards.indexOf(board) + " has won! Won boards: " + noOfWonBoards);
                                }
                                //If the board is the last to win, end the game
                                if (wonBoards.size() == boards.size()) {
                                    finished = true;
                                    winningBoardIndex = boards.indexOf(board);
                                    winningNumber = drawnNumber;
                                }
                            }
                        }
                    }
                }
            }
        }

        int unmarkedNumberSum = 0;

        System.out.println("\n" + "Winner!");
        System.out.println("Last board to win is: " + winningBoardIndex + " with drawn number " + winningNumber);

        String[][] winningBoardState = gameState.get(winningBoardIndex);
        Integer[][] winningBoard = boards.get(winningBoardIndex);

        //Find sum of unmarked numbers on winning board
        for (int row = 0; row < winningBoardState.length; row++) {
            for (int col = 0; col < winningBoardState[row].length; col++) {
                if (winningBoardState[row][col].equals("_")) {
                    unmarkedNumberSum += winningBoard[row][col];
                }
            }
        }

        System.out.println("Final score = " + winningNumber + " * " + unmarkedNumberSum + " = " + winningNumber*unmarkedNumberSum);

    }
}
