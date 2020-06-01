package io.hardplant.cmmn;
/**
 * type: P or S
 * id: Unique ID or "select"
 * name: name of commu
 */
public class CommuTable {
    public String type;
    public String id;
    public String name;
    public String info;
    public String translator;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTranslator() {
        return this.translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

}