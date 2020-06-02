package io.hardplant.cmmn;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.fastily.jwiki.core.Wiki;
import org.junit.jupiter.api.Test;

public class WikiEditorTest {

    @Test
    public void testOverwriteFails() {
        WikiEditor editor = new WikiEditor(new Wiki.Builder().withDomain("publictestwiki.com").build());

        // Not Logged On
        assertFalse(editor.overwrite("bottest", "test", "봇 자동 업로드"), "로그인 없이 업로드됨");
    }
    
    @Test
    public void testOverwriteWithLogon() {
        WikiEditor editor = new WikiEditor(new Wiki.Builder().withDomain("publictestwiki.com").build());
        editor.logon("Hardplant2", "1q2w3e4r");
        assertTrue(editor.overwrite("bottest", "test", "봇 자동 업로드"), "로그인 실패");
    }

}
