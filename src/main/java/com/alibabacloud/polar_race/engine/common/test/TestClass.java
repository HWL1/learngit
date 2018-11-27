package com.alibabacloud.polar_race.engine.common.test;

import com.alibabacloud.polar_race.engine.common.EngineRace;
import com.alibabacloud.polar_race.engine.common.logFileAOF.MyLoggerFactory;

import java.util.Random;
import java.util.Vector;

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

    public static   void  synchronimmp(long   n)throws Exception{
        EngineRace engineRace = new EngineRace();

        for(long  i = 0;i<n;i++) {
            byte[] by = getTestThreadExample();
            byte[] val = getTestThreadExample();
            engineRace.write(by, val);
            //val = engineRace.read(by);
        }
    }




    public static void main(String[] args) {

        long t1=System.currentTimeMillis();
        int threadNumber = 64;
        int threadIndex = 10;
        Vector<Thread> ts = new Vector<Thread>();
        for(int i=0; i<threadNumber; i++){
            Thread t = new Thread(new Runnable() {
                public void run() {
                    try {
                        synchronimmp(threadIndex);
                    } catch (Exception e) {
                        log.myLogger("Thread: 异常" + e);
                    }
                }
            });
            t.start();
            ts.add(t);

        }
        for (Thread t : ts) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long t2=System.currentTimeMillis();
        log.myLogger("Thread: 数量 = " +threadNumber+ "；  每个线程执行次数 = "+threadIndex+" ；   运行时间 ："+(t2-t1)+"毫秒；");
    }

}


