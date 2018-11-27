package com.alibabacloud.polar_race.engine.common;

import com.alibabacloud.polar_race.engine.common.engineDao.DBmap;
import com.alibabacloud.polar_race.engine.common.engineDao.SingletonDBMap;
import com.alibabacloud.polar_race.engine.common.exceptions.EngineException;
import com.alibabacloud.polar_race.engine.common.logFileAOF.MyLoggerFactory;

public class EngineRace extends AbstractEngine {
	private static MyLoggerFactory log = new  MyLoggerFactory(EngineRace.class);
	DBmap singletonDBMap = SingletonDBMap.getInstance();
	@Override
	public void open(String path) throws EngineException {
	}
	
	@Override
	public void write(byte[] key, byte[] value) throws EngineException {
		if(singletonDBMap == null)
			log.myLogger("singletonDBMap = "+singletonDBMap);

		singletonDBMap.write(key,value);
	}

	@Override
	public byte[] read(byte[] key) throws EngineException {
		return singletonDBMap.read(key);
	}
	
	@Override
	public void range(byte[] lower, byte[] upper, AbstractVisitor visitor) throws EngineException {
	}
	
	@Override
	public void close() {
	}

}
