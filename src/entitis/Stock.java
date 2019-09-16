/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitis;

/**
 *
 * @author zrik
 */
public class Stock {

    private String stock_code;
    private int traderId;
    private String company;
    private int companyId;
    private String createDate;

    public Stock(String stock_code, int traderId, String company, String createDate) {
        this.stock_code = stock_code;
        this.traderId = traderId;
        this.company = company;
        this.createDate = createDate;
    }

    public Stock(String stock_code, int traderId, String company, int companyId, String createDate) {
        this.stock_code = stock_code;
        this.traderId = traderId;
        this.company = company;
        this.companyId = companyId;
        this.createDate = createDate;
    }

    public String getStock_code() {
        return stock_code;
    }

    public void setStock_code(String stock_code) {
        this.stock_code = stock_code;
    }

    public int getTraderId() {
        return traderId;
    }

    public void setTraderId(int traderId) {
        this.traderId = traderId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "\nStock{" + "stock_code=" + stock_code + ", traderId=" + traderId + ", company=" + company + ", createDate=" + createDate + '}';
    }

}
