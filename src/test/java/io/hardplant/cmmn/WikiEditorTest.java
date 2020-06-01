package io.hardplant.cmmn;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WikiEditorTest {
        
    @Test
    public void testFileUploads() {
        WikiEditor editor = new WikiEditor();

        // Not Logged On
        assertFalse(editor.overwrite("bottest", "test", "봇 자동 업로드"), "로그인 없이 업로드됨");
    }
}
    