
/****************************************************************************************************************************************************
 *  @Author:         Corey M. Moura
 *  @Date:           March 1, 2018
 *  @Professor:      Dr. Trafftz
 *  @Project:        Project 3 of CS163: Chess Game, player vs computer 
 *  @Notes:               
 *                   
 *                   
/****************************************************************************************************************************************************/

public class Bishop extends ChessPiece
{
    public Bishop(Player player){
        super(player);
    }

    public String type(){
        return "Bishop";
    }

    public boolean isValidMove(Move move, IChessPiece[][] board) {
        int changeY = Math.abs(move.fromRow - move.toRow);
        int changeX = Math.abs(move.fromColumn - move.toColumn);

        /**  Checks that the move is on the board  **/
        if (!super.isValidMove(move,board)){
            return false;
        }  
        else if((move.fromRow == move.toRow) || (move.fromColumn == move.toColumn) || (changeY != changeX)){
            return false;
        }
        /**  Checks the spaces diagonal up and right  **/  
        else if((move.toRow < move.fromRow) && (move.toColumn > move.fromColumn)){   
            for(int i = 1; i < changeY ; i++){
                if(board[move.fromRow - i][move.fromColumn + i] != null){
                    return false;
                }
            }
        }
        /**  Checks the spaces diagonal up and left  **/  
        else if((move.toRow < move.fromRow) && (move.toColumn < move.fromColumn)){   
            for(int i = 1; i < changeY ; i++){
                if(board[move.fromRow - i][move.fromColumn - i] != null){
                    return false;
                }
            }
        }
        /**  Checks the spaces diagonal down and left **/  
        else if((move.toRow > move.fromRow) && (move.toColumn < move.fromColumn)){   
            for(int i = 1; i < changeY; i++){
                if(board[move.fromRow + i][move.fromColumn - i] != null){
                    return false;
                }
            }
        }
        /**  Checks the spaces diagonal down and right **/  
        else if((move.toRow > move.fromRow) && (move.toColumn > move.fromColumn)){   
            for(int i = 1; i < changeY; i++){
                if(board[move.fromRow + i][move.fromColumn + i] != null){
                    return false;
                }
            }
        }
        return true;
    }
}

