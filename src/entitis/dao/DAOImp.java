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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 *
 * @author zrik
 */
public class DAOImp implements DAO {

    private final ConnectDB connect;
    private Statement stat;
    private PreparedStatement preStat;

    public DAOImp() {
        connect = new ConnectDB();
    }

    @Override
    public TreeMap<String, Trader> getTraders() {
        TreeMap<String, Trader> listTrader = new TreeMap<>();
        ResultSet rs;
        Trader trader;

        String sql = "select * from trader";

        try {
            stat = connect.getConnect().createStatement();
            rs = stat.executeQuery(sql);

            while (rs.next()) {
                trader = new Trader(rs.getInt(1), rs.getString(2), rs.getString(3));
                listTrader.put(rs.getString(2), trader);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage() + " getTrader method");
        } finally {
            try {
                stat.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage() + " close statement");
            }
            connect.closeConnect();
        }

        return listTrader;
    }

    @Override
    public HashMap<String, ArrayList<Stock>> getStocks() {
        HashMap<String, ArrayList<Stock>> listStock = new HashMap<>();
        ResultSet rs;
        Stock stock;
        ArrayList<Stock> stockOfCompany;
        String company;

        String sql = "select stock_code, trader_id, name, create_date "
                + "from stock s join company c on s.company_id = c.id";

        try {
            stat = connect.getConnect().createStatement();
            rs = stat.executeQuery(sql);

            while (rs.next()) {
                company = rs.getString(3);
                if (!listStock.containsKey(company)) {
                    stockOfCompany = new ArrayList<>();
                    stock = new Stock(rs.getString(1), rs.getInt(2), company, rs.getString(4));

                    stockOfCompany.add(stock);
                    listStock.put(company, stockOfCompany);
                } else {
                    stock = new Stock(rs.getString(1), rs.getInt(2), company, rs.getString(4));
                    listStock.get(company).add(stock);
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage() + " getStocks method");
        } finally {
            try {
                stat.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage() + " close statement");
            }
            connect.closeConnect();
        }

        return listStock;
    }

    @Override
    public ArrayList<Company> getCompany() {
        ArrayList<Company> listCompany = new ArrayList<>();
        ResultSet rs;
        Company company;

        String sql = "select * from company";

        try {
            stat = connect.getConnect().createStatement();
            rs = stat.executeQuery(sql);

            while (rs.next()) {
                company = new Company(rs.getInt(1), rs.getString(2));
                listCompany.add(company);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage() + " getCompany method");
        } finally {
            try {
                stat.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage() + " close statment");
            }
            connect.closeConnect();
        }

        return listCompany;
    }

    @Override
    public HashMap<Integer, PriorityQueue<TraderOrderSell>> getSellOrders() {
        HashMap<Integer, PriorityQueue<TraderOrderSell>> sellOrders = new HashMap<>();
         PriorityQueue<TraderOrderSell> orderEarchCompany = null;

        ResultSet rs;
        TraderOrderSell traderOrder;

        String sql = "select * from trader_order where state = 0";

        try {
            stat = connect.getConnect().createStatement();
            rs = stat.executeQuery(sql);

            while (rs.next()) {
                traderOrder = new TraderOrderSell(rs.getInt(1), rs.getInt(2),
                        rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getInt(6), rs.getString(7));
                if (!sellOrders.containsKey(rs.getInt(3))) {
                    orderEarchCompany = new PriorityQueue<>();
                    sellOrders.put(rs.getInt(3), orderEarchCompany);
                }
                sellOrders.get(rs.getInt(3)).add(traderOrder);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage() + " getSellOrder method");
        } finally {
            try {
                stat.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage() + " close statment");
            }
            connect.closeConnect();
        }

        return sellOrders;
    }

    @Override
    public HashMap<Integer, PriorityQueue<TraderOrderBuy>> getBuyOrrders() {
        HashMap<Integer, PriorityQueue<TraderOrderBuy>> buyOrders = new HashMap<>();

        PriorityQueue<TraderOrderBuy> orderEarchCompany = null;
        ResultSet rs;
        TraderOrderBuy traderOrder;

        String sql = "select * from trader_order where state = 1";

        try {
            stat = connect.getConnect().createStatement();
            rs = stat.executeQuery(sql);

            while (rs.next()) {
                traderOrder = new TraderOrderBuy(rs.getInt(1), rs.getInt(2),
                        rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getInt(6), rs.getString(7));
                if (!buyOrders.containsKey(rs.getInt(3))) {
                    orderEarchCompany = new PriorityQueue<>();
                    buyOrders.put(rs.getInt(3), orderEarchCompany);
                }
                buyOrders.get(rs.getInt(3)).add(traderOrder);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage() + " getBuyOrder method");
        } finally {
            try {
                stat.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage() + " close statment");
            }
            connect.closeConnect();
        }

        return buyOrders;
    }

    @Override
    public int insertTrader(Trader trader) {
        int hasRow = 0;
        String sql = "insert into trader (username, create_date) values (?, ?) ";

        try {
            preStat = connect.getConnect().prepareStatement(sql);
            preStat.setString(1, trader.getUsername());
            preStat.setString(2, trader.getCreateDate());

            hasRow = preStat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " insertTrader method");
        } finally {
            try {
                stat.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage() + " close statment");
            }
            connect.closeConnect();
        }

        return hasRow;
    }

    @Override
    public int insertTraderOrder(TraderOrder traderOrder) {
        int hasRow = 0;
        String sql = "insert into trader_order (trader_id, company_id, quantity, price, state, create_date) "
                + "values (?, ?, ?, ?, ?, ?) ";

        try {
            preStat = connect.getConnect().prepareStatement(sql);
            preStat.setInt(1, traderOrder.getTraderId());
            preStat.setInt(2, traderOrder.getCompanyId());
            preStat.setInt(3, traderOrder.getQuantity());
            preStat.setFloat(4, traderOrder.getPrice());
            preStat.setInt(5, traderOrder.getState());
            preStat.setString(6, traderOrder.getCreateDate());

            hasRow = preStat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " insertTraderOrder method");
        } finally {
            try {
                stat.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage() + " close statment");
            }
            connect.closeConnect();
        }

        return hasRow;
    }

    @Override
    public int insertStock(Stock stock) {
    int hasRow = 0;
        String sql = "insert into stock values (?, ?, ?, ?) ";

        try {
            preStat = connect.getConnect().prepareStatement(sql);
            preStat.setString(1, stock.getStock_code());
            preStat.setInt(2, stock.getCompanyId());
            preStat.setInt(3, stock.getTraderId());
            preStat.setString(4, stock.getCreateDate());
            
            hasRow = preStat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + " insertStock method");
        } finally {
            try {
                stat.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage() + " close statment");
            }
            connect.closeConnect();
        }

        return hasRow;    
    }

    @Override
    public int matchTrade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
