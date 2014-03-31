/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jm.gov.documentcomponent;

import jm.gov.projectcomponent.Project;

/**
 *
 * @author RiteshReddy
 */
public class DocumentComponent {
    
    public ExpenditureReport getExpenditureReport(Project proj){
        return new ExpenditureReport();
    }
    
    public ProgressReport generateProgressReport(Project proj){
        return new ProgressReport();
    }
}
