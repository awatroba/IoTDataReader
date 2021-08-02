package com.awa;

import com.awa.data.DataInput;

import java.util.List;

public interface Detector {
    void start(List<DataInput> data, int maxDataPortion);
}
