/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockex.util;

import entitis.Company;
import entitis.Stock;
import entitis.Trader;
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
public class Common {

    public static final int SELL_STOCK = 0;
    public static final int BUY_STOCK = 1;
    public static final int MATCHED_STOCK = 2;

    public static TreeMap<String, Trader> registedTraders;
    public static HashMap<String, ArrayList<Stock>> listStock;
    public static ArrayList<Company> listCompany;
    public static HashMap<Integer, PriorityQueue<TraderOrderSell>> sellOrders;
    public static HashMap<Integer, PriorityQueue<TraderOrderBuy>> buyOrrders;
}
