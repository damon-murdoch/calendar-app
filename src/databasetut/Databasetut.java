// ~~~~ Written by Damon Murdoch ~~~~
// ~~~~ Last Updated 19/08/2014 ~~~~

// Imports required packages
package databasetut;

// Main Class
public class Databasetut {

    // Main program loop
    public static void main(String[] args){
        
        
        
    }
    /*
    // Adds some test inputs to the database and prints them to the console
    public static void test(){
        
        //String host, String username, String password,String table, String arguments
        
         String 'arguments' is structured in the following patterns - 
           
            tblAppointments - "(aID, cID, 'aStart','aEnd','aDesc','aBookingType',aDate)"
            tblBookingType - "('bType', 'bDesc', bPrice)"
            tblClients - "(cID, 'cName', 'cAddress', cNumber, cVip)"
         
        
     
        DataBaseControl.deleteFromDataBase("jdbc:derby://localhost:1527/CALENDARDATA", "superadmin", "superadmin", "TBLAPPOINTMENTS","");
        DataBaseControl.deleteFromDataBase("jdbc:derby://localhost:1527/CALENDARDATA", "superadmin", "superadmin", "TBLCLIENTS","");
        DataBaseControl.deleteFromDataBase("jdbc:derby://localhost:1527/CALENDARDATA", "superadmin", "superadmin", "TBLBOOKINGTYPE","");
        
        System.out.println();
        // Writes information to table TBLAPPOINTMENTS
        DataBaseControl.writeToDataBase("jdbc:derby://localhost:1527/CALENDARDATA","superadmin","superadmin","TBLAPPOINTMENTS","(1,1,1130,1200,'Cut my own hair','Haircut',20082014)");
        DataBaseControl.writeToDataBase("jdbc:derby://localhost:1527/CALENDARDATA","superadmin","superadmin","TBLAPPOINTMENTS","(2,2,1430,1500,'Kill JFK', 'Assassination', 20082014)");
        DataBaseControl.writeToDataBase("jdbc:derby://localhost:1527/CALENDARDATA","superadmin","superadmin","TBLAPPOINTMENTS","(3,1,1530,1600,'Kill Gareth', 'Assassination', 20082014)");
        
        System.out.println();
        // Writes information to table TBLCLIENTS
        DataBaseControl.writeToDataBase("jdbc:derby://localhost:1527/CALENDARDATA","superadmin","superadmin","TBLCLIENTS","(1,'Damon Murdoch','3 Staffa Close Merrimac',55690951,true)");
        DataBaseControl.writeToDataBase("jdbc:derby://localhost:1527/CALENDARDATA","superadmin","superadmin","TBLCLIENTS","(2,'Jarod Burger', 'www.4chan.org/b/', 127001, false)");
        DataBaseControl.writeToDataBase("jdbc:derby://localhost:1527/CALENDARDATA","superadmin","superadmin","TBLCLIENTS","(3,'Gareth Watson', 'Somewhere', 12345678, false)");
        
        System.out.println();
        // Writes information to table TBLBOOKINGTYPE
        DataBaseControl.writeToDataBase("jdbc:derby://localhost:1527/CALENDARDATA","superadmin","superadmin","TBLBOOKINGTYPE","('Haircut','Cut the hair of the customer for a set price',25)");
        DataBaseControl.writeToDataBase("jdbc:derby://localhost:1527/CALENDARDATA","superadmin","superadmin","TBLBOOKINGTYPE","('Assassination','Eliminate the target', 2000)");
        
        System.out.println();
        // Reads the information in table TBLAPPOINTMENTS
        DataBaseControl.readFromDataBase("jdbc:derby://localhost:1527/CALENDARDATA","superadmin","superadmin","TBLAPPOINTMENTS"," * ");
        DataBaseControl.readFromDataBase("jdbc:derby://localhost:1527/CALENDARDATA","superadmin","superadmin","TBLCLIENTS"," * ");
        DataBaseControl.readFromDataBase("jdbc:derby://localhost:1527/CALENDARDATA","superadmin","superadmin","TBLBOOKINGTYPE"," * "); 
        
        
    }
    */
}
