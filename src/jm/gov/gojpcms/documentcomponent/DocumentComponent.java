/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jm.gov.gojpcms.documentcomponent;

import jm.gov.gojpcms.projectcomponent.Project;

/**
 *
 * @author JCARJ
 */
public class DocumentComponent {

    /**
     *
     * @param proj - Project Object
     * @return ExpenditureReport of the given project
     */
    public ExpenditureReport getExpenditureReport(Project proj) {
        return new ExpenditureReport();
    }

    /**
     *
     * @param proj - Project object
     * @return ProgressReport of the given project
     */
    public ProgressReport generateProgressReport(Project proj) {
        return new ProgressReport();
    }
}
