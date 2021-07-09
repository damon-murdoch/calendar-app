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
public class Editor_ClientCreate {
    
        public static DragScrollPane scrollClient;
        
        public static JPanel pnlClient;
        
       public static JTextField txtClient, txtName;
       
       public static JTextArea txtClientDetails, txtAdress, txtContact;
        
        public static JLabel lblClient, lblClientDetails, lblName, lblAdress, lblContact;
        
        static JButton btnAddClient;
        
        static JCheckBox cbVIP;
                        
        Editor_ClientCreate() {
            
        // Attempts to set up UI Manager
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        // Catches ClassNotFound, Instantiation, IllegalAccess, and UnsupportedLookAndFeel Exceptions.
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e){}
                
        // Creates controls
        pnlClient = new JPanel(null);
        scrollClient = new DragScrollPane(pnlClient);
        
        txtClient = new JTextField();
        txtName = new JTextField();
        txtAdress = new JTextArea();
        txtContact = new JTextArea();
        txtClientDetails = new JTextArea();
        
        lblClient = new JLabel("Client: ");
        lblName = new JLabel("Name: ");
        lblAdress = new JLabel("Adress: ");
        lblContact = new JLabel("Contact: ");
        lblClientDetails = new JLabel("Client Details: ");
        
        btnAddClient = new JButton("Add");
        
        cbVIP = new JCheckBox("Is a VIP?", false);

        // Sets the border
        //pnlClient.setBorder(BorderFactory.createLineBorder(Color.black, 2, false));
        
        Editor.pnlEditor.add(scrollClient);
        
        pnlClient.add(txtClient);
        pnlClient.add(txtName);
        pnlClient.add(txtAdress);
        pnlClient.add(txtContact);
        pnlClient.add(txtClientDetails);
        pnlClient.add(cbVIP);
                
        pnlClient.add(lblClient);
        pnlClient.add(lblName);
        pnlClient.add(lblAdress);
        pnlClient.add(lblContact);
        pnlClient.add(lblClientDetails);
        
        pnlClient.add(btnAddClient);
        
        txtClient.setBorder(BorderFactory.createLineBorder(Color.black));
        txtName.setBorder(BorderFactory.createLineBorder(Color.black));
        txtAdress.setBorder(BorderFactory.createLineBorder(Color.black));
        txtContact.setBorder(BorderFactory.createLineBorder(Color.black));
        txtClientDetails.setBorder(BorderFactory.createLineBorder(Color.black));
        cbVIP.setBorder(BorderFactory.createLineBorder(Color.black));
        
        scrollClient.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollClient.setAutoscrolls(true);
        
                // Registers action listeners
        btnAddClient.addActionListener(new btnAddClient_Action());     
        
        //scrollClient.setMaximumSize(dimClient);
        //scrollClient.setMinimumSize(dimClient);
        
        scrollClient.setBounds(ScreenRatio(10, 'x'), ScreenRatio(50, 'y'), ScreenRatio(300, 'x'), ScreenRatio(445, 'y'));
        
        pnlClient.setPreferredSize(new Dimension(ScreenRatio(280, 'x'), ScreenRatio(585, 'y')));
        pnlClient.setMinimumSize(new Dimension(ScreenRatio(280, 'x'), ScreenRatio(585, 'y')));
        pnlClient.setMaximumSize(new Dimension(ScreenRatio(280, 'x'), ScreenRatio(585, 'y')));
        
        txtClient.setBounds(ScreenRatio(10, 'x'), ScreenRatio(70, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        txtName.setBounds(ScreenRatio(10, 'x'), ScreenRatio(130, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        txtAdress.setBounds(ScreenRatio(10, 'x'), ScreenRatio(190, 'y'), ScreenRatio(260, 'x'), ScreenRatio(75, 'y'));
        txtContact.setBounds(ScreenRatio(10, 'x'), ScreenRatio(300, 'y'), ScreenRatio(260, 'x'), ScreenRatio(75, 'y'));
        txtClientDetails.setBounds(ScreenRatio(10, 'x'), ScreenRatio(470, 'y'), ScreenRatio(260, 'x'), ScreenRatio(100, 'y'));
        cbVIP.setBounds(ScreenRatio(10, 'x'), ScreenRatio(405, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        
        lblClient.setBounds(ScreenRatio(10, 'x'), ScreenRatio(45, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        lblName.setBounds(ScreenRatio(10, 'x'), ScreenRatio(105, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        lblAdress.setBounds(ScreenRatio(10, 'x'), ScreenRatio(165, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        lblContact.setBounds(ScreenRatio(10, 'x'), ScreenRatio(275, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        lblClientDetails.setBounds(ScreenRatio(10, 'x'), ScreenRatio(445, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        
        btnAddClient.setBounds(ScreenRatio(10, 'x'), ScreenRatio(10, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        //scrollClient.setBounds(ScreenRatio(10, 'x'), ScreenRatio(50, 'y'), ScreenRatio(300, 'x'), ScreenRatio(445, 'y'));
        
        //Set Visible starts on true so that it is the first visible when editor is opened.
        scrollClient.setVisible(false);
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
    
    static class btnAddClient_Action implements ActionListener {
        public void actionPerformed(ActionEvent e){
            LocalDataBase.type_ClientCreate = LocalDataBase.AddData(LocalDataBase.type_ClientCreate, txtClient.getText());
            LocalDataBase.LoadClientComboBox();
        } 
    }
    
}
