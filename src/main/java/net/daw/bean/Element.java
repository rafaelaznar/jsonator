package net.daw.bean;

import com.google.gson.annotations.Expose;

public class Element implements IElement {

    @Expose
    private String tag;
    @Expose
    private String name;
    @Expose
    private String id;
    @Expose
    private String clase;

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getTagClass() {
        return clase;
    }

    @Override
    public void setTagClass(String clase) {
        this.clase = clase;
    }

}
