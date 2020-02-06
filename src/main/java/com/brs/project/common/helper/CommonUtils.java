package com.brs.project.common.helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class CommonUtils {

    public static String generateUUID(){
        String uid = UUID.randomUUID().toString();
        StringBuilder sb = new StringBuilder();
        sb.append(uid.substring(0,8));
        sb.append(uid.substring(9,13));
        sb.append(uid.substring(14,18));
        sb.append(uid.substring(19,23));
        sb.append(uid.substring(24));
        return sb.toString().toUpperCase();
    }

    public Date generateDate(){
        Date date = Calendar.getInstance().getTime();
        return date;
    }

    public String convertDate(Date date, String format){
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String strDate = formatter.format(date);
        return strDate;
    }

}
