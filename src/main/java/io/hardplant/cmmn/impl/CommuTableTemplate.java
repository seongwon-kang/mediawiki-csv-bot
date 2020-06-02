package io.hardplant.cmmn.impl;

public class CommuTableTemplate {
    public String title;

    private StringBuilder template = new StringBuilder();
    private CommuTable table;

    public CommuTableTemplate() {
        template.append("{{{커뮤테이블|");
    }

    public CommuTableTemplate setTable(CommuTable table) {
        this.table = table;
        
        this.setTitle();

        if (table.commus == null)
            return this;

        if (table.info != null) {
            template.append("|info = " + table.info);
        }

        if (table.translator != null) {
            template.append("|translator = " + table.translator + "|");
        }

        for (CommuRow row : table.commus) {
            this.addRow(row);
        }

        return this;
    }

    public String toContent() {
        template.append("}}}");
        return template.toString();
    }

    private CommuTableTemplate setTitle() {
        if (table != null) {
            this.title = table.rawName;
        }

        return this;
    }

    public CommuTableTemplate addRow(CommuRow row) {
        addRow(row.id, row.name, row.text, row.trans);

        return this;
    }

    public CommuTableTemplate addRow(String id, String character, String text, String trans) {
        template.append("\n  {{{커뮤대사|").append(id).append("|").append(character).append("|").append(text).append("|")
                .append(trans).append("|").append("}}}");

        return this;
    }
}