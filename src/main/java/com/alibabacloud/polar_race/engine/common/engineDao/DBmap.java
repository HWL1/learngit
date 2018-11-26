package com.alibabacloud.polar_race.engine.common.engineDao;

import com.alibabacloud.polar_race.engine.common.exceptions.EngineException;

import java.util.concurrent.ConcurrentHashMap;

public class DBmap {

    private static volatile ConcurrentHashMap<byte[],byte[]> DBMap;
    public byte[] read(byte[] key)throws EngineException {

        return DBMap.get(key);

    }

    public void write(byte[] key,byte[] val)throws EngineException {

        DBMap.put(key, val);
    }


}
