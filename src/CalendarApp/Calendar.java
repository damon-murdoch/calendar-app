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
import databasetut.*;

// Public class Task
public class Calendar {
   
        // ~~ Object Initialisation ~~
    
    // JLabel object - able to display text / images
    static JLabel lblMonth, lblYear;
    
    // Java interactable button
    static JButton btnPrev, btnNext;
    
    // Java information table
    static JTable tblCalendar;
    
    // Java drop-down box
    static JComboBox cmbYear;
    
    // Java object container
    static Container pane;
    
    //Table model, whatever that is
    static DefaultTableModel mtblCalendar; 
   
    // Scrollbar
    static JScrollPane stblCalendar; 
    
    // Generic, lightweight container
    static public JPanel pnlCalendar;
    public static boolean showCalendar = true;
    
    // Initialisation of integer values relating to date / time
    static int realDay, realMonth, realYear, currentMonth, currentYear;
    //public static int Framex = 330, Framey = 600;
    //public static int Basex = 330, Basey = 600;
                      
    Calendar() {
        
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
        lblMonth = new JLabel ("January");
        lblYear = new JLabel ("Change year:");
        cmbYear = new JComboBox();
        btnPrev = new JButton("<<");
        btnNext = new JButton(">>");
        mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mCollIndex){return false;}};
        tblCalendar = new JTable(mtblCalendar);
        stblCalendar = new JScrollPane(tblCalendar);
        pnlCalendar = new JPanel(null);

        
        // Sets the border
        pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));
        
        // Registers action listeners
        btnPrev.addActionListener(new btnPrev_Action());
        btnNext.addActionListener(new btnNext_Action());
        cmbYear.addActionListener(new cmbYear_Action());
        tblCalendar.addMouseListener(new mouseEventDemo());
        
        // Adds controls to the pane
        pane.add(pnlCalendar);
        pnlCalendar.add(lblMonth);
        pnlCalendar.add(lblYear);
        pnlCalendar.add(cmbYear);
        pnlCalendar.add(btnPrev);
        pnlCalendar.add(btnNext);
        pnlCalendar.add(stblCalendar);
        
        stblCalendar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        
        //System.out.print((ScreenRatio(320, 'x')) + " " + (ScreenRatio(40, 'y')));
        // Set bounds 330,375
        //(160-lblMonth.getPreferredSize().width/2)
        //lblMonth.getSize().width/2
        pnlCalendar.setBounds(0, ScreenRatio(55, 'y'), ScreenRatio(320, 'x'), ScreenRatio(335, 'y'));
        lblMonth.setBounds( (ScreenRatio(160, 'x') - lblMonth.getPreferredSize().width/2), ScreenRatio(25, 'y'), ScreenRatio(100, 'x'), ScreenRatio(25, 'y'));
        lblYear.setBounds(ScreenRatio(10, 'x'), ScreenRatio(305, 'y'), ScreenRatio(80, 'x'), ScreenRatio(20, 'y'));
        cmbYear.setBounds(ScreenRatio(230, 'x'), ScreenRatio(305, 'y'), ScreenRatio(80, 'x'), ScreenRatio(20, 'y'));
        btnPrev.setBounds(ScreenRatio(10, 'x'), ScreenRatio(25, 'y'), ScreenRatio(50, 'x'), ScreenRatio(25, 'y'));
        btnNext.setBounds(ScreenRatio(260, 'x'), ScreenRatio(25, 'y'), ScreenRatio(50, 'x'), ScreenRatio(25, 'y'));
        stblCalendar.setBounds(ScreenRatio(10, 'x'), ScreenRatio(50, 'y'), ScreenRatio(300, 'x'), ScreenRatio(250, 'y'));
//lblMonth.setSize(ScreenRatio((int)lblMonth.getSize().getWidth(), 'x'), ScreenRatio((int)lblMonth.getSize().getHeight(), 'y'));
        //lblYear.setSize(ScreenRatio((int)lblYear.getSize().getWidth(), 'x'), ScreenRatio((int)lblYear.getSize().getHeight(), 'y'));
// Makes the frame visible
    
        // Gets the actual date, month, and year
        
        // Creates Gregorian Calendar
        GregorianCalendar cal = new GregorianCalendar();
        
        // Gets the current day 
        realDay = cal.get(GregorianCalendar.DAY_OF_MONTH);
        
        // Gets the current month
        realMonth = cal.get(GregorianCalendar.MONTH);
        
        // Gets the current year 
        realYear = cal.get(GregorianCalendar.YEAR);
        
        // Sets the currentmonth variable to the actual month
        currentMonth = realMonth;
        
        // Sets the currentyear variable to the actual year
        currentYear = realYear;
        
        // Adds headers
        String[] headers = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"}; 
        for(int i = 0; i<7; i++){
            mtblCalendar.addColumn(headers[i]);
        }
        
        // Sets the background colour of tbCalendar's parent to tbCalendar's colour
        tblCalendar.getParent().setBackground(tblCalendar.getBackground());
        
        // No resize / reorder
        tblCalendar.getTableHeader().setResizingAllowed(false);
        tblCalendar.getTableHeader().setReorderingAllowed(false);
        
        // Single cell selection
        tblCalendar.setColumnSelectionAllowed(true);
        tblCalendar.setRowSelectionAllowed(true);
        tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Set row / column count
        tblCalendar.setRowHeight(ScreenRatio(38, 'y'));
        mtblCalendar.setColumnCount(7);
        mtblCalendar.setRowCount(6);
        
        // Populate table
        for(int i=realYear - 100; i<= realYear+100; i++){
            cmbYear.addItem(String.valueOf(i));
        }
        
        // Refresh calendar
        System.out.print("Refresh!   : ");
        refreshCalendar(realMonth,realYear);
    }
/*
    // Main program loop
    public static void main(String[] args) {
              
        
    }*/
    
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
        
        
    private static final String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
    
    // Method for reloading the calendar at the updated month and yea
    public static void refreshCalendar(int month, int year){
        
        // ~~ Variables ~~
        // Array of Strings containing the names of every month.
        
        int nod, som; // number of days, start of month
        
        // Previous month and next month button are enabled.
        btnPrev.setEnabled(true);
        btnNext.setEnabled(true);
        
        // If currently viewing month is 10 years before actual year, disable the previous month button.
        if (month == 0 && year <= realYear - 10){btnPrev.setEnabled(false);}
        
        // If currently viewing month is 100 years after the actual year, disable the next month button.
        if (month == 11 && year >= realYear + 100){btnNext.setEnabled(false);}
        
        // label for month is set to the current month
        lblMonth.setText(months[month]);
        
        // lblMonth is resized 
        lblMonth.setBounds((ScreenRatio(160, 'x') - lblMonth.getPreferredSize().width/2),25,180,25);
        
        // Sets the selected item of combo box year to the current year
        cmbYear.setSelectedItem(String.valueOf(year)); 
        
        // Clears the table
        for(int i = 0; i<6; i++){
            for(int j = 0; j<7; j++){
                // table calendar's value is set to null at position i,j
                
                mtblCalendar.setValueAt(null,i,j);
            }
        }
        
        // Get first month and number of days
        GregorianCalendar cal = new GregorianCalendar(year,month, 1);
        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        som = cal.get(GregorianCalendar.DAY_OF_WEEK);
        
        // Draw calendar
        for(int i = 1; i<=nod; i++){
            int row = (Integer)((i+som-2)/7);
            int column = (i+som-2)%7;
            mtblCalendar.setValueAt(i,row,column);
        }

        // Apply renders
        tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
        
    }
    
    static class tblCalendarRenderer extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table,Object value, boolean selected, boolean focused, int row , int column){
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            
            // If it's a weekend
            if (column == 0 || column == 6){
                setBackground(new Color(255,220,220));
            }
            // If it's a weekday
            else{
                setBackground(new Color(255,255,255));
            }
            setBorder(null);
            if (value != null){
                
                if (Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear){
                    setBackground(new Color(220,220,255));
                }
                
            }

            try {
                if (selectedcolumn == column && selectedrow == row && currentmonth.equals(lblMonth.getText())&& currentyear.equals((String)Calendar.cmbYear.getSelectedItem()) ){
                    setBorder(BorderFactory.createLineBorder(Color.blue));
                }
            } 
            catch(java.lang.NullPointerException e) {
                System.out.println("Error;");                
            }
            
            
            setForeground(Color.black);
            return this;
        }
        
    }
    
    static class btnPrev_Action implements ActionListener {
        
        public void actionPerformed (ActionEvent e){

            if (currentMonth == 0){
                currentMonth = 11;
                currentYear -=1;
            }
            
            else {
                currentMonth -= 1;
            }
            refreshCalendar(currentMonth,currentYear);
        }
        
    }
    
        static class mtlbDay_Action implements ActionListener {
        
        public void actionPerformed (ActionEvent e){

            if (currentMonth == 0){
                currentMonth = 11;
                currentYear -=1;
            }
            
            else {
                currentMonth -= 1;
            }
            refreshCalendar(currentMonth,currentYear);
        }
        
    }
    
    static class btnNext_Action implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if(currentMonth == 11){
                currentMonth = 0;
                currentYear += 1;
            }
            else {
                currentMonth += 1;
            }
            refreshCalendar(currentMonth, currentYear);
        }
    }
    
   /* static class cell_Action extends mouseEventDemo {
        
        public void mousePressed (ActionEvent e){

            System.out.print("PIE");
        
        }
    } */
    
    static class cmbYear_Action implements ActionListener {
        public void actionPerformed (ActionEvent e){
            if (cmbYear.getSelectedItem() != null){
                String b = cmbYear.getSelectedItem().toString();
                currentYear = Integer.parseInt(b);
                refreshCalendar(currentMonth, currentYear);
            }
    
        }
        
    }
    
    public static void infoBox(String infoMessage, String title){
        {
            JOptionPane.showMessageDialog(null,infoMessage, title, JOptionPane.INFORMATION_MESSAGE);        
        }
        
    }
    

        
    public static class mouseEventDemo implements MouseListener {
        
        public void mousePressed(MouseEvent e){
            //for Mouse Pressed Statements
            //System.out.print("Mouse pressed.");
            isCellEditable(e);
        }
        
        public void mouseReleased(MouseEvent e){
            //for Mouse Exited Statements
            //System.out.print("Mouse released.");
        }
        
        public void mouseEntered(MouseEvent e){
            //for Mouse Entered Statements
            //System.out.print("Mouse entered.");
        }
        
        public void mouseExited(MouseEvent e){
            //for Mouse Exited Statements
            //System.out.print("Mouse exited.");
            
        }
        
        public void mouseClicked(MouseEvent e){
            //for Mouse Clicked Statements
            //System.out.print("Mouse Clicked.");
            
        }
        
    }
    
    /*
            // Get first month and number of days
        GregorianCalendar cal = new GregorianCalendar(year,month, 1);
        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        som = cal.get(GregorianCalendar.DAY_OF_WEEK);
        
        
        // Draw calendar
        for(int i = 1; i<=nod; i++){
            int row = (Integer)((i+som-2)/7);
            int column = (i+som-2)%7;

        }
        */
    
    public static int getIntMonth(String month) {
        for (int i = 0; i < 12; i++) {
            if (month.equals(months[i])) {
                return i+1;
            }
        }
        return -1;
    }
    
    public static int selectedcolumn = 0, selectedrow = 0, currentCompare;
    public static String currentmonth = "", currentyear = "";
    public static void isCellEditable(EventObject getEvent) {
        MouseEvent me = (MouseEvent) getEvent;
        JTable table = (JTable) (me.getSource());
        Point point = me.getPoint();
        selectedcolumn = table.columnAtPoint(point);
        selectedrow = table.rowAtPoint(point);
        currentmonth = lblMonth.getText();
        currentyear = (String)cmbYear.getItemAt(cmbYear.getSelectedIndex());
        System.out.print(currentCompare);
        Rectangle rec = table.getCellRect(selectedrow, selectedcolumn, true); 
        DataBaseControl.readFromDataBase("jdbc:derby://localhost:1527/CALENDARDATA","superadmin","superadmin","TBLAPPOINTMENTS"," * ", 20082014);
        View.pnlTimeView.setPreferredSize(new Dimension(ScreenRatio( 280, 'x'), ScreenRatio(10 + (DataBaseControl.Counter) * 100 + (DataBaseControl.Counter) * 10, 'y')));
        DataBaseControl.Counter = 0;
        if (mtblCalendar.getValueAt(selectedrow, selectedcolumn) != null) {
            //System.out.print("column: " + selectedcolumn + " row:  " + selectedrow + "  ;  ");
            tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new CellRenderer());
            Menu.ValueUpdate();
        } else {
            selectedrow = -1;
            selectedcolumn = -1;
            //System.out.print("Non-selectable cell!  ;  ");
        }
   }
    
        static class CellRenderer extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table,Object value, boolean selected, boolean focused, int row , int column){
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);

            // the following piece of of code does repeat from the main cell renderer, however,
            //    it was found that when one piece of rendering is done all must be done to avoid errors.
            
            // If it's a weekend
            if (column == 0 || column == 6){
                setBackground(new Color(255,220,220));
            }
            // If it's a weekday
            else {
                setBackground(new Color(255,255,255));
            }
            if (value != null){
                
                if (Integer.parseInt(value.toString()) == realDay && currentMonth == realMonth && currentYear == realYear){
                    setBackground(new Color(220,220,255));
                }
                
            } 

            if (selectedrow == row && selectedcolumn == column && value != null) {
                setBorder(BorderFactory.createLineBorder(Color.blue));
            }
            else {
                setBorder(null);
            }
                
            
            setForeground(Color.black);
            return this;
        }
        
    }
}