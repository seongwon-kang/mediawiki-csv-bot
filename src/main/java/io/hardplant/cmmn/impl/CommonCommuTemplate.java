package io.hardplant.cmmn.impl;

import java.util.List;

import io.hardplant.cmmn.ITemplate;

public class CommonCommuTemplate implements ITemplate {

    public String idolName;

    public List<MorningSelectionTable> morningTables;

    public List<AuditionSelectionTable> auditionTables;

    @Override
    public String getTitle() {
        return idolName + "/공통 커뮤";
    }

    public String getMorningTableContent() {
        String content = "";
        for (MorningSelectionTable table : morningTables) {
            content += "{{틀:커뮤 아침 요약"
                    + String.format("\n | CommuName = [[%s/공통/Morning%s|Morning%s]]", idolName,
                            getMaruByNum(table.CommuName), getMaruByNum(table.CommuName))
                    + "\n | Intro_JP = " + table.IntroJP + "\n | Intro_KR = " + "\n | Choice1_JP = " + table.Choice1_JP
                    + "\n | Choice1_KR = " + table.Choice1_KR + "\n | Choice2_JP = " + table.Choice2_JP
                    + "\n | Choice2_KR = " + table.Choice2_KR + "\n | Choice3_JP = " + table.Choice3_JP
                    + "\n | Choice3_KR = " + table.Choice3_KR + "\n}}";
            content += "\n";
        }
        return content;
    }

    public String getAuditionTableContent() {
        String content = "";
        for (AuditionSelectionTable table : auditionTables) {
            content += "{{틀:커뮤 오디션 전 요약"
                    + String.format("\n | CommuName = [[%s/공통/오디션 전%s|오디션 전%s]]", idolName,
                            getMaruByNum(table.CommuName), getMaruByNum(table.CommuName))
                    + "\n | Intro_JP = " + "\n | Intro_KR = " + "\n | Choice1_JP = " + table.Choice1_JP
                    + "\n | Choice1_KR = " + table.Choice1_KR + "\n | Choice2_JP = " + table.Choice2_JP
                    + "\n | Choice2_KR = " + table.Choice2_KR + "\n | Choice3_JP = " + table.Choice3_JP
                    + "\n | Choice3_KR = " + table.Choice3_KR + "\n}}";
            content += "\n";
        }
        return content;
    }

    @Override
    public String toContent() {

        return "<div class='mw-collapsible mw-collapsed'>" 
                + "\n=== W.I.N.G. ==="
                + "\n<div class='mw-collapsible-content'>" + "\n</div></div>\n"
                + "\n</div></div>"
                + "\n<div class='mw-collapsible mw-collapsed'>\n" 
                + "\n=== 팬 감사제 ===\n"
                + "\n<div class='mw-collapsible-content'>\n" + "\n</div></div>\n"
                + "\n</div></div>"
                + "\n<div class='mw-collapsible mw-collapsed'>\n" 
                + "\n=== G.R.A.D ===\n"
                + "\n<div class='mw-collapsible-content'>\n" + "\n</div></div>\n"
                + "\n</div></div>"
                + "\n<div class='mw-collapsible mw-collapsed'>\n" 
                + "\n=== 아침 이벤트 ===\n"
                + "\n<div class='mw-collapsible-content'>\n" 
                + getMorningTableContent()
                + "\n</div></div>"
                + "\n<div class='mw-collapsible mw-collapsed'>\n" 
                + "\n=== 오디션 전 ===\n"
                + "\n<div class='mw-collapsible-content'>\n"
                + getAuditionTableContent()
                + "\n</div></div>"
                + "\n";
    }

    private String getMaruByNum(int num) {
        final String[] maru = { "①", "②", "③", "④", "⑤", "⑥", "⑦", "⑧", "⑨", "⑩", "⑪", "⑫", "⑬", "⑭", "⑮" };
        return maru[num];
    }
}