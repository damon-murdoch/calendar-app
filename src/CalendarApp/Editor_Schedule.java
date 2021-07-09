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
public class Editor_Schedule {
    
    public static DragScrollPane scrollSchedule;
    
    public static JPanel pnlSchedule;
    
    static JTextField txtStartTime, txtEndTime;
    static JTextArea txtLocation, txtDetails;
    
    static JLabel  lblLocation, lblStartTime, lblEndTime, lblDetails;
    
    static JComboBox cmbTypeLoad, cmbClientLoad;
    
    static JLabel lblTypeLoad, lblClientLoad;
    
    static JButton btnSave;
    
    
        
    static JCheckBox cbNever, cbDay, cbWeek, cbFortnight, cbMonth, cbYear;

    static JPanel pnlRepeat;
        
    Editor_Schedule() {
        
        // Places comstructor variables into global Calendar equivilents.
        
                // Attempts to set up UI Manager
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        // Catches ClassNotFound, Instantiation, IllegalAccess, and UnsupportedLookAndFeel Exceptions.
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e){}
        
                // ~~ Preparing frame ~~
        
        // Instantiates the frame

         //Gets the content pane
        
        pnlSchedule = new JPanel(null);
        scrollSchedule = new DragScrollPane(pnlSchedule);

        txtLocation = new JTextArea("dd:mm:yyyy - Gregorian Calendar");
        txtStartTime = new JTextField("hh:mm - 24 hour time");
        txtEndTime = new JTextField("hh:mm - 24 hour time");
        txtDetails = new JTextArea();
   
        lblLocation = new JLabel("Location: ");
        lblStartTime = new JLabel("Start Time: ");
        lblEndTime = new JLabel("End Time: ");
 
        lblDetails = new JLabel("Details: ");
        
        lblTypeLoad = new JLabel("Type Loader: ");
        lblClientLoad = new JLabel("Client Loader: ");
        
        cmbTypeLoad = new JComboBox();
        cmbClientLoad = new JComboBox();
        
        btnSave = new JButton("Save");
                
        
              
        cbNever = new JCheckBox("Never", true);
        cbDay = new JCheckBox("Every Day", false);
        cbWeek = new JCheckBox("Every Week",  false);
        cbFortnight = new JCheckBox("Every Fortnight", false);
        cbMonth = new JCheckBox("Every Month", false);
        cbYear = new JCheckBox("Every Year", false);
        
        pnlRepeat = new JPanel(null);
        
        // Registers action listeners
        btnSave.addActionListener(new btnSave_Action());
        
        cbNever.addItemListener(new CheckBox_CheckChanged());
        cbDay.addItemListener(new CheckBox_CheckChanged());
        cbWeek.addItemListener(new CheckBox_CheckChanged());
        cbFortnight.addItemListener(new CheckBox_CheckChanged());
        cbMonth.addItemListener(new CheckBox_CheckChanged());
        cbYear.addItemListener(new CheckBox_CheckChanged());
        
        Editor.pnlEditor.add(scrollSchedule);
    
        pnlSchedule.add(txtLocation);
        pnlSchedule.add(txtStartTime);
        pnlSchedule.add(txtEndTime);
        pnlSchedule.add(txtDetails);
        
        pnlSchedule.add(lblLocation);
        pnlSchedule.add(lblStartTime);
        pnlSchedule.add(lblEndTime);
        pnlSchedule.add(lblDetails);
        
        pnlSchedule.add(lblTypeLoad);
        pnlSchedule.add(lblClientLoad);
        
        pnlSchedule.add(cmbTypeLoad);
        pnlSchedule.add(cmbClientLoad);
        
        pnlSchedule.add(btnSave);
        
        pnlSchedule.add(pnlRepeat);
        
        pnlRepeat.add(cbNever);
        pnlRepeat.add(cbDay);
        pnlRepeat.add(cbWeek);
        pnlRepeat.add(cbFortnight);
        pnlRepeat.add(cbMonth);
        pnlRepeat.add(cbYear);

        
        txtLocation.setBorder(BorderFactory.createLineBorder(Color.black));
        txtStartTime.setBorder(BorderFactory.createLineBorder(Color.black));
        txtEndTime.setBorder(BorderFactory.createLineBorder(Color.black));
        txtDetails.setBorder(BorderFactory.createLineBorder(Color.black));
        
        pnlRepeat.setBorder(BorderFactory.createTitledBorder("Repeat"));
        
        
        scrollSchedule.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollSchedule.setAutoscrolls(true);
        
        scrollSchedule.setBounds(ScreenRatio(10, 'x'), ScreenRatio(50, 'y'), ScreenRatio(300, 'x'), ScreenRatio(445, 'y'));
        
        pnlSchedule.setPreferredSize(new Dimension(ScreenRatio(280, 'x'), ScreenRatio(690, 'y')));
        pnlSchedule.setMinimumSize(new Dimension(ScreenRatio(280, 'x'), ScreenRatio(690, 'y')));
        pnlSchedule.setMaximumSize(new Dimension(ScreenRatio(280, 'x'), ScreenRatio(690, 'y')));
      
        txtLocation.setBounds(ScreenRatio(10, 'x'), ScreenRatio(190, 'y'), ScreenRatio(260, 'x'), ScreenRatio(50, 'y'));
        txtStartTime.setBounds(ScreenRatio(10, 'x'), ScreenRatio(275, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        txtEndTime.setBounds(ScreenRatio(10, 'x'), ScreenRatio(335, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        txtDetails.setBounds(ScreenRatio(10, 'x'), ScreenRatio(575, 'y'), ScreenRatio(260, 'x'), ScreenRatio(100, 'y'));
      
        lblLocation.setBounds(ScreenRatio(10, 'x'), ScreenRatio(165, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        lblStartTime.setBounds(ScreenRatio(10, 'x'), ScreenRatio(250, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        lblEndTime.setBounds(ScreenRatio(10, 'x'), ScreenRatio(310, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        lblDetails.setBounds(ScreenRatio(10, 'x'), ScreenRatio(550, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        
        lblTypeLoad.setBounds(ScreenRatio(10, 'x'), ScreenRatio(45, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        lblClientLoad.setBounds(ScreenRatio(10, 'x'), ScreenRatio(105, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        
        cmbTypeLoad.setBounds(ScreenRatio(10, 'x'), ScreenRatio(70, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        cmbClientLoad.setBounds(ScreenRatio(10, 'x'), ScreenRatio(130, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        
        btnSave.setBounds(ScreenRatio(10, 'x'), ScreenRatio(10, 'y'), ScreenRatio(260, 'x'), ScreenRatio(25, 'y'));
        
        pnlRepeat.setBounds(ScreenRatio(10, 'x'), ScreenRatio(370, 'y'), ScreenRatio(260, 'x'), ScreenRatio(170, 'y'));

        cbNever.setBounds(ScreenRatio(10, 'x'), ScreenRatio(15, 'y'), ScreenRatio(240, 'x'), ScreenRatio(25, 'y'));
        cbDay.setBounds(ScreenRatio(10, 'x'), ScreenRatio(40, 'y'), ScreenRatio(240, 'x'), ScreenRatio(25, 'y'));
        cbWeek.setBounds(ScreenRatio(10, 'x'), ScreenRatio(65, 'y'), ScreenRatio(240, 'x'), ScreenRatio(25, 'y'));
        cbFortnight.setBounds(ScreenRatio(10, 'x'), ScreenRatio(90, 'y'), ScreenRatio(240, 'x'), ScreenRatio(25, 'y'));
        cbMonth.setBounds(ScreenRatio(10, 'x'), ScreenRatio(115, 'y'), ScreenRatio(240, 'x'), ScreenRatio(25, 'y'));
        cbYear.setBounds(ScreenRatio(10, 'x'), ScreenRatio(140, 'y'), ScreenRatio(240, 'x'), ScreenRatio(25, 'y'));


        //Visible is set to false so it won't appear when Editor is first opened

        LocalDataBase.LoadTypeComboBox();
        LocalDataBase.LoadClientComboBox();
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
        static class btnSave_Action implements ActionListener {
        public void actionPerformed(ActionEvent e){
            LocalDataBase.dataLocation = LocalDataBase.AddData(LocalDataBase.dataLocation, txtLocation.getText());
            LocalDataBase.dataStart = LocalDataBase.AddData(LocalDataBase.dataStart, txtStartTime.getText());
            LocalDataBase.dataEnd = LocalDataBase.AddData(LocalDataBase.dataEnd, txtEndTime.getText());
            LocalDataBase.dataDetails = LocalDataBase.AddData(LocalDataBase.dataDetails, txtDetails.getText());
            LocalDataBase.UpdateQuickView();
        }     
    }
       
        
    static class CheckBox_CheckChanged implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if ( ((JCheckBox)e.getSource()).isSelected()) {
                if (e.getSource() == cbNever) {
                    cbDay.setSelected(false);
                    cbWeek.setSelected(false);
                    cbFortnight.setSelected(false);
                    cbMonth.setSelected(false);
                    cbYear.setSelected(false);
                } else if (e.getSource() == cbDay) {
                    cbNever.setSelected(false);
                    cbWeek.setSelected(false);
                    cbFortnight.setSelected(false);
                    cbMonth.setSelected(false);
                    cbYear.setSelected(false);
                } else if (e.getSource() == cbWeek) {
                    cbNever.setSelected(false);
                    cbDay.setSelected(false);
                    cbFortnight.setSelected(false);
                    cbMonth.setSelected(false);
                    cbYear.setSelected(false);  
                } else if (e.getSource() == cbFortnight) {
                    cbNever.setSelected(false);
                    cbDay.setSelected(false);
                    cbWeek.setSelected(false);
                    cbMonth.setSelected(false);
                    cbYear.setSelected(false);
                } else if (e.getSource() == cbMonth) {
                    cbNever.setSelected(false);
                    cbDay.setSelected(false);
                    cbWeek.setSelected(false);
                    cbFortnight.setSelected(false);
                    cbYear.setSelected(false);
                } else if (e.getSource() == cbYear) {
                    cbNever.setSelected(false);
                    cbDay.setSelected(false);
                    cbWeek.setSelected(false);
                    cbFortnight.setSelected(false);
                    cbMonth.setSelected(false);  
                }
                
            } else if (!(cbNever.isSelected() || cbDay.isSelected() || cbWeek.isSelected() || cbFortnight.isSelected() || cbMonth.isSelected() || cbYear.isSelected())){
                ((JCheckBox)e.getSource()).setSelected(true);
            }

        }
    
    }
}
    
