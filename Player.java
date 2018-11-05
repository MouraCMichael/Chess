
/****************************************************************************************************************************************************
 *  @Author:         Corey M. Moura
 *  @Date:           March 1, 2018
 *  @Professor:      Dr. Trafftz
 *  @Project:        Project 3 of CS163: Chess Game, player vs computer 
 *  @Notes:          
 *                   
 *                   
/****************************************************************************************************************************************************/

public enum Player
{
    BLACK, WHITE;           //black is 0 white is 1

    /**
     * Return the {@code Player} whose turn is next.
     *
     * @return the {@code Player} whose turn is next
     */
    public Player next() {  
        if(this == BLACK){
            return WHITE;
        }
        else{
            return BLACK;
        }
    }
    //return this == BLACK ? WHITE : BLACK;
}

