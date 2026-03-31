import java.util.*;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char num = board[i][j];

                if(num == '.') continue;

                String rowKey = num + " in row " + i;
                String colKey = num + " in col " + j;
                String boxKey = num + " in box " + (i / 3) + "-" + (j / 3);

                if(!seen.add(rowKey) ||
                   !seen.add(colKey) ||
                   !seen.add(boxKey)){
                    return false;
                }
            }
        }
        return true;
    }

    // 🔥 Board print function
    public static void printBoard(char[][] board){
        for(int i = 0; i < 9; i++){
            if(i % 3 == 0 && i != 0){
                System.out.println("------+-------+------");
            }

            for(int j = 0; j < 9; j++){
                if(j % 3 == 0 && j != 0){
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println("Sudoku Board:");
        printBoard(board);

        boolean result = isValidSudoku(board);

        System.out.println("\nIs Valid Sudoku: " + result);
    }
}