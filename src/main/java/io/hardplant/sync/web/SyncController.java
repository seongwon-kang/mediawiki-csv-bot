package io.hardplant.sync.web;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import io.hardplant.sync.service.SyncService;

/**
 * SyncController
 */

@Controller
public class SyncController {

    private final static Logger logger = LoggerFactory.getLogger(SyncController.class);

    @Resource
    private SyncService syncService;

    public String syncWikiWithSheet() {
        int affected = syncService.syncWikiWithSheet("사쿠라기 마노", "", "");
        
        logger.info("syncWiki: " + affected);

        return "true";
    }
    
}