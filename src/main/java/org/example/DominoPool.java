package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DominoPool {
    private List<DominoPiece> pieces;

    public DominoPool() {
       pieces = new ArrayList<>();
       for (int i = 0; i<=6;i++){
           for(int j =0; j <=6;j++){
               pieces.add(new DominoPiece(i,j));
           }
       }
        Collections.shuffle(pieces);
    }

    public boolean isEmpty(){
        return pieces.isEmpty();
    }

    public DominoPiece drawPiece(){
        if (!pieces.isEmpty()){
            return pieces.remove(0);
        }
        return null;
    }

    public List<DominoPiece> drawHand(int numberOfPieces) {
        List<DominoPiece> hand = new ArrayList<>();
        for (int i =0;i < numberOfPieces;i ++){
            if (!pieces.isEmpty()){
                hand.add(pieces.remove(0));
            }else {
                break;
            }
        }
        return hand;
    }

    public void resetPool() {
        pieces.clear();
        // Здесь предполагается, что DominoPiece имеет конструктор принимающий два значения
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) { // Обратите внимание на j = i, чтобы избежать дублирования
                pieces.add(new DominoPiece(i, j));
            }
        }
        Collections.shuffle(pieces);
    }


}
