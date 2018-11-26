package com.alibabacloud.polar_race.engine.common.engineDao;

import com.alibabacloud.polar_race.engine.common.exceptions.EngineException;

import java.util.concurrent.ConcurrentHashMap;

public class SingletonDBMap {

    private static volatile SingletonDBMap singletonMap;
    private static volatile ConcurrentHashMap<byte[],byte[]>  DBMap;
    private SingletonDBMap() {}
    public static SingletonDBMap getInstance() {
        if (singletonMap == null) {
            synchronized (SingletonDBMap.class) {
                if (singletonMap == null) {
                    singletonMap = new SingletonDBMap();
                }
            }
        }
        return singletonMap;
    }
    public byte[] read(byte[] key)throws EngineException{

      return DBMap.get(key);

    }


    public void write(byte[] key,byte[] val)throws EngineException {

            DBMap.put(key, val);
    }


}
