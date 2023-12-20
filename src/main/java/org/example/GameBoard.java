package org.example;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class GameBoard {
    private LinkedList<DominoPiece> boardPieces;
    private int leftValue;
    private int rightValue;

    public GameBoard() {
        boardPieces = new LinkedList<>();
        leftValue = -1;
        rightValue = -1;
    }

    public void clearBoard() {
        boardPieces.clear();
        leftValue = -1;
        rightValue = -1;
    }

    public List<DominoPiece> getPlayedPieces() {
        // Возвращаем неизменяемый список, чтобы предотвратить изменение внешним кодом
        return Collections.unmodifiableList(boardPieces);
    }
    public boolean addPiece(DominoPiece piece) {
        if (boardPieces.isEmpty()) {
            boardPieces.add(piece);
            leftValue = piece.getLeftValue();
            rightValue = piece.getRightValue();
            return true;
        }

        if (piece.getLeftValue() == rightValue || piece.getRightValue() == rightValue) {
            alignAndAdd(piece, true);
            return true;
        } else if (piece.getLeftValue() == leftValue || piece.getRightValue() == leftValue) {
            alignAndAdd(piece, false);
            return true;
        }

        return false; // Фишка не подходит для игры
    }

    private void alignAndAdd(DominoPiece piece, boolean addToRight) {
        if (addToRight) {
            if (piece.getLeftValue() == rightValue) {
                rightValue = piece.getRightValue();
                boardPieces.addLast(piece);
            } else {
                rightValue = piece.getLeftValue();
                boardPieces.addLast(new DominoPiece(piece.getRightValue(), piece.getLeftValue()));
            }
        } else {
            if (piece.getRightValue() == leftValue) {
                leftValue = piece.getLeftValue();
                boardPieces.addFirst(piece);
            } else {
                leftValue = piece.getRightValue();
                boardPieces.addFirst(new DominoPiece(piece.getRightValue(), piece.getLeftValue()));
            }
        }
    }

    public boolean isPiecePlayable(DominoPiece piece) {
        if (boardPieces.isEmpty()) {
            return true;
        }

        return piece.getLeftValue() == leftValue || piece.getRightValue() == leftValue
                || piece.getLeftValue() == rightValue || piece.getRightValue() == rightValue;
    }

    public LinkedList<DominoPiece> getBoardPieces() {
        return boardPieces;
    }


    // Метод для печати состояния доски
    public void printBoard() {
        if (boardPieces.isEmpty()) {
            System.out.println("The board is empty.");
            return;
        }

        System.out.print("Board: ");
        for (DominoPiece piece : boardPieces) {
            System.out.print("[" + piece.getLeftValue() + "|" + piece.getRightValue() + "] ");
        }
        System.out.println(); // Переход на новую строку
    }

    public boolean isPlayable() {
        // Если доска пуста, любая фишка может быть сыграна
        return boardPieces.isEmpty();
    }
}
