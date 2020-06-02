package io.hardplant.sync.service;

import java.util.List;

import io.hardplant.cmmn.CommuTableTemplate;

public interface SyncService {

	int syncWikiWithSheet(String sheetName, String id, String pwd);

	List<CommuTableTemplate> getTemplateFromSheet(String string);
    
}