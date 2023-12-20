package org.example;

import java.util.List;

public abstract class Player {
    protected List<DominoPiece> hand;
    protected DominoPool dominoPool;

    public Player(List<DominoPiece> hand, DominoPool dominoPool) {
        this.hand = hand;
        this.dominoPool = dominoPool;
    }

    public void setHand(List<DominoPiece> hand) {
        this.hand = hand;
    }

    public abstract boolean makeMove(GameBoard board);



    public boolean hasWon(){
        return hand.isEmpty();
    }

    public List<DominoPiece> getHand() {
        return hand;
    }
    public boolean hasPlayablePiece(GameBoard board) {
        return hand.stream().anyMatch(piece -> board.isPiecePlayable(piece));
    }
}
