/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jm.gov.projectcomponent;

import java.util.ArrayList;
import java.util.Iterator;
import jm.gov.aclcomponent.AclComponent;
import jm.gov.aclcomponent.Session;
import jm.gov.documentcomponent.DocumentComponent;
import jm.gov.documentcomponent.ExpenditureReport;
import jm.gov.documentcomponent.ProgressReport;
import jm.gov.documentcomponent.Report;

/**
 *
 * @author RiteshReddy
 */
public class ProjectComponent {
    
    private ArrayList<Project> projects;

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
    
    
}
