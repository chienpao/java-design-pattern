package com.chienpao.designpattern.designpattern.flyWeight;

/**
 * Created by pao on 2/29/16.
 */
public class FinancialReportManager implements IReportManager{

    protected String tenantId = null;

    public FinancialReportManager(String tenantId) {
        this.tenantId = tenantId;
    }

    @Override
    public String createReport() {
        return "This is a financial report generate to: " + tenantId;
    }
}
