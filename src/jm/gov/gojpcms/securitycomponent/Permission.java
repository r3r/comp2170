/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jm.gov.gojpcms.securitycomponent;

import jm.gov.gojpcms.enums.Privilege;

/**
 *
 * @author JCARJ
 */
public class Permission {
    private Privilege RegistrationInformation;
    private Privilege ExpenditureReports;
    private Privilege ProgressReports;
    private Privilege MonitoringReports;
    private Privilege CompletionReport;
    private Privilege UserManagement;

    public Privilege getRegistrationInformation() {
        return RegistrationInformation;
    }

    public void setRegistrationInformation(Privilege RegistrationInformation) {
        this.RegistrationInformation = RegistrationInformation;
    }

    public Privilege getExpenditureReports() {
        return ExpenditureReports;
    }

    public void setExpenditureReports(Privilege ExpenditureReports) {
        this.ExpenditureReports = ExpenditureReports;
    }

    public Privilege getProgressReports() {
        return ProgressReports;
    }

    public void setProgressReports(Privilege ProgressReports) {
        this.ProgressReports = ProgressReports;
    }

    public Privilege getMonitoringReports() {
        return MonitoringReports;
    }

    public void setMonitoringReports(Privilege MonitoringReports) {
        this.MonitoringReports = MonitoringReports;
    }

    public Privilege getCompletionReport() {
        return CompletionReport;
    }

    public void setCompletionReport(Privilege CompletionReport) {
        this.CompletionReport = CompletionReport;
    }

    public Privilege getUserManagement() {
        return UserManagement;
    }

    public void setUserManagement(Privilege UserManagement) {
        this.UserManagement = UserManagement;
    }
    
    
    
}


