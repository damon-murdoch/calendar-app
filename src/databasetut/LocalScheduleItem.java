/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package databasetut;

/**
 *
 * @author gwats8
 */
public class LocalScheduleItem {
    
    public int AID, CID, ASTART, AEND;
    public String ABOOKINGTYPE, ADESC, ADEST;
    
    public LocalScheduleItem(int _AID, int _CID, String _ABOOKINGTYPE, int _ASTART, int _AEND, String _ADESC, String _ADEST) { 
        AID = _AID;
        CID = _CID;
        ASTART = _ASTART;
        AEND = _AEND;
        ABOOKINGTYPE = _ABOOKINGTYPE;
        ADESC = _ADESC;
        ADEST = _ADEST;
    }
    
}
