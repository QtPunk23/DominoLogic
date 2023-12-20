package org.example;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DominoPieceTest {
    @Test
    void createDominoPiece() {
        DominoPiece piece = new DominoPiece(3, 6);
        assertNotNull(piece);
        assertEquals(3, piece.getLeftValue());
        assertEquals(6, piece.getRightValue());
    }

    @Test
    void testEquality() {
        DominoPiece piece1 = new DominoPiece(3, 6);
        DominoPiece piece2 = new DominoPiece(3, 6);
        assertEquals(piece1, piece2);
    }
}
