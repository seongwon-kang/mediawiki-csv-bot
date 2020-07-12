package io.hardplant.cmmn.impl;

import io.hardplant.cmmn.ITemplate;

public class RCardTemplate implements ITemplate{
    
    String titleJP;
    String titleKR;
    // ex: Mano
    String idolNameEN;
    // ex: 櫻木真乃
    String idolNameJP;
    // ex: 사쿠라기 마노
    String idolNameKR;

    @Override
    public String getTitle() {
        return String.format("【%s】%s", titleJP, idolNameJP);
    }

    @Override
    public String toContent() {

        return introduce()
            + "\n"+ produceCommu()
            + "\n"+ skillPanel()
            + "\n"+ memoryAppeal()
            + "\n"+ seeAlso();
    }
    
    private String memoryAppeal() {
        return "{{틀:추억 어필"
           + "\n | Name1 = 色とりどりの羽根"
           + "\n | Name5 = (레어는 3레벨까지)"
           + "\n | Effect3 = {{Vo}} 10% UP [6턴]"
           + "\n | Effect4 = -"
           + "\n | Effect5 = -"
           + "\n | Link1 = {{Vo}} 1.0배 어필"
           + "\n | Link3 = {{Vo}} 1.5배 어필"
           + "\n}}";
    }

    public String introduce() {
        return "{{틀:프로듀스 카드 개요"
            + "\n| Rarity = R"
            + String.format("\n| Unit = %s", UnitUtills.getUnitByJPName(idolNameJP))
            + String.format("\n| Name_JP = 【%s】%s", titleJP, idolNameJP)
            + String.format("\n| Name_KR = 【%s】%s", titleJP, idolNameJP)
            + String.format("\n| Image_name =【%s】%s", titleJP, idolNameJP)
            + "\n| Vo = 50"
            + "\n| Da = 50"
            + "\n| Vi = 50"
            + "\n| Me = 50"
            + "\n| 입수 방법 = 통상 뽑기"
            + "\n| 최초 등장 가챠 = 통상 뽑기"
            + "\n| 가챠 기간 = 2018/04/24"
            + "\n}}";
    }

    public String produceCommu() {
        return "== 프로듀스 =="
        + String.format("\n\n{{공통 커뮤/%s}}", idolNameKR); 
    }

    private String skillPanel() {
        return "== 스킬 패널 =="
        + "\n{{틀:스킬 패널"
        + "\n| skill_20_1 = {{Vo}} 7% UP"
        + "\n| color_20_1 = {{Color_Dictionary | Vo_Background1}}"
        + "\n| effect_20_1 = [조건:4턴 이전]<br />[확률:20%]<br />[최대:1회]"
        + "\n| skill_30_1 = {{Vi}} 7% UP"
        + "\n| color_30_1 = {{Color_Dictionary | Vi_Background1}}"
        + "\n| effect_30_1 = [조건:스타 10 이상]<br />[확률:30%]<br />[최대:1회]"
        + "\n| skill_30_2 = {{Vo}} 3% UP"
        + "\n| color_30_2 = {{Color_Dictionary | Vo_Background1}}"
        + "\n| effect_30_2 = {{Vo}} & {{Vi}} 2배 어필/<br />(Link) {{Da}} & {{Vi}} 50% UP[4턴]";
    }

    public String seeAlso() {
        return "== 같이 보기 =="
        + String.format("\nhttps://wikiwiki.jp/shinycolors/【%s】%s", titleJP, idolNameJP)
        + "\n{{#set:"
        + "\n| 카드 종류 = P"
        + String.format("\n| 이름 = %s", titleJP)
        + "\n| 레어도 = R"
        + String.format("\n| 카드명 = 【%s】)", titleJP, idolNameJP)
        + String.format("\n| 아이콘 = [[File:Icon %s P R 01.png]]", idolNameEN)
        + "\n}}"
        + "\n[[Category:카드 | P]]";
    }

    public String getTitleJP() {
        return titleJP;
    }

    public void setTitleJP(String titleJP) {
        this.titleJP = titleJP;
    }

    public String getTitleKR() {
        return titleKR;
    }

    public void setTitleKR(String titleKR) {
        this.titleKR = titleKR;
    }

    public String getIdolNameEN() {
        return idolNameEN;
    }

    public void setIdolNameEN(String idolNameEN) {
        this.idolNameEN = idolNameEN;
    }

    public String getIdolNameJP() {
        return idolNameJP;
    }

    public void setIdolNameJP(String idolNameJP) {
        this.idolNameJP = idolNameJP;
    }

    public String getIdolNameKR() {
        return idolNameKR;
    }

    public void setIdolNameKR(String idolNameKR) {
        this.idolNameKR = idolNameKR;
    }
}