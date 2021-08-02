package com.awa;

import com.awa.data.DataInput;
import com.awa.data.DataInputImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * Class for reading data from a file
 * split - char for separating data = ;
 */
public class MyReader {
    private static String split = ":";

    static List<DataInput> read(String filePath) {
        List<DataInput> flows = new LinkedList<>();

        String line = "";

        File file = new File(filePath);

        Scanner in = null;

        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (in.hasNext()) {
            line = in.nextLine().replace(" ", "");
            String[] a = line.split(split);
            flows.add(DataInputImpl.Builder
                    .builder()
                    .time(Integer.valueOf(a[0]))
                    .value(Short.valueOf(a[1]))
                    .build());
        }

        return flows;
    }
}