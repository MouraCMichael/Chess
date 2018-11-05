/****************************************************************************************************************************************************
 *  @Author:         Corey M. Moura
 *  @Date:           March 1, 2018
 *  @Professor:      Dr. Trafftz
 *  @Project:        Project 3 of CS163: Chess Game, player vs computer 
 *  @Notes:                  
 *                   
 *                   
/****************************************************************************************************************************************************/

/** Libraries used for the creation of this GUI **/
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChessPanel extends JPanel
{
    /** Variables Used in GUI **/
    private int pressed = 0,        size = 8;
    private int toThisRow,      toThisColumn;
    private int fromThisRow,    fromThisColumn; 

    /** Arrays used in GUI  **/
    private JButton[][] selection;  

    /** Objects  **/    
    private Move m;
    private IChessModel ichessModel;
    private IChessPiece chessPiece;
    private ChessModel model; 

    /**  Board Color Icons   **/
    private ImageIcon boardBlue,    boardGray;

    /**  Button Listener  **/
    ButtonListener listener = new ButtonListener();         // Creates a button listener object

    /**  Chess Peice Icons  */
    private ImageIcon   wb_King,    wg_King,    bb_King,    bg_King;
    private ImageIcon   wb_Queen,   wg_Queen,   bb_Queen,   bg_Queen;
    private ImageIcon   wb_Rook,    wg_Rook,    bb_Rook,    bg_Rook;
    private ImageIcon   wb_Bishop,  wg_Bishop,  bb_Bishop,  bg_Bishop;
    private ImageIcon   wb_Knight,  wg_Knight,  bb_Knight,  bg_Knight;
    private ImageIcon   wb_Pawn,    wg_Pawn,    bb_Pawn,    bg_Pawn;

    private ImageIcon steelKnight; 

    public ChessPanel() {
        /** Objects  **/
        selection = new JButton[size][size];              
        ichessModel = new ChessModel();
        model = new ChessModel();

        /**Makes all of the select buttons for a board size determined by the variable size*/
        setLayout(new GridLayout(size,size));                                   // Sets the size of the grid layout via bSize variable
        boardBlue = new ImageIcon ("Board Blue.png");                                       // Icon of blue square blck dot     
        boardGray = new ImageIcon ("Board Gray.png");                                       // Icon of blue square blck dot

        /** Icons **/
        wb_King = new ImageIcon ("WBKing.png");         wg_King = new ImageIcon ("WGKing.png"); 
        wb_Queen = new ImageIcon ("WBQueen.png");       wg_Queen = new ImageIcon ("WGQueen.png"); 
        wb_Rook = new ImageIcon ("WBRook.png");         wg_Rook = new ImageIcon ("WGRook.png");     
        wb_Bishop = new ImageIcon ("WBBishop.png");     wg_Bishop = new ImageIcon ("WGBishop.png");    
        wb_Knight = new ImageIcon ("WBKnight.png");     wg_Knight = new ImageIcon ("WGKnight.png"); 
        wb_Pawn = new ImageIcon ("WBPawn.png");         wg_Pawn = new ImageIcon ("WGPawn.png"); 

        bb_King = new ImageIcon ("BBKing.png");         bg_King = new ImageIcon ("BGKing.png"); 
        bb_Queen = new ImageIcon ("BBQueen.png");       bg_Queen = new ImageIcon ("BGQueen.png"); 
        bb_Rook = new ImageIcon ("BBRook.png");         bg_Rook = new ImageIcon ("BGRook.png");
        bb_Bishop = new ImageIcon ("BBBishop.png");     bg_Bishop = new ImageIcon ("BGBishop.png"); 
        bb_Knight = new ImageIcon ("BBKnight.png");     bg_Knight = new ImageIcon ("BGKnight.png"); 
        bb_Pawn = new ImageIcon ("BBPawn.png");         bg_Pawn = new ImageIcon ("BGPawn.png");

        steelKnight = new ImageIcon ("Steel Knight");
        /**  Creates the default board setup  **/

        defaultBoard();
    }

    /**************************************************************************************************************************************/
    private void defaultBoard(){            
        /**Creates the board display*/
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                /**  Makes all of the select buttons */
                selection[row][col] = new JButton ("");
                selection[row][col].addActionListener(listener);                             // Add the button to the list of action listeners

                /**  Set All White Pieces **/
                if((row % 2) == (col % 2)){
                    if(row == 1)                                    selection[row][col].setIcon(wb_Pawn);
                    else if(row == 0 && (col == 0 || col == 7))     selection[row][col].setIcon(wb_Rook);                 
                    else if(row == 0 && (col == 1 || col == 6))     selection[row][col].setIcon(wb_Knight);    
                    else if(row == 0 && (col == 2 || col == 5))     selection[row][col].setIcon(wb_Bishop);                        
                    else if(row == 0 && col == 3)                   selection[row][col].setIcon(wb_Queen);                       
                    else if(row == 0 && col == 4)                   selection[row][col].setIcon(wb_King);            
                    else                                            selection[row][col].setIcon(boardBlue);   
                }
                else{ 
                    if(row == 1)                                    selection[row][col].setIcon(wg_Pawn);                    
                    else if(row == 0 && (col == 0 || col == 7))     selection[row][col].setIcon(wg_Rook);  
                    else if(row == 0 && (col == 1 || col == 6))     selection[row][col].setIcon(wg_Knight);   
                    else if(row == 0 && (col == 2 || col == 5))     selection[row][col].setIcon(wg_Bishop); 
                    else if(row == 0 && col == 3)                   selection[row][col].setIcon(wg_Queen);  
                    else if(row == 0 && col == 4)                   selection[row][col].setIcon(wg_King); 
                    else                                            selection[row][col].setIcon(boardGray);    
                }

                /**  Set All Black Pieces **/
                if((row % 2) == (col % 2)){
                    if(row == 6)                                    selection[row][col].setIcon(bb_Pawn);
                    else if(row == 7 && (col == 0 || col == 7))     selection[row][col].setIcon(bb_Rook);
                    else if(row == 7 && (col == 1 || col == 6))     selection[row][col].setIcon(bb_Knight);
                    else if(row == 7 && (col == 2 || col == 5))     selection[row][col].setIcon(bb_Bishop);
                    else if(row == 7 && col == 3)                   selection[row][col].setIcon(bb_King);
                    else if(row == 7 && col == 4)                   selection[row][col].setIcon(bb_Queen);
                }
                else{
                    if(row == 6)                                    selection[row][col].setIcon(bg_Pawn);
                    else if(row == 7 && (col == 0 || col == 7))     selection[row][col].setIcon(bg_Rook);
                    else if(row == 7 && (col == 1 || col == 6))     selection[row][col].setIcon(bg_Knight);
                    else if(row == 7 && (col == 2 || col == 5))     selection[row][col].setIcon(bg_Bishop);
                    else if(row == 7 && col == 3)                   selection[row][col].setIcon(bg_King);
                    else if(row == 7 && col == 4)                   selection[row][col].setIcon(bg_Queen);
                }
                add(selection[row][col]);                       
            }    
        }
    }

    //method that updates the board
    private void displayBoard() {
        IChessPiece chessPiece = ichessModel.pieceAt(fromThisRow, fromThisColumn);  
        try{  
            //System.out.println("Player: " + model.currentPlayer() + "  Owner: " + chessPiece.player() + "  Piece is " + chessPiece.type());        // Tell me black or white
            System.out.println();  
            System.out.println();  
            System.out.println();  

            if((model.isValidMove(m)) && model.currentPlayer() == chessPiece.player()){
                /**  each argument checks the piece type, the owner, and the locaion on the board (using the modulus tells us a blue or gray square)**/
                if((toThisRow % 2) == (toThisColumn % 2)) {
                    if((chessPiece.type().equals("Rook")) && (chessPiece.player() == Player.WHITE)){           selection[toThisRow][toThisColumn].setIcon(wb_Rook);    }
                    if ((chessPiece.type().equals("Knight")) && (chessPiece.player() == Player.WHITE)){        selection[toThisRow][toThisColumn].setIcon(wb_Knight);  }    
                    if ((chessPiece.type().equals("Bishop")) && (chessPiece.player() == Player.WHITE)){        selection[toThisRow][toThisColumn].setIcon(wb_Bishop);  }
                    if ((chessPiece.type().equals("King")) && (chessPiece.player() == Player.WHITE)){          selection[toThisRow][toThisColumn].setIcon(wb_King);    } 
                    if ((chessPiece.type().equals("Queen")) && (chessPiece.player() == Player.WHITE)){         selection[toThisRow][toThisColumn].setIcon(wb_Queen);   }
                    if ((chessPiece.type().equals("Pawn")) && (chessPiece.player() == Player.WHITE)){          selection[toThisRow][toThisColumn].setIcon(wb_Pawn);    }

                    if((chessPiece.type().equals("Rook")) && (chessPiece.player() == Player.BLACK)){           selection[toThisRow][toThisColumn].setIcon(bb_Rook);    }
                    if ((chessPiece.type().equals("Knight")) && (chessPiece.player() == Player.BLACK)){        selection[toThisRow][toThisColumn].setIcon(bb_Knight);  }    
                    if ((chessPiece.type().equals("Bishop")) && (chessPiece.player() == Player.BLACK)){        selection[toThisRow][toThisColumn].setIcon(bb_Bishop);  }
                    if ((chessPiece.type().equals("King")) && (chessPiece.player() == Player.BLACK)){          selection[toThisRow][toThisColumn].setIcon(bb_King);    } 
                    if ((chessPiece.type().equals("Queen")) && (chessPiece.player() == Player.BLACK)){         selection[toThisRow][toThisColumn].setIcon(bb_Queen);   }
                    if ((chessPiece.type().equals("Pawn")) && (chessPiece.player() == Player.BLACK)){          selection[toThisRow][toThisColumn].setIcon(bb_Pawn);    }
                }

                /**  each argument checks the piece type, the owner, and the locaion on the board (using the modulus tells us a blue or gray square)**/
                if((toThisRow % 2) != (toThisColumn % 2)){
                    if((chessPiece.type().equals("Rook")) && (chessPiece.player() == Player.WHITE)){           selection[toThisRow][toThisColumn].setIcon(wg_Rook);    }
                    if ((chessPiece.type().equals("Knight")) && (chessPiece.player() == Player.WHITE)){        selection[toThisRow][toThisColumn].setIcon(wg_Knight);  }    
                    if ((chessPiece.type().equals("Bishop")) && (chessPiece.player() == Player.WHITE)){        selection[toThisRow][toThisColumn].setIcon(wg_Bishop);  }
                    if ((chessPiece.type().equals("King")) && (chessPiece.player() == Player.WHITE)){          selection[toThisRow][toThisColumn].setIcon(wg_King);    } 
                    if ((chessPiece.type().equals("Queen")) && (chessPiece.player() == Player.WHITE)){         selection[toThisRow][toThisColumn].setIcon(wg_Queen);   }
                    if ((chessPiece.type().equals("Pawn")) && (chessPiece.player() == Player.WHITE)){          selection[toThisRow][toThisColumn].setIcon(wg_Pawn);    }

                    if((chessPiece.type().equals("Rook")) && (chessPiece.player() == Player.BLACK)){           selection[toThisRow][toThisColumn].setIcon(bg_Rook);    }
                    if ((chessPiece.type().equals("Knight")) && (chessPiece.player() == Player.BLACK)){        selection[toThisRow][toThisColumn].setIcon(bg_Knight);  }    
                    if ((chessPiece.type().equals("Bishop")) && (chessPiece.player() == Player.BLACK)){        selection[toThisRow][toThisColumn].setIcon(bg_Bishop);  }
                    if ((chessPiece.type().equals("King")) && (chessPiece.player() == Player.BLACK)){          selection[toThisRow][toThisColumn].setIcon(bg_King);    } 
                    if ((chessPiece.type().equals("Queen")) && (chessPiece.player() == Player.BLACK)){         selection[toThisRow][toThisColumn].setIcon(bg_Queen);   }
                    if ((chessPiece.type().equals("Pawn")) && (chessPiece.player() == Player.BLACK)){          selection[toThisRow][toThisColumn].setIcon(bg_Pawn);    }
                }

                /** always set the from position icon to a blank space **/
                if((fromThisRow % 2) == (fromThisColumn % 2)){          selection[fromThisRow][fromThisColumn].setIcon(boardBlue);  }
                else if((fromThisRow % 2) != (fromThisColumn % 2)){     selection[fromThisRow][fromThisColumn].setIcon(boardGray);  }

                ichessModel.move(m); 
                model.move(m);     
                System.out.println("Next Player To Move: " + model.nextPlayer());
            }
            else{
                JOptionPane.showMessageDialog(null, "Not Valid");
            } 
        }
        catch(NullPointerException n){
            System.out.println("empty");
        } 
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            int row = 0, col = 0;
            JComponent button = (JComponent) event.getSource(); 
            pressed++;
            if(pressed == 1){
                for(row = 0; row < size; row++) {
                    for (col = 0; col < size; col++){  
                        if(selection[row][col] == button){
                            fromThisRow = row;
                            fromThisColumn = col;
                        }
                    }
                }
            }

            if(pressed == 2){
                for(row = 0; row < size; row++) {
                    for (col = 0; col < size; col++){  
                        if(selection[row][col] == button){
                            toThisRow = row;
                            toThisColumn = col;
                        }
                    }
                }
                pressed = 0;
                m = new Move(fromThisRow, fromThisColumn, toThisRow, toThisColumn); 
                displayBoard();
            }    
        }
    }
}

