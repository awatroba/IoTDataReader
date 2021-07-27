package com.awa.data;

/**
 * Interface for  the input packet data stream
 */
public interface DataInput {
    long getTimestamp();

    void setTimestamp(long timestamp);

    short getInputValue();

    void setInputValue(short inputValue);

    @Override
    String toString();
}

