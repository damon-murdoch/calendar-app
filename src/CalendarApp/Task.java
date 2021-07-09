// File is inside class CalendarApp
package CalendarApp;

// Class imports
import javax.swing.*;
//import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import databasetut.*;

// Public class Task
 class Task {
   
    //Databasetut.test();
     
    // Java main frame
    static JFrame frmMain;
    public static int frameX = 330, frameY = 600;
    public static int baseX = 330, baseY = 600;
    
    
        // Main program loop
    public static void main(String[] args) {
        

        
        
        
        frmMain = new JFrame("Calendar Application"); 
        
        // Sets the size to 400x400 pixels
        //frmMain.setSize(330,375);
        //frmMain.setSize(Framex = 330, Framey = 375);
        frmMain.setSize(frameX, frameY);
        // Closes application upon pressing the 'x' button
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        frmMain.setResizable(false);
        frmMain.setVisible(true);
        
        //Equal Level classes must be declared in the order they ar eintended to be viewed
        //Subclasses must be declared first to avoid NullPointer Exceptions.
        
        Menu MainMenu = new Menu();
        
        Calendar MainCalendar = new Calendar();
        Notes MainNotes = new Notes();
        
        View MainView = new View();
        
        Editor MainEditor = new Editor();
        Editor_Schedule MainSchedule = new Editor_Schedule();
        Editor_ClientCreate MainClient = new Editor_ClientCreate();
        Editor_TypeCreate MainTypeCreate = new Editor_TypeCreate();
        
     }
 }
 