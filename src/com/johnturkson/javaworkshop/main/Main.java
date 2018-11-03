package com.johnturkson.javaworkshop.main;

import com.johnturkson.javaworkshop.model.Board;
import com.johnturkson.javaworkshop.util.Reader;

import java.io.IOException;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("Hello World"); // prints "Hello World"
        Board board = new Board();
        while (true) {
            try {
                if (!board.hasValidMove()) {
                    System.out.println("It's a draw.");
                    break;
                }
                System.out.println("Human's move: ");
                int humanMove = Integer.parseInt(Reader.getInput());
                board.makeHumanMove(humanMove);
                board.printBoard();
                if (board.hasWinner()) {
                    System.out.println("Human wins.");
                    break;
                }
                
                if (!board.hasValidMove()) {
                    System.out.println("It's a draw.");
                    break;
                }
                System.out.println("Computer's move: " + board.makeComputerMove());
                System.out.println("Board: ");
                board.printBoard();
                if (board.hasWinner()) {
                    System.out.println("Computer wins.");
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
