package io.hardplant.cmmn;

import org.fastily.jwiki.core.Wiki;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WikiEditor {
    public boolean isLoggedOn;
    private Wiki wiki;

    String id;
    String pwd;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public WikiEditor() {
        wiki = new Wiki.Builder().build();
    }

    public WikiEditor(String id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public boolean logon() {
        if (isLoggedOn) {
            wiki.login(id, pwd);
            isLoggedOn = true;
        }
        return isLoggedOn;
    }

    public boolean overwrite(String docTitle, String docText, String editSummary) {
        if (isLoggedOn) {
            wiki.edit(docTitle, docText, editSummary);
            return true;

        } else {
            logger.error("not logged on");
            return false;
        }
    }

    public boolean appendAfter(String docTitle, String docText, String editSummary) {
        if (isLoggedOn) {
            String content = wiki.getPageText(docTitle);
            wiki.edit(docTitle, content + docText, editSummary);
            return true;

        } else {
            logger.error("not logged on");
            return false;
        }
    }

}