package io.hardplant.sheet_parser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import io.hardplant.cmmn.impl.CommuRow;
import io.hardplant.cmmn.impl.CommuTable;

@Component
public class SheetTableConverter {

    public List<CommuTable> sheetToTableDatas(List<List<Object>> datas) {

        List<CommuTable> tables = new ArrayList<>();
        CommuTable commuTable = new CommuTable();

        for (List row : datas) {
            if (row.size() == 0) continue;
            if (row.size() < 2) {
                if (row.get(0).toString().startsWith("#FILENAME:")) {
                    commuTable = new CommuTable();
                    commuTable.translator = "";
                    commuTable.fileheaderToInfo(row.get(0).toString());
                } else if (row.get(0).toString().startsWith("#EOF")) {
                    tables.add(commuTable);
                }
            } else {
                if (row.get(1).toString().startsWith("id")) {
                    // header
                    continue;
                } else if (row.get(1).toString().startsWith("info")) {
                    // json info
                    commuTable.info = row.get(2).toString();
                } else if (row.get(1).toString().startsWith("译者")) {
                    // translator
                    try {
                        commuTable.translator = row.get(2).toString();
                    } catch (Exception e) {
                        commuTable.translator = "";
                    }
                } else {
                    String id = row.get(1).toString();
                    String name = row.get(2).toString();
                    String text = row.get(3).toString();
                    String trans = row.get(4).toString();

                    commuTable.commus.add(new CommuRow(id, name, text, trans));
                }
            }
        }
        return tables;
    }
}