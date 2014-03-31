/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jm.gov.gojpcms.projectcomponent;

import java.util.ArrayList;
import jm.gov.gojpcms.documentcomponent.Document;

/**
 *
 * @author RiteshReddy
 */
public class Project {
    
    private static float nextId = 0;

    public static float getNextId() {
        return nextId;
    }

    public static void setNextId(float aNextId) {
        nextId = aNextId;
    }
    
    private float id;
    
    private String name;
    
    private String  description;
    /**
     * Funding Arrangement for the project
     */
    private FundingArrangement fa;
    
    private ProjectState state;
    
    private ArrayList<Document> projectDocuments;
    
    private String projectLocation;
    
    private ProjectType projectFundingType;

    private float  totalCost;

    private ProjectBeneficiaries beneficiaries;

    public Project(String name, String description, String projectLocation, ProjectType projectFundingType, FundingArrangement fa, ProjectBeneficiaries beneficiaries) {
        this.id = ++Project.nextId;
        this.name = name;
        this.description = description;
        this.state = ProjectState.INCEPTION;
        this.projectLocation = projectLocation;
        this.projectFundingType = projectFundingType;
        this.beneficiaries = beneficiaries;
        this.fa = fa;
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
        return projectDocuments;
    }

    public void setProjectDocuments(ArrayList<Document> projectDocuments) {
        this.projectDocuments = projectDocuments;
    }

    public String getProjectLocation() {
        return projectLocation;
    }

    public void setProjectLocation(String projectLocation) {
        this.projectLocation = projectLocation;
    }

    public ProjectType getProjectFundingType() {
        return projectFundingType;
    }

    public void setProjectFundingType(ProjectType projectFundingType) {
        this.projectFundingType = projectFundingType;
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

    
   
    
}


enum ProjectState {
    INCEPTION, PREPARATION, IMPLEMENTATION, TERMINATION, POSTEVALUATION, CANCELLED
}

enum ProjectType {
    CAPITAL_A, CAPITAL_B
}