
/****************************************************************************************************************************************************
 *  @Author:         Corey M. Moura
 *  @Date:           March 1, 2018
 *  @Professor:      Dr. Trafftz
 *  @Project:        Project 3 of CS163: Chess Game, player vs computer 
 *  @Notes:               
 *                   
 *                   
/****************************************************************************************************************************************************/

public class Queen extends ChessPiece
{
    public Queen(Player player)
    {
        super(player);
    }

    public String type(){
        return "Queen";
    }

    public boolean isValidMove(Move move, IChessPiece[][] board) {
        boolean valid = true;
        int changeY = Math.abs(move.fromRow - move.toRow);
        int changeX = Math.abs(move.fromColumn - move.toColumn);

        if (!super.isValidMove(move,board)){
            return false;
        }

        /*********************   DIAGONAL CHECKS  *************************/

        /**  Checks the spaces diagonal up and right  **/  
        if((move.toRow < move.fromRow) && (move.toColumn > move.fromColumn)){   
            for(int i = 1; i < changeY ; i++){
                if(board[move.fromRow - i][move.fromColumn + i] != null){
                    valid = false;
                }
            }
        }
        /**  Checks the spaces diagonal up and left  **/  
        else if((move.toRow < move.fromRow) && (move.toColumn < move.fromColumn)){   
            for(int i = 1; i < changeY ; i++){
                if(board[move.fromRow - i][move.fromColumn - i] != null){
                    valid = false;
                }
            }
        }
        /**  Checks the spaces diagonal down and left **/  
        else if((move.toRow > move.fromRow) && (move.toColumn < move.fromColumn)){   
            for(int i = 1; i < changeY; i++){
                if(board[move.fromRow + i][move.fromColumn - i] != null){
                    valid = false;
                }
            }
        }
        /**  Checks the spaces diagonal down and right **/  
        else if((move.toRow > move.fromRow) && (move.toColumn > move.fromColumn)){   
            for(int i = 1; i < changeY; i++){
                if(board[move.fromRow + i][move.fromColumn + i] != null){
                    valid = false;
                }
            }
        }

        /*********************   HORIZONTAL CHECKS  *************************/

        /**  Checks the spaces below the Queen  **/  
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
