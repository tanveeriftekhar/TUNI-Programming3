package fi.tuni.prog3.sudoku;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Sudoku {
    private char[][] grid;

    public Sudoku() {
        grid = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public void set(int i, int j, char c) {
        if (i < 0 || i > 8 || j < 0 || j > 8) {
            System.out.println("Trying to access illegal cell (" + i + ", " + j + ")!");
            return;
        }
        if (c != ' ' && (c < '1' || c > '9')) {
            System.out.println("Trying to set illegal character " + c + " to (" + i + ", " + j + ")!");
            return;
        }
        grid[i][j] = c;
    }

    public boolean check() {
  
        for (int i = 0; i < 9; i++) {
            if (!checkRow(i)) {
                return false;
            }
        }


        for (int j = 0; j < 9; j++) {
            if (!checkColumn(j)) {
                return false;
            }
        }

 
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!checkSubgrid(i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkRow(int row) {
        boolean[] used = new boolean[10];
        for (int j = 0; j < 9; j++) {
            char c = grid[row][j];
            if (c != ' ') {
                int digit = c - '0';
                if (used[digit]) {
                    System.out.println("Row " + row + " has multiple " + c + "'s!");
                    return false;
                }
                used[digit] = true;
            }
        }
        return true;
    }

    private boolean checkColumn(int col) {
        boolean[] used = new boolean[10];
        for (int i = 0; i < 9; i++) {
            char c = grid[i][col];
            if (c != ' ') {
                int digit = c - '0';
                if (used[digit]) {
                    System.out.println("Column " + col + " has multiple " + c + "'s!");
                    return false;
                }
                used[digit] = true;
            }
        }
        return true;
    }

    private boolean checkSubgrid(int startRow, int startCol) {
        boolean[] used = new boolean[10];
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                char c = grid[i][j];
                if (c != ' ') {
                    int digit = c - '0';
                    if (used[digit]) {
                        System.out.println("Block at (" + startRow + ", " + startCol + ") has multiple " + c + "'s!");
                        return false;
                    }
                    used[digit] = true;
                }
            }
        }
        return true;
    }

    public void print() {

        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) {
                System.out.println("#####################################");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0) {
                    System.out.print("#");
                }
                System.out.print(" " + grid[i][j] + " ");
                if (j == 8) {
                    System.out.print("#");
                } else {
                    if(j!=2 && j!=5 )
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i == 8) {
                System.out.println("#####################################");
            } else {
                if(i!=2 && i!=5)
                System.out.println("#---+---+---#---+---+---#---+---+---#");
            }
        }
    }
    
    
}
