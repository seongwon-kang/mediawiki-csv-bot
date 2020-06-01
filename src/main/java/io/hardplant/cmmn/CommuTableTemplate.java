package io.hardplant.cmmn;

public class CommuTableTemplate {
    StringBuilder template = new StringBuilder();

    public CommuTableTemplate() {
        template.append("{{커뮤테이블|");
    }

    public CommuTableTemplate setTable(CommuTable table) {
        return this;
    }

    public String toContent() {
        template.append("}}");
        return template.toString();
    }

    public CommuTableTemplate title() {
        template.append("");

        return this;
    }

    public CommuTableTemplate addRow(CommuRow row) {
        addRow(row.id,row.name, row.text, row.trans);

        return this;
    }

    public CommuTableTemplate addRow(String id,String character, String text, String trans) {
        template.append("{{커뮤대사|")
            .append(id).append("|")
            .append(character).append("|")
            .append(text).append("|")
            .append(trans).append("|")
            .append("}}");

        return this;
    }
}