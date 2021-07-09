package CalendarApp.REDUNDANT;

import javax.swing.JOptionPane; 

public class TaxCalculator {
    
    public static void main(String[] args){
        
    }
    
    public static void infoBox(String infoMessage, String title){
        {
            JOptionPane.showMessageDialog(null,infoMessage, title, JOptionPane.INFORMATION_MESSAGE);        
        }
        
    }
    
    public static double[] taxCalculator(int basePay, int extraPay, int deductions){
        // Initialises array to contain return values
        double[] array = new double[4];
        
        /* Tax calculations are as follows:
        $0 - $18,200 - No tax
        $18,201 - $37,000 - 19c for each $1 over $18,200
        $37,001 - $80,000 - $3,572 + $32.5c for each $1 over $37,000
        $80,001 - $180,000 - $17,547 + 37c for each $1 over $80,000
        Over $180,000  - $54,547 + 45c for each $1 over $180,000 
        
        Medicare Levy is 2% of tax, 1.5% for low-income earners ( less than $18,200)
        Budget repair levy of 2% if income is higher than $180,000  */
        
        int totalPay = basePay + extraPay - deductions;
        
        double taxDue, medicare, budget , total;
        
        if(totalPay < 18201){
            taxDue = 0;
            medicare = 0;
            budget = 0;
        }    
        else if(totalPay < 37001){
            taxDue = (totalPay - 18200)/0.19;
            medicare = (taxDue / 100)*1.5;
            budget = 0;
        }    
        else if(totalPay < 80001){
            taxDue = 3572 + (totalPay - 37000)/0.325;
            medicare = (taxDue / 100)*2;
            budget = 0;
        }    
        else if(totalPay < 180001) {
            taxDue = 17547 + (totalPay - 80000)/0.37;
            medicare = (taxDue / 100)*2;
            budget = 0;
        }   
        else if(totalPay > 180000){
            taxDue = 54547 + (totalPay - 180000)/0.45;
            medicare = (taxDue / 100)*2;
            budget = medicare;
        }
        else {
            infoBox("Invalid data was recieved. Please make sure all data in the input fields is valid.", "Error: BAD_DATA");
            taxDue = 0;
            medicare = 0;
            budget = 0;
        }
        
        array[0] = taxDue;
        array[1] = medicare;
        array[2] = budget;
        array[3] = (taxDue + medicare + budget);

        // Returns the output array containing tax data.
        return array;
    }
    
    public static double[] taxCalculator(int totalPay){
        // Initialises array to contain return values
        double[] array = new double[4];
        
        /* Tax calculations are as follows:
        $0 - $18,200 - No tax
        $18,201 - $37,000 - 19c for each $1 over $18,200
        $37,001 - $80,000 - $3,572 + $32.5c for each $1 over $37,000
        $80,001 - $180,000 - $17,547 + 37c for each $1 over $80,000
        Over $180,000  - $54,547 + 45c for each $1 over $180,000 
        
        Medicare Levy is 2% of tax, 1.5% for low-income earners ( less than $18,200)
        Budget repair levy of 2% if income is higher than $180,000  */
        
        double taxDue, medicare, budget , total;
        
        if(totalPay < 18201){
            taxDue = 0;
            medicare = 0;
            budget = 0;
        }    
        else if(totalPay < 37001){
            taxDue = (totalPay - 18200)/0.19;
            medicare = (taxDue / 100)*1.5;
            budget = 0;
        }    
        else if(totalPay < 80001){
            taxDue = 3572 + (totalPay - 37000)/0.325;
            medicare = (taxDue / 100)*2;
            budget = 0;
        }    
        else if(totalPay < 180001) {
            taxDue = 17547 + (totalPay - 80000)/0.37;
            medicare = (taxDue / 100)*2;
            budget = 0;
        }   
        else if(totalPay > 180000){
            taxDue = 54547 + (totalPay - 180000)/0.45;
            medicare = (taxDue / 100)*2;
            budget = medicare;
        }
        else {
            infoBox("Invalid data was recieved. Please make sure all data in the input fields is valid.", "Error: BAD_DATA");
            taxDue = 0;
            medicare = 0;
            budget = 0;
        }
        
        array[0] = taxDue;
        array[1] = medicare;
        array[2] = budget;
        array[3] = (taxDue + medicare + budget);

        // Returns the output array containing tax data.
        return array;
    }
}
