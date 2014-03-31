/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jm.gov.gojpcms.aclcomponent;

/**
 *
 * @author RiteshReddy
 */
public class AclComponent {
    
    public static User getCurrentUser(){
        return Session.getCurrentUser();
    }
    public static boolean hasAccess(User usr){
        //Check User Permissions
        
        //Dummy return value: 
        return true;
        
    }
}
