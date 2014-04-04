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
public class TechnicalAssistanceProject extends Project{
    private Consultant consultant;
    private TermsOfReference tof;

    public TechnicalAssistanceProject(String name, String description, String projectLocation, ProjectType projectFundingType, FundingArrangement fa, ProjectBeneficiaries beneficiaries, int ownerId) {
        super(name, description, projectLocation, projectFundingType, fa, beneficiaries, ownerId);
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public void setConsultant(Consultant consultant) {
        this.consultant = consultant;
    }

    public TermsOfReference getTof() {
        return tof;
    }

    public void setTof(TermsOfReference tof) {
        this.tof = tof;
    }
    
    
    
}
