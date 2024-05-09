package com.phonepe.alertconfig;

/*
 * code by Akash Mishra (akash.mish97@gmail.com)
 */
public class AlertConfig {
    private String type;
    private int count;
    private int windowSizeInSecs;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getWindowSizeInSecs() {
        return windowSizeInSecs;
    }

    public void setWindowSizeInSecs(int windowSizeInSecs) {
        this.windowSizeInSecs = windowSizeInSecs;
    }

    @Override
    public String toString() {
        return "AlertConfig [type=" + type + ", count=" + count + ", windowSizeInSecs=" + windowSizeInSecs + "]";
    }

    
}