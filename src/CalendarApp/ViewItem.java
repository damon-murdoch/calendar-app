/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CalendarApp;

/**
 *
 * @author gwats8
 */

// Class imports
import javax.swing.*;
//import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ViewItem extends JPanel {
    
    private JLabel _lblStartTime, _lblEndTime, _lblType, _lblClient, _lblLocation;
    private  int _number;
    public ViewItem(int startTime, int endTime, String type, int client, String location, int number) {
        
       
        _number = number;
        
        _lblStartTime = new JLabel("From: " + startTime);
        _lblType = new JLabel("Type: " + type);
        _lblClient = new JLabel("For:    " + client);
        _lblLocation = new JLabel("At:      " + location);
        _lblEndTime = new JLabel("To:     " + endTime);     
        
        AddThis();
        SetBounds();
    }
    
    private void SetBounds() {
        this.setBounds(ScreenRatio(10, 'x'), ScreenRatio((10 + _number * 100 + _number * 10), 'y'), 280, 100);
        _lblStartTime.setPreferredSize( new Dimension(260, 10));
        _lblStartTime.setLocation(new Point(10, 10));
        _lblType.setPreferredSize( new Dimension(260, 10));
        _lblType.setLocation(new Point(10, 25));
        _lblClient.setPreferredSize( new Dimension(260, 10));
        _lblClient.setLocation(new Point(10, 40));
        _lblLocation.setPreferredSize( new Dimension(260, 20));
        _lblLocation.setLocation(new Point(10, 55));
        _lblEndTime.setPreferredSize( new Dimension(260, 10));
        _lblEndTime.setLocation(new Point(10, 80));
        
      /*  _lblStartTime.setBounds(10, 10, 100, 25);
        _lblType.setBounds(10, 45, 100, 25);
        _lblClient.setBounds(10, 80, 100, 25);
        _lblLocation.setBounds(10, 115, 100, 50);
        _lblEndTime.setBounds(10, 175, 100, 25); */
    }
    
    private void AddThis() { 
        
        this.setBorder(BorderFactory.createLineBorder(Color.black));

        View.pnlTimeView.add(this); 
        this.add(_lblStartTime);
        this.add(_lblType);
        this.add(_lblClient);
        this.add(_lblLocation);
        this.add(_lblEndTime);
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
