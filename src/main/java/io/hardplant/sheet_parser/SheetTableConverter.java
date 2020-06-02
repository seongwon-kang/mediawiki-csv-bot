package io.hardplant.sheet_parser;

import java.util.ArrayList;
import java.util.List;

import io.hardplant.cmmn.CommuTable;

public class SheetTableConverter {
    public List<CommuTable> sheetToTableDatas(List<List<Object>> datas) {
        
        List<CommuTable> tables = new ArrayList<>();
        CommuTable commuTable = new CommuTable();

        for (List row : datas) {
            if (row.toString().startsWith("#FILENAME:")) {
                commuTable = new CommuTable();
            } else if (row.toString().startsWith("EOF")) {
                tables.add(commuTable);
            } else if (row.get(1).toString().startsWith("id")) {

            } else {
                row.get(1);
                row.get(2);
                row.get(3);
                row.get(4);
            }
        }

        return tables;
    }
}