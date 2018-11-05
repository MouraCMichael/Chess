
/****************************************************************************************************************************************************
 *  @Author:         Corey M. Moura
 *  @Date:           March 1, 2018
 *  @Professor:      Dr. Trafftz
 *  @Project:        Project 3 of CS163: Chess Game, player vs computer 
 *  @Notes:               
 *                   
 *                   
/****************************************************************************************************************************************************/

public class Knight extends ChessPiece
{
    public Knight(Player player)
    {
        super(player);
    }

    public String type(){
        return "Knight";
    }

    public boolean isValidMove(Move move, IChessPiece[][] board) {
        boolean valid = false;
        if (!super.isValidMove(move,board)){
            return false;
        }

        /**  Position 1 **/        
        if((move.toRow == move.fromRow - 1) && (move.toColumn == move.fromColumn + 2)){
            valid = true;
        } 

        /**  Position 2 **/ 
        else if((move.toRow == move.fromRow - 2) && (move.toColumn == move.fromColumn + 1)){
            valid = true;
        }  

        /**  Position 3 **/ 
        else if((move.toRow == move.fromRow - 2) && (move.toColumn == move.fromColumn - 1)){
            valid = true;
        } 

        /**  Position 4 **/ 
        else if((move.toRow == move.fromRow - 1) && (move.toColumn == move.fromColumn - 2)){
            valid = true;
        }

        /**  Position 5 **/ 
        else if((move.toRow == move.fromRow + 1) && (move.toColumn == move.fromColumn - 2)){
            valid = true;
        }

        /**  Position 6 **/ 
        else if((move.toRow == move.fromRow + 2) && (move.toColumn == move.fromColumn - 1)){
            valid = true;
        }

        /**  Position 7 **/
        else if((move.toRow == move.fromRow + 2) && (move.toColumn == move.fromColumn + 1)){
            valid = true;
        }

        /**  Position 8 **/
        else if((move.toRow == move.fromRow + 1) && (move.toColumn == move.fromColumn + 2)){
            valid = true;
        }
        return valid;
    }
}
