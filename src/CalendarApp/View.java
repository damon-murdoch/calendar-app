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
public class View {
    
    // Java object  container
    static Container pane;
        
    // Tabbel panel to place objects.
    static public JPanel pnlView, pnlTimeView;
    static public boolean showView = false;
    
    public static DragScrollPane scrollView;
    
    //public ResultSet currentSet;
    
    View() {
        
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
        pnlView = new JPanel(null);
        pnlTimeView = new JPanel(null);
        scrollView = new DragScrollPane(pnlTimeView);
        
        // Sets the border
        pnlView.setBorder(BorderFactory.createTitledBorder("View"));    
        
       // Registers action listeners

        pane.add(pnlView);
       
        pnlView.add(scrollView);

        scrollView.setAutoscrolls(true);
        
        scrollView.setBounds(ScreenRatio(10, 'x'), ScreenRatio(15, 'y'), ScreenRatio(300, 'x'), ScreenRatio(480, 'y'));
        
        pnlTimeView.setPreferredSize(new Dimension(ScreenRatio(280, 'x'), ScreenRatio(470, 'y')));
        
        pnlView.setBounds(0, ScreenRatio(55, 'y'), ScreenRatio(320, 'x'), ScreenRatio(505, 'y'));

//pnlView.setBounds 
        //pnlSchedule.setBounds
        //pnlExpenses.setBounds
        
        pnlView.setVisible(false);
        
        //ViewItem seenView = new ViewItem("10am","12am","Mow the lawn", "Ricordial", "E3", 0);

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
    

   /* 
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
    } */
}
    
    
