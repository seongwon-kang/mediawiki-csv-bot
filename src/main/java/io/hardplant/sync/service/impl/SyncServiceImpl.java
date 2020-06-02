package io.hardplant.sync.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import io.hardplant.cmmn.CommuTable;
import io.hardplant.cmmn.CommuTableTemplate;
import io.hardplant.cmmn.WikiEditor;
import io.hardplant.sheet_parser.SheetDAO;
import io.hardplant.sheet_parser.SheetTableConverter;
import io.hardplant.sync.service.SyncService;

public class SyncServiceImpl implements SyncService {

    @Resource
    SheetDAO sheetDao;

    @Resource
    WikiEditor wikiEditor;

    @Resource
    SheetTableConverter converter;

    @Override
    public int syncWikiWithSheet(String sheetName, String id, String pwd) {
        wikiEditor.logon("", "");
        List<CommuTableTemplate> templates = getTemplateFromSheet(sheetName);

        // TODO: 변경 플래그 추가
        for (CommuTableTemplate template : templates) {
            wikiEditor.overwrite(sheetName + "\\" + template.title, template.toContent(), "봇에 의한 자동 수정");
        }
            
        return templates.size();
    }

    @Override
    public List<CommuTableTemplate> getTemplateFromSheet(String sheetName){
        List<CommuTableTemplate> templates = new ArrayList<>();
        try {
            List<List<Object>> datas = sheetDao.getDatas(sheetName);
                
            List<CommuTable> tables = converter.sheetToTableDatas(datas);
            
            for (CommuTable table : tables) {
                CommuTableTemplate template = new CommuTableTemplate();
                template.setTable(table);

                templates.add(template);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return templates;
    }

}