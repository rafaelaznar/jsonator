package net.daw.bean;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;

public class Ol extends Element implements IElement, IOlUl {

    @Expose
    ArrayList<Li> sublist = null;

    @Override
    public ArrayList<Li> getSublist() {
        return sublist;
    }

    @Override
    public void setSublist(ArrayList<Li> sublist) {
        this.sublist = sublist;
    }

    public Ol() {
        super.setTag("ol");
    }

}
