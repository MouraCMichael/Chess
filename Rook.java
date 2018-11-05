
/****************************************************************************************************************************************************
 *  @Author:         Corey M. Moura
 *  @Date:           March 1, 2018
 *  @Professor:      Dr. Trafftz
 *  @Project:        Project 3 of CS163: Chess Game, player vs computer 
 *  @Notes:               
 *                                
/****************************************************************************************************************************************************/

public class Rook extends ChessPiece
{ 
    private Player owner;

    public Rook(Player player)
    {
        super(player);
    }

    public String type(){
        return "Rook";
    }

    public boolean isValidMove(Move move, IChessPiece[][] board) { 
        int changeY = Math.abs(move.fromRow - move.toRow);
        int changeX = Math.abs(move.fromColumn - move.toColumn);

        boolean valid = true;

        /**  Checks that the move is on the board  **/
        if (!super.isValidMove(move,board)){
            return false;
        } 
        /** Checks that your either moving in the same row or same column  **/ 
        else if((move.fromRow != move.toRow) && (move.fromColumn != move.toColumn)){
            valid = false;
        }
        /**  Checks the spaces below the rook  **/  
        else if(move.toRow > move.fromRow){   
            for(int i = 1; i < changeY ; i++){
                if(board[move.fromRow + i][move.fromColumn] != null){
                    valid = false;
                }
            }
        }
        /**  Checks the spaces above the rook  **/ 
        else if(move.toRow < move.fromRow){   
            for(int i = 1; i < changeY ; i++){
                if(board[move.fromRow - i][move.fromColumn] != null){
                    valid = false;
                }
            }
        }        
        /**  Checks the spaces right of rook  **/ 
        else if(move.toColumn > move.fromColumn){   
            for(int i = 1; i < changeX ; i++){
                if(board[move.fromRow][move.fromColumn + i] != null){
                    valid = false;
                }
            }
        } 
        /**  Checks the spaces left of rook  **/ 
        else if(move.toColumn < move.fromColumn){   
            for(int i = 1; i < changeX ; i++){
                if(board[move.fromRow][move.fromColumn - i] != null){
                    valid = false;
                }
            }
        } 

        return valid;
    } 
}

