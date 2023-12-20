package org.example;

import java.util.List;

public interface PlayStrategy {
    boolean makeMove(GameBoard board, List<DominoPiece> hand,DominoPool pool);
}
