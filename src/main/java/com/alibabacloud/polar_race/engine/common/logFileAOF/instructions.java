package com.alibabacloud.polar_race.engine.common.logFileAOF;

import java.io.Serializable;
import java.util.Arrays;

public class instructions implements Serializable {


    enum Signal {
        WRITE,READ, RANGE
    }

    private  byte[]  key;

    private  byte[] val;

    private byte[] lower;

    private  byte[] upper;

    private  Signal type;

    public byte[] getKey() {
        return key;
    }

    public byte[] getVal() {
        return val;
    }

    public byte[] getLower() {
        return lower;
    }

    public byte[] getUpper() {
        return upper;
    }

    public Signal getType() {
        return type;
    }

    public void setKey(byte[] key) {
        this.key = key;
    }

    public void setVal(byte[] val) {
        this.val = val;
    }

    public void setLower(byte[] lower) {
        this.lower = lower;
    }

    public void setUpper(byte[] upper) {
        this.upper = upper;
    }

    public void setType(Signal type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "instructions{" +
                "key=" + Arrays.toString(key) +
                ", val=" + Arrays.toString(val) +
                ", lower=" + Arrays.toString(lower) +
                ", upper=" + Arrays.toString(upper) +
                ", type=" + type +
                '}';
    }
}
