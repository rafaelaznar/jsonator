package net.daw.bean;

import com.google.gson.annotations.Expose;

public class Th extends Element implements IElement {

    @Expose
    private String content = "";

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Th() {
        super.setTag("th");
    }

}
