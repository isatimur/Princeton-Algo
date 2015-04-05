/**
 * Created by tisachenko on 05.04.2015.
 */
public class TicTacToe {
    private static int length = 9;
    private static int N = (int) Math.sqrt(length);
    private static char[] matrix = new char[length];
    private static String winner = "Player";
    private static char[] winner1 = new char[N];
    private static char[] winner2 = new char[N];
    private static String txtWinnerX;
    private static String txtWinnerO;

    public TicTacToe(int length) {
        for (int i = 0; i < length; i++) {
            matrix[i] = '-';
        }
        for (int i = 0; i < N; i++) {
            winner1[i] = 'x';
            winner2[i] = 'o';
        }
        txtWinnerX = String.valueOf(winner1);
        txtWinnerO = String.valueOf(winner2);

    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(9);
        outputBoard();
        int counter = 1;
        while (StdIn.hasNextLine() && !StdIn.isEmpty()) {
            String input = StdIn.readString();
            String[] ttt = input.split("-");
            int idStep = Integer.parseInt(ttt[0]);
            matrix[idStep] = (char) ttt[1].charAt(0);
            outputBoard();
            counter++;
            if (counter >= (2 * N)) {
                if (hasWin()) {
                    System.out.println("The winner is " + winner);
                    break;
                } else if (isBoardFull()) {
                    System.out.println("The game is over with draw!");
                    break;
                }
            }
        }
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < length; i++) {
            if (matrix[i] == '-') {
                return false;
            }
        }
        return true;
    }

    private static boolean hasWin() {
        if (checkDiagonalsForWin()) {
            return true;
        } else if (checkRowsForWin()) {
            return true;
        }
        return false;
    }

    private static boolean checkRowsForWin() {
        char[] result1 = new char[N];
        char[] result2 = new char[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int rowId1 = i * N + j;
                int rowId2 = i + j * N;
                result1[j] = matrix[rowId1];
                result2[j] = matrix[rowId2];
            }
            String resultTxt1 = String.valueOf(result1);
            String resultTxt2 = String.valueOf(result2);
            if (txtWinnerX.equals(resultTxt1) || txtWinnerX.equals(resultTxt2)) {
                winner = winner + " X";
                return true;
            } else if (txtWinnerO.equals(resultTxt1) || txtWinnerO.equals(resultTxt2)) {
                winner = winner + " O";
                return true;
            }
        }

        return false;
    }

    private static boolean checkDiagonalsForWin() {
        char[] result1 = new char[N];
        char[] result2 = new char[N];
        for (int i = 0; i < N; i++) {
            int elDiag1 = i * (N + 1);
            int elDiag2 = (i + 1) * (N - 1);
            result1[i] = matrix[elDiag1];
            result2[i] = matrix[elDiag2];
        }
        String resultTxt1 = String.valueOf(result1);
        String resultTxt2 = String.valueOf(result2);
        if (txtWinnerX.equals(resultTxt1) || txtWinnerX.equals(resultTxt2)) {
            winner = winner + " X";
            return true;
        } else if (txtWinnerO.equals(resultTxt1) || txtWinnerO.equals(resultTxt2)) {
            winner = winner + " O";
            return true;
        }
        return false;
    }

    private static void outputBoard() {
        for (int i = 0; i < length; i++) {
            System.out.print(" " + matrix[i] + " ");
            if ((i) == 2 || (i) == 5 || (i) == 8) System.out.println();

        }
    }
}
