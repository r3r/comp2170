/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jm.gov.gojpcms.securitycomponent;

import java.util.Map;

/**
 *
 * @author JCARJ
 */
public class User {
    private int id;
    
    /**
     * Permissions for each project
     */
    private Map<Float, Permission> permissions;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
