/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jm.gov.gojpcms.projectcomponent;

import jm.gov.gojpcms.enums.ProjectState;
import jm.gov.gojpcms.enums.ProjectType;
import java.util.ArrayList;
import java.util.Iterator;
import jm.gov.gojpcms.documentcomponent.Document;

/**
 * Project represents a GOJPCMS project
 * @author JCARJ
 */
public class Project {
    
    /**
     * To generate automatic unique IDs for Projects
     */
    private static float nextId = 0;

    /**
     * Project Id
     */
    private float id;
    
    /**
     * Project name
     */
    private String name;
    
    /**
     * Project Description
     */
    private String  description;
    /**
     * Funding Arrangement for the project
     */
    private FundingArrangement fa;
    
    /**
     * Project state
     */
    private ProjectState state;
    
    /**
     * Project Document List
     */
    private ArrayList<Document> documents;
        
    /**
     * Project Geographic Location
     */
    private String location;
    
    /**
     * Project Funding Type : Capital A or Capital B
     */
    private ProjectType fundingType;

    /**
     * Total Cost for the project (Aggregate cost of all sub-projects)
     */
    private float  totalCost;
    /**
     * Project Beneficiaries
     */
    private ProjectBeneficiaries beneficiaries;
    
    /**
     * Project Activities
     */;
    
    
    private ArrayList<Activity> activities;
    
    /**
     * Sub-Projects
     */    
    private ArrayList<Project> subProjects;
    
    /**
     * Owner User ID
     */
    private int ownerId;
    
    
    
    /**
     * Constructor
     * @param name - Project name
     * @param description - Project Description
     * @param projectLocation - Geographic Location
     * @param projectFundingType - Funding Type: Capital A or Capital B
     * @param fa - funding arrangement
     * @param beneficiaries - beneficiaries
     */
    public Project(String name, String description, String projectLocation, ProjectType projectFundingType, FundingArrangement fa, ProjectBeneficiaries beneficiaries, int ownerId) {
        this.id = ++Project.nextId;
        this.name = name;
        this.description = description;
        this.state = ProjectState.INCEPTION;
        this.location = projectLocation;
        this.fundingType = projectFundingType;
        this.beneficiaries = beneficiaries;
        this.fa = fa;
        this.ownerId = ownerId;
        this.activities = new ArrayList<Activity>();
        this.subProjects = new ArrayList<Project>();
    }

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FundingArrangement getFa() {
        return fa;
    }

    public void setFa(FundingArrangement fa) {
        this.fa = fa;
    }

    public ProjectState getState() {
        return state;
    }

    public void setState(ProjectState state) {
        this.state = state;
    }

    public ArrayList<Document> getProjectDocuments() {
        return documents;
    }

    public void setProjectDocuments(ArrayList<Document> projectDocuments) {
        this.documents = projectDocuments;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ProjectType getFundingType() {
        return fundingType;
    }

    public void setFundingType(ProjectType fundingType) {
        this.fundingType = fundingType;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

    public ProjectBeneficiaries getBeneficiaries() {
        return beneficiaries;
    }

    public void setBeneficiaries(ProjectBeneficiaries beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }
    
    /**
     * Adds the given activity to the project
     * @param activity Activity 
     */
    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    /**
     * 
     * @param activity Activity being updated
     * @return Boolean success or failure
     */
    public boolean updateActivity(Activity activity){
        Iterator<Activity> it = this.activities.iterator();
        Activity act = null;
        while (it.hasNext()){
            Activity temp = it.next();
            if (temp.getId() == activity.getId()){
                act = temp;
                break;
            }
        }
        if (act != null){
            activities.remove(act);
            activities.add(activity);
            return true;            
        }
        return false;
    }
    public ArrayList<Project> getSubProjects() {
        return subProjects;
    }

    public void setSubProjects(ArrayList<Project> subProjects) {
        this.subProjects = subProjects;
    }
    
    /**
     * Add documents and reports to the project
     * @param doc Document to add
     */
    public void addDocument(Document doc){
        this.documents.add(doc);
    }
    
    /**
     * Updates a given document
     * @param doc Document to update
     * @return Boolean success or failure
     */
    
    public boolean updateDocument(Document doc){
        Iterator<Document> it = this.documents.iterator();
        Document act = null;
        while (it.hasNext()){
            Document temp = it.next();
            if (temp.getId() == doc.getId()){
                act = temp;
                break;
            }
        }
        if (act != null){
            documents.remove(act);
            documents.add(doc);
            return true;            
        }
        return false;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
    
    /**
     * 
     * @return Stringified status report
     */
    public String getStatusReport(){
        String report;
        report = "Status: " + this.state.name();
        Iterator<Activity> it = this.activities.iterator();
        report += "\nActivities";
        float totalPercentage = 0;
        while(it.hasNext()){
            Activity act = it.next();
            float weight = act.getWeight();
            float percentage = act.getPercentage();
            report += "\n" + act; 
            totalPercentage += weight * percentage;
        }
        report += "\nOverall Percent Complete: " + totalPercentage + "%";
        
        return report;
    }
    
    /**
     * 
     * @return Stringifed Activities List
     */
    public ArrayList<String> getActivitiesList(){
        ArrayList<String> list = new ArrayList<String>();
        Iterator<Activity> it = activities.iterator();
        while(it.hasNext()){
            Activity act = it.next();
            list.add(act.toString());            
        }
        return list;
    }
    
   public Activity getActivity(float id){
       Iterator<Activity> it = this.activities.iterator();
        Activity act = null;
        while (it.hasNext()){
            Activity temp = it.next();
            if (temp.getId() == id){
                return temp;
            }
        }
        return new Activity();
   }
    
}

