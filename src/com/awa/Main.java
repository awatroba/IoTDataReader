package com.awa;

import com.awa.data.DataInput;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<DataInput> data = MyReader.read("plik.txt");
        Detector detector = new DetectorImpl();
        detector.start(data,30);
    }
}
