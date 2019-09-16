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
public class TraderOrderSell extends TraderOrder implements Comparable<TraderOrder> {

    public TraderOrderSell(int traderId, int companyId, int quantity, float price, int state, String createDate) {
        super(traderId, companyId, quantity, price, state, createDate);
    }

    public TraderOrderSell(int id, int traderId, int companyId, int quantity, float price, int state, String createDate) {
        super(id, traderId, companyId, quantity, price, state, createDate);
    }

    @Override
    public int compareTo(TraderOrder t) {
        float num = this.getPrice() - t.getPrice();
        return num == 0 ? 0 : num > 0 ? 1 : -1;
    }

}
