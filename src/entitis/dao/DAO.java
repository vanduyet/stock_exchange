/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitis.dao;

import entitis.Company;
import entitis.Stock;
import entitis.Trader;
import entitis.TraderOrder;
import entitis.TraderOrderBuy;
import entitis.TraderOrderSell;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 *
 * @author zrik
 */
public interface DAO {
    //get init data
    public TreeMap<String, Trader> getTraders();
    public HashMap<String, ArrayList<Stock>> getStocks();
    public ArrayList<Company> getCompany();
    public HashMap<Integer, PriorityQueue<TraderOrderSell>> getSellOrders();
    public HashMap<Integer, PriorityQueue<TraderOrderBuy>> getBuyOrrders();
    
    // insert data 
    public int insertTrader(Trader trader);
    public int insertTraderOrder(TraderOrder traderOrder);
    public int insertStock(Stock stock);
    
    // match trade
    public int matchTrade();
}
