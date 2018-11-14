import java.util.Arrays;

public class TokenPass {
    int[] board;
    int currentPlayer;

    public TokenPass(int playerCount) {
        board = new int[playerCount];
        for (int i = 0; i < playerCount; i++)
            board[i] = (int) (10 * Math.random()) + 1;
        currentPlayer = (int) (playerCount * Math.random());
    }


    public void distributeCurrentPlayerTokens() {
        int numTokens = board[currentPlayer];
        board[currentPlayer] = 0;
        int i = currentPlayer;
        while (numTokens > 0) {
            i = (i + 1) % board.length;
            board[i]++;
            numTokens--;
        }
    }

    public void printBoard() {
        System.out.println(Arrays.toString(board));
    }

    public void nextPlayer() {
        currentPlayer++;
    }

    public int gameOver() {
        return java.util.Arrays.asList(board).indexOf(0);
    }
}
