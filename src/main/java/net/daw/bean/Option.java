package net.daw.bean;

import com.google.gson.annotations.Expose;

public class Option extends Element implements IElement {

    @Expose
    private String text;
    @Expose
    private String selected;
    @Expose
    private String value;

    public Option() {
        super.setTag("option");
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
