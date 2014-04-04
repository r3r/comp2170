/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jm.gov.gojpcms.projectcomponent;

import java.util.ArrayList;
import java.util.Iterator;
import jm.gov.gojpcms.aclcomponent.AclComponent;
import jm.gov.gojpcms.documentcomponent.DocumentComponent;
import jm.gov.gojpcms.documentcomponent.ExpenditureReport;
import jm.gov.gojpcms.documentcomponent.ProgressReport;
import jm.gov.gojpcms.documentcomponent.Report;

/**
 * Manager/Driver for Project and related classes
 * @author JCARJ
 */
public class ProjectComponent {
    /**
     * List of all Projects in GOJPCMS
     */
    private ArrayList<Project> projects;

    /**
     * 
     * @param id - Project Id
     * @return Report[] - Returns progress report and expenditure report
     */
    public Report[] getProjectDetails(float id){
        
        Report[] details = new Report[2];
      
        if (AclComponent.hasAccess(AclComponent.getCurrentUser())){
            Iterator<Project> it = this.projects.iterator();
            Project proj = null;
            while (it.hasNext()){
                Project temp = it.next();
                if(temp.getId() == id){
                    proj = temp;
                    break;
                }
            }               
             if (proj != null){
                 DocumentComponent docComp = new DocumentComponent();
                 ProgressReport progReport = docComp.generateProgressReport(proj);
                 ExpenditureReport expenReport =  docComp.getExpenditureReport(proj);
                 details[0] = progReport;
                 details[1] = expenReport;                 
             }
        }
        return details;
    }   
    
    /**
     * 
     * @param name - project name
     * @param description - project description
     * @param location - geographic location
     * @param fundingType - funding type
     * @param fa - Funding arrangement
     * @param beneficiaries - beneficiaries
     * @return String - "Success" or "Failure"
     */
    public String addProject(String name, String description, String location, ProjectType fundingType, FundingArrangement fa, ProjectBeneficiaries beneficiaries){
        
       if (AclComponent.hasAccess(AclComponent.getCurrentUser())){
            Project proj = new Project(name, description, location, fundingType, fa, beneficiaries);
            projects.add(proj);
            
            return "SUCCESS";
        }
        else {
            return "FAILURE";
        }
               
    }
    
    /**
     * 
     * @param id - id of the project being edited
     * @param name - project name
     * @param description - project description
     * @param location - geographic location
     * @param fundingType - funding type
     * @param fa - Funding arrangement
     * @param beneficiaries - beneficiaries
     * @return String - "Success" or "Failure"
     */
    public String editProject(float id,String name, String description, String location, ProjectType fundingType, FundingArrangement fa, ProjectBeneficiaries beneficiaries ){
        if (AclComponent.hasAccess(AclComponent.getCurrentUser())){
            Iterator<Project> it = this.projects.iterator();
            Project proj = null;
            while (it.hasNext()){
                Project temp = it.next();
                if(temp.getId() == id){
                    proj = temp;
                    break;
                }
            }               
             if (proj != null){
                if (name != ""){
                    proj.setName(name);
                }
                if (description != ""){
                    proj.setDescription(description);
                }
                if (location != ""){
                    proj.setProjectLocation(location);
                }
                if (fundingType != null){
                    proj.setProjectFundingType(fundingType);
                }
                if (fa != null){
                    proj.setFa(fa);
                }
                if (beneficiaries != null){
                    proj.setBeneficiaries(beneficiaries);
                }
            }
            else {
                return "FAILURE";
            }
            
            return "SUCCESS";
        }
        else {
            return "FAILURE";
        }
    }
    
    /**
     * 
     * @param id - id of project to cancel
     * @return String "Success" or "Failure"
     */
    public String cancelProject(float id){
        if (AclComponent.hasAccess(AclComponent.getCurrentUser())){
            Iterator<Project> it = this.projects.iterator();
            Project proj = null;
            while (it.hasNext()){
                Project temp = it.next();
                if(temp.getId() == id){
                    proj = temp;
                    break;
                }
            }
            if (proj != null){
                proj.setState(ProjectState.CANCELLED);
            }
            else {
                return "FAILURE";
            }
            
            return "SUCCESS";
        }
        else {
            return "FAILURE";
        }
    }
    
    /**
     * 
     * @param id - Project ID
     * @param cons - Consultant
     * @return String "Success" or "Failure"
     */
    
    public String addConsultant(float id, Consultant cons){
        if (AclComponent.hasAccess(AclComponent.getCurrentUser())){
            Iterator<Project> it = this.projects.iterator();
            Project proj = null;
            while (it.hasNext()){
                Project temp = it.next();
                if(temp.getId() == id){
                    proj = temp;
                    break;
                }
            }
            if (proj != null){
                try {
                    TechnicalAssistanceProject tap = (TechnicalAssistanceProject) proj;
                    tap.setConsultant(cons);
                    return "SUCCESS";
                }
                catch(Exception e){
                    return "FAILURE";
                }
            }
        }         
        return "FAILURE";
    }
    
    /**
     * 
     * @param id - Project ID
     * @return String "Success" or "Failure"
     */
    public String removeConsultant(float id){
        if (AclComponent.hasAccess(AclComponent.getCurrentUser())){
            Iterator<Project> it = this.projects.iterator();
            Project proj = null;
            while (it.hasNext()){
                Project temp = it.next();
                if(temp.getId() == id){
                    proj = temp;
                    break;
                }
            }
            if (proj != null){
                try {
                    TechnicalAssistanceProject tap = (TechnicalAssistanceProject) proj;
                    tap.setConsultant(null);
                    return "SUCCESS";
                }
                catch(Exception e){
                    return "FAILURE";
                }
            }
        }         
        return "FAILURE";
    }
    
    /**
     * 
     * @param id Project ID
     * @param activity Activity
     * @return ""
     */
    public String addActivities(float id, float activity){
        return "";
    }
    
    /**
     * 
     * @param id Project ID
     * @param activityId Activity ID
     * @param activity Activity
     * @return ""
     */
    public String updateActivities(float id, float activityId, float activity){
        return "";
    }
    
}
