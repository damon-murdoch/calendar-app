// ~~~~ Written by Damon Murdoch ~~~~
// ~~~~ Last Updated 19/08/2014 ~~~~

// Imports required packages
package databasetut;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import CalendarApp.*;



// Reads information from a database
public class DataBaseControl{
    
    // Main program loop
    public static void main(String[] args){

    }
    
    public static String[] stringSchedule = new String[2];
    public static int[] intSchedule = new int[4];
    
    public static String[] stringClient;
    public static int[] intClient;
    
    public static String[] stringType;
    public static int[] intType;
    
    public static int actualDate;
    
    public static int Counter = 0;
        
    
    // Reads from a database, taking the host, username, password, items to search for and table to find it in as inputs.
    public static void readFromDataBase(String host, String username, String password,String table, String arguments, int _actualDate) {
        actualDate = _actualDate;
        
        try {

            
            // Connects to the database at address host, using the provided username and password
            System.out.println("Connecting to " + host);
            Connection con = DriverManager.getConnection(host,username,password);
            System.out.println("Connected database successfully...");
            
            // Creates a statement for the connected database
            System.out.println("Creating statement...");
            Statement stmt = con.createStatement();
            
            // Creates a string of SQL code, using the data to be selected and the table for it to be selected from as parameters
            String SQL = "SELECT " + arguments +  " FROM " + table;
            
            // Creates a resultset from reading the data in the table
            System.out.println("Reading data...");
            ResultSet rs = stmt.executeQuery(SQL);

            /*
            
            // If connected table is TBLAPPOINTMENTS
            if ("TBLAPPOINTMENTS".equals(table.toUpperCase())){
            
                // While there is unread information in rs
                while(rs.next()){
                
                    int aID = rs.getInt("AID");
                    int cID = rs.getInt("CID");
                    String aBookingType = rs.getString("ABOOKINGTYPE");
                    int aDate = rs.getInt("ADATE");
                    int aStart = rs.getInt("ASTART");
                    int aEnd = rs.getInt("AEND");
                    String aDesc = rs.getString("ADESC");
                       
                    // Prints the data contained in the table
                    System.out.println("Appointment ID: " + aID + " Customer ID: " + cID + " Booking Type: " + aBookingType + " Date: " + aDate + " Start Time: " + aStart + " End Time: " + aEnd + " Description: " + aDesc);
                }
                
            }
            
            // If connected table is TBLBOOKINGTYPE
            if ("TBLBOOKINGTYPE".equals(table.toUpperCase())){
            
                // While there is unread information in rs
                while(rs.next()){
                
                    String bType = rs.getString("BTYPE");                                                            
                    String bDesc = rs.getString("BDESC");
                    String bPrice = rs.getString("BPRICE");
                       
                    // Prints the data contained in the table
                    System.out.println("Booking Type: " + bType + " Description: " + bDesc + " Price: $" + bPrice);
                    
                }
 
            }
            
            
            // If connected table is TBLCLIENTS
            if ("TBLCLIENTS".equals(table.toUpperCase())){
            
                // While there is unread information in rs
                while(rs.next()){
                
                    int cID = rs.getInt("CID");
                    String cName = rs.getString("CNAME");
                    String cAddress = rs.getString("CADDRESS");
                    int cNumber = rs.getInt("CNUMBER");
                    boolean cVIP = rs.getBoolean("CVIP");

                    // Prints the data contained in the table
                    System.out.println("Customer ID: " + cID + " Name: " + cName + " Address: " + cAddress + " Phone Number:" + cNumber + " VIP: " + cVIP);
                    
                }
                
            } */
            
            
            // If connected table is TBLAPPOINTMENTS
            if ("TBLAPPOINTMENTS".equals(table.toUpperCase())){
            
                // While there is unread information in rs
                while(rs.next()){
                if (actualDate == rs.getInt("ADATE") ) {
                    
                    intSchedule[0] = rs.getInt("AID");
                    intSchedule[1] = rs.getInt("CID");
                    stringSchedule[0] = rs.getString("ABOOKINGTYPE");
                    
                    intSchedule[2] = rs.getInt("ASTART");
                    intSchedule[3] = rs.getInt("AEND");
                    stringSchedule[1] = rs.getString("ADESC");
                    
                    
                    //Items[Counter] = new ViewItem(rs.getInt("ASTART"), rs.getInt("AEND"), rs.getString("ABOOKINGTYPE"), rs.getInt("CID"), rs.getString("ADEST"), Counter++);
                  
                }
                }
                
            }

                
            // If the username is Ricardo
            if (username.equals("Ricardo")){
                // String Ricardo = "love"; Ricardo = "life...";
                System.out.println("Ricardo is love, Ricardo is life...");
            }
                        
        }
        
        // Catches exceptions thrown by SQL Errors
        catch (SQLException se) {
            
            // Prints the error message of the error thrown
            System.out.print("Task failed: ");
            System.out.println(se.getMessage());           
        }
        
        // Always do this after the try... catch loop
        finally {
            // Print 'Goodbye!' to the console to signify the closing of the database
            System.out.println("Goodbye!");
        }
        
    }
    
    // Deletes data from the selected table 
    public static void deleteFromDataBase(String host, String username, String password, String table, String arguments){
        
        // Attempt this
        try {
            
            // Connects to the database
            System.out.println("Connecting to " + host );
            Connection conn = DriverManager.getConnection(host,username,password);
            System.out.println("Connected to database successfully.");
            
            // creates the java jdbc statement
            System.out.println("Creating statement...");
            Statement statement = conn.createStatement();
            
            // Deletes the data selected in input 'arguments'
            System.out.println("Deleting selected data...");
            statement.executeUpdate("DELETE " + arguments + " FROM " + table);
            System.out.println("Selected data deleted successfully.");
            
        }
        
        // Catches any SQL Exceptions thrown 
        catch (SQLException e) {
             
            // Prints the errormessage of e
            System.out.print("Task failed: ");
            System.out.println(e.getMessage());
            
        }
        
        // Always runs after the try/catch 
        finally {
            
            // Prints 'goodbye' to the console to signify the ending of the function
            System.out.println("Goodbye!");
            
        }
        
    }
    
    
    // Class for writing a new object to the database
    public static void writeToDataBase(String host, String username, String password, String table, String arguments){
     
        // Attempt this
        try{
            
            // Connects to the database specified by host, using the username and password combination provided as arguments
            System.out.println("Connecting to " + host );
            
            try (Connection conn = DriverManager.getConnection(host,username,password)) {
                
                System.out.println("Connected to database successfully.");
                
                // create our java jdbc statement
                System.out.println("Creating statement...");
                Statement statement = conn.createStatement();
                
                /* String arguments is structured in the following patterns -
                
                tblAppointments - (aID, cID, 'aBookingType', aDate, aStart, aEnd, 'aDesc')
                tblBookingType - ('bType', 'bDesc', bPrice)
                tblClients - (cID, 'cName', 'cAddress', cNumber, cVip)
                
                */
                
                // Adds the new data to the selected table
                System.out.println("Adding data to table...");
                statement.executeUpdate("INSERT INTO " + table +  " VALUES" + arguments);
                System.out.println("Successfully added data to table.");
                
                
                // Close the connection to the database
                System.out.println("Closing database connection...");
            }
            
        }
        // if an SQL Exception occurs
        catch (SQLException se) {
            
            // Print the error message to the console
            System.out.print("Task failed: ");
            System.out.println(se.getMessage());
        }   
         
        // Runs after the try/catch loop
        finally {
            
            // Prints 'goodbye' to the console to signify the end of the function
            System.out.println("Goodbye!");
            
        }
        
    }
    public static Array[] Items;
    public static ViewItem[] temp;
    public static int ID[] = new int[3];

            
    static ViewItem[] AddArrayData(ViewItem[] Array, ViewItem Element) {
        temp = new ViewItem[Array.length + 1];
        
        for (int i = 0; i < Array.length; i++) {
            temp[i] = Array[i];
        }
        Array = temp;
        Array[Array.length - 1] = Element;
        return Array;
    }
    
    
    
}
