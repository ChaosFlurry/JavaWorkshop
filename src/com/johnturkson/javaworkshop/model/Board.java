package com.johnturkson.javaworkshop.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    List<Integer> squares = new ArrayList<>();
    
    public Board() {
        for (int i = 0; i < 9; i++) {
            squares.add(0);
        }
    }
    
    public int makeComputerMove() {
        Random random = new Random();
        while (true) {
            int position = random.nextInt(9);
            if (squares.get(position) == 0) {
                squares.set(position, -1);
                return position;
            }
        }
    }
    
    public void makeHumanMove(int position) {
        squares.set(position, 1);
    }
    
    public boolean hasWinner() {
        return (squares.get(0) + squares.get(1) + squares.get(2) == 3 ||
                squares.get(3) + squares.get(4) + squares.get(5) == 3 ||
                squares.get(6) + squares.get(7) + squares.get(8) == 3 ||
                squares.get(0) + squares.get(3) + squares.get(6) == 3 ||
                squares.get(1) + squares.get(4) + squares.get(7) == 3 ||
                squares.get(2) + squares.get(5) + squares.get(8) == 3 ||
                squares.get(0) + squares.get(4) + squares.get(8) == 3 ||
                squares.get(2) + squares.get(4) + squares.get(6) == 3)
                ||
                (squares.get(0) + squares.get(1) + squares.get(2) == -3 ||
                squares.get(3) + squares.get(4) + squares.get(5) == -3 ||
                squares.get(6) + squares.get(7) + squares.get(8) == -3 ||
                squares.get(0) + squares.get(3) + squares.get(6) == -3 ||
                squares.get(1) + squares.get(4) + squares.get(7) == -3 ||
                squares.get(2) + squares.get(5) + squares.get(8) == -3 ||
                squares.get(0) + squares.get(4) + squares.get(8) == -3 ||
                squares.get(2) + squares.get(4) + squares.get(6) == -3);
    }
    
    public boolean hasValidMove() {
        for (int i : squares) {
            if (i == 0) {
                return true;
            }
        }
        return false;
    }
    
    public void printBoard() {
        String board = "";
        board += "-------------\n";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int square = squares.get(i * 3 + j);
                if (square == 1) {
                    board += "| X ";
                } else if (square == -1) {
                    board += "| O ";
                } else {
                    board += "|   ";
                }
            }
            board += "|\n";
            board += "-------------\n";
        }
        System.out.println(board);
    }
}
