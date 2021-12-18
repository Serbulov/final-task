package com.trackensure.finaltask.integration.valueobject.profit;

/**
 * ---------------------------------------------------------------------------------------------------------------- <br>
 * Объект представления прибыли для всей компании <br>
 * ---------------------------------------------------------------------------------------------------------------- <br>
 */
public class CompanyProfit {
    private final String companyName;
    private final double companyProfit;

    public CompanyProfit(String companyName, double companyProfit) {
        this.companyName = companyName;
        this.companyProfit = companyProfit;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getCompanyProfit() {
        return companyProfit;
    }
}
