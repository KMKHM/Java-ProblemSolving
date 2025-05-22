package baekjoon.gold;

import java.util.*;
import java.io.*;

public class Main {
    static int[][] sudoku = new int[9][9];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int zeroCount=0;

        for (int i=0; i<9; i++) {
            String s = br.readLine();
            for (int j=0; j<9; j++) {
                sudoku[i][j] = s.charAt(j) - '0';
                if (sudoku[i][j] == 0) {
                    zeroCount++;
                }
            }
        }

        System.out.println(Arrays.deepToString(sudoku));

    }

    static void backtracking(int zeroCount) {

        if (zeroCount ==0 && checkRow() && checkCol()) {
            for (int i=0; i<9; i++) {
                for (int j=0; j<9; j++) {
                    System.out.print(sudoku[i][j]);
                }
                System.out.println();
            }
            return;
        }

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (sudoku[i][j] == 0) {
                    for (int k=1; k<=9; k++) {
                        sudoku[i][j] = k;
                        backtracking(zeroCount--);
                        sudoku[i][j] = 0;
                    }
                }
            }
        }
    }

    static  boolean checkRow() {
        int[] check = new int[10];

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (sudoku[i][j] != 0) {
                    check[sudoku[i][j]]++;
                    if (check[sudoku[i][j]] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static boolean checkCol() {
        int[] check = new int[10];

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (sudoku[j][i] != 0) {
                    check[sudoku[j][i]]++;
                    if (check[sudoku[j][i]] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
