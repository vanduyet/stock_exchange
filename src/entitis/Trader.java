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
public class Trader {

    private int id;
    private String username;
    private String createDate;

    public Trader(String username, String createDate) {
        this.username = username;
        this.createDate = createDate;
    }

    public Trader(int id, String username, String createDate) {
        this.id = id;
        this.username = username;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "\nTrader{" + "id=" + id + ", username=" + username + ", createDate=" + createDate + '}';
    }

}
