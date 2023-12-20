package org.example;

import java.util.List;

public class ComputerPlayer extends Player {
    private PlayStrategy strategy;

    // Измените конструктор, чтобы он принимал стратегию
    public ComputerPlayer(List<DominoPiece> hand, DominoPool dominoPool, PlayStrategy strategy) {
        super(hand, dominoPool);
        this.strategy = strategy;
    }

    @Override
    public boolean makeMove(GameBoard board) {
        return strategy.makeMove(board, hand, dominoPool);
    }

    public void addPieceToHand(DominoPiece piece) {
        hand.add(piece);
    }
}
