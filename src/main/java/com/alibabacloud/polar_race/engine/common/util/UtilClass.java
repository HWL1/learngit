package com.alibabacloud.polar_race.engine.common.util;

public class UtilClass {

    public static  String  toString(byte[] by){

        String s ="";
        for(int i =0;i<by.length;i++){
            s = s+""+by[i];
        }
        return s;
    }




}
