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
public class Editor {
    
    // Java object  container
    static Container pane;
    
    static JButton btnSchedule, btnClient, btnTypeCreate;
    
    // Tabbel panel to place objects.
    static public JPanel pnlEditor;
    static public boolean showEditor = false;
    
    Editor() {
        
        // Attempts to set up UI Manager
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        // Catches ClassNotFound, Instantiation, IllegalAccess, and UnsupportedLookAndFeel Exceptions.
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e){}
        
                // ~~ Preparing frame ~~
        
        // Instantiates the frame

         //Gets the content pane
        pane = Task.frmMain.getContentPane();
        
        // Applies null layout
        pane.setLayout(null);
        
        // Creates controls
        pnlEditor = new JPanel(null);
        btnSchedule = new JButton("Schedule");
        btnClient = new JButton("Client Create");
        btnTypeCreate = new JButton("Type Create");
        
        // Sets the border
        pnlEditor.setBorder(BorderFactory.createTitledBorder("Editor"));    
        
       // Registers action listeners
        btnSchedule.addActionListener(new btnSchedule_Action());
        btnClient.addActionListener(new btnView_Action()); 
        btnTypeCreate.addActionListener(new btnExpenses_Action());
        
        pane.add(pnlEditor);
        pnlEditor.add(btnSchedule);
        pnlEditor.add(btnClient);
        pnlEditor.add(btnTypeCreate);


        pnlEditor.setBounds(0, ScreenRatio(55, 'y'), ScreenRatio(320, 'x'), ScreenRatio(505, 'y'));
        btnSchedule.setBounds(ScreenRatio(10, 'x'), ScreenRatio(15, 'y'), ScreenRatio(100, 'x'), ScreenRatio(25, 'y'));
        btnClient.setBounds(ScreenRatio(110, 'x'), ScreenRatio(15, 'y'), ScreenRatio(100, 'x'), ScreenRatio(25, 'y'));
        btnTypeCreate.setBounds(ScreenRatio(210, 'x'), ScreenRatio(15, 'y'), ScreenRatio(100, 'x'), ScreenRatio(25, 'y'));      

//pnlView.setBounds
        //pnlSchedule.setBounds
        //pnlExpenses.setBounds
        
        pnlEditor.setVisible(false);
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
    
    static class btnView_Action implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Editor_ClientCreate.scrollClient.setVisible(true);
            Editor_Schedule.scrollSchedule.setVisible(false);
            Editor_TypeCreate.scrollTypeCreate.setVisible(false);
            btnSchedule.setBorder(null);
            btnClient.setBorder(BorderFactory.createLineBorder(Color.blue));
            btnTypeCreate.setBorder(null);
        } 
    }
    
    static class btnSchedule_Action implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Editor_Schedule.scrollSchedule.setVisible(true);
            Editor_ClientCreate.scrollClient.setVisible(false);
            Editor_TypeCreate.scrollTypeCreate.setVisible(false);
            btnSchedule.setBorder(BorderFactory.createLineBorder(Color.blue));
            btnClient.setBorder(null);
            btnTypeCreate.setBorder(null);
        } 
    }
    
    static class btnExpenses_Action implements ActionListener {
        public void actionPerformed(ActionEvent e){
            Editor_Schedule.scrollSchedule.setVisible(false);
            Editor_ClientCreate.scrollClient.setVisible(false);
            Editor_TypeCreate.scrollTypeCreate.setVisible(true);
            
            btnSchedule.setBorder(null);
            btnClient.setBorder(null);
            btnTypeCreate.setBorder(BorderFactory.createLineBorder(Color.blue));
        }
    }
}
    
    
