package com.alibabacloud.polar_race.engine.common.engineDao;

public class SingletonDBMap {

    private static volatile DBmap singletonMap;

    private SingletonDBMap() {}
    public static DBmap getInstance() {
        if (singletonMap == null) {
            synchronized (DBmap.class) {
                if (singletonMap == null) {
                    singletonMap = new DBmap();
                }
            }
        }
        return singletonMap;
    }



}
