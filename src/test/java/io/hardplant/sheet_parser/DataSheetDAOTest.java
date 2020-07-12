package io.hardplant.sheet_parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class DataSheetDAOTest {
    
    @Test
    public void test() throws Exception {
        List<List<Object>> datas = new DataSheetDAO().getMorningDatas("마노_P");
        
        assertEquals(0, datas.get(0).size());
    }
}