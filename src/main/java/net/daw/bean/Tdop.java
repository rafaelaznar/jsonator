package net.daw.bean;

import com.google.gson.annotations.Expose;

public class Tdop extends Element implements IElement {

    @Expose
    private Operation content = null;
    @Expose
    private String contentType = "op";

    public Operation getContent() {
        return content;
    }

    public void setContent(Operation content) {
        this.content = content;
    }

    public Tdop() {
        super.setTag("td");
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

}
