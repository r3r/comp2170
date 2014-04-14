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
    /**
     * To generate automatic unique IDs for Projects
     */
    private static int nextId = 0;
    
    /**
     * Id for the activity
     */
    private int id;
    
    /**
     * Name of the activity
     */
    private String name;
    
    /**
     * Weight of the activity for the overall project
     */
    private float weight;
    
    /**
     * Percentage completed
     */
    private float percentage;

    public Activity() {
        this.id = ++nextId;
        this.weight = 0;
        this.percentage = 0;
    }
    
    
    
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        String block = "";
        block += this.getId() + "\t" + this.getName() + "\t" + this.getWeight() + "\t" + this.getPercentage() +"%";
        return block;
    }
    
    
    
}
