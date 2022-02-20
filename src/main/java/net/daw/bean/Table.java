package net.daw.bean;

import com.google.gson.annotations.Expose;
import java.util.ArrayList;

public class Table extends Element implements IElement {

    @Expose
    ArrayList<Th> cabecera = null;
    @Expose
    ArrayList<Tr> cuerpo = null;

    public ArrayList<Th> getCabecera() {
        return cabecera;
    }

    public void setCabecera(ArrayList<Th> cabecera) {
        this.cabecera = cabecera;
    }

    public ArrayList<Tr> getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(ArrayList<Tr> cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Table() {
        super.setTag("table");
    }

}
