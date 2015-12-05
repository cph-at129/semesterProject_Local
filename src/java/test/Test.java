/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author terziev
 */
public class Test {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        Date date1 = sdf1.parse("01-01-2016 06:00:00");
        System.out.println(date1);

        System.out.println("--------------------------");

        DateFormat sdfISO = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        Date date2 = sdfISO.parse("2001-07-04T12:08:56.235-0700");
        System.out.println(date2);

    }
}
