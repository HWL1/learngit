package com.alibabacloud.polar_race.engine.common;

import com.alibabacloud.polar_race.engine.common.engineDao.DBmap;
import com.alibabacloud.polar_race.engine.common.engineDao.SingletonDBMap;
import com.alibabacloud.polar_race.engine.common.exceptions.EngineException;
import com.alibabacloud.polar_race.engine.common.logFileAOF.MyLoggerFactory;
import com.alibabacloud.polar_race.engine.common.util.UtilClass;

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
		log.myLogger("写入 key：[" + UtilClass.toString(key )+ " ]  val ：[" + UtilClass.toString(value) );
	}

	@Override
	public byte[] read(byte[] key) throws EngineException {
		if(singletonDBMap == null)
			log.myLogger("singletonDBMap = "+singletonDBMap);

		byte[] val = singletonDBMap.read(key);
		log.myLogger("读 key：[" +UtilClass.toString(key )+ " ]   val ：[" + UtilClass.toString(val) );
		return val;
	}
	
	@Override
	public void range(byte[] lower, byte[] upper, AbstractVisitor visitor) throws EngineException {
	}
	
	@Override
	public void close() {
	}

}
