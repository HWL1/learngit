package com.alibabacloud.polar_race.engine.common.engineDao;

import com.alibabacloud.polar_race.engine.common.exceptions.EngineException;
import com.alibabacloud.polar_race.engine.common.logFileAOF.MyLoggerFactory;
import com.alibabacloud.polar_race.engine.common.util.UtilClass;

import java.util.concurrent.ConcurrentHashMap;

public class DBmap {
    private static  MyLoggerFactory log = new  MyLoggerFactory(DBmap.class);
    private static volatile ConcurrentHashMap<byte[],byte[]> DBMap;
    public DBmap(){
        DBMap = new ConcurrentHashMap<byte[],byte[]>();
    }
    public static  ConcurrentHashMap <byte[],byte[]> getMap(){
        return DBMap;
    }
    public static  void setMap(ConcurrentHashMap <byte[],byte[]> DBMap){
        DBmap.DBMap = DBMap;
    }


    public byte[] read(byte[] key)throws EngineException {
     try {
      return DBMap.get(key);
        }catch (Exception e){
        System.out.println("key:为空" + UtilClass.toString(key));
        return null;
        }
    }

    public void write(byte[] key,byte[] val)throws EngineException {
        if(SingletonDBMap.getInstance().DBMap == null){
            log.myLogger("SingletonDBMap.getInstance().DBMap:为空" + UtilClass.toString(key));
            DBMap = SingletonDBMap.getInstance().DBMap;
        }
        DBMap.put(key, val);

    }


}
