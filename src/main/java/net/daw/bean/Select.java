package net.daw.bean;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;

public class Select extends Element implements IElement {

    @Expose
    private String multiple;
    @Expose
    private ArrayList<Option> options;

    public Select() {
        super.setTag("select");
    }

    public String getMultiple() {
        return multiple;
    }

    public void setMultiple(String multiple) {
        this.multiple = multiple;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }
}
