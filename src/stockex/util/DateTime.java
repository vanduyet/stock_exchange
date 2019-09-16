/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockexchange.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author zrik
 */
public class DateTime {
    private DateTimeFormatter dateFormatter;
    private LocalDateTime now;
    
    public DateTime() {
    }
    
    public String getCurrentDateTime() {
        dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        now = LocalDateTime.now();
        
        return dateFormatter.format(now);
    }
    
    public String getCurrentDate() {
        dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        now = LocalDateTime.now();
        
        return dateFormatter.format(now);
    }
}
