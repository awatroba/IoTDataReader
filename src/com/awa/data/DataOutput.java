package com.awa.data;

/**
 * Interface for  the output packet data stream
 */
public interface DataOutput {
    void setTimestamp(long timestamp);

    void setInputValue(short inputValue);

    @Override
    String toString();
}
