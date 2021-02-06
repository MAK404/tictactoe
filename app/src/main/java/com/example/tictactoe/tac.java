package com.example.tictactoe;

public class tac{
     public static int pos;

    static class Move
        {
            int bespos;
        };

        static int player = 0;
        static int opponent =1;


        // This function returns true if there are moves
// remaining on the board. It returns false if
// there are no moves left to play.
        static Boolean isMovesLeft(int[] board)
        {
            for (int i = 0; i < 9; i++)
            {
                if(board[i]==2)
                    return true;
            }
            return false;
        }

        // This is the evaluation function as discussed
// in the previous article ( http://goo.gl/sJgv68 )
        static int evaluate(int[] board, int[][] winningboard) {

            for (int[] wins : winningboard) {
                if (board[wins[0]] == board[wins[1]] && board[wins[1]] == board[wins[2]] && board[wins[0]] != 2) {
                    if (board[wins[0]] == 0) {
                        return 10;
                    } else
                        return -10;
                }
            }
            return 0;
        }

        // This is the minimax function. It considers all
// the possible ways the game can go and returns
// the value of the board
        static int minimax(int [] board,int [][] winningboard,Boolean isMax,int depth)
        {
            int score = evaluate(board,winningboard);

            // If Maximizer has won the game
            // return his/her evaluated score
            if (score == 10)
                return score-depth;

            // If Minimizer has won the game
            // return his/her evaluated score
            if (score == -10)
                return score+depth;

            // If there are no more moves and
            // no winner then it is a tie
            if (isMovesLeft(board))
                return 0;

            // If this maximizer's move
            if (isMax)
            {
                int best = -1000;

                // Traverse all cells
                for (int i = 0; i < 9; i++) {
                    if (board[i] == 2) {
                        board[i] = player;
                    }
                    best = Math.max(best, minimax(board, winningboard, !isMax,depth+1));

                    board[i] = 2;

                }
                return best;
            }

            // If this minimizer's move
            else
            {
                int best = 1000;
                for (int i = 0; i < 9; i++) {
                    if (board[i] == 2) {
                        board[i] = opponent;
                    }
                    best = Math.min(best, minimax(board, winningboard, !isMax,depth+1));
                    board[i] = 2;
                }
                return best;
            }
        }

        // This will return the best possible
// move for the player
        static Move findBestMove(int[]board,int[][] winningboard,int count)
        {
            int bestVal = -1000;
            Move bestMove = new Move();
            bestMove.bespos = -1;

            // Traverse all cells, evaluate minimax function
            // for all empty cells. And return the cell
            // with optimal value.
            if(count==1)
            {
                for(int i=0;i<9;i++)
                {
                    if(board[i]==2)
                    {
                        bestMove.bespos=i;
                    }
                }
            }
            else {
                for (int i = 0; i < 9; i++) {// Check if cell is empty
                    if (board[i] == 2) {
                        // Make the move
                        board[i] = player;

                        // compute evaluation function for this
                        // move.
                        int moveVal = minimax(board, winningboard, false,0);

                        // Undo the move
                        board[i] = 2;

                        // If the value of the current move is
                        // more than the best value, then update
                        // best/
                        if (moveVal > bestVal) {
                            bestMove.bespos = i;
                            bestVal = moveVal;
                        }
                    }

                }
            }
            System.out.println(bestMove.bespos);
            return bestMove;

        }
        public static int count(int[] board)
        {int countthem=0;
            for (int i=0;i<9;i++)
            {
                if(board[i]==2)
                {
                    countthem++;
                }
            }
            return countthem;
        }
}

