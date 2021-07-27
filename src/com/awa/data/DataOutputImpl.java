package com.awa.data;

public class DataOutputImpl implements DataOutput {
    private long timestamp;
    private short inputValue;
    @Override
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }


    @Override
    public void setInputValue(short inputValue) {
        this.inputValue = inputValue;
    }

    @Override
    public String toString() {
        return timestamp + ": " + inputValue;
    }

}
