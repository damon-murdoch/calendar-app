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
public class LocalClientItem {
    
    public int CID, CNUMBER;
    public String CNAME, CADRESS, CDESC;
    public boolean CVIP;
    public LocalClientItem(int _CID, String _CNAME, String _CADRESS, boolean _CVIP, String _CDESC) {
        
        CID = _CID;
        CNAME = _CNAME;
        CADRESS = _CADRESS;
        CVIP = _CVIP;
        CDESC = _CDESC;
        
    }
    
}
