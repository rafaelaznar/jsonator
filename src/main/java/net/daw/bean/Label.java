package net.daw.bean;

import com.google.gson.annotations.Expose;

public class Label extends Element implements IElement {
@Expose
    private String labelfor;
@Expose
    private String text;

    public  Label() {
        super.setTag("label");
    }

    public String getLabelfor() {
        return labelfor;
    }

    public void setLabelfor(String labelfor) {
        this.labelfor = labelfor;
    }

    public String getLabeltext() {
        return text;
    }

    public void setLabeltext(String labeltext) {
        this.text = labeltext;
    }
}
