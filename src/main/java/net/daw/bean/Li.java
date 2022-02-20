package net.daw.bean;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;

public class Li extends Element implements IElement {

    @Expose
    private String content = "";
    @Expose
    IOlUl list = null;

    public IOlUl getSublist() {
        return list;
    }

    public void setSublist(IOlUl list) {
        this.list = list;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Li() {
        super.setTag("li");
    }

}
