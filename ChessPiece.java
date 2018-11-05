/****************************************************************************************************************************************************
 *  @Author:         Corey M. Moura
 *  @Date:           March 1, 2018
 *  @Professor:      Dr. Trafftz
 *  @Project:        Project 3 of CS163: Chess Game, player vs computer 
 *  
 *  @Notes:          ChessPiece class will check if the move you selected is valid
 *                                               
/****************************************************************************************************************************************************/

public abstract class ChessPiece implements IChessPiece
{    
    private Player owner;

    public ChessPiece(Player player){      
        this.owner = player;       
    }

    public abstract String type();

    /**  Return the player that owns this piece.  **/
    public Player player() {
        return owner;
    }

    /**  This method is invoked by each piece's class, because these are common, valid move peramiters to all  **/
    public boolean isValidMove(Move move,IChessPiece[][] board) {

        /**  You cant move to your current location  **/
        if ((move.fromRow == move.toRow) && (move.fromColumn == move.toColumn)) {
            return false;
        }

        /**  If your not the owner of the selected piece this is not a valid move  **/
        if ( this != board[move.fromRow][move.fromColumn] ) {
            return false;
        }

        /**  You cant move to a location occupied by your own piece, so if there is a piece and the piece is yours that is not a valid move.  **/
        if((board[move.toRow][move.toColumn] != null) && (board[move.toRow][move.toColumn].player() == owner)) {
            return false;
        }

        return true;
    }
}

