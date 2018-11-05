
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
import java.awt.Button;
import java.util.Random;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class ChessGUI extends JPanel{
    public static void main(String[] args) {
        JMenuBar menus;
        JMenu fileMenu;
        JMenuItem quitItem;
        JMenuItem gameItem;  
                
        JFrame frame = new JFrame("Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        fileMenu = new JMenu("File");
        quitItem = new JMenuItem("quit");
        gameItem = new JMenuItem("new game");
        
        fileMenu.add(gameItem);
        fileMenu.add(quitItem);
        menus = new JMenuBar();
        frame.setJMenuBar(menus);
        menus.add(fileMenu);
        
        ChessPanel panel = new ChessPanel();
        frame.getContentPane().add(panel);
        
        
        frame.pack();
        frame.setSize(400, 400);
        frame.setVisible(true);
        
    }
}

