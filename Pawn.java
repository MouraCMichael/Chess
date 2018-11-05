
/****************************************************************************************************************************************************
 *  @Author:         Corey M. Moura
 *  @Date:           March 1, 2018
 *  @Professor:      Dr. Trafftz
 *  @Project:        Project 3 of CS163: Chess Game, player vs computer 
 *  @Notes:               
 *                   
 *                   
/****************************************************************************************************************************************************/

public class Pawn extends ChessPiece
{
    public Pawn(Player player) {
        super(player);
    }

    public String type() {
        return "Pawn";
    }

    public boolean isValidMove(Move move,IChessPiece[][] board) {        
        boolean valid = false;

        if (!super.isValidMove(move,board)){
            return false;
        }

        if (board[move.fromRow][move.fromColumn].player() == Player.WHITE) {
            if (((move.toRow - 1 == move.fromRow) && (move.toColumn + 1 == move.fromColumn)) 
            || ((move.toRow - 1 == move.fromRow) && (move.toColumn - 1 == move.fromColumn)))       // checks to see if the piece is being moved diagonally down and over one space
                if (board[move.toRow][move.toColumn] != null)           // checks to see if this piece is taking another player's piece
                    valid = true;

            if (move.fromRow == 1)          // checks to see if this piece is a black pawn in row 2 (can move pawns 2 spaces from the starting position)

                if ((move.toColumn == move.fromColumn) && (move.toRow == 3))        // checks to see if this piece is being moved 2 spaces forward

                    if ((board[2][move.fromColumn]) == null && (board[3][move.fromColumn]) == null)     // checks to see if this piece has a clear path
                        valid = true;

            if ((move.toColumn == move.fromColumn) && (move.toRow - 1 == move.fromRow))         // checks to see if this piece is being moved down one row from the top 
                if ((board[move.toRow][move.toColumn]) == null)         // checks to see if this piece has a clear path
                    valid = true;
        }

        else if (board[move.fromRow][move.fromColumn].player() == Player.BLACK) {       // checks to see if it is black's turn
            if (((move.toRow + 1 == move.fromRow) && (move.toColumn + 1 == move.fromColumn))
            || ((move.toRow + 1 == move.fromRow) && (move.toColumn - 1 == move.fromColumn)))        // checks to see if the piece is being moved diagonally up and over one space

                if (board[move.toRow][move.toColumn] != null)       // checks to see if this piece is taking another player's piece
                    valid = true;

            if (move.fromRow == 6)      // checks to see if this piece is a black pawn in row 7
                if ((move.toColumn == move.fromColumn) && (move.toRow == 4)){        // checks to see if this piece is being moved 2 spaces forward
                    if ((board[5][move.fromColumn]) == null && (board[4][move.fromColumn]) == null){     // checks to see if this piece has a clear path
                        valid = true;
                    }
                }
            if ((move.toColumn == move.fromColumn) && (move.toRow + 1 == move.fromRow))     // checks to see if this piece is being moved up one row

                if ((board[move.toRow][move.toColumn]) == null)         // checks to see if this piece has a clear path
                    valid = true;
        }

        return valid;
    }
}
