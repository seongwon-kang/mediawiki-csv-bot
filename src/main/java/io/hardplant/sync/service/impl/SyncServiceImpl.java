package io.hardplant.sync.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.hardplant.cmmn.WikiEditor;
import io.hardplant.cmmn.impl.CommuTable;
import io.hardplant.cmmn.impl.CommuTableTemplate;
import io.hardplant.sheet_parser.SheetDAO;
import io.hardplant.sheet_parser.SheetTableConverter;
import io.hardplant.sync.service.SyncService;

public class SyncServiceImpl implements SyncService {

    private static final Logger logger = LoggerFactory.getLogger(SyncService.class);

    @Resource
    SheetDAO sheetDao;

    @Resource
    WikiEditor wikiEditor;

    @Resource
    SheetTableConverter converter;

    @Override
    public boolean logonWiki(String id, String pwd) {
        wikiEditor.logon(id, pwd);

        if (!wikiEditor.isLoggedOn) {
            logger.error("Wiki not logged on");
            return false;
        }
        
        return true;
    }

    @Override
    public int syncWikiWithSheet(String sheetName) {
        List<CommuTableTemplate> templates = getTemplateFromSheet(sheetName);
            
        return syncWikiFromTemplates(templates);
    }
    
    @Override
    public int syncWikiFromTemplates(List<CommuTableTemplate> templates) {

        for (CommuTableTemplate template : templates) {
            wikiEditor.overwrite(template.title, template.toContent(), "봇에 의한 자동 수정");
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