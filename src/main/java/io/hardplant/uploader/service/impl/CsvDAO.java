package io.hardplant.uploader.service.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import io.hardplant.uploader.service.CommuTable;

@Repository
public class CsvDAO {

    private String filename = "mycsv.csv";

    public List<String[]> readCsv() {
        List<String[]> data = new ArrayList<String[]>();

        try {
            CSVReader reader = new CSVReader(new FileReader(filename));
            // UTF-8
            // CSVReader reader = new CSVReader(new InputStreamReader(new
            // FileInputStream(filename), "UTF-8"), ",", '"', 1);
            String[] s;
            while ((s = reader.readNext()) != null) {
                data.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
    
    public List<CommuTable> readTableWithRowname(String[] rowNames, String filename) {
 
        List<CommuTable> data = null;
 
        try {
            CSVReader reader = new CSVReader(new FileReader(filename));
 
            ColumnPositionMappingStrategy<CommuTable> start = new ColumnPositionMappingStrategy<CommuTable>();
            start.setType(CommuTable.class);
            start.setColumnMapping(rowNames);
            CsvToBean<CommuTable> csv = new CsvToBean<CommuTable>();
            data = csv.parse(start, reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
 
        return data;
    }
}