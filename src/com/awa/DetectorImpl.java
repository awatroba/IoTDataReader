package com.awa;

import com.awa.data.DataInput;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DetectorImpl implements Detector {
    private short presentValue;
    private long previousTimestamp;
    private int maxDataPortion;
    private List<DataInput> data;

    @Override
    public void start(List<DataInput> data, int maxDataPortion) {
        initialValue(data, maxDataPortion);
        monitor(data);
        int count = maxDataPortion;
        while (count < data.size()) {
            if (maxDataPortion + count < data.size())
                monitor(data.subList(count, maxDataPortion + count));
            else
                monitor(data.subList(count, data.size()));
            count += maxDataPortion;
        }
    }

    private void monitor(List<DataInput> data) {
        System.out.println(data.stream()
                .limit(maxDataPortion)
                .sorted(Comparator.comparing(DataInput::getTimestamp))
                .filter(x -> checkStatusChanges(x))
                .collect(Collectors.toList()));
    }

    private boolean checkStatusChanges(DataInput data) {
        if (data.getInputValue() != presentValue) {
            setPresentValue(data.getInputValue());
            return true;
        }
        return false;
    }

    private void setPresentValue(short value) {
        this.presentValue = value;
    }

    public void setPreviousTimestamp(long previousTimestamp) {
        this.previousTimestamp = previousTimestamp;
    }

    private void setFirstValue(short value) {
        this.presentValue = (short) (value == 1 ? 0 : 1);
    }

    private void initialValue(List<DataInput> data, int maxDataPortion) {
        this.maxDataPortion = maxDataPortion;
        this.data = data;
        setFirstValue(data.get(0).getInputValue());
        setPreviousTimestamp(data.get(0).getTimestamp());
    }
}
