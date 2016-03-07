package com.chienpao.designpattern.designpattern.flyWeight;

/**
 * Created by pao on 2/29/16.
 */
public class EmployeeReportManager implements IReportManager{

    protected String tenantId = null;

    public EmployeeReportManager(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return "This is a employee report generate to: " + tenantId;
    }
}
