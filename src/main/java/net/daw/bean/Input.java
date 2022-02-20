package net.daw.bean;

import com.google.gson.annotations.Expose;

public class Input extends Element implements IElement {

    @Expose
    private String type;
    @Expose
    private String value;
    @Expose
    private String text;

    public Input() {
        super.setTag("input");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
