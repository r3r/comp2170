/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jm.gov.gojpcms.projectcomponent;

import jm.gov.gojpcms.enums.ProjectType;

/**
 *
 * @author JCARJ
 */
public class CapitalProject extends Project{

    public CapitalProject(String name, String description, String projectLocation, ProjectType projectFundingType, FundingArrangement fa, ProjectBeneficiaries beneficiaries, int ownerId) {
        super(name, description, projectLocation, projectFundingType, fa, beneficiaries, ownerId);
    }
    
}
