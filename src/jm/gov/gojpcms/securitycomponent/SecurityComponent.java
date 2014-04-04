/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jm.gov.gojpcms.securitycomponent;

/**
 *
 * @author JCARJ
 */
public class SecurityComponent {
    
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
     * @param projId Project Id
     * @param privelage Privilege Level Required
     * @param action Action being performed
     * @return boolean
     */
    public static boolean hasAccess(User usr, float projId, Action action, Privilege privelage){
        //Check User Permissions
        
        //Dummy return value: 
       
        return true;
        
    }
}
