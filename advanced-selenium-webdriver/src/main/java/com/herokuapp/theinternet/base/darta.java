package com.herokuapp.theinternet.base;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class darta {
    private Iterator<Object[]> parseCsvData(String fileName) throws IOException
    {
        BufferedReader input = null;
        File file = new File(fileName);
        input = new BufferedReader(new FileReader(file));
        String line = null;
        ArrayList<Object[]> data = new ArrayList<Object[]>();
        while ((line = input.readLine()) != null)
        {
            String in = line.trim();
            String[] temp = in.split(",");
            List<Object> arrray = new ArrayList<Object>();
            for(String s : temp)
            {
                arrray.add(Integer.parseInt(s));
            }
            data.add(arrray.toArray());
        }
        input.close();
        return data.iterator();
    }
    @DataProvider(name = "testData")
    public Iterator<Object[]> testData() throws IOException
    {
        return parseCsvData("C:\\Work.darta");
    }
}
