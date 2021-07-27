package com.awa.data;
/**
 * Implementation of the input data interface
 */
public class DataInputImpl implements DataInput {
    private long timestamp;
    private short inputValue;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public short getInputValue() {
        return inputValue;
    }

    public void setInputValue(short inputValue) {
        this.inputValue = inputValue;
    }

    @Override
    public String toString() {
        return timestamp + ": " + inputValue;
    }

    /*
     * helper class to create an object of type DataInputImpl
     *   time - timestamp,
     *   value - inputValue
     */
    public static final class Builder {
        private int time;
        private short value;

        public static Builder builder() {
            return new Builder();
        }

        public Builder time(int time) {
            this.time = time;
            return this;
        }

        public Builder value(short value) {
            this.value = value;
            return this;
        }

        public DataInputImpl build() {
            DataInputImpl data = new DataInputImpl();
            data.setTimestamp(time);
            data.setInputValue(value);
            return data;
        }
    }
}
