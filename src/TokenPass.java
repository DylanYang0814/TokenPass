import java.util.Arrays;

public class TokenPass {
    int[] board;
    int currentPlayer;

    public TokenPass(int playerCount) {
        board = new int[playerCount];
        for (int i = 0; i < playerCount; i++) {
            board[i] = (int) (10 * Math.random()) + 1;
        }
        currentPlayer = (int) (playerCount * Math.random());
        System.out.println("Current Player " + currentPlayer);
    }


    public void distributeCurrentPlayerTokens() {
        int numTokens = board[currentPlayer];
        System.out.println("numTokens : " + numTokens);
        board[currentPlayer] = 0;
        int i = currentPlayer;
        while (numTokens > 0) {
            i = (i + 1) % board.length;
            board[i]++;
            numTokens--;
        }
    }

    public void printBoard() {
        //System.out.println(Arrays.toString(board));

        String display = "[ ";
        for (int i=0;i<board.length;i++)
        {
            display += board[i] + ", ";
        }
        display += "]";
        System.out.println(display);
    }

    public void nextPlayer() {
        currentPlayer = (currentPlayer + 1) % board.length;
    }

    public int gameOver() {
        for (int i = 0; i<board.length; i++)
        {
            if (board[i] == 0)
            {
                return i;
            }
        }
        return -1;
    }
}
