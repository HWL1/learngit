package com.alibabacloud.polar_race.engine.common.test;

import com.alibabacloud.polar_race.engine.common.EngineRace;
import com.alibabacloud.polar_race.engine.common.logFileAOF.MyLoggerFactory;
import com.alibabacloud.polar_race.engine.common.util.UtilClass;

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

    public static   void  synchronimmp()throws Exception{
        EngineRace engineRace = new EngineRace();
        byte[] by = TestClass.getTestThreadExample();
        byte[] val = TestClass.getTestThreadExample();
        engineRace.write(by, val);
        log.myLogger("写入 key：[" + UtilClass.toString(by )+ " ]  val ：[" + UtilClass.toString(val) );

        val = engineRace.read(by);
        log.myLogger("读 key：[" +UtilClass.toString(by )+ " ]   val ：[" + UtilClass.toString(val) );
    }




    public static void main(String[] args) {

        long t1=System.currentTimeMillis();
        int threadNumber = 80;
        for(int i=0; i<threadNumber; i++){
            new Thread("" + i){
                public void run(){
                    try {
                        synchronimmp();
                    }catch (Exception e){
                        System.out.println("Thread: 异常" +e);
                    }
                }
            }.start();
        }



        long t2=System.currentTimeMillis();
        System.out.println("Thread: 数量 " +threadNumber+ "运行时间 ："+(t2-t1)+"毫秒");
    }

}


