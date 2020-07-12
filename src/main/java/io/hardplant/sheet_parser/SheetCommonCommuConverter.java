package io.hardplant.sheet_parser;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.hardplant.cmmn.impl.MorningSelectionTable;

public class SheetCommonCommuConverter {
    
    private Logger logger = LoggerFactory.getLogger(SheetTableConverter.class);
 
    public List<MorningSelectionTable> sheetToMorningTables(List<List<Object>> datas) {
        List<MorningSelectionTable> tables = new ArrayList<>();
        MorningSelectionTable table = null;
        
        for (List row : datas) {
            try {
                switch (row.size()) {
                    case 0:
                        continue;
                    case 3:
                        // Intro, 퍼펙트 커뮤
                        if (row.get(0).toString().length() != 0) {
                            table = new MorningSelectionTable();
                            table.setIntroJP(row.get(0).toString());
                            table.setChoice1_JP(row.get(1).toString());
                        } else {
                            if (row.get(2).toString().startsWith("굿")) {
                                table.setChoice2_JP(row.get(1).toString());
                            }
                            if (row.get(2).toString().startsWith("노멀")) {
                                table.setChoice3_JP(row.get(1).toString());
                            }

                            if (row.get(2).toString().startsWith("(친애도 +3")) {
                                table.setChoice1_KR(row.get(1).toString());
                            }
                            if (row.get(2).toString().startsWith("(친밀도 +1")) {
                                table.setChoice2_KR(row.get(1).toString());
                            }
                            if (row.get(2).toString().startsWith("(변화 없음")) {
                                table.setChoice3_KR(row.get(1).toString());
                                tables.add(table);
                            }
                        }

                }
            } catch (IndexOutOfBoundsException e) {
                logger.error(row + " was not inserted");
            }
        }

        return tables;
    }
}
