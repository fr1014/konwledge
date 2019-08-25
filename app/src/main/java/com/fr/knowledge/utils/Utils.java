package com.fr.knowledge.utils;

import android.content.Context;
import android.widget.Toast;

import androidx.databinding.BindingConversion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Utils {

    @BindingConversion
    public static String convertDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    public static Date StrToDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static boolean isEmpty(List list) {
        return null != list && list.isEmpty();
    }

    public static void ToastShort(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void ToastLong(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
