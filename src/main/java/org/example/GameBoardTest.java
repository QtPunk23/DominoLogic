package org.example;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {
    @Test
    void addPieceToBoard() {
        GameBoard board = new GameBoard();
        DominoPiece piece = new DominoPiece(3, 6);
        assertTrue(board.addPiece(piece));
        // Дополнительные проверки состояния доски
    }

    @Test
    void testIsPiecePlayable() {
        GameBoard board = new GameBoard();
        board.addPiece(new DominoPiece(3, 6));
        assertTrue(board.isPiecePlayable(new DominoPiece(6, 4)));
        assertFalse(board.isPiecePlayable(new DominoPiece(1, 5)));
    }
}
