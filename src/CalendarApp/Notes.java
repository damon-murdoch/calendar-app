/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CalendarApp;

// Class imports
import javax.swing.*;
//import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author gwats8
 */
public class Notes {
    
    public static Container pane;
    
    public static JPanel pnlNotes;
    public static boolean showNotes = true;
    
    public static JTextArea txtNotes;
    
    Notes() {
        
                        // Attempts to set up UI Manager
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        // Catches ClassNotFound, Instantiation, IllegalAccess, and UnsupportedLookAndFeel Exceptions.
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e){}
        
        pane = Task.frmMain.getContentPane();
        
        pnlNotes = new JPanel(null);
         
        txtNotes = new JTextArea();
        
        pane.add(pnlNotes);
        pnlNotes.add(txtNotes);
        
        // Sets the border
        pnlNotes.setBorder(BorderFactory.createTitledBorder("Notes"));
        txtNotes.setBorder(BorderFactory.createLineBorder(Color.black));
        
        pnlNotes.setBounds(0, ScreenRatio(389, 'y'), ScreenRatio(320, 'x'), ScreenRatio(171, 'y'));
        txtNotes.setBounds(10, ScreenRatio(15, 'y'), ScreenRatio(300, 'x'), ScreenRatio(145, 'y'));
        
    }
    public static int ScreenRatio(int value, char axis) {
        //System.out.print("  Fired: " + axis + " " + value);
                        
        if (axis == 'y') {
                return (int)((double)Task.frameY * ((double)value / (double)Task.baseY));
            }
        else if (axis == 'x') {
               return (int)((double)Task.frameX * ((double)value / (double)Task.baseX)); 
            }
        else {return -1;}
    }
         
}
