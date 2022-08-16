package com.atguigu.commonutils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionToFile {

    public static String getMessage(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
        } finally {
            if ( sw != null){
                try {
                    sw.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if ( pw != null){
                pw.close();
            }
        }
    return sw.toString();

    }

}
