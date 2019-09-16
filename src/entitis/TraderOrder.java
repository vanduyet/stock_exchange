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
public class TraderOrder {

    private int id;
    private int traderId;
    private int companyId;
    private int quantity;
    private float price;
    private int state;
    private String createDate;

    public TraderOrder(int traderId, int companyId, int quantity, float price, int state, String createDate) {
        this.traderId = traderId;
        this.companyId = companyId;
        this.quantity = quantity;
        this.price = price;
        this.state = state;
        this.createDate = createDate;
    }

    
    public TraderOrder(int id, int traderId, int companyId, int quantity, float price, int state, String createDate) {
        this.id = id;
        this.traderId = traderId;
        this.companyId = companyId;
        this.quantity = quantity;
        this.price = price;
        this.state = state;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTraderId() {
        return traderId;
    }

    public void setTraderId(int traderId) {
        this.traderId = traderId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "\nTraderOrder{" + "id=" + id + ", traderId=" + traderId + ", "
                + "companyId=" + companyId + ", quantity=" + quantity + ", "
                + "price=" + price + ", state=" + state + ", createDate=" + createDate + '}';
    }

}
