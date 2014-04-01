/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jm.gov.gojpcms.aclcomponent;

/**
 *
 * @author JCARJ
 */
public class AclComponent {
    
    /**
     * Static method to get the current user
     * @return - Gets the current user
     */
    public static User getCurrentUser(){
        return Session.getCurrentUser();
    }
    
    /**
     * Checks if the given user has appropriate permissions
     * @param usr - User Objects
     * @return boolean
     */
    public static boolean hasAccess(User usr){
        //Check User Permissions
        
        //Dummy return value: 
        return true;
        
    }
}
