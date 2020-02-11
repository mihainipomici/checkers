import java.util.Scanner;
public class assign1 {
    private static int player;

    public static void main(String[] args) {

        int[][] board = {
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {2, 0, 2, 0, 2, 0, 2, 0},
                {0, 2, 0, 2, 0, 2, 0, 2},
                {2, 0, 2, 0, 2, 0, 2, 0}
        };
        player = 1;
        Scanner s = new Scanner(System.in);

        printTable(board);
        System.out.println("Turn of player no. 1");
        System.out.println("Coordinate of piece to move");
        System.out.println("  Enter X: ");
        int sx = s.nextInt();
        System.out.println("  Enter Y: ");
        int sy = s.nextInt();
        checkStart(player, board, sx,sy);
        checkNext(player, board, sx, sy);
    }

    public static void printTable(int[][] board) {
        System.out.println("   0 1 2 3 4 5 6 7    <- X axis");
        System.out.println("  +----------------+");
        for (int i = 0; i < board.length; i++) {         //this equals to the row in our matrix.
            System.out.print(i + " ");
            System.out.print("|");

            for (int j = 0; j < board[i].length; j++) {   //this equals to the column in each row.
                if (board[i][j] == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("  +----------------+");
        System.out.println("   0 1 2 3 4 5 6 7");
    }

    // This method will check the order of the turn of the player as well as if
    // the initially selected piece is allowed to move
    public static void checkStart(int player, int[][] board, int sx, int sy) {
        //check if it's the right player's moove
        if (player == 1){
            System.out.println("Turn of player no. 1");
        } else {
            System.out.println("Turn of player no. 2");
        }


//        boolean start_cord = false;
        while (true) {

            if (sx > 7 || sy > 7) {
                System.out.println("Wrong coordinate of piece to move. Reenter the coordinates.");
                System.out.println("New coordinate of piece to move.");
                continue;
            } else if (board[sy][sx] == 0) {
                System.out.println("Wrong coordinate of piece to move. Reenter the coordinates.");
                System.out.println("New coordinate of piece to move.");
                continue;
            } else if (board[sy][sx] == player) {
                //the direction of the move
                int sign = -2 * player + 3;
                int fy = sy + sign;
                int fx1 = sx + 1;
                int fx2 = sx - 1;
                if ((board[fy][fx1] != 0) && (board[fy][fx2] != 0)) {
                    System.out.println("Wrong coordinate of piece to move. Reenter the coordinates.");
                    System.out.println("New coordinate of piece to move.");
                    continue;
                }

            } else {
                System.out.println("Error");
                ;
            }
            break;


        }
    }

    public static void checkNext(int player, int[][] board, int sx, int sy) {
//           insert the coordinate of the new position
        Scanner sc = new Scanner(System.in);
        System.out.println("Coordinate of the new position");
        System.out.println("  Enter X: ");
        int nx = sc.nextInt();
        System.out.println("  Enter Y: ");
        int ny = sc.nextInt();
//check the validity of the new position
        while (true) {
            if (board[ny][nx] == 0) {
                int diff_x = nx - sx;
                int diff_y = ny - sy;
//       if player 1 diff_y = 1
//       if player 2 diff_y = -1
                int sign = -2 * player + 3;
                if (diff_y == 1 * sign) {
                    if (Math.abs(diff_x) == 1) {
                        board[ny][nx] = player;
                        board[sy][sx] = 0;


                    } else {


                    }
                }

            }
            if (player == 1) {
                player = 2;

            } else {
                player = 1;
            }
            break;
        }


    }
}
