package org.example;

import java.util.Objects;

public class DominoPiece {
    private final int leftValue;
    private final int rightValue;

    public DominoPiece(int leftValue,int rightValue){
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    public int getLeftValue() {
        return leftValue;
    }

    public int getRightValue() {
        return rightValue;
    }

    public boolean matches(DominoPiece other){
        return this.leftValue == other.leftValue || this.leftValue == other.rightValue
                || this.rightValue == other.leftValue || this.rightValue == other.leftValue;
    }

    @Override
    public String toString(){
        return "[" + leftValue + "|" + rightValue + "]";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DominoPiece that = (DominoPiece) o;
        return leftValue == that.leftValue && rightValue == that.rightValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftValue, rightValue);
    }
}
