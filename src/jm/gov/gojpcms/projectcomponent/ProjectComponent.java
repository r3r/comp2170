/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jm.gov.gojpcms.projectcomponent;

import java.util.ArrayList;
import java.util.Iterator;
import jm.gov.gojpcms.documentcomponent.Document;
import jm.gov.gojpcms.securitycomponent.SecurityComponent;
import jm.gov.gojpcms.securitycomponent.Privilege;
import jm.gov.gojpcms.securitycomponent.Action;
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
      
        if (SecurityComponent.hasAccess(SecurityComponent.getCurrentUser(), id, Action.ProgressReports, Privilege.ViewOnly )){
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
        
       if (SecurityComponent.hasAccess(SecurityComponent.getCurrentUser(), 0, Action.RegistrationInformation, Privilege.Update )){
            Project proj = new Project(name, description, location, fundingType, fa, beneficiaries, SecurityComponent.getCurrentUser().getId());
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
        if (SecurityComponent.hasAccess(SecurityComponent.getCurrentUser(), id, Action.RegistrationInformation, Privilege.Update )){
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
                    proj.setLocation(location);
                }
                if (fundingType != null){
                    proj.setFundingType(fundingType);
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
        if (SecurityComponent.hasAccess(SecurityComponent.getCurrentUser(), id, Action.RegistrationInformation, Privilege.Update )){
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
        if (SecurityComponent.hasAccess(SecurityComponent.getCurrentUser(), id, Action.RegistrationInformation, Privilege.Update )){
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
        if (SecurityComponent.hasAccess(SecurityComponent.getCurrentUser(), id, Action.RegistrationInformation, Privilege.Update )){
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
     * @return String "Success" or "Failure"
     */
    public String addActivity(float id, Activity activity){
         if (SecurityComponent.hasAccess(SecurityComponent.getCurrentUser(), id, Action.RegistrationInformation, Privilege.Update )){
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
               proj.addActivity(activity);
               return "SUCCESS";
            }
            return "FAILURE";
         }
         return "FAILURE";
    }
    
    
    /**
     * 
     * @param id Project ID
     * @param activity Activity
     * @return String "Success" or "Failure"
     */
    public String updateActivities(float id, Activity activity){
        if (SecurityComponent.hasAccess(SecurityComponent.getCurrentUser(), id, Action.RegistrationInformation, Privilege.Update )){
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
               proj.updateActivity(activity);
               return "SUCCESS";
            }
            return "FAILURE";
         }
         return "FAILURE";
    
    }
    
    /**
     * 
     * @param id Project ID
     * @param document Document to add
     * @return String "Success" or "Failure"
     */
    public String addDocument(float id, Document document){
         if (SecurityComponent.hasAccess(SecurityComponent.getCurrentUser(), id, Action.ExpenditureReports, Privilege.Update)){
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
               proj.addDocument(document);
               return "SUCCESS";
            }
            return "FAILURE";
         }
         return "FAILURE";
    }
    
    /**
     * 
     * @param id Project ID
     * @param document Document to update
     * @return String "Success" or "Failure"
     */
    public String updateDocument(float id, Document document){
         if (SecurityComponent.hasAccess(SecurityComponent.getCurrentUser(), id, Action.ExpenditureReports, Privilege.Update)){
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
               proj.updateDocument(document);
               return "SUCCESS";
            }
            return "FAILURE";
         }
         return "FAILURE";
    }
    
    /**
     * The owner of the project can transfer ownership to any other user
     * @param id Project Id
     * @param userId - new user id
     * @return string "SUCCESS" or "FAILURE"
     */
    public String transferOwnership(float id, int userId){
        if (SecurityComponent.hasAccess(SecurityComponent.getCurrentUser(), id, Action.RegistrationInformation, Privilege.Update )){
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
                if(SecurityComponent.getCurrentUser().getId() == proj.getOwnerId()){
                    proj.setOwnerId(userId);
                    return "SUCCESS";
                }
                return "FAILURE";
            }
            return "FAILURE";
        }
        return "FAILURE";            
    }
    
    /**
     * 
     * @param id Project Id
     * @param status Project Status to update to
     * @return String "SUCCESS" or "FAILURE"
     */
    public String changeProjectStatus(float id, ProjectState status){
        if (SecurityComponent.hasAccess(SecurityComponent.getCurrentUser(), id, Action.RegistrationInformation, Privilege.Update )){
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
                proj.setState(status);
                return "SUCCESS";
            }
            return "FAILURE";
        }
        return "FAILURE";
    }
    
    
    public String assignUsersToProjects(float id, Action[] projActions, Privilege[] privileges){
        if (SecurityComponent.hasAccess(SecurityComponent.getCurrentUser(), id, Action.UserManagement, Privilege.Update )){
            //Set Permissions Here
            return "SUCCESS";
        }
        return "FAILURE";
    }
}
