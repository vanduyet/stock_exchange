/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockex.util;

import entitis.Account;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author zrik
 */
public class DataProperties {

    private Properties properties;

    public DataProperties(String propertyName) {
        properties = new Properties();
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();

        try {
            properties.load(new FileInputStream(rootPath + propertyName));
        } catch (FileNotFoundException ex) {
            System.out.println("Not have file " + propertyName);
        } catch (IOException ex) {
            System.out.println("Can read file " + propertyName);
        }
    }

    public Account getAccount() {
        Account account;
        account = new Account(properties.getProperty("USERNAME"),
                properties.getProperty("PASSWORD"));
        return account;
    }

    public Properties getProperties() {
        return properties;
    }
}
