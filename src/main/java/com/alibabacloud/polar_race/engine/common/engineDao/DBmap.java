package com.alibabacloud.polar_race.engine.common.engineDao;

import com.alibabacloud.polar_race.engine.common.exceptions.EngineException;
import com.alibabacloud.polar_race.engine.common.logFileAOF.MyLoggerFactory;
import com.alibabacloud.polar_race.engine.common.util.UtilClass;

import java.util.concurrent.ConcurrentHashMap;

public class DBmap {
    private static  MyLoggerFactory log = new  MyLoggerFactory(DBmap.class);
    private static volatile ConcurrentHashMap<byte[],byte[]> DBMap;
    public byte[] read(byte[] key)throws EngineException {
  try {
      return DBMap.get(key);
  }catch (Exception e){
      System.out.println("key:为空" + UtilClass.toString(key));
      return null;
  }
    }

    public void write(byte[] key,byte[] val)throws EngineException {
        System.out.println("write   key:" +key[0]+ "    val:"+val[0]);
        DBMap.put(key, val);
        log.myLogger(""+DBMap.get(key));
    }


}
