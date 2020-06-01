package io.hardplant.cmmn;

public class CommuTableTemplate {
    StringBuilder template = new StringBuilder();

    public CommuTableTemplate() {
        template.append("{{커뮤테이블|");

    }

    String toContent() {
        template.append("}}");
        return template.toString();
    }

    CommuTableTemplate title() {
        template.append("");

        return this;
    }

    CommuTableTemplate addRow(String character, String text) {
        template.append("{{커뮤대사|")
            .append(character).append("|")
            .append(text)
            .append("}}");

        return this;
    }
}