package com.alibabacloud.polar_race.engine.common.test;

import com.alibabacloud.polar_race.engine.common.EngineRace;
import com.alibabacloud.polar_race.engine.common.logFileAOF.MyLoggerFactory;

import java.util.Random;

public class TestClass {
    private static MyLoggerFactory log = new  MyLoggerFactory(TestClass.class);
    public static byte[]  getTestThreadExample() {
        Random ra =new Random();
        byte[] bytedata = new byte[8];
        for(int i = 0;i<8;i++) {
            bytedata[i] = (byte)(((ra.nextInt(10)+1)*100%256)-128);
        }
        return bytedata;
    }

    public static   void  synchronimmp(int n)throws Exception{
        EngineRace engineRace = new EngineRace();

        for(int i =0;i<n;i++) {
            byte[] by = getTestThreadExample();
            byte[] val = getTestThreadExample();
            engineRace.write(by, val);
            val = engineRace.read(by);
        }
    }




    public static void main(String[] args) {

        long t1=System.currentTimeMillis();
        int threadNumber = 80;
        for(int i=0; i<threadNumber; i++){
            new Thread("" + i){
                public void run(){
                    try {
                        synchronimmp(20);
                    }catch (Exception e){
                        log.myLogger("Thread: 异常" +e);
                    }
                }
            }.start();
        }
        long t2=System.currentTimeMillis();
        log.myLogger("Thread: 数量 " +threadNumber+ "运行时间 ："+(t2-t1)+"毫秒");
    }

}


