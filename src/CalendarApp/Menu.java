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


public class Menu {
    
        // Java object container
    static Container pane;
    
    static JButton btnExit, btnSwitch1, btnSwitch2;
    
        // Generic, lightweight container
    static JPanel pnlMenu;
    
        // JLabel object - able to display text / images
    static JLabel lblDate;

        Menu() {
             
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
                
        btnExit = new JButton("Exit");
        btnSwitch1 = new JButton("Editor");
        btnSwitch2 = new JButton("View");
        pnlMenu = new JPanel(null);
        lblDate = new JLabel("Choose Date");


        // Sets the border
        pnlMenu.setBorder(BorderFactory.createTitledBorder("Menu"));
        
        // Registers action listeners
        btnExit.addActionListener(new btnExit_Action());
        btnSwitch1.addActionListener(new btnSwitch_Action());
        btnSwitch2.addActionListener(new btnSwitch_Action());
        
        // Adds controls to the pane
        pane.add(pnlMenu);
        pnlMenu.add(btnExit);
        pnlMenu.add(btnSwitch1);
        pnlMenu.add(btnSwitch2);
        pnlMenu.add(lblDate);
        //.setBounds(ScreenRatio(190, 'x'), ScreenRatio(15, 'y'), ScreenRatio(50, 'x'), ScreenRatio(25, 'y'));
        pnlMenu.setBounds(0, ScreenRatio(1, 'y'), ScreenRatio(320, 'x'), ScreenRatio(50, 'y'));
        btnExit.setBounds(ScreenRatio(120, 'x'), ScreenRatio(15, 'y'), ScreenRatio(60, 'x'), ScreenRatio(25, 'y'));
        btnSwitch1.setBounds(ScreenRatio(185, 'x'), ScreenRatio(15, 'y'), ScreenRatio(60, 'x'), ScreenRatio(25, 'y'));
        btnSwitch2.setBounds(ScreenRatio(250, 'x'), ScreenRatio(15, 'y'), ScreenRatio(60, 'x'), ScreenRatio(25, 'y'));
        lblDate.setBounds(ScreenRatio(10, 'x'), ScreenRatio(15, 'y'), ScreenRatio(200, 'x'), ScreenRatio(25, 'y'));
 }
        final static String[] headers = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"}; 
        
        public static void ValueUpdate() {
                //lblDate.setText(Calendar.selectedrow + " : " + Calendar.selectedcolumn);
                

                // Draw calendar
                //dateReference = (headers[Calendar.selectedcolumn] + ", " + Calendar.mtblCalendar.getValueAt(Calendar.selectedrow, Calendar.selectedcolumn) + " " + Calendar.lblMonth.getText() + " " + (String)Calendar.cmbYear.getItemAt(Calendar.cmbYear.getSelectedIndex()));
                // System.out.print("THIS:" + Calendar.mtblCalendar.getValueAt(Calendar.selectedrow, Calendar.selectedcolumn) + ":");
                lblDate.setText(headers[Calendar.selectedcolumn] + ", " + Calendar.mtblCalendar.getValueAt(Calendar.selectedrow, Calendar.selectedcolumn) + " " + Calendar.lblMonth.getText().substring(0, 3) + " " + (String)Calendar.cmbYear.getItemAt(Calendar.cmbYear.getSelectedIndex()));
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
         
    static class btnExit_Action implements ActionListener {
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    
    static int nameSwitch = 0;
    static class btnSwitch_Action implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if ( ((((JButton)e.getSource()).getText()).equals("Main") && nameSwitch == 1 ) || ((((JButton)e.getSource()).getText()).equals("Editor") && nameSwitch == 0 ) ) {
                Calendar.showCalendar = !(Calendar.showCalendar);
                Calendar.pnlCalendar.setVisible(Calendar.showCalendar);
                            
                Notes.showNotes = !(Notes.showNotes);
                Notes.pnlNotes.setVisible(Notes.showNotes);
            
               Editor.showEditor = !(Editor.showEditor);
               Editor.pnlEditor.setVisible(Editor.showEditor);
               
               if (nameSwitch == 0) {
                   ((JButton)e.getSource()).setText("Main");
                   nameSwitch = 1;
               } else { 
                   ((JButton)e.getSource()).setText("Editor");
                   nameSwitch = 0; 
               }
               
            } 
            else if ( ((((JButton)e.getSource()).getText()).equals("Main") && nameSwitch == 2 ) || ((((JButton)e.getSource()).getText()).equals("View") && nameSwitch == 0 ) )  {
                Calendar.showCalendar = !(Calendar.showCalendar);
                Calendar.pnlCalendar.setVisible(Calendar.showCalendar);
                            
                Notes.showNotes = !(Notes.showNotes);
                Notes.pnlNotes.setVisible(Notes.showNotes);
            
               View.showView = !(View.showView);
               View.pnlView.setVisible(View.showView);
               
               if (nameSwitch == 0) {
                   ((JButton)e.getSource()).setText("Main");
                   nameSwitch = 2;
               } else { 
                   ((JButton)e.getSource()).setText("View");
                   nameSwitch = 0; 
               }
               
           }
            else if ( ((((JButton)e.getSource()).getText()).equals("View") && nameSwitch == 1 ) || ((((JButton)e.getSource()).getText()).equals("Editor") && nameSwitch == 2 ) )  {
               Editor.showEditor = !(Editor.showEditor);
               Editor.pnlEditor.setVisible(Editor.showEditor);
               
               View.showView = !(View.showView);
               View.pnlView.setVisible(View.showView);
               
               if (nameSwitch == 1) {
                   ((JButton)e.getSource()).setText("Editor");
                   nameSwitch = 2;
               } else { 
                   ((JButton)e.getSource()).setText("View");
                   nameSwitch = 1; 
               }
               
               
               }
         } 
    }
    
} 
