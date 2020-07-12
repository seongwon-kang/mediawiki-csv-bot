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
            
        return syncWikiFromTemplates(sheetName, templates);
    }
    
    @Override
    public int syncWikiFromTemplates(String sheetName, List<CommuTableTemplate> templates) {
        
        for (CommuTableTemplate template : templates) {
            String[] splits = template.title.split("/");
            String title = splits[splits.length - 1];
            
            // 선택지 가져오기
            

            // 커뮤데이터 Overwrite
            wikiEditor.overwrite("커뮤니케이션:" + sheetName + '/' + template.title.replace('\\', '/'), template.toContent(), "봇에 의한 자동 수정");

            // 본문 Overwrite
            wikiEditor.overwrite(sheetName + '/' + template.title.replace('\\', '/'), 
            "< [["+ sheetName + "| 이전 페이지]]\n\n"
            + "{{틀: 커뮤 요약|"
                + "\n|CommuNameJP = " + title
                + "\n|CommuNameKR = "
                + "\n| Choice1_JP = text_JP11"
                + "\n| Choice1_KR = text_KR11"
                + "\n| Choice1_Vo = 20"
                + "\n| Choice2_JP = text_JP12"
                + "\n| Choice2_KR = text_KR12"
                + "\n| Choice2_Da = 20"
                + "\n| Choice3_JP = text_JP13"
                + "\n| Choice3_KR = text_KR13"
                + "\n| Choice3_Vi = 20"
                + "\n| Me = 5"
                + "\n| Sp = 10"
                + "}}\n\n"
                + "== 커뮤 =="
            + "\n\n"
            + "\n{{커뮤니케이션:" + sheetName + '/' + template.title.replace('\\', '/') + "}}"
            , "봇에 의한 자동 수정");
            
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