/****************************************************************************************************************************************************
 *  @Author:         Corey M. Moura
 *  @Date:           March 1, 2018
 *  @Professor:      Dr. Trafftz
 *  @Project:        Project 3 of CS163: Chess Game, player vs computer 
 *  
 *  @Notes:          The ChessModel class implements the IChessModel interface.
 *                   
 *                   This class is responsible for storing the chessboard and implementing the game logic.
 *                   Implement the methods from the IChessModel interface.
 *                                   
/****************************************************************************************************************************************************/

public class ChessModel implements IChessModel {
    private IChessPiece[][] board;
    public Player player;

    final private int BLACK = 0, WHITE = 1;;
    private int size = 8;

    public ChessModel() {  
        player = Player.BLACK;
        board = new ChessPiece[size][size];

        /**  Set the board locations with the white pieces  **/ 
        board[0][0] = new Rook(player.WHITE);            board[1][0] = new Pawn(player.WHITE);      
        board[0][1] = new Knight(player.WHITE);          board[1][1] = new Pawn(player.WHITE);           
        board[0][2] = new Bishop(player.WHITE);          board[1][2] = new Pawn(player.WHITE);              
        board[0][3] = new Queen(player.WHITE);           board[1][3] = new Pawn(player.WHITE);        
        board[0][4] = new King(player.WHITE);            board[1][4] = new Pawn(player.WHITE);               
        board[0][5] = new Bishop(player.WHITE);          board[1][5] = new Pawn(player.WHITE);           
        board[0][6] = new Knight(player.WHITE);          board[1][6] = new Pawn(player.WHITE);          
        board[0][7] = new Rook(player.WHITE);            board[1][7] = new Pawn(player.WHITE);             

        /**  Set the board locations with the black pieces  **/ 
        board[7][0] = new Rook(player.BLACK);           board[6][0] = new Pawn(player.BLACK);
        board[7][1] = new Knight(player.BLACK);         board[6][1] = new Pawn(player.BLACK);
        board[7][2] = new Bishop(player.BLACK);         board[6][2] = new Pawn(player.BLACK); 
        board[7][3] = new King(player.BLACK);           board[6][3] = new Pawn(player.BLACK);
        board[7][4] = new Queen(player.BLACK);          board[6][4] = new Pawn(player.BLACK);    
        board[7][5] = new Bishop(player.BLACK);         board[6][5] = new Pawn(player.BLACK);
        board[7][6] = new Knight(player.BLACK);         board[6][6] = new Pawn(player.BLACK); 
        board[7][7] = new Rook(player.BLACK);           board[6][7] = new Pawn(player.BLACK); 

        for(int row = 2; row < 6; row++){
            for(int col = 0; col < size; col++)
                board[row][col] = null;
        }
    }

    public boolean isComplete() {
        return false;
    }

    public boolean isValidMove(Move move) {
        boolean valid = false;

        /** If there is a piece occupying the destination  **/
        if(board[move.fromRow][move.fromColumn] != null) {
            /**  isValid(move, board) returns false if current position is destination; not the owneer of piece; try to move somewhere occupied by your other pieces  **/ 
            if(board[move.fromRow][move.fromColumn].isValidMove(move, board) == true){
                valid = true;
            }
        }
        return valid;
    }

    public void move(Move move) {       
        board[move.toRow][move.toColumn] = board[move.fromRow][move.fromColumn];
        board[move.fromRow][move.fromColumn] = null;
    }

    public boolean inCheck(Player p) {
        return false;
    }

    public Player currentPlayer() { 
        return player;
    } 

    public int numRows() {
        return size;
    }

    public int numColumns() {
        return size;
    }

    public IChessPiece pieceAt(int row, int column) { 
        return board[row][column];
    }

    public Player nextPlayer(){
        player = player.next();
        return player;
    }
}

