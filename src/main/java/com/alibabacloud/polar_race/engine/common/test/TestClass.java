package com.alibabacloud.polar_race.engine.common.test;

import com.alibabacloud.polar_race.engine.common.EngineRace;

import java.util.Random;

public class TestClass {

    public static byte[]  getTestThreadExample() {
        Random ra =new Random();
        byte[] bytedata = new byte[8];
        for(int i = 0;i<8;i++) {
            bytedata[i] = (byte)(((ra.nextInt(10)+1)*100%256)-128);
        }
        return bytedata;
    }


    public static void main(String[] args) {

        long t1=System.currentTimeMillis();
        int threadNumber = 10;
        for(int i=0; i<threadNumber; i++){
            new Thread("" + i){
                public void run(){
                    try {
                        EngineRace engineRace = new EngineRace();
                        byte[] by = TestClass.getTestThreadExample();
                        byte[] val = TestClass.getTestThreadExample();
                        engineRace.write(by, val);
                        System.out.println("写入 key：" +by+ "val ："+val);
                        engineRace.read(by);
                        System.out.println("读 key：" +by);
                    }catch (Exception e){
                        System.out.println("Thread: 异常" +e);
                    }
                }
            }.start();
        }



        long t2=System.currentTimeMillis();
        System.out.println("Thread: 数量 " +threadNumber+ "运行时间 ："+(t2-t1));
    }


    }


