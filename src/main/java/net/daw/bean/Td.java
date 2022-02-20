package net.daw.bean;

import com.google.gson.annotations.Expose;

public class Td extends Element implements IElement {

    @Expose
    private String content = "";
    @Expose
    private String contentType = "string";

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Td() {
        super.setTag("td");
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

}
