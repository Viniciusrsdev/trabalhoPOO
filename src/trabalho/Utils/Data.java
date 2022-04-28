/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oreki
 */
public class Data {

    public static LocalDateTime dataAtual() {
        LocalDateTime h = LocalDateTime.now();
        return h;
    }

    public static String converterDataEmAno(Date data) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String s = formatter.format(data);
        return s;
    }

    public static Date converterDataEmAno(String data) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        Date d;
        try {
            d = formatter.parse(data);
            return d;
        } catch (ParseException ex) {
            return null;
        }
    }
    
    public static String converterData(Date data) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String s = formatter.format(data);
        return s;
    }

    public static Date converterData(String data) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date d;
        try {
            d = formatter.parse(data);
            return d;
        } catch (ParseException ex) {
            return null;
        }
    }
}
