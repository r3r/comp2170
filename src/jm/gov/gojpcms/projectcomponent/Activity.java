/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jm.gov.gojpcms.projectcomponent;

/**
 *
 * @author JCARJ
 */
public class Activity implements Comparable<Activity> {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int compareTo(Activity other){
        if (this.id == other.getId()){
            return 0;
        }
        else if (this.id < other.getId()){
            return -1;
        }
        else {
            return 1;
        }
    }
    
}
