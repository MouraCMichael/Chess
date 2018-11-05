
/****************************************************************************************************************************************************
 *  @Author:         Corey M. Moura
 *  @Date:           March 1, 2018
 *  @Professor:      Dr. Trafftz
 *  @Project:        Project 3 of CS163: Chess Game, player vs computer 
 *  @Notes:          
 *                   
 *                   
/****************************************************************************************************************************************************/

public class Move
{
    /**  Public variables Which are accessed through the ChessModel Class **/
    public int fromRow, fromColumn, toRow, toColumn;

    public Move() {
        
     }

    public Move(int fromRow, int fromColumn, int toRow, int toColumn) {
        this.fromRow = fromRow;
        this.fromColumn = fromColumn;
        this.toRow = toRow;
        this.toColumn = toColumn;
    }
    
    @Override
    public String toString() {
        return "Move [fromRow=" + fromRow + ", fromColumn=" + fromColumn + ", toRow=" + toRow + ", toColumn=" + toColumn + "]";
    }
}
