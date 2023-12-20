package org.example;



import java.util.List;
import java.util.Random;

public class RandomPlayStrategy implements PlayStrategy {
    private Random random = new Random();

    @Override
    public boolean makeMove(GameBoard board, List<DominoPiece> hand, DominoPool pool) {
        if (hand.isEmpty()) {
            return false;
        }

        // Пытаемся сыграть случайную фишку из руки
        int attempts = hand.size();
        while (attempts > 0) {
            int index = random.nextInt(hand.size());
            DominoPiece piece = hand.get(index);
            if (board.isPiecePlayable(piece)) {
                hand.remove(piece);
                board.addPiece(piece);
                return true;
            }
            attempts--;
        }

        // Если нет подходящей фишки, берем фишку из пула
        if (!pool.isEmpty()) {
            hand.add(pool.drawPiece());
        }

        return false;
    }
}
