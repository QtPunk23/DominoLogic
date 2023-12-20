package org.example;

import java.util.List;
import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(List<DominoPiece> hand, DominoPool dominoPool) {
        super(hand, dominoPool);
        this.scanner = new Scanner(System.in);
    }

    public HumanPlayer(List<DominoPiece> hand, DominoPool dominoPool, boolean isGuiMode) {
        super(hand, dominoPool);
        // Если isGuiMode true, scanner не нужен
        if (!isGuiMode) {
            this.scanner = new Scanner(System.in);
        }
    }

    @Override
    public boolean makeMove(GameBoard board) {
        // Логика для консольного режима
        if (scanner != null) {
            System.out.println("Your hand: ");
            for (int i = 0; i < hand.size(); i++) {
                System.out.println((i + 1) + ": " + hand.get(i));
            }

            System.out.print("Select the number of the piece to play, or 0 to draw from the pool: ");
            String input = scanner.nextLine().trim();

            try {
                int index = Integer.parseInt(input) - 1;

                if (index == -1) {
                    return drawFromPool();
                } else if (index >= 0 && index < hand.size()) {
                    return playSelectedPiece(index, board);
                } else {
                    System.out.println("Invalid number. Please select a valid piece number.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return false;
    }

    private boolean drawFromPool() {
        if (!dominoPool.isEmpty()) {
            DominoPiece newPiece = dominoPool.drawPiece();
            hand.add(newPiece);
            System.out.println("You drew: " + newPiece);
            return false;
        } else {
            System.out.println("The pool is empty. You cannot draw.");
            return false;
        }
    }

    private boolean playSelectedPiece(int index, GameBoard board) {
        DominoPiece selectedPiece = hand.get(index);
        if (board.isPiecePlayable(selectedPiece)) {
            hand.remove(selectedPiece);
            board.addPiece(selectedPiece);
            return true;
        } else {
            System.out.println("Invalid move. Try again.");
            return false;
        }
    }

    public void addPieceToHand(DominoPiece piece) {
        hand.add(piece);
    }
}
