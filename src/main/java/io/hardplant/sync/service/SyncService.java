package io.hardplant.sync.service;

import java.util.List;

import io.hardplant.cmmn.impl.CommuTableTemplate;

public interface SyncService {
	boolean logonWiki(String id, String pwd);

	int syncWikiWithSheet(String sheetName);

	public int syncWikiFromTemplates(List<CommuTableTemplate> templates);

	List<CommuTableTemplate> getTemplateFromSheet(String string);
    
}