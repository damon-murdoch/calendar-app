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

public class LocalDataBase {
    
    
    static String[] dataType = new String[0];
    static String[] dataStart = new String[0];
    static String[] dataLocation = new String[0];
    static String[] dataEnd = new String[0];
    static String[] dataDetails = new String[0];
    static String[] temp;

    static String[] type_TypeCreate = new String[0];
    static String[] type_ClientCreate = new String[0];
    
    
    static String[] AddData(String[] Array, String Text) {
        temp = new String[Array.length + 1];
        
        for (int i = 0; i < Array.length; i++) {
            temp[i] = Array[i];
        }
        Array = temp;
        Array[Array.length - 1] = Text;
        return Array;
    }
    
    static boolean checkBox(JComboBox Box, String test) {

        for (int i = 0; i < Box.getItemCount(); i++) {
            if (Box.getItemAt(i).equals(test)) {
                return false;
            }
        }
        return true;

    }
    
    static void LoadTypeComboBox() {
        Editor_Schedule.cmbTypeLoad.removeAllItems();
        for (String dataType1 : type_TypeCreate) {
            if (checkBox(Editor_Schedule.cmbTypeLoad, dataType1)) {
                Editor_Schedule.cmbTypeLoad.addItem(dataType1);
            }
        }

    }
    
    static void LoadClientComboBox() {
        Editor_Schedule.cmbClientLoad.removeAllItems();
        for (String dataType1 : type_ClientCreate) {
            if (checkBox(Editor_Schedule.cmbClientLoad, dataType1)) {
                Editor_Schedule.cmbClientLoad.addItem(dataType1);
            }
        }

    }
    
    static void UpdateQuickView() {
        //QuickView.lstType.setListData(dataType);
        //QuickView.lstStart.setListData(dataStart);
        //QuickView.lstEnd.setListData(dataEnd);
    }
    
}
