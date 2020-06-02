package io.hardplant.sync.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import io.hardplant.cmmn.CommuTable;
import io.hardplant.cmmn.CommuTableTemplate;
import io.hardplant.sheet_parser.SheetTableConverter;
import io.hardplant.sync.service.SyncService;

@SpringBootTest
@ContextConfiguration(classes = { TestConfig.class })
public class SyncServiceImplTest {

    @Resource
    private SyncService syncService;

    @Test
    public void getTemplateFromSheet() {
        assertNotNull(syncService);

        List<CommuTableTemplate> templates = syncService.getTemplateFromSheet("사쿠라기 마노");
        
        assertNotNull(templates);
    }


    @Test
    public void uploadWikiFromTemplateData() {
        List<CommuTableTemplate> templates = getTestTemplates();

        assertEquals("P\\SR-1\\ショッピング日和", templates.get(0).title);
        
        syncService.logonWiki("Hardplant2", "1q2w3e4r");
        
        syncService.syncWikiFromTemplates(templates);
    }

    private List<CommuTableTemplate> getTestTemplates() {
        // Ready template
        List<CommuTableTemplate> templates= new ArrayList();
        List<CommuTable> tables = getTables();

        for (CommuTable table : tables) {
            CommuTableTemplate template = new CommuTableTemplate();
            template.setTable(table);

            templates.add(template);
        }
        return templates;
    }
    
    private List<CommuTable> getTables() {
        SheetTableConverter converter = new SheetTableConverter();

        List<List<Object>> datas = getMockData();

        return converter.sheetToTableDatas(datas);
    }

    private List<List<Object>> getMockData() {

        List<List<Object>> data = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            data.add(new ArrayList<>());
        }

        data.get(0).add("#FILENAME: P\\SR-1\\ショッピング日和.csv");

        data.get(1).add("");
        data.get(1).add("id");
        data.get(1).add("name");
        data.get(1).add("text");
        data.get(1).add("trans");

        data.get(2).add("");
        data.get(2).add("select");
        data.get(2).add("");
        data.get(2).add("似合うと思うな");
        data.get(2).add("어울린다고 생각해.");

        data.get(3).add("");
        data.get(3).add("0000000000000");
        data.get(3).add("");
        data.get(3).add("★選択肢①【似合うと思うな】");
        data.get(3).add("★선택지①【어울린다고 생각해】");

        data.get(4).add("");
        data.get(4).add("info");
        data.get(4).add("produce_events/200100301.json");

        data.get(5).add("译者");

        data.get(6).add("#EOF");

        data.get(7).add("#FILENAME: P\\SR-1\\ショッピング日和.csv");

        data.get(8).add("");
        data.get(8).add("id");
        data.get(8).add("name");
        data.get(8).add("text");
        data.get(8).add("trans");

        data.get(9).add("");
        data.get(9).add("select");
        data.get(9).add("");
        data.get(9).add("似合うと思うな");
        data.get(9).add("어울린다고 생각해.");

        data.get(10).add("");
        data.get(10).add("0000000000000");
        data.get(10).add("");
        data.get(10).add("★選択肢①【似合うと思うな】");
        data.get(10).add("★선택지①【어울린다고 생각해】");

        data.get(11).add("");
        data.get(11).add("info");
        data.get(11).add("produce_events/200100301.json");

        data.get(12).add("译者");

        data.get(13).add("#EOF");

        return data;
    }

}
    