package io.hardplant.cmmn;

import org.fastily.jwiki.core.Wiki;

public class WikiEditor {
    public boolean isLoggedOn;
    private Wiki wiki;

    String id;
    String pwd;

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
        wiki.edit(docTitle, docText, editSummary);

        return true;
    }

    public boolean appendAfter(String docTitle, String docText, String editSummary) {
        String content = wiki.getPageText(docTitle);
        wiki.edit(docTitle, content + docText, editSummary);

        return true;
    }

    
}