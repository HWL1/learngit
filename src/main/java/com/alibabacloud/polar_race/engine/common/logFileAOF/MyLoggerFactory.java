package com.alibabacloud.polar_race.engine.common.logFileAOF;

public class MyLoggerFactory {

    private  static   Class T;
    public  MyLoggerFactory(Class T){
        this.T = T;
    }


    public static  void  myLogger(String s){
        System.out.println(MyLoggerFactory.T.getName()+" "+s);
    }

}
