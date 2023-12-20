package org.example;

public class GameController {
    private HumanPlayer humanPlayer;
    private ComputerPlayer computerPlayer;
    private GameBoard board;
    private DominoPool dominoPool;

    public GameController() {
        this.dominoPool = new DominoPool();
        this.board = new GameBoard();

        // Создайте стратегию для ComputerPlayer
        PlayStrategy computerStrategy = new RandomPlayStrategy(); // или другая стратегия

        // Инициализация игроков
        this.humanPlayer = new HumanPlayer(dominoPool.drawHand(7), dominoPool);
        this.computerPlayer = new ComputerPlayer(dominoPool.drawHand(7), dominoPool, computerStrategy);

        startGameConsole();
    }

    private void startGameConsole() {
        boolean humanTurn = true;

        while (!isGameOver()) {
            if (humanTurn) {
                System.out.println("Human player's turn.");
                if (playTurn(humanPlayer)) {
                    board.printBoard(); // Выводим состояние доски после хода человека
                } else if (!dominoPool.isEmpty()) {
                    humanPlayer.addPieceToHand(dominoPool.drawPiece());
                }
            } else {
                System.out.println("Computer player's turn.");
                if (playTurn(computerPlayer)) {
                    board.printBoard(); // Выводим состояние доски после хода компьютера
                }
            }
            printMoveSeparator();
            humanTurn = !humanTurn;
        }

        declareWinner();
    }

    private boolean playTurn(Player player) {
        if (player.hasPlayablePiece(board)) {
            return player.makeMove(board);
        } else {
            System.out.println("No playable pieces. Player must draw from the pool.");
            return false;
        }
    }

    private boolean isGameOver() {
        return humanPlayer.hasWon() || computerPlayer.hasWon() || dominoPool.isEmpty();
    }

    private void declareWinner() {
        if (humanPlayer.hasWon()) {
            System.out.println("Human player wins!");
        } else if (computerPlayer.hasWon()) {
            System.out.println("Computer player wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private void printMoveSeparator() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
