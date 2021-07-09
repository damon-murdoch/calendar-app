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

public class Editor_TypeCreate {
        
        public static DragScrollPane scrollTypeCreate;
    
        public static JPanel pnlTypeCreate;
        
        public static JTextField txtType, txtDiscount;
        
        public static JTextArea txtTypeDetails;
        
        public static JLabel lblType, lblTypeDetails, lblDiscount;
        
        static JButton btnAddType;
        
    
        Editor_TypeCreate() {
              
        // Attempts to set up UI Manager
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        // Catches ClassNotFound, Instantiation, IllegalAccess, and UnsupportedLookAndFeel Exceptions.
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e){}
        
        // Creates controls
        pnlTypeCreate = new JPanel(null);
        
        scrollTypeCreate = new DragScrollPane(pnlTypeCreate);
        
        txtType = new JTextField();
        txtDiscount = new JTextField();
        txtTypeDetails = new JTextArea();
        
        lblType = new JLabel("Type: ");
        lblDiscount = new JLabel("How much is the discount for VIPs?: ");
        lblTypeDetails = new JLabel("Type Details: ");
        
        btnAddType = new JButton("Add");
        
        
        Editor.pnlEditor.add(scrollTypeCreate); 
        
        pnlTypeCreate.add(txtType);
        pnlTypeCreate.add(txtDiscount);
        pnlTypeCreate.add(txtTypeDetails);
        
        pnlTypeCreate.add(lblType);
        pnlTypeCreate.add(lblDiscount);
        pnlTypeCreate.add(lblTypeDetails);
        
        pnlTypeCreate.add(btnAddType);
        
        txtType.setBorder(BorderFactory.createLineBorder(Color.black));
        txtDiscount.setBorder(BorderFactory.createLineBorder(Color.black));
        txtTypeDetails.setBorder(BorderFactory.createLineBorder(Color.black));
        
        scrollTypeCreate.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollTypeCreate.setAutoscrolls(true);
        
        // Registers action listeners
        btnAddType.addActionListener(new btnAddType_Action());        
             
        
        scrollTypeCreate.setBounds(ScreenRatio(10, 'x'), ScreenRatio(50, 'y'), ScreenRatio(300, 'x'), ScreenRatio(445, 'y'));
        
        pnlTypeCreate.setPreferredSize(new Dimension(ScreenRatio(280, 'x'), ScreenRatio(435, 'y')));
        pnlTypeCreate.setMinimumSize(new Dimension(ScreenRatio(280, 'x'), ScreenRatio(435, 'y')));
        pnlTypeCreate.setMaximumSize(new Dimension(ScreenRatio(280, 'x'), ScreenRatio(435, 'y')));
               
        txtType.setBounds(ScreenRatio(10, 'x'), ScreenRatio(70, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        txtDiscount.setBounds(ScreenRatio(10, 'x'), ScreenRatio(130, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        txtTypeDetails.setBounds(ScreenRatio(10, 'x'), ScreenRatio(190, 'y'), ScreenRatio(260, 'x'), ScreenRatio(100, 'y'));
        lblType.setBounds(ScreenRatio(10, 'x'), ScreenRatio(45, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        lblDiscount.setBounds(ScreenRatio(10, 'x'), ScreenRatio(105, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        lblTypeDetails.setBounds(ScreenRatio(10, 'x'), ScreenRatio(165, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        btnAddType.setBounds(ScreenRatio(10, 'x'), ScreenRatio(10, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        
        //Visible is set to false so it won't appear when Editor is first opened
        scrollTypeCreate.setVisible(false);
            
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
    
    static class btnAddType_Action implements ActionListener {
        public void actionPerformed(ActionEvent e){
            LocalDataBase.type_TypeCreate = LocalDataBase.AddData(LocalDataBase.type_TypeCreate, txtType.getText());
            LocalDataBase.LoadTypeComboBox();
        } 
    }
}
