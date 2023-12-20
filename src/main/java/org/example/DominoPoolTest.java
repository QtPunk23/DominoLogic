package org.example;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DominoPoolTest {
    @Test
    void testDrawPiece() {
        DominoPool pool = new DominoPool();
        assertNotNull(pool.drawPiece());
    }

    @Test
    void testIsEmpty() {
        DominoPool pool = new DominoPool();
        // Продолжите брать фишки, пока "Базар" не опустеет
        while (!pool.isEmpty()) {
            pool.drawPiece();
        }
        assertTrue(pool.isEmpty());
    }
}
